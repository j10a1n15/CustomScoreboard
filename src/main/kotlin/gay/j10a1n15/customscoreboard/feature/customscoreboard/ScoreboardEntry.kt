package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.*

enum class ScoreboardEntry(val element: Element) {
    TITLE(ElementTitle),
    ISLAND(ElementIsland),
    AREA(ElementArea),
//    DATE(Date),
TIME(ElementTime),
//    LOBBY_CODE(LobbyCode),
PURSE(ElementPurse),
    MOTES(ElementMotes),
    BANK(ElementBank),
    BITS(ElementBits),
    COPPER(ElementCopper),
    GEMS(ElementGems),
    HEAT(ElementHeat),
    COLD(ElementCold),
    NORTH_STARS(ElementNorthStars),

//    OBJECTIVE(Objective),
//    SLAYER(Slayer),
//    EVENTS(Events),
EMPTY(ElementEmpty),

//    PROFILE(Profile),
//    POWER(Power),
//    TUNING(Tuning),
//    COOKIE(Cookie),
//    CHUNKED_STATS(ChunkedStats),
//    SOULFLOW(Soulflow),
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
