package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.utils.TextUtils.trim
import net.minecraft.network.chat.Component
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.info.ScoreboardUpdateEvent
import tech.thatgravyboat.skyblockapi.api.location.LocationAPI
import tech.thatgravyboat.skyblockapi.utils.regex.component.ComponentRegex
import tech.thatgravyboat.skyblockapi.utils.regex.component.anyMatch

object ScoreboardElementArea : ScoreboardElement() {
    override fun getDisplay() = listOfNotNull(formattedLocation, formattedGardenPlot, formattedVisiting)

    override val configLine = "Area"


    private val locationRegex = ComponentRegex("\\s*[⏣ф] .+")
    private val gardenPlotRegex = ComponentRegex("\\s*Plot -.+")
    private val visitingRegex = ComponentRegex("\\s*✌ \\(\\d+/\\d+\\)")

    private var formattedLocation: Component? = null
    private var formattedGardenPlot: Component? = null
    private var formattedVisiting: Component? = null

    @Subscription
    fun onScoreboardChange(event: ScoreboardUpdateEvent) {
        if (!LocationAPI.isOnSkyblock) return

        if (!locationRegex.anyMatch(event.components) {
                this.formattedLocation = it.component.trim()
            }) {
            formattedLocation = null
        }
        if (!gardenPlotRegex.anyMatch(event.components) {
                this.formattedGardenPlot = it.component
            }) {
            formattedGardenPlot = null
        }
        if (!visitingRegex.anyMatch(event.components) {
                this.formattedVisiting = it.component.trim()
            }) {
            formattedVisiting = null
        }
    }
}
