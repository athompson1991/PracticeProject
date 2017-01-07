package com.preparation.parking;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by aleth on 12/28/2016.
 */
public class SetOfSpots {

    private HashMap<String, Integer> availableSpotCounts;
    private HashMap<String, Stack> availableSpots;
    private HashMap<String, Boolean> spotLookupTable;
    private final String sizeBuckets[] = {"small", "medium", "large"};

    public SetOfSpots(int nSmall, int nMedium, int nLarge) {
        availableSpots = new HashMap();
        availableSpotCounts = new HashMap();
        spotLookupTable = new HashMap<String, Boolean>();

        int nValues[] = {nSmall, nMedium, nLarge};

        for (int i = 0; i < 3; i++) {
            String lotSize = sizeBuckets[i];
            int tempVal = nValues[i];
            availableSpotCounts.put(lotSize, tempVal);
            this.generateTickets(lotSize);
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
        String ticketCode;
        for (int i = 0; i < (Integer) getAvailableSpotCounts().get(lotSize); i++) {
            ticketCode = firstCharCap + Integer.toString(i + 1);
            spotLookupTable.put(ticketCode, true);
            ticketStack.push(ticketCode);
        }
        availableSpots.put(lotSize, ticketStack);
    }

    public String distributeTicket(String lotSize) {
        Stack sizeStack = availableSpots.get(lotSize);
        String ticketCode;
        if (sizeStack.empty()) {
            ticketCode = null;
        } else {
            ticketCode = (String) sizeStack.pop();
            int oldCount = availableSpotCounts.get(lotSize);
            availableSpotCounts.put(lotSize, oldCount - 1);
            spotLookupTable.put(ticketCode, false);
        }
        return ticketCode;
    }

    public void returnTicket(String ticketCode) {
        char sizeCode = ticketCode.charAt(0);
        for (int i = 0; i < 3; i++) {
            String lotSize = sizeBuckets[i];
            Stack ticketStack = availableSpots.get(lotSize);
            if (sizeCode == firstCharUpperCase(lotSize)) {
                ticketStack.push(ticketCode);
                spotLookupTable.put(ticketCode, true);
            }
        }
    }

    public boolean outOfTicketType(String lotSize) {
        Stack testStack = availableSpots.get(lotSize);
        return testStack.empty();
    }

    public Boolean isEmptySpot(String spotCode) {
        return spotLookupTable.get(spotCode);
    }
}
