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
        int i = 2;
        while (tempTicket == null & i > 0) {
            String tempLot = lotSizes[i];
            if (tempLot == this.size) {
                tempTicket = ticketHandler.distributeTicket(this.size);
            }
            i--;
        }
        assignedTicket = tempTicket;
    }


}
