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

// done akiyaman javadocにauthorを追加お願いします by jflute (2020/10/16)
/**
 * @author jflute
 * @author akiyaman
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    //    public static String ONE_DAY_PASS_TYPE = "OneDayPass";
    //    public static String TWO_DAY_PASS_TYPE = "TwoDayPass";

    private static final int MAX_QUANTITY = 10;
    private static final int ONE_DAY_PRICE = 7400; // when 2019/06/15
    private static final int TWO_DAY_PRICE = 13200;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // done akiyaman コメントの空白のポリシーが不統一 by jflute (2020/10/16)
    //  ;// チケットの数
    //  ; //売り上げ
    private int quantity = MAX_QUANTITY; // チケットの数
    private Integer salesProceeds; // 売り上げ

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {

    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                     ==========
    // done akiyaman [いいね] コメントアウトの理由コメントがしっかり書いてあるのとてもGood by jflute (2020/10/16)
    //Let's fix 4問目でコメントアウト
    //    public void buyOneDayPassport(int handedMoney) {
    //
    //        // How To 一問目削除
    //        // --quantity;
    //
    //        if (quantity <= 0) {
    //            throw new TicketSoldOutException("Sold out");
    //        }
    //
    //        if (handedMoney < ONE_DAY_PRICE) {
    //            throw new TicketShortMoneyException("Short money: " + handedMoney);
    //        }
    //
    //        // How To 一問目追加
    //        --quantity;
    //
    //        if (salesProceeds != null) { // lets fix 3問目で追加
    //            salesProceeds = salesProceeds + ONE_DAY_PRICE;
    //        } else {
    //            salesProceeds = ONE_DAY_PRICE;
    //        }
    //    }
    //
    //    //  Let's fix 4問目でコメントアウト
    //    public int buyTwoDayPassport(int handedMoney) { // OneDayパスポート*2という考え方
    //
    //        if (quantity <= 1) {
    //            throw new TicketSoldOutException("Sold out");
    //        }
    //
    //        if (handedMoney < TWO_DAY_PRICE) {
    //            throw new TicketShortMoneyException("Short money: " + handedMoney);
    //        }
    //
    //        //                done akiyaman まあ、ローカル変数だったら、定数っぽくても、大文字じゃなくて普通のキャメルケースで by jflute (2020/10/16)
    //        //                変数を選択して、ctrl+1 => rename in file で修正してみましょう
    //
    //        final int CHANGE = handedMoney - TWO_DAY_PRICE;
    //
    //        // How To 一問目
    //        quantity = quantity - 2;
    //
    //        if (salesProceeds != null) {
    //            salesProceeds = salesProceeds + TWO_DAY_PRICE;
    //        } else {
    //            salesProceeds = TWO_DAY_PRICE;
    //        }
    //
    //        return CHANGE;
    //    }

    // done 再利用についてレビューをしていただく  (2020/12/11)

    //    public void buyOneDayPassport(int handedMoney) { // Let's fix 4問目で追加
    //
    //        final int numberOfTickets = 1; // 購入予定のチケット枚数
    //        final int ticketPrice = ONE_DAY_PRICE;
    //        doBuyingTicketSteps(handedMoney, numberOfTickets, ticketPrice);
    //
    //    }
    //
    //    public int buyTwoDayPassport(int handedMoney) { // Let's fix 4問目で追加
    //
    //        final int numberOfTickets = 2; // 購入予定のチケット枚数
    //        final int ticketPrice = TWO_DAY_PRICE;
    //        doBuyingTicketSteps(handedMoney, numberOfTickets, ticketPrice);
    //        final int change = handedMoney - ticketPrice;
    //
    //        return change;
    //
    //    }
    //
    public Ticket buyOneDayPassport(int handedMoney) { // Challenge2問目でTicketTypeが判別できるよう修正

        final int numberOfTickets = 1; // 購入予定のチケット枚数
        final int ticketPrice = ONE_DAY_PRICE;
        final TicketType ticketType = TicketType.ONE_DAY_PASS;
        doBuyingTicketSteps(handedMoney, numberOfTickets, ticketPrice);
        Ticket ticket = new Ticket(ticketPrice, ticketType);

        return ticket;

    }

    public TicketBuyResult buyTwoDayPassport(int handedMoney) { // challenge 2問目で追加

        final int numberOfTickets = 2; // 購入予定のチケット枚数
        final int ticketPrice = TWO_DAY_PRICE;
        final int change = handedMoney - ticketPrice;
        TicketType ticketType = TicketType.TWO_DAY_PASS;
        doBuyingTicketSteps(handedMoney, numberOfTickets, ticketPrice);
        Ticket ticket = new Ticket(ticketPrice, ticketType);
        TicketBuyResult result = new TicketBuyResult(ticket, change);

        return result;

    }

    /**
     *アサート処理,チケット購入処理の一連の流れの実行(指示？)を行う
     */
    private void doBuyingTicketSteps(int handedMoney, int numberOfTickets, int ticketPrice) {

        assertNumberOfTickets(handedMoney, numberOfTickets, ticketPrice);
        doBuyTicket(numberOfTickets, ticketPrice);

    }

    /**
     *受け取った購入枚数を実際に購入できるか判定
     *購入できない場合、例外処理を行う
     */
    private void assertNumberOfTickets(int handedMoney, int numberOfTickets, int ticketPrice) {

        if (quantity < numberOfTickets) { // 購入枚数に対して在庫が足りていないとき
            throw new TicketSoldOutException("Sold out");
        }

        if (handedMoney < ticketPrice) { // 用意したお金が足りないとき
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }

    }

    /**
     *実際にチケットの購入(在庫を減らして、売上高を増やす)を行う
     */
    // assertNumberOfTicketsにより正しい購入枚数・手持ち金が渡される前提のメソッド。assertNumber~と合体した方がよかった？
    private void doBuyTicket(int numberOfTickets, int ticketPrice) {

        quantity = quantity - numberOfTickets; // 在庫を購入枚数の分減らす

        if (salesProceeds != null) {
            salesProceeds = salesProceeds + ticketPrice;
        } else { // 売上高が0のとき
            salesProceeds = ticketPrice;
        }

    }

    public static class TicketSoldOutException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketSoldOutException(String msg) {
            super(msg);
        }
    }

    public static class TicketShortMoneyException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketShortMoneyException(String msg) {
            super(msg);
        }
    }

    //    private enum TicketType {
    //
    //        ONE_DAY_PASS("OneDay", 1), TWO_DAY_PASS_TYPE("TwoDay", 2);
    //
    //        private String ticketType;
    //        private int ticketDays;
    //
    //        private TicketType(String ticketType, int ticketDays) {
    //            this.ticketType = ticketType;
    //            this.ticketDays = ticketDays;
    //        }
    //
    //        private String getTicketType() {
    //            return ticketType;
    //        }
    //
    //        private int getTicketDays() {
    //            return ticketDays;
    //        }
    //
    //        private static String getTicketTypeByDays(int ticketDays) {
    //            for (TicketType ticket : TicketType.values()) {
    //                if (ticket.getTicketDays() == ticketDays) {
    //                    return ticket.getTicketType();
    //                }
    //            }
    //            return "ticket type not found";
    //        }
    //    };

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getQuantity() {
        return quantity;
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
