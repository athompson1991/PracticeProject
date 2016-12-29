package com.preparation.parking;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

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
        assertTrue(true);
    }

    @Test
    public void assignTicket() {
        assertTrue(true);
    }

    private void assignAllTickets(String size) {

    }
}
