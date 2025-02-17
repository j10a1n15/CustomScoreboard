package gay.j10a1n15.customscoreboard.feature.customscoreboard

import com.teamresourceful.resourcefulconfig.api.types.info.TooltipProvider
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.Element
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementArea
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementBank
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementBits
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementCold
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementCopper
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementDate
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementEvents
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementFooter
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementGems
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementHeat
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementIsland
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementLobby
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementMayor
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementMotes
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementNorthStars
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementObjective
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementParty
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementPet
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementPowder
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementProfile
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementPurse
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementQuiver
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementSeparator
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementSlayer
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementSoulflow
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementTime
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementTitle
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
    QUIVER(ElementQuiver),
    POWDER(ElementPowder),
    MAYOR(ElementMayor),
    PARTY(ElementParty),
    PET(ElementPet),
    //    Unknown(Unknown),

    FOOTER(ElementFooter),
    ;

    override fun getTooltip() = element.configLineHover.joinToString("\n").toComponent()

    override fun toString() = element.configLine

    companion object {
        val default = listOf(
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
            QUIVER,
            EVENTS,
            POWDER,
            MAYOR,
            PARTY,
            PET,
            FOOTER,
        )
    }
}
