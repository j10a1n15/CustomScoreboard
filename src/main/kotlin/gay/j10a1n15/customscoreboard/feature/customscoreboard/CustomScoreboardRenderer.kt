package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.api.events.RenderHudEvent
import gay.j10a1n15.customscoreboard.utils.rendering.RenderUtils.drawAlignedTexts

object CustomScoreboardRenderer {

    private val display: List<String>? = null

    fun onRender(event: RenderHudEvent) {
        if (display == null) return

        event.graphics.drawAlignedTexts(
            display.map { it to Alignment.START },
            0,
            0,
        )
    }

}