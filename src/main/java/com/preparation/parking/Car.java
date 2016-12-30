package com.preparation.parking;

import java.util.Stack;

/**
 * Created by aleth on 12/28/2016.
 */
public class Car {

    private String size;
    private String assignedTicket = null;
    private final String lotSizes[] = {"small", "medium", "large"};


    public String getSize() {
        return size;
    }

    public String getTicket() {
        return assignedTicket;
    }

    Car(String carSize) {
        this.size = carSize;
    }

    public void assignTicket(SetOfSpots ticketHandler) {
        String tempTicket = null;
        String determinedTicket = null;
        int i = 2;
        while (tempTicket == null & i >= 0) {
            String tempLot = lotSizes[i];
            if (tempLot == this.size) {
                determinedTicket = determineRightTicket(ticketHandler);
                tempTicket = ticketHandler.distributeTicket(determinedTicket);
            }
            i--;
        }
        assignedTicket = tempTicket;
    }

    public void relinquishTicket(SetOfSpots spots) {
        spots.returnTicket(this.assignedTicket);
        this.assignedTicket = null;
    }

    private String determineRightTicket(SetOfSpots spots) {
        String rightTicket = null;
        if (this.size == "large") {
            rightTicket = "large";
        } else if (this.size == "medium") {
            rightTicket = "medium";
            if (spots.outOfTicketType("medium")) rightTicket = "large";
        } else if (this.size == "small") {
            rightTicket = "small";
            if (spots.outOfTicketType("small")) rightTicket = "medium";
            if (spots.outOfTicketType("small") & spots.outOfTicketType("medium")) rightTicket = "large";
        }
        return rightTicket;
    }

}
