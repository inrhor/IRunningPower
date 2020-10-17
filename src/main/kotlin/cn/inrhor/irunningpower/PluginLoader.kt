package cn.inrhor.irunningpower

import cn.inrhor.irunningpower.utils.MsgUtil

class PluginLoader {
    var food = 1

    fun init() {
        val pluginCon = IRunningPower.plugin.description

        MsgUtil().send("${MsgUtil().tag} ┍  &a正在加载  &f"+pluginCon.name+"  &a插件")
        MsgUtil().send("${MsgUtil().tag} ┝  &3插件当前版本： "+pluginCon.version)
        MsgUtil().send("${MsgUtil().tag} ┕  &a插件正常运行")

        food = IRunningPower.config.getInt("food")
    }
}