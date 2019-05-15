package com.company.BusReservationSystem;

public class TicketCounter {

    Integer availableSeats;

    public TicketCounter(Integer seats) {
        this.availableSeats = seats;
    }

    public synchronized void bookTicket(String name, Integer numberOfSeats) {
        if(availableSeats >= numberOfSeats && numberOfSeats > 0) {
            System.out.println("Hi, " + name + " : " + numberOfSeats + " Seats books Successfully...");
            availableSeats = availableSeats - numberOfSeats;
        } else {
            System.out.println("Hi, " + name + " : Seats Not Available");
        }
    }
}

class TicketBookingThread implements Runnable {

    TicketCounter ticketCounter;
    String pName;
    Integer noOfSeatsToBook;

    public TicketBookingThread(TicketCounter ticketCounter, String pName, Integer noOfSeatsToBook) {
        this.ticketCounter = ticketCounter;
        this.pName = pName;
        this.noOfSeatsToBook = noOfSeatsToBook;
    }

    @Override
    public void run() {
        ticketCounter.bookTicket(pName, noOfSeatsToBook);
    }
}
