package gay.j10a1n15.customscoreboard.config;

import com.teamresourceful.resourcefulconfig.api.annotations.*
import com.teamresourceful.resourcefulconfig.api.types.options.EntryType
import gay.j10a1n15.customscoreboard.config.category.TitleAndFooterConfig
import gay.j10a1n15.customscoreboard.feature.customscoreboard.ScoreboardEntry

@ConfigInfo.Provider(InfoProvider::class)
@Config(
    value = "customscoreboard/config",
    categories = [
        TitleAndFooterConfig::class,
    ],
)
object MainConfig {

    @ConfigEntry(
        id = "Appearance",
        type = EntryType.ENUM,
    )
    @ConfigOption.Draggable
    @Comment("Edit this list to change the order of appearance of the scoreboard.")
    var appearance: Array<ScoreboardEntry> = ScoreboardEntry.entries.toTypedArray()

}
