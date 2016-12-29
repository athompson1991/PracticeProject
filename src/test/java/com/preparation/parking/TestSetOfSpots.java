package com.preparation.parking;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by aleth on 12/28/2016.
 */
public class TestSetOfSpots {

    private SetOfSpots mySpots;
    private Stack testSmallTickets;

    @Before
    public void setUp() {
        mySpots = new SetOfSpots(4, 3, 6);
        testSmallTickets = new Stack();
        testSmallTickets.push("S1");
        testSmallTickets.push("S2");
        testSmallTickets.push("S3");
        testSmallTickets.push("S4");

    }

    @Test
    public void testInit() {
        Map<String, Object> availSpotCounts;
        availSpotCounts = mySpots.getAvailableSpotCounts();
        assertEquals(4, availSpotCounts.get("small"));
        assertEquals(3, availSpotCounts.get("medium"));
        assertEquals(6, availSpotCounts.get("large"));
    }

    @Test
    public void testGenerateSpots() {
        Map<String, Stack> availSpots;
        availSpots = mySpots.getAvailableSpots();
        assertEquals(availSpots.get("small").peek(), testSmallTickets.peek());
    }

    @Test
    public void testDistributeTickets() {
        assertEquals(4, mySpots.getAvailableSpotCounts().get("small"));
        String tempTicket = mySpots.distributeTicket("small");
        assertEquals(3, mySpots.getAvailableSpotCounts().get("small"));
        assertEquals("S4", tempTicket);

        tempTicket = mySpots.distributeTicket("small");
        tempTicket = mySpots.distributeTicket("small");
        tempTicket = mySpots.distributeTicket("small");
        tempTicket = mySpots.distributeTicket("small");

        tempTicket = mySpots.distributeTicket("medium");
        assertEquals("M3", tempTicket);

        tempTicket = mySpots.distributeTicket("large");
        assertEquals("L6", tempTicket);
    }

    @Test
    public void testReturnTicket() {
        HashMap<String, Stack> ticketStack;
        String s1Ticket = mySpots.distributeTicket("small");
        String s2Ticket = mySpots.distributeTicket("small");
        String m1Ticket = mySpots.distributeTicket("medium");
        String l1Ticket = mySpots.distributeTicket("large");
        mySpots.returnTicket(s2Ticket);
        mySpots.returnTicket(s1Ticket);
        mySpots.returnTicket(m1Ticket);
        mySpots.returnTicket(l1Ticket);
        ticketStack = mySpots.getAvailableSpots();
        assertEquals("S4", ticketStack.get("small").peek());
        assertEquals("M3", ticketStack.get("medium").peek());
        assertEquals("L6", ticketStack.get("large").peek());
    }

    @Test
    public void testEmptyStacks() {
        assertFalse(mySpots.outOfTicketType("small"));
        mySpots.distributeTicket("small");
        mySpots.distributeTicket("small");
        mySpots.distributeTicket("small");
        mySpots.distributeTicket("small");
        assertTrue(mySpots.outOfTicketType("small"));
    }

}
