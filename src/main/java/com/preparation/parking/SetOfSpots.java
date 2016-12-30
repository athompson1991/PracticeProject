package com.preparation.parking;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by aleth on 12/28/2016.
 */
public class SetOfSpots {

    private HashMap<String, Integer> availableSpotCounts;
    private HashMap<String, Stack> availableSpots;
    private final String sizeBuckets[] = {"small", "medium", "large"};

    SetOfSpots(int nSmall, int nMedium, int nLarge) {
        availableSpots = new HashMap();
        availableSpotCounts = new HashMap();

        int nValues[] = {nSmall, nMedium, nLarge};

        for (int i = 0; i < 3; i++) {
            String tempBucket = sizeBuckets[i];
            int tempVal = nValues[i];
            availableSpotCounts.put(tempBucket, tempVal);
            this.generateTickets(tempBucket);
        }
    }

    public HashMap getAvailableSpots() {
        return availableSpots;
    }

    public HashMap getAvailableSpotCounts() {
        return availableSpotCounts;
    }

    private char firstCharUpperCase(String lotSize) {
        return Character.toUpperCase(lotSize.charAt(0));
    }


    private void generateTickets(String lotSize) {
        char firstCharCap = firstCharUpperCase(lotSize);
        Stack ticketStack = new Stack();
        for (int i = 0; i < (Integer) getAvailableSpotCounts().get(lotSize); i++) {
            ticketStack.push(firstCharCap + Integer.toString(i + 1));
        }
        availableSpots.put(lotSize, ticketStack);
    }

    public String distributeTicket(String lotSize) {
        String ticket;
        if (availableSpots.get(lotSize).empty()) {
            ticket = null;
        } else {
            ticket = (String) availableSpots.get(lotSize).pop();
            int oldCount = availableSpotCounts.get(lotSize);
            availableSpotCounts.put(lotSize, oldCount - 1);
        }
        return ticket;

    }

    public void returnTicket(String ticket) {
        char sizeCode = ticket.charAt(0);
        for (int i = 0; i < 3; i++) {
            String tempBucket = sizeBuckets[i];
            Stack tempStack = availableSpots.get(tempBucket);
            if (sizeCode == firstCharUpperCase(tempBucket)) {
                tempStack.push(ticket);
            }
        }

    }

    public boolean outOfTicketType(String lotSize) {
        Stack testStack;
        testStack = availableSpots.get(lotSize);
        return testStack.empty();
    }

}
