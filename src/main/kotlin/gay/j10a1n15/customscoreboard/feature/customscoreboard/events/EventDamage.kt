package gay.j10a1n15.customscoreboard.feature.customscoreboard.events

import net.minecraft.network.chat.Component
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.info.ScoreboardUpdateEvent
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland
import tech.thatgravyboat.skyblockapi.utils.regex.component.ComponentRegex

object EventDamage : Event() {
    override fun getDisplay() = formattedLines

    override fun showIsland() = SkyBlockIsland.inAnyIsland(SkyBlockIsland.JERRYS_WORKSHOP)

    override val configLine = "Winter"


    private var formattedLines = mutableListOf<Component>()

    private val hpRegex = ComponentRegex("(?:Protector|Dragon) HP: [\\d,.]* ❤")
    private val damageRegex = ComponentRegex("Your Damage: [\\d,.]+")

    private val patterns = listOf(hpRegex, damageRegex)


    @Subscription
    fun onScoreboardUpdate(event: ScoreboardUpdateEvent) {
        formattedLines.clear()
        formattedLines.addAll(
            event.components.filter { component ->
                patterns.any { it.matches(component) }
            },
        )
    }
}
