package com.company.BusReservationSystem;

public class SystemTest {

    public static void main(String[] args) {
        TicketCounter ticketCounter = new TicketCounter(5);
        TicketBookingThread t1 = new TicketBookingThread(ticketCounter, "John", 2);
        TicketBookingThread t2 = new TicketBookingThread(ticketCounter, "Martin", 3);
        TicketBookingThread t3 = new TicketBookingThread(ticketCounter, "Christ",2);

        t1.run();
        t2.run();
        t3.run();
    }
}
