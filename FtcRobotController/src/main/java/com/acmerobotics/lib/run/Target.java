package com.acmerobotics.lib.run;

import java.util.ArrayList;
import java.util.List;

public class Target {

    public static final TargetAction EMPTY_ACTION = (packet) -> false;
    public static final Target EMPTY_TARGET = new Target(EMPTY_ACTION);

    protected List<Target> dependencies = new ArrayList<>();
    protected TargetAction action;

    public Target (TargetAction action) {
        this.action = action;
    }

    public Target () {
        this.action = EMPTY_ACTION;
    }

    public Target require (Target dependency) {
        dependencies.add(dependency);
        return this;
    }

}
