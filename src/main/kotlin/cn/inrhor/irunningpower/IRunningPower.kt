package cn.inrhor.irunningpower

import io.izzel.taboolib.loader.Plugin
import io.izzel.taboolib.module.config.TConfig
import io.izzel.taboolib.module.inject.TInject

object IRunningPower : Plugin() {
    @TInject
    lateinit var config : TConfig

    @TInject(state = TInject.State.STARTING, init = "init")
    lateinit var Loader : PluginLoader
}