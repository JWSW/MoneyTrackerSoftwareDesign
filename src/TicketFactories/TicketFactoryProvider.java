package TicketFactories;

public class TicketFactoryProvider {
    public static TicketFactory getRestoTicket()
    {
        return new RestoTicketFactory();
    }
    public static TicketFactory getPlaneTicket()
    {
        return new PlaneTicketFactory();
    }
    public static TicketFactory getTaxiTicket()
    {
        return new TaxiTicketFactory();
    }
    public static TicketFactory getOtherTicket()
    {
        return new OtherTicketFactory();
    }
}
