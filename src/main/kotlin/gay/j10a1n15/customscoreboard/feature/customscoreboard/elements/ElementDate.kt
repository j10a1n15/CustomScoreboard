package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.config.categories.LinesConfig
import gay.j10a1n15.customscoreboard.utils.TextUtils.ordinal
import gay.j10a1n15.customscoreboard.utils.Utils.getColoredName
import tech.thatgravyboat.skyblockapi.api.datetime.DateTimeAPI

object ElementDate : Element() {
    override fun getDisplay() =
        DateTimeAPI.season?.run { if (LinesConfig.coloredMonth) getColoredName() else name } + " " + DateTimeAPI.day.ordinal()

    override val configLine = "Date"
}
