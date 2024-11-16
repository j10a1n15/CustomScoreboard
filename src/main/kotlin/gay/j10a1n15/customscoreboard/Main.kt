package gay.j10a1n15.customscoreboard

import com.teamresourceful.resourcefulconfig.api.client.ResourcefulConfigScreen
import com.teamresourceful.resourcefulconfig.api.loader.Configurator
import gay.j10a1n15.customscoreboard.config.MainConfig
import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementArea
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementLobby
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementObjective
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementSlayer
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementTime
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventBroodmother
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventCarnival
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventDamage
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventDarkAuction
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventDojo
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventDungeons
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventEssence
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventFlightDuration
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventGarden
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventJacobsContest
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventKuudra
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventMagmaBoss
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventMining
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventNewYear
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventQueue
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventRedstone
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventRift
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventServerRestart
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventSpooky
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventTrapper
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventVoting
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventWinter
import gay.j10a1n15.customscoreboard.feature.updatechecker.UpdateChecker
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import net.fabricmc.api.ModInitializer
import tech.thatgravyboat.skyblockapi.api.SkyBlockAPI
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.misc.LiteralCommandBuilder
import tech.thatgravyboat.skyblockapi.api.events.misc.RegisterCommandsEvent
import tech.thatgravyboat.skyblockapi.helpers.McClient

object Main : ModInitializer {

    const val VERSION = "@MOD_VERSION@"

    val configurator = Configurator("customscoreboard")

    private val globalJob: Job = Job(null)
    val coroutineScope = CoroutineScope(
        CoroutineName("CustomScoreboard") + SupervisorJob(globalJob),
    )

    override fun onInitialize() {
        configurator.register(MainConfig::class.java)

        SkyBlockAPI.eventBus.register(this)
        SkyBlockAPI.eventBus.register(CustomScoreboardRenderer)
        SkyBlockAPI.eventBus.register(UpdateChecker)
        SkyBlockAPI.eventBus.register(ElementArea)
        SkyBlockAPI.eventBus.register(ElementTime)
        SkyBlockAPI.eventBus.register(ElementLobby)
        SkyBlockAPI.eventBus.register(ElementObjective)
        SkyBlockAPI.eventBus.register(ElementSlayer)
        SkyBlockAPI.eventBus.register(EventVoting)
        SkyBlockAPI.eventBus.register(EventBroodmother)
        SkyBlockAPI.eventBus.register(EventEssence)
        SkyBlockAPI.eventBus.register(EventRedstone)
        SkyBlockAPI.eventBus.register(EventFlightDuration)
        SkyBlockAPI.eventBus.register(EventServerRestart)
        SkyBlockAPI.eventBus.register(EventDarkAuction)
        SkyBlockAPI.eventBus.register(EventNewYear)
        SkyBlockAPI.eventBus.register(EventGarden)
        SkyBlockAPI.eventBus.register(EventTrapper)
        SkyBlockAPI.eventBus.register(EventDojo)
        SkyBlockAPI.eventBus.register(EventWinter)
        SkyBlockAPI.eventBus.register(EventCarnival)
        SkyBlockAPI.eventBus.register(EventMagmaBoss)
        SkyBlockAPI.eventBus.register(EventSpooky)
        SkyBlockAPI.eventBus.register(EventDamage)
        SkyBlockAPI.eventBus.register(EventQueue)
        SkyBlockAPI.eventBus.register(EventMining)
        SkyBlockAPI.eventBus.register(EventKuudra)
        SkyBlockAPI.eventBus.register(EventDungeons)
        SkyBlockAPI.eventBus.register(EventRift)
        SkyBlockAPI.eventBus.register(EventJacobsContest)
    }

    @Subscription
    fun onRegisterCommands(event: RegisterCommandsEvent) {
        val builder: (LiteralCommandBuilder.() -> Unit) = {
            callback {
                McClient.tell {
                    McClient.setScreen(ResourcefulConfigScreen.get(null, configurator, MainConfig::class.java))
                }
            }
        }

        event.register("customscoreboard") { builder() }
        event.register("csb") { builder() }
        event.register("cs") { builder() }
    }
}
