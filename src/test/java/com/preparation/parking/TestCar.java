package com.preparation.parking;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by aleth on 12/28/2016.
 */
public class TestCar {

    private final String lotSizes[] = {"small", "medium", "large"};
    private HashMap<String, Car[]> cars;
    private SetOfSpots spots;
    private Car singleCar;

    @Before
    public void setUp() {
        int nLots[] = {3, 2, 5};
        spots = new SetOfSpots(nLots[0], nLots[1], nLots[2]);
        cars = new HashMap<String, Car[]>();

        Car[] tempCarArray;
        int tempN;
        String tempLotSize;
        for (int i = 0; i < 3; i++) {
            tempLotSize = lotSizes[i];
            tempN = nLots[i];
            tempCarArray = new Car[tempN];
            for (int j = 0; j < tempN; j++) {
                tempCarArray[j] = new Car(tempLotSize);
            }
            cars.put(tempLotSize, tempCarArray);
        }
    }

    @Test
    public void testInit() {
        singleCar = cars.get("small")[0];
        assertEquals("small", singleCar.getSize());
        assertNull(singleCar.getTicket());
    }

    @Test
    public void assignIndividualTicket() {
        singleCar = cars.get("small")[0];
        singleCar.assignTicket(spots);
        assertEquals("S3", singleCar.getTicket());
        singleCar = cars.get("medium")[0];
        singleCar.assignTicket(spots);
        assertEquals("M2", singleCar.getTicket());
        singleCar = cars.get("large")[0];
        singleCar.assignTicket(spots);
        assertEquals("L5", singleCar.getTicket());
    }

    @Test
    public void assignAllSmallThenAMediumTicket() {
        Car allSmall[] = cars.get("small");
        Car anotherSmallCar = new Car("small");
        assignAllTickets("small");
        assertEquals("S3", allSmall[0].getTicket());
        anotherSmallCar.assignTicket(spots);
        assertEquals("M2", anotherSmallCar.getTicket());
    }

    @Test
    public void assignAllSmallAllMediumThenALarge() {
        Car allSmall[] = cars.get("small");
        Car anotherSmallCar = new Car("small");
        assignAllTickets("small");
        assignAllTickets("medium");
        anotherSmallCar.assignTicket(spots);
        assertEquals("L5", anotherSmallCar.getTicket());
    }

    @Test
    public void assignAllMediumThenASmall() {
        assignAllTickets("medium");
        Car smallCar = new Car("small");
        smallCar.assignTicket(spots);
        assertEquals("S3", smallCar.getTicket());
    }

    @Test
    public void testRelinquishTicket() {
        assignAllTickets("small");
        Car testCar = cars.get("small")[0];
        Stack ticketStack = (Stack) spots.getAvailableSpots().get("small");
        testCar.relinquishTicket(spots);
        assertNull(testCar.getTicket());
        assertEquals("S3", ticketStack.peek());
    }

    private void assignAllTickets(String size) {
        Car carArr[] = cars.get(size);
        for (int i = 0; i < carArr.length; i++) carArr[i].assignTicket(spots);
    }

}
