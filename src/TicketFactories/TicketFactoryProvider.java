package TicketFactories;

public class TicketFactoryProvider {
    public static TicketFactory getRestoTicketFactory()
    {
        return new RestoTicketFactory();
    }
    public static TicketFactory getPlaneTicketFactory()
    {
        return new PlaneTicketFactory();
    }
    public static TicketFactory getTaxiTicketFactory()
    {
        return new TaxiTicketFactory();
    }
    public static TicketFactory getOtherTicketFactory()
    {
        return new OtherTicketFactory();
    }
}
