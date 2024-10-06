package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.*

enum class ScoreboardEntry(val element: ScoreboardElement) {
    TITLE(Title),

    //    ISLAND(Island),
//    LOCATION(Location),
//    VISITING(Visiting),
//    DATE(Date),
//    TIME(Time),
//    LOBBY_CODE(LobbyCode),
    PURSE(Purse),
    MOTES(Motes),
    BANK(Bank),
    BITS(Bits),
    COPPER(Copper),
    GEMS(Gems),
    HEAT(Heat),
    COLD(Cold),
    NORTH_STARS(NorthStars),
//    OBJECTIVE(Objective),
//    SLAYER(Slayer),
//    EVENTS(Events),
//    EXTRA(Extra),
//    EMPTY_LINE(EmptyLine),

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

    FOOTER(Footer),
    ;

    override fun toString() = element.configLine
}
