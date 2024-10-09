package gay.j10a1n15.customscoreboard.config

import com.teamresourceful.resourcefulconfig.api.annotations.*
import com.teamresourceful.resourcefulconfig.api.types.entries.Observable
import gay.j10a1n15.customscoreboard.config.objects.Position
import gay.j10a1n15.customscoreboard.config.objects.TitleOrFooterObject
import gay.j10a1n15.customscoreboard.feature.customscoreboard.ScoreboardEntry
import gay.j10a1n15.customscoreboard.utils.NumberFormatType

@ConfigInfo.Provider(InfoProvider::class)
@Config(
    value = "customscoreboard/config",
    categories = [],
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

    @ConfigOption.Hidden
    @ConfigEntry(id = "position")
    val position = Position(100, 100)
}
