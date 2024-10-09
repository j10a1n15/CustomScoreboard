package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.*

enum class ScoreboardEntry(val element: ScoreboardElement) {
    TITLE(ScoreboardElementTitle),
    ISLAND(ScoreboardElementIsland),
    LOCATION(ScoreboardElementArea),
//    DATE(Date),
//    TIME(Time),
//    LOBBY_CODE(LobbyCode),
    PURSE(ScoreboardElementPurse),
    MOTES(ScoreboardElementMotes),
    BANK(ScoreboardElementBank),
    BITS(ScoreboardElementBits),
    COPPER(ScoreboardElementCopper),
    GEMS(ScoreboardElementGems),
    HEAT(ScoreboardElementHeat),
    COLD(ScoreboardElementCold),
    NORTH_STARS(ScoreboardElementNorthStars),

//    OBJECTIVE(Objective),
//    SLAYER(Slayer),
//    EVENTS(Events),
EMPTY(ScoreboardElementEmpty),

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

    FOOTER(ScoreboardElementFooter),
    ;

    override fun toString() = element.configLine
}
