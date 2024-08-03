package gay.j10a1n15.customscoreboard

import com.mojang.brigadier.CommandDispatcher
import com.teamresourceful.resourcefulconfig.api.client.ResourcefulConfigScreen
import com.teamresourceful.resourcefulconfig.api.loader.Configurator
import gay.j10a1n15.customscoreboard.config.Config
import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource
import net.minecraft.client.Minecraft
import net.minecraft.commands.CommandBuildContext

object Main : ClientModInitializer {

    const val VERSION = "0.0.1"

    val configurator = Configurator("customscoreboard")
    val config get() = Config

    override fun onInitializeClient() {
        configurator.register(Config::class.java)
        ClientCommandRegistrationCallback.EVENT.register(::onRegisterCommands)
        CustomScoreboardRenderer.init()
    }

    private fun onRegisterCommands(
        dispatcher: CommandDispatcher<FabricClientCommandSource>,
        buildContext: CommandBuildContext
    ) {
        dispatcher.register(
            ClientCommandManager.literal("cs").executes { context ->
                Minecraft.getInstance().tell {
                    Minecraft.getInstance().let {
                        it.setScreen(ResourcefulConfigScreen.get(it.screen, configurator, Config::class.java))
                    }
                }
                1
            })
    }
}