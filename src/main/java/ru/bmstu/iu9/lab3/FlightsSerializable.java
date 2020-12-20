package ru.bmstu.iu9.lab3;

public class FlightsSerializable {

    private double maxDelay;
    private  int flightDelaysNumber, allFlightsNumber;

    public FlightsSerializable(double maxDelay, int flightDelaysNumber, int allFlightsNumber) {
        this.maxDelay = maxDelay;
        this.flightDelaysNumber = flightDelaysNumber;
        this.allFlightsNumber = allFlightsNumber;
    }

    public double getMaxDelay() {
        return maxDelay;
    }

    public void setMaxDelay(double maxDelay) {
        this.maxDelay = maxDelay;
    }

    public int getFlightDelaysNumber() {
        return flightDelaysNumber;
    }

    public void setFlightDelaysNumber(int flightDelaysNumber) {
        this.flightDelaysNumber = flightDelaysNumber;
    }

    public int getAllFlightsNumber() {
        return allFlightsNumber;
    }

    public void setAllFlightsNumber(int allFlightsNumber) {
        this.allFlightsNumber = allFlightsNumber;
    }


    public void incrementDelayCount(){
        flightDelaysNumber++;
        allFlightsNumber++;
    }

    public void 

}
