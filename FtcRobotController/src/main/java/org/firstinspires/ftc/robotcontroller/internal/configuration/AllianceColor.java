package org.firstinspires.ftc.robotcontroller.internal.configuration;

public enum AllianceColor {
    RED(0),
    BLUE(0);

    private  int index;
    AllianceColor (int i) {
        index = i;
    }

    public int getIndex () {return index;}

    public static AllianceColor fromIndex(int i) {
        for (AllianceColor color: AllianceColor.values()) {
            if (color.index == i) return color;
        }
        return null;
    }
}
