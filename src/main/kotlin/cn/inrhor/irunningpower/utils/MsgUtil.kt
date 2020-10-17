package cn.inrhor.irunningpower.utils

import org.bukkit.Bukkit

class MsgUtil {
    val tag = "§7§l[ §c§l§ki§r§l §7§l]§r "

    fun send(msg : String) {
        Bukkit.getConsoleSender().sendMessage(msg.replace("&", "§"))
    }
}