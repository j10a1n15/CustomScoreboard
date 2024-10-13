package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.Event
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventBroodmother
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventCarnival
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventDarkAuction
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventDojo
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventEssence
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventFlightDuration
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventGarden
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventJacobMedals
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventJacobsContest
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventNewYear
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventRedstone
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventServerRestart
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventTrapper
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventVoting
import gay.j10a1n15.customscoreboard.feature.customscoreboard.events.EventWinter

enum class ScoreboardEventEntry(val event: Event) {
    VOTING(EventVoting),
    SERVER_RESTART(EventServerRestart),

    //     DUNGEONS(ScoreboardEventDungeons),
//     KUUDRA(ScoreboardEventKuudra),
    DOJO(EventDojo),
    DARK_AUCTION(EventDarkAuction),
    JACOB_CONTEST(EventJacobsContest),
    JACOB_MEDALS(EventJacobMedals),

    TRAPPER(EventTrapper),
    GARDEN(EventGarden),
    FLIGHT_DURATION(EventFlightDuration),

    WINTER(EventWinter),
    NEW_YEAR(EventNewYear),

    //     SPOOKY(ScoreboardEventSpooky),
    BROODMOTHER(EventBroodmother),

    //     MINING_EVENTS(ScoreboardEventMining),
//     DAMAGE(ScoreboardEventDamage),
//     MAGMA_BOSS(ScoreboardEventMagmaBoss),
    CARNIVAL(EventCarnival),
//     RIFT(ScoreboardEventRift),
    ESSENCE(EventEssence),

    //     QUEUE(ScoreboardEventQueue),
    REDSTONE(EventRedstone),


//     ACTIVE_TABLIST_EVENTS(ScoreboardEventActiveTablist),
//     STARTING_SOON_TABLIST_EVENTS(ScoreboardEventStartingSoonTablist),
    ;

    override fun toString() = event.configLine
}
