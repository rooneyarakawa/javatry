package org.docksidestage.bizfw.basic.buyticket;

/**
 *チケットの種類に関しての操作を行う
 */
public enum TicketType {

    ONE_DAY_PASS("OneDay", 1), TWO_DAY_PASS("TwoDay", 2);

    private String ticketName;
    private int ticketType;

    private TicketType(String ticketName, int ticketDays) {
        this.ticketName = ticketName;
        this.ticketType = ticketDays;
    }

    public String getTicketName() {
        return ticketName;
    }

    public int getTicketType() {
        return ticketType;
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