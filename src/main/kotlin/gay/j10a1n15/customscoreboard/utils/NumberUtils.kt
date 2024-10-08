package gay.j10a1n15.customscoreboard.utils

import gay.j10a1n15.customscoreboard.config.MainConfig
import java.text.NumberFormat
import java.util.Locale

enum class NumberFormatType(val format: String) {
    LONG("1.234.567"),
    SHORT("1.2m"),
    ;

    override fun toString() = format
}

object NumberUtils {

    fun Number.format() = when (MainConfig.numberFormat) {
        NumberFormatType.LONG -> addSeparator()
        NumberFormatType.SHORT -> shorten()
    }

    fun Number.addSeparator() = NumberFormat.getNumberInstance(Locale.US).format(this)

    fun Number.shorten(): String {
        val number = this.toLong()
        return when {
            number >= 1_000_000_000_000 -> String.format("%.1ft", number / 1_000_000_000_000.0)
            number >= 1_000_000_000 -> String.format("%.1fb", number / 1_000_000_000.0)
            number >= 1_000_000 -> String.format("%.1fm", number / 1_000_000.0)
            number >= 1_000 -> String.format("%.1fk", number / 1_000.0)
            else -> this.toString()
        }
    }
}

