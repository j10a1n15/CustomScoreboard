package gay.j10a1n15.customscoreboard.utils.rendering

import gay.j10a1n15.customscoreboard.utils.rendering.alignment.TextAlignment
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.Font
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.network.chat.Component

typealias AlignedText = Pair<Component, TextAlignment>

object RenderUtils {

    private val font: Font
        get() = Minecraft.getInstance().font

    fun GuiGraphics.drawAlignedText(text: Component, x: Int, y: Int, width: Int, alignment: TextAlignment) {
        val textWidth = font.width(text)
        drawString(font, text, x + alignment.align(textWidth, width), y, -1)
    }

    fun GuiGraphics.drawAlignedTexts(texts: List<AlignedText>, x: Int, y: Int): Pair<Int, Int> {
        var currentY = y
        val maxWidth = texts.maxOf { font.width(it.first) }
        val maxHeight = texts.sumOf { font.lineHeight }
        texts.forEach { text ->
            drawAlignedText(text.first, x, currentY, maxWidth, text.second)
            currentY += font.lineHeight
        }
        return maxWidth to maxHeight
    }

    fun GuiGraphics.drawAlignedTexts(texts: List<AlignedText>, x: Int, y: Int, width: Int) {
        var currentY = y
        texts.forEach { text ->
            drawAlignedText(text.first, x, currentY, width, text.second)
            currentY += font.lineHeight
        }
    }
}
