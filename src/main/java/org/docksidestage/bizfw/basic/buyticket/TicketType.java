package org.docksidestage.bizfw.basic.buyticket;

/**
 *チケットの種類に関しての操作を行う
 */
public enum TicketType {

    ONE_DAY_PASS("OneDay", 1), TWO_DAY_PASS("TwoDay", 2);

    private String ticketName;
    private int ticketDays;

    private TicketType(String ticketName, int ticketDays) {
        this.ticketName = ticketName;
        this.ticketDays = ticketDays;
    }

    public String getTicketName() {
        return ticketName;
    }

    public int getTicketDays() {
        return ticketDays;
    }

    // 懐かしきおもひで
    //    public static String getTicketTypeByDays(int ticketDays) {
    //        for (TicketType ticket : TicketType.values()) {
    //            if (ticket.getTicketDays() == ticketDays) {
    //                return ticket.getTicketType();
    //            }
    //        }
    //        return "ticket type not found";
    //    }
};