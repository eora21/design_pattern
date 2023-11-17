package singleton;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketMaker {
    private static final TicketMaker INSTANCE = new TicketMaker();
    private static final AtomicInteger TICKET_NUMBER_GENERATOR = new AtomicInteger(1_000);

    private TicketMaker() {
    }

    public static TicketMaker getInstance() {
        return INSTANCE;
    }

    public int getNextTicketNumber() {
        return TICKET_NUMBER_GENERATOR.getAndIncrement();
    }
}
