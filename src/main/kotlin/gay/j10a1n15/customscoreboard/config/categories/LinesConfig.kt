package gay.j10a1n15.customscoreboard.config.categories

import com.teamresourceful.resourcefulconfig.api.annotations.Category
import com.teamresourceful.resourcefulconfig.api.annotations.Comment
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigOption
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementQuiver

@Category("Line Modification")
object LinesConfig {

    @ConfigEntry(id = "bits_available", translation = "config.cs.lines.bits_available")
    @Comment("", translation = "config.cs.lines.bits_available.desc")
    var showBitsAvailable = true

    @ConfigEntry(id = "colored_month", translation = "config.cs.lines.colored_month")
    @Comment("", translation = "config.cs.lines.colored_month.desc")
    var coloredMonth = true

    @ConfigEntry(id = "profile_name", translation = "config.cs.lines.profile_name")
    @Comment("", translation = "config.cs.lines.profile_name.desc")
    var showProfileName = false

    @ConfigEntry(id = "mayor_time", translation = "config.cs.lines.mayor_time")
    @Comment("", translation = "config.cs.lines.mayor_time.desc")
    var showMayorTime = true

    @ConfigEntry(id = "mayor_perks", translation = "config.cs.lines.mayor_perks")
    @Comment("", translation = "config.cs.lines.mayor_perks.desc")
    var showMayorPerks = true

    @ConfigEntry(id = "mayor_minister", translation = "config.cs.lines.mayor_minister")
    @Comment("", translation = "config.cs.lines.mayor_minister.desc")
    var showMinister = true

    @ConfigEntry(id = "all_events", translation = "config.cs.lines.all_events")
    @Comment("", translation = "config.cs.lines.all_events.desc")
    var showAllActiveEvents = true

    @ConfigEntry(id = "hypixel_title", translation = "config.cs.lines.hypixel_title")
    @Comment("", translation = "config.cs.lines.hypixel_title.desc")
    var useHypixelTitle = true

    @ConfigEntry(id = "party_everywhere", translation = "config.cs.lines.party_everywhere")
    @Comment("", translation = "config.cs.lines.party_everywhere.desc")
    var showPartyEverywhere = true

    @ConfigEntry(id = "max_party", translation = "config.cs.lines.max_party")
    @Comment("", translation = "config.cs.lines.max_party.desc")
    @ConfigOption.Range(min = 1.0, max = 10.0)
    @ConfigOption.Slider
    var maxPartyMembers = 5

    @ConfigEntry(id = "party_leader", translation = "config.cs.lines.party_leader")
    @Comment("", translation = "config.cs.lines.party_leader.desc")
    var showPartyLeader = true

    @ConfigEntry(id = "consecutive_separator", translation = "config.cs.lines.consecutive_separator")
    @Comment("", translation = "config.cs.lines.consecutive_separator.desc")
    var condenseConsecutiveSeparators = true

    @ConfigEntry(id = "separators_start_end", translation = "config.cs.lines.separators_start_end")
    @Comment("", translation = "config.cs.lines.separators_start_end.desc")
    var hideSeparatorsAtStartEnd = true

    @ConfigEntry(id = "color_arrow", translation = "config.cs.lines.color_arrow")
    @Comment("", translation = "config.cs.lines.color_arrow.desc")
    var colorArrowAmount = true

    @ConfigEntry(id = "arrow_display", translation = "config.cs.lines.arrow_display")
    @Comment("", translation = "config.cs.lines.arrow_display.desc")
    var arrowDisplay = ElementQuiver.ArrowDisplay.NUMBER

    @ConfigEntry(id = "piggy", translation = "config.cs.lines.piggy")
    @Comment("", translation = "config.cs.lines.piggy.desc")
    var showPiggy = false

    @ConfigEntry(id = "pet_max", translation = "config.cs.lines.pet_max")
    @Comment("", translation = "config.cs.lines.pet_max.desc")
    var showPetMax = true

    @ConfigEntry(id = "hypixel_powder", translation = "config.cs.lines.hypixel_powder")
    @Comment("", translation = "config.cs.lines.hypixel_powder.desc")
    var showHypixelPowder = true
}
