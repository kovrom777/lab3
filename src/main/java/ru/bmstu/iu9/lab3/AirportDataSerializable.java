package ru.bmstu.iu9.lab3;

import java.io.Serializable;

public class AirportDataSerializable implements Serializable {


    private int originalAirportId, destinationAirportId;
    private double timeDaley;
    private boolean isCanceled;

    public AirportDataSerializable(int originalAirportId, int destinationAirportId, double timeDaley, boolean isCanceled) {
        this.originalAirportId = originalAirportId;
        this.destinationAirportId = destinationAirportId;
        this.timeDaley = timeDaley;
        this.isCanceled = isCanceled;
    }
    
}
