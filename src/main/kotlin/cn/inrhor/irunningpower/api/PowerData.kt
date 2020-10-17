package cn.inrhor.irunningpower.api

import cn.inrhor.irunningpower.IRunningPower
import cn.inrhor.irunningpower.PluginLoader
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import java.util.LinkedHashMap

class PowerData {

    var foodData : java.util.HashMap<Player, Int> = LinkedHashMap()
    var runState : java.util.HashMap<Player, Boolean> = LinkedHashMap()

    fun running(player: Player) {
        object : BukkitRunnable() {
            override fun run() {
                if (!(runState[player]!! && player.foodLevel > 1)) return
                player.foodLevel = player.foodLevel - PluginLoader().food
                running(player)
            }
        }.runTaskLater(IRunningPower.plugin, 20)
    }

    fun stopRun(player: Player) {
        object : BukkitRunnable() {
            override fun run() {
                if (runState[player]!!) return
                if (player.foodLevel < foodData[player]!!) {
                    player.foodLevel = player.foodLevel + PluginLoader().food
                    stopRun(player)
                }else{
                    foodData.remove(player)
                }
            }
        }.runTaskLater(IRunningPower.plugin, 20)
    }
}