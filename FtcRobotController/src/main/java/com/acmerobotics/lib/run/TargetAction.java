package com.acmerobotics.lib.run;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;

public interface TargetAction {

    boolean update (TelemetryPacket packet);

}
