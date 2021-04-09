package org.docksidestage.bizfw.basic.buyticket;

/**
 *チケットの種類に関しての操作を行う
 * @author jflute
 * @author akiyaman
 */
public enum TicketType {

    ONE_DAY_PASS("OneDay", 1, 7400), TWO_DAY_PASS("TwoDay", 2, 13200);

    private final String ticketName;
    private final int ticketDays;
    private final int ticketPrice;

    private TicketType(String ticketName, int ticketDays, int ticketPrice) {
        this.ticketName = ticketName;
        this.ticketDays = ticketDays;
        this.ticketPrice = ticketPrice;
    }

    public String getTicketName() {
        return ticketName;
    }

    public int getTicketDays() {
        return ticketDays;
    }

    public int getTicketPrice() {
        return ticketPrice;
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