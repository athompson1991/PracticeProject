package com.preparation.parking;

/**
 * Created by aleth on 12/28/2016.
 */
public class SimpleGarage implements Garage {

    private SetOfSpots spots;

    public void setSpot(Car inCar) {

    }

    public void leaveSpot(Car outCar) {

    }

    public SetOfSpots getSpots() {
        return spots;
    }

    public void createSetOfSpots(int nSmall, int nMedium, int nLarge) {
        spots = new SetOfSpots(nSmall, nMedium, nLarge);
    }
}
