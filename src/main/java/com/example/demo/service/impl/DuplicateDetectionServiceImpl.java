@Service
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final TicketRepository ticketRepo;
    private final DuplicateRuleRepository ruleRepo;
    private final DuplicateDetectionLogRepository logRepo;

    public DuplicateDetectionServiceImpl(
            TicketRepository ticketRepo,
            DuplicateRuleRepository ruleRepo,
            DuplicateDetectionLogRepository logRepo) {
        this.ticketRepo = ticketRepo;
        this.ruleRepo = ruleRepo;
        this.logRepo = logRepo;
    }

    public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {
        Ticket base = ticketRepo.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("not found"));

        List<Ticket> tickets = ticketRepo.findByStatus("OPEN");
        List<DuplicateDetectionLog> logs = new ArrayList<>();

        for (Ticket t : tickets) {
            if (!t.getId().equals(ticketId)) {
                double score = TextSimilarityUtil.similarity(
                        base.getDescription(), t.getDescription());

                if (score > 0.3) {
                    DuplicateDetectionLog log = new DuplicateDetectionLog();
                    log.setTicket(base);
                    log.setMatchedTicket(t);
                    log.setMatchScore(score);
                    logs.add(logRepo.save(log));
                }
            }
        }
        return logs;
    }
}
