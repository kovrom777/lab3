package ru.bmstu.iu9.lab3;

import java.io.Serializable;

public class AirportDataSerializable implements Serializable {


    private int originalAirportId, destinationAirportId;
    private double timeDaley;
    private boolean isCanceled;

    public AirportDataSerializable(){
        
    }

    public AirportDataSerializable(int originalAirportId, int destinationAirportId, double timeDaley, boolean isCanceled) {
        this.originalAirportId = originalAirportId;
        this.destinationAirportId = destinationAirportId;
        this.timeDaley = timeDaley;
        this.isCanceled = isCanceled;
    }

    public int getOriginalAirportId() {
        return originalAirportId;
    }

    public void setOriginalAirportId(int originalAirportId) {
        this.originalAirportId = originalAirportId;
    }

    public int getDestinationAirportId() {
        return destinationAirportId;
    }

    public void setDestinationAirportId(int destinationAirportId) {
        this.destinationAirportId = destinationAirportId;
    }

    public double getTimeDaley() {
        return timeDaley;
    }

    public void setTimeDaley(double timeDaley) {
        this.timeDaley = timeDaley;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }
}
