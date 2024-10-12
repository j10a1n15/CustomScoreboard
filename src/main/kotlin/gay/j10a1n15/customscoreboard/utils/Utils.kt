package gay.j10a1n15.customscoreboard.utils

import net.minecraft.network.chat.Component
import tech.thatgravyboat.skyblockapi.api.datetime.SkyBlockSeason
import tech.thatgravyboat.skyblockapi.utils.text.TextProperties.stripped
import kotlin.time.Duration
import kotlin.time.DurationUnit

object Utils {
    private val seasonColors = mapOf(
        SkyBlockSeason.EARLY_SPRING to "§a",
        SkyBlockSeason.SPRING to "§a",
        SkyBlockSeason.LATE_SPRING to "§a",
        SkyBlockSeason.EARLY_SUMMER to "§e",
        SkyBlockSeason.SUMMER to "§e",
        SkyBlockSeason.LATE_SUMMER to "§e",
        SkyBlockSeason.EARLY_AUTUMN to "§6",
        SkyBlockSeason.AUTUMN to "§6",
        SkyBlockSeason.LATE_AUTUMN to "§6",
        SkyBlockSeason.EARLY_WINTER to "§9",
        SkyBlockSeason.WINTER to "§9",
        SkyBlockSeason.LATE_WINTER to "§9",
    )

    fun SkyBlockSeason.getColoredName(): String = seasonColors[this] + this.toString()

    fun <T> Collection<T>.nextAfter(element: T, skip: Int = 1): T? {
        val index = indexOfFirst { if (it is Component && element is String) it.stripped == element else it == element }
        if (index == -1 || index + skip >= size) return null
        return elementAt(index + skip)
    }

    // https://stackoverflow.com/a/74231671/15031174
    fun Int.ordinal() = "$this" + when {
        (this % 100 in 11..13) -> "th"
        (this % 10) == 1 -> "st"
        (this % 10) == 2 -> "nd"
        (this % 10) == 3 -> "rd"
        else -> "th"
    }

    fun Duration.formatReadableTime(biggestUnit: DurationUnit, maxUnits: Int = -1): String {
        val units = listOf(
            DurationUnit.DAYS to this.inWholeDays,
            DurationUnit.HOURS to this.inWholeHours % 24,
            DurationUnit.MINUTES to this.inWholeMinutes % 60,
            DurationUnit.SECONDS to this.inWholeSeconds % 60,
            DurationUnit.MILLISECONDS to this.inWholeMilliseconds % 1000,
        )

        val unitNames = mapOf(
            DurationUnit.DAYS to "d",
            DurationUnit.HOURS to "h",
            DurationUnit.MINUTES to "min",
            DurationUnit.SECONDS to "s",
            DurationUnit.MILLISECONDS to "ms",
        )

        val filteredUnits = units.dropWhile { it.first != biggestUnit }
            .filter { it.second > 0 }
            .take(maxUnits)

        return filteredUnits.joinToString(", ") { (unit, value) ->
            "$value${unitNames[unit]}"
        }.ifEmpty { "0 seconds" }
    }
}
