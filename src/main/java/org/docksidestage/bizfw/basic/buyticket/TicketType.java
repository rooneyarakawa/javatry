package org.docksidestage.bizfw.basic.buyticket;

/**
 *チケットの種類に関しての操作を行う
 * @author jflute
 * @author akiyaman
 */
public enum TicketType {

    ONE_DAY_PASS("OneDay", 1, 7400), // 
    TWO_DAY_PASS("TwoDay", 2, 13200), // 
    FOUR_DAY_PASS("FourDay", 4, 22400), // 
    NIGHT_ONLY_TWO_DAY_PASS("NightOnlyTwoDay", 2, 7400); // 

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

};