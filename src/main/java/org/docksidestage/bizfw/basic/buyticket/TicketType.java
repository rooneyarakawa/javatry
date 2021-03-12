package org.docksidestage.bizfw.basic.buyticket;

public enum TicketType {

    ONE_DAY_PASS("OneDay", 1), TWO_DAY_PASS_TYPE("TwoDay", 2);

    private String ticketType;
    private int ticketDays;

    private TicketType(String ticketType, int ticketDays) {
        this.ticketType = ticketType;
        this.ticketDays = ticketDays;
    }

    private String getTicketType() {
        return ticketType;
    }

    private int getTicketDays() {
        return ticketDays;
    }

    public static String getTicketTypeByDays(int ticketDays) {
        for (TicketType ticket : TicketType.values()) {
            if (ticket.getTicketDays() == ticketDays) {
                return ticket.getTicketType();
            }
        }
        return "ticket type not found";
    }
};