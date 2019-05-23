package com.acmerobotics.lib.run;

import com.qualcomm.robotcore.util.ElapsedTime;

public class DelayTarget extends Target{

    private ElapsedTime time;
    private double millis;

    private DelayTarget (TargetAction action) { /*mask this */ }

    public DelayTarget (double millis) {
        this.millis = millis;
        this.time = new ElapsedTime();
        this.action = (packet) -> time.milliseconds() >= millis;
    }

}
