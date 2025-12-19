@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepo;
    private final UserRepository userRepo;
    private final TicketCategoryRepository catRepo;

    public TicketServiceImpl(TicketRepository ticketRepo, UserRepository userRepo, TicketCategoryRepository catRepo) {
        this.ticketRepo = ticketRepo;
        this.userRepo = userRepo;
        this.catRepo = catRepo;
    }

    public Ticket createTicket(Long userId, Long categoryId, Ticket ticket) {
        if (ticket.getDescription().length() < 10)
            throw new RuntimeException("description too short");

        ticket.setUser(userRepo.findById(userId).orElseThrow(() -> new RuntimeException("not found")));
        ticket.setCategory(catRepo.findById(categoryId).orElseThrow(() -> new RuntimeException("not found")));
        return ticketRepo.save(ticket);
    }
}
