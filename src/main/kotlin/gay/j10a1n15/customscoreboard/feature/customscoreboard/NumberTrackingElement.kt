package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.Main
import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.profile.ProfileChangeEvent

interface NumberTrackingElement {
    var previousAmount: Long
    var temporaryChangeDisplay: String?
    val numberColor: String

    fun checkDifference(currentAmount: Long) {
        if (previousAmount == -1L) {
            previousAmount = currentAmount
            return
        }
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

    @Subscription
    fun onProfileSwitch(event: ProfileChangeEvent) {
        previousAmount = -1
    }
}
