package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.utils.TextUtils.trim
import net.minecraft.network.chat.Component
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.info.ScoreboardUpdateEvent
import tech.thatgravyboat.skyblockapi.api.location.LocationAPI
import tech.thatgravyboat.skyblockapi.utils.regex.component.ComponentRegex
import tech.thatgravyboat.skyblockapi.utils.regex.component.anyMatch
import tech.thatgravyboat.skyblockapi.utils.text.CommonText

object ScoreboardElementArea : ScoreboardElement() {
    override fun getDisplay() =
        listOf(formattedLocation, formattedGardenPlot, formattedVisiting).filter { it != CommonText.EMPTY }

    override val configLine = "Area"


    private val locationRegex = ComponentRegex("\\s*[⏣ф] .+")
    private val gardenPlotRegex = ComponentRegex("\\s*Plot -.+")
    private val visitingRegex = ComponentRegex("\\s*✌ \\(\\d+/\\d+\\)")

    private var formattedLocation: Component = CommonText.EMPTY
    private var formattedGardenPlot: Component = CommonText.EMPTY
    private var formattedVisiting: Component = CommonText.EMPTY

    @Subscription
    fun onScoreboardChange(event: ScoreboardUpdateEvent) {
        if (!LocationAPI.isOnSkyblock) return

        if (!locationRegex.anyMatch(event.addedComponents) {
                this.formattedLocation = it.component.trim()
            }) {
            formattedLocation = CommonText.EMPTY
        }
        if (!gardenPlotRegex.anyMatch(event.addedComponents) {
                this.formattedGardenPlot = it.component
            }) {
            formattedGardenPlot = CommonText.EMPTY
        }
        if (!visitingRegex.anyMatch(event.addedComponents) {
                this.formattedVisiting = it.component.trim()
            }) {
            formattedVisiting = CommonText.EMPTY
        }
    }
}
