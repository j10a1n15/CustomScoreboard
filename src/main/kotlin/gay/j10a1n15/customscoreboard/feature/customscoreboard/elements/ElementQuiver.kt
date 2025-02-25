package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.config.categories.LinesConfig
import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer
import gay.j10a1n15.customscoreboard.utils.TextUtils.uppercaseFirstChar
import net.minecraft.world.item.Items
import tech.thatgravyboat.skyblockapi.api.profile.quiver.QuiverAPI
import tech.thatgravyboat.skyblockapi.helpers.McPlayer

object ElementQuiver : Element() {
    private const val MAX_ARROW_AMOUNT = 2880

    override fun getDisplay(): String? {
        val type = QuiverAPI.currentArrow?.uppercaseFirstChar() ?: return null
        val amount = QuiverAPI.currentAmount ?: return null

        val percentage = amount / MAX_ARROW_AMOUNT.toDouble() * 100

        val color = if (LinesConfig.colorArrowAmount) {
            when {
                percentage <= 10 -> "§c"
                percentage <= 25 -> "§6"
                percentage <= 50 -> "§e"
                percentage <= 75 -> "§2"
                else -> "§a"
            }
        } else ""

        val wearingSkeletonMasterChestplate = McPlayer.chestplate.hoverName.string.contains("Skeleton Master Chestplate")

        val amountLine = if (wearingSkeletonMasterChestplate) {
            "∞"
        } else {
            when (LinesConfig.arrowDisplay) {
                ArrowDisplay.NUMBER -> amount.toString()
                ArrowDisplay.PERCENTAGE -> "${percentage.toInt()}%"
            }
        }

        return CustomScoreboardRenderer.formatNumberDisplayDisplay(type, amountLine, color)
    }

    override fun showWhen() = McPlayer.inventory.any { it.item == Items.BOW }

    override val configLine = "Quiver"

    enum class ArrowDisplay {
        NUMBER,
        PERCENTAGE,
        ;

        override fun toString() = name.uppercaseFirstChar()
    }
}
