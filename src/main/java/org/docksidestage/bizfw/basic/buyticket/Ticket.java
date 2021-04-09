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
    private final int displayPrice;
    private final int ticketDays;

    private boolean alreadyIn = false;
    private int doInCount = 0; // 入園回数

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Ticket(TicketType ticketType) {
        this.ticketType = ticketType;
        this.displayPrice = ticketType.getTicketPrice();
        this.ticketDays = ticketType.getTicketDays();
    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======
    public void doInPark() {
        if (ticketDays > doInCount) {
            doInCount += 1;
        } else {
            //throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
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
