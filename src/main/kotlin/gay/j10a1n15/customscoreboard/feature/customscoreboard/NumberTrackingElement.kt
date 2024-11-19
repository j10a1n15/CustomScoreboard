package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.Main
import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

interface NumberTrackingElement {
    var previousAmount: Long
    var temporaryChangeDisplay: String?
    val numberColor: String

    fun checkDifference(currentAmount: Long) {
        if (currentAmount != previousAmount) {
            val changeAmount = currentAmount - previousAmount
            showTemporaryChange(changeAmount)
            previousAmount = currentAmount
        }
    }

    private fun showTemporaryChange(changeAmount: Long, durationMillis: Long = 5000) {
        temporaryChangeDisplay = if (changeAmount > 0) {
            " §7($numberColor+${changeAmount.format()}§7)$numberColor"
        } else {
            " §7($numberColor${changeAmount.format()}§7)$numberColor"
        }


        Main.coroutineScope.launch {
            delay(durationMillis)
            temporaryChangeDisplay = null
        }
    }
}
