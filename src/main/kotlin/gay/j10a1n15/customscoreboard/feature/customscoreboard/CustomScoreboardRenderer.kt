package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.Main
import gay.j10a1n15.customscoreboard.config.Config
import gay.j10a1n15.customscoreboard.utils.rendering.AlignedText
import gay.j10a1n15.customscoreboard.utils.rendering.RenderUtils.drawAlignedTexts
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
import net.minecraft.client.DeltaTracker
import net.minecraft.client.gui.GuiGraphics

object CustomScoreboardRenderer {

    private var display: List<AlignedText>? = null
    private val config: Config get() = Main.config

    fun init() {
        HudRenderCallback.EVENT.register(::onRender)
        ClientTickEvents.START_CLIENT_TICK.register { updateDisplay() }
    }

    private fun onRender(graphics: GuiGraphics, partialTicks: DeltaTracker) {
        display?.let {
            graphics.drawAlignedTexts(
                it,
                100,
                100,
            )
        }
    }

    private fun updateDisplay() {
        display = createDisplay()
    }

    private fun createDisplay() = buildList {
        for (element in config.appearance) {
            addAll(element.element.getLines().map { it.toAlignedText() })
        }
    }

}