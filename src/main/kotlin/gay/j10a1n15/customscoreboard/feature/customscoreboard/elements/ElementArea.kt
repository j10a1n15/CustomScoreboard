package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.utils.TextUtils.trim
import net.minecraft.network.chat.Component
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.info.ScoreboardUpdateEvent
import tech.thatgravyboat.skyblockapi.utils.regex.RegexUtils.anyMatch
import tech.thatgravyboat.skyblockapi.utils.regex.component.ComponentRegex
import tech.thatgravyboat.skyblockapi.utils.regex.component.anyMatch

object ElementArea : Element() {
    override fun getDisplay() = listOfNotNull(formattedLocation, formattedGardenPlot, formattedVisiting)

    override val configLine = "Area"


    private val locationComponentRegex = ComponentRegex("\\s*[⏣ф] .+")
    private val gardenPlotComponentRegex = ComponentRegex("\\s*Plot -.+")
    private val visitingComponentRegex = ComponentRegex("\\s*✌ \\(\\d+/\\d+\\)")

    private val gardenPlotRegex = gardenPlotComponentRegex.regex()
    private val visitingRegex = visitingComponentRegex.regex()

    private var formattedLocation: Component? = null
    private var formattedGardenPlot: Component? = null
    private var formattedVisiting: Component? = null

    @Subscription
    fun onScoreboardChange(event: ScoreboardUpdateEvent) {
        locationComponentRegex.anyMatch(event.addedComponents) {
            this.formattedLocation = it.component.trim()
        }
        val addedGardenPlot = gardenPlotComponentRegex.anyMatch(event.addedComponents) {
            this.formattedGardenPlot = it.component
        }
        val addedVisiting = visitingComponentRegex.anyMatch(event.addedComponents) {
            this.formattedVisiting = it.component.trim()
        }

        if (!addedGardenPlot && formattedGardenPlot != null && gardenPlotRegex.anyMatch(event.removed)) {
            formattedGardenPlot = null
        }
        if (!addedVisiting && formattedVisiting != null && visitingRegex.anyMatch(event.removed)) {
            formattedVisiting = null
        }
    }
}
