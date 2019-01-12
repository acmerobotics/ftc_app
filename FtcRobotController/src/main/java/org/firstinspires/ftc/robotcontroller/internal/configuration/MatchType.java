package org.firstinspires.ftc.robotcontroller.internal.configuration;

public enum MatchType {
    PRACTICE(0),
    PRELIM(1),
    ELIM(2);

    private int index;

    MatchType (int i) {
        index = i;
    }

    public int getIndex() {
        return index;
    }

    public static MatchType fromIndex(int i) {
        for (MatchType type: MatchType.values()) {
            if (type.index == i) return type;
        }
        return null;
    }

}
