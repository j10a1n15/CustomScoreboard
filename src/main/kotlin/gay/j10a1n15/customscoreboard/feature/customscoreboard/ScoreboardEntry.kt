package gay.j10a1n15.customscoreboard.feature.customscoreboard

import com.teamresourceful.resourcefulconfig.api.types.info.TooltipProvider
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.*
import gay.j10a1n15.customscoreboard.utils.TextUtils.toComponent

enum class ScoreboardEntry(val element: Element) : TooltipProvider {
    SEPARATOR(ElementSeparator),

    TITLE(ElementTitle),
    LOBBY(ElementLobby),
    DATE(ElementDate),
    TIME(ElementTime),
    ISLAND(ElementIsland),
    AREA(ElementArea),
    PROFILE(ElementProfile),

    PURSE(ElementPurse),
    MOTES(ElementMotes),
    BANK(ElementBank),
    BITS(ElementBits),
    COPPER(ElementCopper),
    GEMS(ElementGems),
    HEAT(ElementHeat),
    COLD(ElementCold),
    NORTH_STARS(ElementNorthStars),
    SOULFLOW(ElementSoulflow),

    OBJECTIVE(ElementObjective),
    SLAYER(ElementSlayer),
    EVENTS(ElementEvents),

    //    POWER(Power),
    //    COOKIE(Cookie),
    //    CHUNKED_STATS(ChunkedStats),
    //    QUIVER(Quiver),
    POWDER(ElementPowder),
    MAYOR(ElementMayor),
    PARTY(ElementParty),
    //    Unknown(Unknown),

    FOOTER(ElementFooter),
    ;

    override fun getTooltip() = element.configLineHover.joinToString("\n").toComponent()

    override fun toString() = element.configLine

    companion object {
        val default = arrayOf(
            TITLE,
            LOBBY,
            SEPARATOR,
            DATE,
            TIME,
            ISLAND,
            AREA,
            PROFILE,
            SEPARATOR,
            PURSE,
            MOTES,
            BANK,
            BITS,
            COPPER,
            GEMS,
            HEAT,
            COLD,
            NORTH_STARS,
            SOULFLOW,
            SEPARATOR,
            OBJECTIVE,
            SLAYER,
            EVENTS,
            POWDER,
            MAYOR,
            PARTY,
            FOOTER,
        )
    }
}
