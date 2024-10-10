package gay.j10a1n15.customscoreboard.utils

import net.minecraft.network.chat.Component
import tech.thatgravyboat.skyblockapi.utils.text.Text

private val colorCodesStart = Regex("^(?<start>(§.| )*)(?!§.| )")
private val colorCodesEnd = Regex("^(?<end>(.§| )*)(?!.§| )")

object TextUtils {

    fun String.toComponent() = Component.literal(this)

    fun String.trimStartIgnoreColor(): String {
        val start = colorCodesStart.find(this)?.groups?.get("start")?.value ?: ""
        val trimmed = this.removePrefix(start)
        return start.replace(" ", "") + trimmed
    }

    fun String.trimEndIgnoreColor(): String {
        val end = colorCodesEnd.find(this.reversed())?.groups?.get("end")?.value?.reversed() ?: ""
        val trimmed = this.removeSuffix(end)
        return trimmed + end.replace(" ", "")
    }

    fun Component.trim(): Component {
        var siblings = this.toFlatList().toMutableList()
        val first = siblings.firstOrNull()
        val last = siblings.lastOrNull()
        siblings = siblings.drop(1).dropLast(1).toMutableList()

        siblings.addFirst(first?.let { Component.literal(it.string.trimStartIgnoreColor()).withStyle(it.style) })
        siblings.addLast(last?.let { Component.literal(it.string.trimEndIgnoreColor()).withStyle(it.style) })

        return Text.join(*siblings.toTypedArray())
    }

    // https://stackoverflow.com/a/74231671/15031174
    fun Int.ordinal() = "$this" + when {
        (this % 100 in 11..13) -> "th"
        (this % 10) == 1 -> "st"
        (this % 10) == 2 -> "nd"
        (this % 10) == 3 -> "rd"
        else -> "th"
    }

}
