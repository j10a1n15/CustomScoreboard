package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.utils.TextUtils.trim
import net.minecraft.network.chat.Component
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.info.ScoreboardUpdateEvent
import tech.thatgravyboat.skyblockapi.api.location.LocationAPI
import tech.thatgravyboat.skyblockapi.utils.regex.component.ComponentRegex
import tech.thatgravyboat.skyblockapi.utils.regex.component.anyMatch
import tech.thatgravyboat.skyblockapi.utils.text.CommonText

// TODO: Overrides the Area element somehow?
object ScoreboardElementTime : ScoreboardElement() {
    override fun getDisplay() = formattedTime

    override val configLine = "Time"


    private val timeRegex = ComponentRegex("\\s*\\d+:\\d+(?:am|pm)(?: (?<symbol>[☀☽⚡☔]))?")

    private var formattedTime: Component = CommonText.EMPTY

    @Subscription
    fun onScoreboardChange(event: ScoreboardUpdateEvent) {
        if (!LocationAPI.isOnSkyblock) return

        if (!timeRegex.anyMatch(event.addedComponents) {
                this.formattedTime = it.component.trim()
            }) {
            formattedTime = CommonText.EMPTY
        }
    }

}
