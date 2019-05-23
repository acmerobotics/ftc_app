package com.acmerobotics.lib.run;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;

public class Scheduler {

    private Target toIsolate = Target.EMPTY_TARGET;

    public void isolate (Target target) {
        this.toIsolate = target;
    }

    public void update (TelemetryPacket packet) {
        achieve(toIsolate, packet);
    }

    private boolean achieve (Target target, TelemetryPacket packet) {
        boolean dependenciesMet = true;
        for (Target dependency: target.dependencies) {
            dependenciesMet = achieve(dependency, packet) && dependenciesMet;
        }
        return dependenciesMet && target.action.update(packet);
    }

}
