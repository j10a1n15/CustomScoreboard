package gay.j10a1n15.customscoreboard.config

import com.teamresourceful.resourcefulconfig.api.annotations.*
import com.teamresourceful.resourcefulconfig.api.types.entries.Observable
import gay.j10a1n15.customscoreboard.config.objects.TitleOrFooterObject
import gay.j10a1n15.customscoreboard.feature.customscoreboard.ScoreboardEntry

@ConfigInfo.Provider(InfoProvider::class)
@Config(
    value = "customscoreboard/config",
    categories = [],
)
object MainConfig {

    @ConfigEntry(id = "enabled")
    @Comment("Enable or disable the custom scoreboard.")
    var enabled: Boolean = true

    @ConfigEntry(id = "appearance")
    @ConfigOption.Draggable
    @Comment("Edit this list to change the order of appearance of the scoreboard.")
    val appearance: Observable<Array<ScoreboardEntry>> = Observable.of(ScoreboardEntry.entries.toTypedArray())

    @ConfigEntry(id = "title_options")
    @Comment("Edit the title of the scoreboard.")
    val title: TitleOrFooterObject = TitleOrFooterObject()

    @ConfigEntry(id = "footer_options")
    @Comment("Edit the footer of the scoreboard.")
    val footer: TitleOrFooterObject = TitleOrFooterObject()
}
