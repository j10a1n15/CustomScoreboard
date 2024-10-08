package gay.j10a1n15.customscoreboard

import com.mojang.brigadier.CommandDispatcher
import com.teamresourceful.resourcefulconfig.api.client.ResourcefulConfigScreen
import com.teamresourceful.resourcefulconfig.api.loader.Configurator
import gay.j10a1n15.customscoreboard.config.MainConfig
import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementArea
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementLobby
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementObjective
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementTime
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource
import net.minecraft.commands.CommandBuildContext
import tech.thatgravyboat.skyblockapi.api.SkyBlockAPI
import tech.thatgravyboat.skyblockapi.helpers.McClient

object Main : ModInitializer {

    const val VERSION = "0.0.1"

    val configurator = Configurator("customscoreboard")

    override fun onInitialize() {
        configurator.register(MainConfig::class.java)
        ClientCommandRegistrationCallback.EVENT.register(::onRegisterCommands)

        SkyBlockAPI.eventBus.register(CustomScoreboardRenderer)
        SkyBlockAPI.eventBus.register(ElementArea)
        SkyBlockAPI.eventBus.register(ElementTime)
        SkyBlockAPI.eventBus.register(ElementLobby)
        SkyBlockAPI.eventBus.register(ElementObjective)
    }

    private fun onRegisterCommands(
        dispatcher: CommandDispatcher<FabricClientCommandSource>,
        buildContext: CommandBuildContext,
    ) {
        dispatcher.register(
            ClientCommandManager.literal("cs").executes { context ->
                McClient.tell {
                    McClient.setScreen(ResourcefulConfigScreen.get(null, configurator, MainConfig::class.java))
                }
                1
            },
        )
    }
}
