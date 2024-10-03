package gay.j10a1n15.customscoreboard.utils

import net.minecraft.network.chat.Component
import java.text.NumberFormat
import java.util.*

object Text {

    fun String.toComponent() = Component.literal(this)

    fun Number.addSeparator() = NumberFormat.getNumberInstance(Locale.US).format(this)
}