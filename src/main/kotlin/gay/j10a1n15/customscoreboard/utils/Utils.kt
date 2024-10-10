package gay.j10a1n15.customscoreboard.utils

import tech.thatgravyboat.skyblockapi.api.datetime.SkyBlockSeason

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

    fun SkyBlockSeason.getColoredName(): String = seasonColors[this] + this.name
}
