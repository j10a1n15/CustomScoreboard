package gay.j10a1n15.customscoreboard.api.events

import gay.j10a1n15.customscoreboard.api.EventHandler
import net.minecraft.client.gui.GuiGraphics

data class RenderHudEvent(val graphics: GuiGraphics) {

    companion object {

        @JvmStatic
        val EVENT = EventHandler<RenderHudEvent>()
    }
}