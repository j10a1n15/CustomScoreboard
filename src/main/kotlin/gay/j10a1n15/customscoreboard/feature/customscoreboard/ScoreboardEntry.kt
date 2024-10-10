package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.*

enum class ScoreboardEntry(val element: Element) {
    EMPTY(ElementEmpty),

    TITLE(ElementTitle),
    LOBBY(ElementLobby),
    DATE(ElementDate),
    TIME(ElementTime),
    ISLAND(ElementIsland),
    AREA(ElementArea),

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
    //    SLAYER(Slayer),
    //    EVENTS(Events),

    //    PROFILE(Profile),
    //    POWER(Power),
    //    TUNING(Tuning),
    //    COOKIE(Cookie),
    //    CHUNKED_STATS(ChunkedStats),
    //    PLAYER_AMOUNT(PlayerAmount),
    //    QUIVER(Quiver),
    //    POWDER(Powder),
    //    MAYOR(Mayor),
    //    PARTY(Party),
    //    Unknown(Unknown),

    FOOTER(ElementFooter),
    ;

    override fun toString() = element.configLine
}
