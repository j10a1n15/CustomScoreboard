package gay.j10a1n15.customscoreboard.config

import com.teamresourceful.resourcefulconfig.api.types.info.ResourcefulConfigLink
import com.teamresourceful.resourcefulconfig.api.types.options.TranslatableValue
import com.teamresourceful.resourcefulconfigkt.api.ConfigKt
import gay.j10a1n15.customscoreboard.Main
import gay.j10a1n15.customscoreboard.config.categories.BackgroundConfig
import gay.j10a1n15.customscoreboard.config.categories.LinesConfig
import gay.j10a1n15.customscoreboard.config.objects.TitleOrFooterObject
import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer
import gay.j10a1n15.customscoreboard.feature.customscoreboard.ScoreboardEntry
import gay.j10a1n15.customscoreboard.feature.customscoreboard.ScoreboardEventEntry
import gay.j10a1n15.customscoreboard.utils.NumberFormatType
import gay.j10a1n15.customscoreboard.utils.rendering.alignment.HorizontalAlignment
import gay.j10a1n15.customscoreboard.utils.rendering.alignment.VerticalAlignment

object MainConfig : ConfigKt("customscoreboard/config") {

    override val name get() = TranslatableValue("Custom Scoreboard Config")
    override val description get() = TranslatableValue("by j10a1n15. Version ${Main.VERSION}")
    override val links: Array<ResourcefulConfigLink>
        get() = arrayOf(
            ResourcefulConfigLink.create(
                "https://discord.gg/FsRc2GUwZR",
                "discord",
                TranslatableValue("Discord"),
            ),
            ResourcefulConfigLink.create(
                "https://modrinth.com/mod/skyblock-custom-scoreboard",
                "modrinth",
                TranslatableValue("Modrinth"),
            ),
            ResourcefulConfigLink.create(
                "https://github.com/meowdding/CustomScoreboard",
                "code",
                TranslatableValue("GitHub"),
            ),
        )

    init {
        category(BackgroundConfig)
        category(LinesConfig)
    }

    var enabled by boolean(true) {
        this.name = Translated("config.cs.enabled")
        this.description = Translated("config.cs.enabled.desc")
    }

    val appearance by observable(
        draggable(*ScoreboardEntry.default.toTypedArray()) {
            this.name = Translated("config.cs.appearance")
            this.description = Translated("config.cs.appearance.desc")
        },
    ) { old, new ->
        CustomScoreboardRenderer.updateIslandCache()
    }

    val events by observable(
        draggable(*ScoreboardEventEntry.entries.toTypedArray()) {
            this.name = Translated("config.cs.events")
            this.description = Translated("config.cs.events.desc")
        },
    ) { old, new ->
        CustomScoreboardRenderer.updateIslandCache()
    }

    val title = obj("title_options", TitleOrFooterObject()) {
        this.name = Translated("config.cs.title_options")
        this.description = Translated("config.cs.title_options.desc")
    }

    val footer = obj("footer_options", TitleOrFooterObject()) {
        this.name = Translated("config.cs.footer_options")
        this.description = Translated("config.cs.footer_options.desc")
    }

    val numberDisplayFormat by enum("number_display_format", CustomScoreboardRenderer.NumberDisplayFormat.TEXT_COLOR_NUMBER) {
        this.name = Translated("config.cs.number_display_format")
        this.description = Translated("config.cs.number_display_format.desc")
    }

    val numberFormat by enum("number_format", NumberFormatType.LONG) {
        this.name = Translated("config.cs.number_format")
        this.description = Translated("config.cs.number_format.desc")
    }

    val verticalAlignment by enum("vertical_alignment", VerticalAlignment.CENTER) {
        this.name = Translated("config.cs.vertical_alignment")
        this.description = Translated("config.cs.vertical_alignment.desc")
    }

    val horizontalAlignment by enum("horizontal_alignment", HorizontalAlignment.RIGHT) {
        this.name = Translated("config.cs.horizontal_alignment")
        this.description = Translated("config.cs.horizontal_alignment.desc")
    }

    val hideHypixelScoreboard by boolean("hide_hypixel", true) {
        this.name = Translated("config.cs.hide_hypixel")
        this.description = Translated("config.cs.hide_hypixel.desc")
    }

    val textShadow by boolean("text_shadow", true) {
        this.name = Translated("config.cs.text_shadow")
        this.description = Translated("config.cs.text_shadow.desc")
    }

    val updateNotification by boolean("update_notification", true) {
        this.name = Translated("config.cs.update_notification")
        this.description = Translated("config.cs.update_notification.desc")
    }

}
