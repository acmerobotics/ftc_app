package com.acmerobotics.lib.run

import com.acmerobotics.dashboard.telemetry.TelemetryPacket
import com.qualcomm.robotcore.util.ElapsedTime

open class Target (var action: (TelemetryPacket) -> Boolean = {true}) {

    companion object {
        @JvmStatic
        val halt = Target { false }
    }

    private val dependencies = mutableListOf<Target>()
    private val dependenciesPost = mutableListOf<Target>()

    fun require (target: Target) : Target {
        dependencies.add(target)
        return this
    }

    fun requirePost (target: Target) : Target{
        dependenciesPost.add(target)
        return this
    }

    private fun removeUntilAllTrue (list: MutableList<Target>, packet: TelemetryPacket) : Boolean {
        return list.all {
            it.update(packet).also { complete ->
                if (complete) list.remove(it)
            }
        }
    }

    fun update (packet: TelemetryPacket) : Boolean {
        if (!removeUntilAllTrue(dependencies, packet)) return false

        if (action(packet)) action = {false}
        else return false

        return (removeUntilAllTrue(dependenciesPost, packet))

    }

}

class DelayTarget (val millis: Int) : Target() {
    val time = ElapsedTime()
    init {
        action = { time.milliseconds() >= millis }
    }
}


