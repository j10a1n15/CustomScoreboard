package gay.j10a1n15.customscoreboard

import com.mojang.brigadier.CommandDispatcher
import com.teamresourceful.resourcefulconfig.api.loader.Configurator
import gay.j10a1n15.customscoreboard.config.ExampleConfig
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource
import net.minecraft.commands.CommandBuildContext

object Main : ClientModInitializer {

    val configurator = Configurator("customscoreboard")

    override fun onInitializeClient() {
        configurator.register(ExampleConfig::class.java)
        ClientCommandRegistrationCallback.EVENT.register(::onRegisterCommands)
    }

    private fun onRegisterCommands(
        dispatcher: CommandDispatcher<FabricClientCommandSource>,
        buildContext: CommandBuildContext
    ) {
        dispatcher.register(
            ClientCommandManager.literal("yourcommand").executes { context ->
                println("Hello, world!")
                1
            })
    }
}