package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.config.MainConfig
import gay.j10a1n15.customscoreboard.config.objects.Position
import gay.j10a1n15.customscoreboard.config.position.Overlay
import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer.display
import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer.isEnabled
import gay.j10a1n15.customscoreboard.utils.Text.toComponent
import gay.j10a1n15.customscoreboard.utils.rendering.RenderUtils.drawAlignedTexts
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.network.chat.Component

object ScoreboardOverlay : Overlay {
    override val name: Component = "Custom Scoreboard".toComponent()
    override val position: Position get() = MainConfig.position
    override var bounds: Pair<Int, Int> = 100 to 100

    override fun render(graphics: GuiGraphics, mouseX: Int, mouseY: Int) {
        if (!isEnabled()) return
        val display = display ?: return
        if (display.isEmpty()) return

        val bounds = graphics.drawAlignedTexts(display, 0, 0)

        this.bounds = bounds
    }

}
