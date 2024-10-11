package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.config.categories.LinesConfig
import gay.j10a1n15.customscoreboard.utils.TextUtils.formatReadableTime
import tech.thatgravyboat.skyblockapi.api.area.hub.ElectionAPI
import tech.thatgravyboat.skyblockapi.api.data.Candidate
import tech.thatgravyboat.skyblockapi.api.datetime.SkyBlockInstant
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland
import kotlin.time.Duration
import kotlin.time.DurationUnit

object ElementMayor : Element() {
    override fun getDisplay() = buildList {
        val mayor = ElectionAPI.currentMayor ?: return@buildList
        val instant = timeUntilNextMayor().formatReadableTime(DurationUnit.DAYS, 2)
        val time = if (LinesConfig.showMayorTime) "§7(§e$instant§7)"
        else ""

        add("${candidateColor[mayor] ?: "§f"}${mayor.candidateName}$time")

        if (LinesConfig.showMayorPerks) {
            for (perk in mayor.activePerks) {
                add(" §7- §e${perk.perkName}")
            }
        }

        if (LinesConfig.showMinister) {
            val minister = ElectionAPI.currentMinister ?: return@buildList

            add("§7Minister: §e${minister.candidateName}")

            if (LinesConfig.showMayorPerks) {
                for (perk in minister.activePerks) {
                    add(" §7- §e${perk.perkName}")
                }
            }
        }
    }

    override fun showIsland() = !SkyBlockIsland.inAnyIsland(SkyBlockIsland.THE_RIFT)

    override fun showWhen() = ElectionAPI.currentMayor != null

    override val configLine = "Mayor"


    private const val ELECTION_MONTH = 3
    private const val ELECTION_DAY = 27

    private fun timeUntilNextMayor(): Duration {
        val instant = SkyBlockInstant.now()

        val mayorYear = if (instant.month < ELECTION_MONTH || (instant.day < ELECTION_DAY && instant.month == ELECTION_MONTH)) {
            instant.year
        } else {
            instant.year + 1
        }

        return SkyBlockInstant(mayorYear, 3, 27) - instant
    }

    private val candidateColor = mapOf(
        Candidate.AATROX to "§3",
        Candidate.COLE to "§e",
        Candidate.DIANA to "§2",
        Candidate.DIAZ to "§6",
        Candidate.FINNEGAN to "§c",
        Candidate.FOXY to "§d",
        Candidate.MARINA to "§b",
        Candidate.PAUL to "§c",
        Candidate.SCORPIUS to "§d",
        Candidate.JERRY to "§d",
        Candidate.DERPY to "§d",
    )
}
