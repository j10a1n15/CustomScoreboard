package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import tech.thatgravyboat.skyblockapi.api.datetime.DateTimeAPI
import tech.thatgravyboat.skyblockapi.helpers.McLevel

object ElementTime : Element() {
    override fun getDisplay() = buildString {
        append("§7")

        val hour = DateTimeAPI.hour
        val hour12 = if (hour % 12 == 0) 12 else hour % 12
        val period = if (hour >= 12) "pm" else "am"

        append(String.format("%02d:%02d%s", hour12, DateTimeAPI.minute, period))

        // TODO: Check thunder in spider island
        val symbol = when {
            McLevel.self.isRaining -> "§3☔"
            McLevel.self.isThundering -> "§e⚡"
            DateTimeAPI.isDay -> "§e☀"
            else -> "§b☽"
        }

        append(" $symbol")
    }

    override val configLine = "Time"
}
