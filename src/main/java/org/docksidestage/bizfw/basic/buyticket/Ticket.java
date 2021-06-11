/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author jflute
 * @author akiyaman
 */
public class Ticket {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private final TicketType ticketType;
    private final int ticketPrice;
    private final int displayPrice; //最終表示価格。ticketPrice ≠ displayPrice
    private final int ticketDays;

    private int doInCount = 0; // 入園回数
    private boolean alreadyIn = false; // 入園可能回数に達した場合=>true

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Ticket(TicketType ticketType) {
        this.ticketType = ticketType;
        this.ticketPrice = ticketType.getTicketPrice();
        this.displayPrice = this.ticketPrice;
        this.ticketDays = ticketType.getTicketDays();
    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======
    public void doInPark() {
        if (alreadyIn == true) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        doInCount += 1;
        if (ticketDays == doInCount) {
            alreadyIn = true;
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getDisplayPrice() {
        return displayPrice;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public boolean isAlreadyIn() {
        return alreadyIn;
    }

    public int getDoInCount() {
        return doInCount;
    }

}
