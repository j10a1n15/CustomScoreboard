package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.config.MainConfig
import gay.j10a1n15.customscoreboard.config.categories.BackgroundConfig
import gay.j10a1n15.customscoreboard.config.categories.LinesConfig
import gay.j10a1n15.customscoreboard.utils.TextUtils.isBlank
import gay.j10a1n15.customscoreboard.utils.rendering.AlignedText
import gay.j10a1n15.customscoreboard.utils.rendering.RenderUtils.drawAlignedTexts
import gay.j10a1n15.customscoreboard.utils.rendering.RenderUtils.fillRect
import gay.j10a1n15.customscoreboard.utils.rendering.alignment.HorizontalAlignment
import gay.j10a1n15.customscoreboard.utils.rendering.alignment.VerticalAlignment
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.minecraft.client.renderer.RenderType
import net.minecraft.resources.ResourceLocation
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.location.IslandChangeEvent
import tech.thatgravyboat.skyblockapi.api.events.render.HudElement
import tech.thatgravyboat.skyblockapi.api.events.render.RenderHudElementEvent
import tech.thatgravyboat.skyblockapi.api.events.render.RenderHudEvent
import tech.thatgravyboat.skyblockapi.api.location.LocationAPI
import tech.thatgravyboat.skyblockapi.helpers.McClient
import tech.thatgravyboat.skyblockapi.helpers.McFont

object CustomScoreboardRenderer {

    private var display: List<AlignedText>? = null
    private var currentIslandElements = emptyList<ScoreboardEntry>()
    var currentIslandEvents = emptyList<ScoreboardEventEntry>()
        private set

    private var position: Pair<Int, Int> = 0 to 0
    private var dimensions: Pair<Int, Int> = 0 to 0

    private val screenWidth get() = McClient.window.guiScaledWidth
    private val screenHeight get() = McClient.window.guiScaledHeight

    private var tickCounter = 0

    private val outlineTexture = ResourceLocation.fromNamespaceAndPath("customscoreboard", "outline")
    private val titleBackgroundTexture = ResourceLocation.fromNamespaceAndPath("customscoreboard", "title")

    init {
        ClientTickEvents.START_CLIENT_TICK.register {
            tickCounter++

            if (tickCounter >= 10) {
                if (isEnabled()) {
                    updateDisplay()
                }
                tickCounter = 0
            }
        }

        MainConfig.appearance.addListener { old, new ->
            updateIslandCache()
        }

        MainConfig.events.addListener { old, new ->
            updateIslandCache()
        }
    }

    private fun updatePosition() {
        with(BackgroundConfig) {
            val width = display?.let { it.maxOf { McFont.width(it.first) } } ?: 0
            val height = display?.let { it.size * McFont.self.lineHeight } ?: 0
            val texturedBackgroundOffset = if (texturedBackground) 10 else 0

            val newX = when (MainConfig.horizontalAlignment) {
                HorizontalAlignment.LEFT -> padding + margin + texturedBackgroundOffset
                HorizontalAlignment.CENTER -> (screenWidth - width) / 2
                HorizontalAlignment.RIGHT -> screenWidth - width - padding - margin - texturedBackgroundOffset
            }
            val newY = when (MainConfig.verticalAlignment) {
                VerticalAlignment.TOP -> padding + margin + texturedBackgroundOffset
                VerticalAlignment.CENTER -> (screenHeight - height) / 2
                VerticalAlignment.BOTTOM -> screenHeight - height - padding - margin - texturedBackgroundOffset
            }
            position = newX to newY
            dimensions = width to height
        }
    }

    @Subscription
    fun onRender(event: RenderHudEvent) {
        if (!isEnabled()) return
        val display = display ?: return
        if (display.isEmpty()) return

        updatePosition()
        renderBackground(event)
        event.graphics.drawAlignedTexts(display, position.first, position.second, MainConfig.textShadow)
    }

    private fun renderBackground(event: RenderHudEvent) {
        if (!BackgroundConfig.enabled) return

        if (BackgroundConfig.texturedBackground) {
            val padding = 15
            val firstElement = MainConfig.appearance.get().first().element.getLines()

            event.graphics.fillRect(
                position.first - padding, position.second - padding,
                dimensions.first + padding * 2, dimensions.second + padding * 2,
                BackgroundConfig.color,
                radius = BackgroundConfig.radius,
            )
            event.graphics.blitSprite(
                RenderType::guiTextured,
                outlineTexture,
                position.first - padding,
                position.second - padding,
                dimensions.first + padding * 2,
                dimensions.second + padding * 2,
            )
            event.graphics.blitSprite(
                RenderType::guiTextured,
                titleBackgroundTexture,
                position.first + dimensions.first / 2,
                position.second - padding,
                30,
                McFont.self.lineHeight * firstElement.size,
            )
        } else {
            val padding = BackgroundConfig.padding
            event.graphics.fillRect(
                position.first - padding, position.second - padding,
                dimensions.first + padding * 2, dimensions.second + padding * 2,
                BackgroundConfig.color,
                radius = BackgroundConfig.radius,
            )
        }
    }

    private fun updateIslandCache() {
        currentIslandElements = MainConfig.appearance.get().filter { it.element.showIsland() }
        currentIslandEvents = MainConfig.events.get().filter { it.event.showIsland() }
    }

    private fun updateDisplay() {
        if (!isEnabled()) return
        createDisplay().hideLeadingAndTrailingSeparators().condenseConsecutiveSeparators().let {
            display = if (BackgroundConfig.texturedBackground) it.drop(1) else it
        }

    }

    private fun createDisplay() = buildList {
        for (element in currentIslandElements) {
            addAll(element.element.getLines().map { it.toAlignedText() })
        }
    }

    private fun List<AlignedText>.hideLeadingAndTrailingSeparators() =
        if (LinesConfig.hideSeparatorsAtStartEnd) this.dropLastWhile { it.first.isBlank() }.dropWhile { it.first.isBlank() } else this

    private fun List<AlignedText>.condenseConsecutiveSeparators() =
        if (!LinesConfig.condenseConsecutiveSeparators) this
        else
            fold(mutableListOf<AlignedText>() to false) { (acc, lastWasSeparator), line ->
                if (line.first.isBlank()) {
                    if (!lastWasSeparator) {
                        acc.add(line)
                    }
                    acc to true
                } else {
                    acc.add(line)
                    acc to false
                }
            }.first

    @Subscription
    fun onRenderHudElement(event: RenderHudElementEvent) {
        if (event.element == HudElement.SCOREBOARD && hideHypixelScoreboard()) {
            event.cancel()
        }
    }

    @Subscription
    fun onIslandChange(event: IslandChangeEvent) {
        updateIslandCache()
    }

    fun formatNumberDisplayDisplay(text: String, number: String, color: String) = when (MainConfig.numberDisplayFormat) {
        NumberDisplayFormat.TEXT_COLOR_NUMBER -> "§f$text: $color$number"
        NumberDisplayFormat.COLOR_TEXT_NUMBER -> "$color$text: $number"
        NumberDisplayFormat.COLOR_NUMBER_TEXT -> "$color$number $text"
        NumberDisplayFormat.COLOR_NUMBER_RESET_TEXT -> "$color$number §f$text"
    }

    enum class NumberDisplayFormat(val config: String) {
        TEXT_COLOR_NUMBER("§fPurse: §6123"),
        COLOR_TEXT_NUMBER("§6Purse: 123"),
        COLOR_NUMBER_TEXT("§6123 Purse"),
        COLOR_NUMBER_RESET_TEXT("§6123 §fPurse"),
        ;

        override fun toString() = config
    }

    private fun isEnabled() = LocationAPI.isOnSkyBlock && MainConfig.enabled
    private fun hideHypixelScoreboard() = isEnabled() && MainConfig.hideHypixelScoreboard

}
