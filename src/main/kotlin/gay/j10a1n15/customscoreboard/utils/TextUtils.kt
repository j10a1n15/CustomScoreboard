package gay.j10a1n15.customscoreboard.utils

import net.minecraft.network.chat.Component
import tech.thatgravyboat.skyblockapi.utils.extentions.trimIgnoreColor
import tech.thatgravyboat.skyblockapi.utils.text.Text

object TextUtils {

    fun String.toComponent() = Component.literal(this)

    fun Component.trim(): Component {
        var siblings = this.toFlatList().toMutableList()
        val first = siblings.firstOrNull()
        val last = siblings.lastOrNull()
        siblings = siblings.drop(1).dropLast(1).toMutableList()

        siblings.addFirst(first?.let { Component.literal((it.string + "|").trimIgnoreColor().removeSuffix("|")).withStyle(it.style) })
        siblings.addLast(last?.let { Component.literal(("|" + it.string).trimIgnoreColor().removePrefix("|")).withStyle(it.style) })

        return Text.join(*siblings.toTypedArray())
    }

}
