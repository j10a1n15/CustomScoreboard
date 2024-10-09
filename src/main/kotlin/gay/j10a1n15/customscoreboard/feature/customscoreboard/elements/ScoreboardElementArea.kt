package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import net.minecraft.network.chat.Component
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.info.ScoreboardUpdateEvent
import tech.thatgravyboat.skyblockapi.api.location.LocationAPI
import tech.thatgravyboat.skyblockapi.utils.regex.component.ComponentRegex
import tech.thatgravyboat.skyblockapi.utils.regex.component.anyMatch
import tech.thatgravyboat.skyblockapi.utils.text.Text

object ScoreboardElementArea : ScoreboardElement() {
    override fun getDisplay() = formattedLocation

    override val configLine = "Area"


    private val locationRegex = ComponentRegex(" *[⏣ф] .+")

    var formattedLocation: Component = Text.of("")

    @Subscription
    fun onScoreboardChange(event: ScoreboardUpdateEvent) {
        if (!LocationAPI.isOnSkyblock) return
        locationRegex.anyMatch(event.addedComponents) {
            this.formattedLocation = it.component
        }
    }
}
