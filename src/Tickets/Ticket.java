package Tickets;

public abstract class Ticket {
    private String name;
    private Integer totaal;

    public abstract void evenTicketSplit();
    public abstract void unevenTicketSplit();

}