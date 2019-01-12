package org.firstinspires.ftc.robotcontroller.internal.configuration;

public enum StartLocation {
    CRATER(0),
    DEPOT(1);

    private int index;

    StartLocation (int i) {
        index = i;
    }

    public int getIndex () {return index;}

    public static StartLocation fromIndex(int i) {
        for (StartLocation loc: StartLocation.values()) {
            if (loc.index == i) return loc;
        }
        return null;
    }
}
