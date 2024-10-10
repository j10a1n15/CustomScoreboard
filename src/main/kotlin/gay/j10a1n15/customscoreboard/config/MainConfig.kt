package gay.j10a1n15.customscoreboard.config

import com.teamresourceful.resourcefulconfig.api.annotations.*
import com.teamresourceful.resourcefulconfig.api.types.entries.Observable
import gay.j10a1n15.customscoreboard.config.categories.BackgroundConfig
import gay.j10a1n15.customscoreboard.config.objects.TitleOrFooterObject
import gay.j10a1n15.customscoreboard.feature.customscoreboard.ScoreboardEntry
import gay.j10a1n15.customscoreboard.utils.NumberFormatType
import gay.j10a1n15.customscoreboard.utils.rendering.HorizontalAlignment
import gay.j10a1n15.customscoreboard.utils.rendering.VerticalAlignment

@ConfigInfo.Provider(InfoProvider::class)
@Config(
    value = "customscoreboard/config",
    categories = [BackgroundConfig::class],
)
object MainConfig {

    @ConfigEntry(id = "enabled", translation = "config.cs.enabled")
    @Comment("", translation = "config.cs.enabled.desc")
    var enabled: Boolean = true

    @ConfigEntry(id = "appearance", translation = "config.cs.appearance")
    @ConfigOption.Draggable(value = ["EMPTY"])
    @Comment("", translation = "config.cs.appearance.desc")
    val appearance: Observable<Array<ScoreboardEntry>> = Observable.of(ScoreboardEntry.entries.toTypedArray())

    @ConfigEntry(id = "title_options", translation = "config.cs.title_options")
    @Comment("", translation = "config.cs.title_options.desc")
    val title: TitleOrFooterObject = TitleOrFooterObject()

    @ConfigEntry(id = "footer_options", translation = "config.cs.footer_options")
    @Comment("", translation = "config.cs.footer_options.desc")
    val footer: TitleOrFooterObject = TitleOrFooterObject()

    @ConfigEntry(id = "number_format", translation = "config.cs.number_format")
    @Comment("", translation = "config.cs.number_format.desc")
    var numberFormat: NumberFormatType = NumberFormatType.LONG

    @ConfigEntry(id = "padding", translation = "config.cs.padding")
    @Comment("", translation = "config.cs.padding.desc")
    @ConfigOption.Range(min = 0.0, max = 20.0)
    @ConfigOption.Slider
    var padding: Int = 5

    @ConfigEntry(id = "vertical_alignment", translation = "config.cs.vertical_alignment")
    @Comment("", translation = "config.cs.vertical_alignment.desc")
    var verticalAlignment: VerticalAlignment = VerticalAlignment.CENTER

    @ConfigEntry(id = "horizontal_alignment", translation = "config.cs.horizontal_alignment")
    @Comment("", translation = "config.cs.horizontal_alignment.desc")
    var horizontalAlignment: HorizontalAlignment = HorizontalAlignment.RIGHT

    @ConfigEntry(id = "hide_hypixel", translation = "config.cs.hide_hypixel")
    @Comment("", translation = "config.cs.hide_hypixel.desc")
    var hideHypixelScoreboard: Boolean = true
}
