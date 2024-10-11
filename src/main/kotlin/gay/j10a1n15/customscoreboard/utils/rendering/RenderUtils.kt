package gay.j10a1n15.customscoreboard.utils.rendering

import com.teamresourceful.resourcefullibkt.client.pushPop
import earth.terrarium.olympus.client.shader.builtin.RoundedRectShader
import gay.j10a1n15.customscoreboard.utils.rendering.alignment.TextAlignment
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.network.chat.Component
import tech.thatgravyboat.skyblockapi.helpers.McClient

typealias AlignedText = Pair<Component, TextAlignment>

object RenderUtils {

    fun GuiGraphics.drawAlignedText(text: Component, x: Int, y: Int, width: Int, alignment: TextAlignment, shadow: Boolean = true) {
        val textWidth = McClient.self.font.width(text)
        drawString(McClient.self.font, text, x + alignment.align(textWidth, width), y, -1, shadow)
    }

    fun GuiGraphics.drawAlignedTexts(texts: List<AlignedText>, x: Int, y: Int, shadow: Boolean = true) {
        var currentY = y
        val maxWidth = texts.maxOf { McClient.self.font.width(it.first) }
        texts.forEach { text ->
            drawAlignedText(text.first, x, currentY, maxWidth, text.second, shadow)
            currentY += McClient.self.font.lineHeight
        }
    }

    fun GuiGraphics.drawAlignedTexts(texts: List<AlignedText>, x: Int, y: Int, width: Int) {
        var currentY = y
        texts.forEach { text ->
            drawAlignedText(text.first, x, currentY, width, text.second)
            currentY += McClient.self.font.lineHeight
        }
    }

    fun GuiGraphics.fillRect(
        x: Int, y: Int, width: Int, height: Int,
        backgroundColor: Int, borderColor: Int = backgroundColor,
        borderSize: Int = 0, radius: Int = 0,
    ) {
        val xOffset = this.pose().last().pose().m30()
        val yOffset = this.pose().last().pose().m31()
        pushPop {
            translate(-xOffset, -yOffset, 0f)
            RoundedRectShader.fill(
                this@fillRect, (x + xOffset).toInt(), (y + yOffset).toInt(), width, height,
                backgroundColor, borderColor, radius.toFloat(), borderSize,
            )
        }
    }
}
