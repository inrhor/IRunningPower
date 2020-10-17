package cn.inrhor.irunningpower.listeners

import cn.inrhor.irunningpower.api.PowerData
import io.izzel.taboolib.module.inject.TListener
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.event.player.PlayerToggleSprintEvent

@TListener
class PlayerListener : Listener {

    @EventHandler
    fun running(ev : PlayerToggleSprintEvent) {
        val player = ev.player
        if (ev.isSprinting) { // 冲刺
            if (!PowerData().foodData.containsKey(player)) {
                PowerData().foodData[player] = player.foodLevel
            }
            PowerData().runState[player] = true
            PowerData().running(player)
        }else {
            PowerData().runState[player] = false
            PowerData().stopRun(player)
        }
    }

    @EventHandler
    fun onQuit(ev : PlayerQuitEvent) {
        val player = ev.player
        player.foodLevel = PowerData().foodData[player]!!
    }
}