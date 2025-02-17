package gay.j10a1n15.customscoreboard.config.categories

import com.teamresourceful.resourcefulconfigkt.api.CategoryKt
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ElementQuiver

object LinesConfig : CategoryKt("Line Modification") {

    val showBitsAvailable by boolean("bits_available", true) {
        this.name = Translated("config.cs.lines.bits_available")
        this.description = Translated("config.cs.lines.bits_available.desc")
    }

    val coloredMonth by boolean("colored_month", true) {
        this.name = Translated("config.cs.lines.colored_month")
        this.description = Translated("config.cs.lines.colored_month.desc")
    }

    val showProfileName by boolean("profile_name", false) {
        this.name = Translated("config.cs.lines.profile_name")
        this.description = Translated("config.cs.lines.profile_name.desc")
    }

    val showMayorTime by boolean("mayor_time", true) {
        this.name = Translated("config.cs.lines.mayor_time")
        this.description = Translated("config.cs.lines.mayor_time.desc")
    }

    val showMayorPerks by boolean("mayor_perks", true) {
        this.name = Translated("config.cs.lines.mayor_perks")
        this.description = Translated("config.cs.lines.mayor_perks.desc")
    }

    val showMinister by boolean("mayor_minister", true) {
        this.name = Translated("config.cs.lines.mayor_minister")
        this.description = Translated("config.cs.lines.mayor_minister.desc")
    }

    val showAllActiveEvents by boolean("all_events", true) {
        this.name = Translated("config.cs.lines.all_events")
        this.description = Translated("config.cs.lines.all_events.desc")
    }

    val useHypixelTitle by boolean("hypixel_title", true) {
        this.name = Translated("config.cs.lines.hypixel_title")
        this.description = Translated("config.cs.lines.hypixel_title.desc")
    }

    val showPartyEverywhere by boolean("party_everywhere", true) {
        this.name = Translated("config.cs.lines.party_everywhere")
        this.description = Translated("config.cs.lines.party_everywhere.desc")
    }

    val maxPartyMembers by int("max_party", 5) {
        this.name = Translated("config.cs.lines.max_party")
        this.description = Translated("config.cs.lines.max_party.desc")
        this.slider = true
        this.range = 1..10
    }

    val showPartyLeader by boolean("party_leader", true) {
        this.name = Translated("config.cs.lines.party_leader")
        this.description = Translated("config.cs.lines.party_leader.desc")
    }

    val condenseConsecutiveSeparators by boolean("consecutive_separator", true) {
        this.name = Translated("config.cs.lines.consecutive_separator")
        this.description = Translated("config.cs.lines.consecutive_separator.desc")
    }

    val hideSeparatorsAtStartEnd by boolean("separators_start_end", true) {
        this.name = Translated("config.cs.lines.separators_start_end")
        this.description = Translated("config.cs.lines.separators_start_end.desc")
    }

    val colorArrowAmount by boolean("color_arrow", true) {
        this.name = Translated("config.cs.lines.color_arrow")
        this.description = Translated("config.cs.lines.color_arrow.desc")
    }

    val arrowDisplay by enum("arrow_display", ElementQuiver.ArrowDisplay.NUMBER) {
        this.name = Translated("config.cs.lines.arrow_display")
        this.description = Translated("config.cs.lines.arrow_display.desc")
    }

    val showPiggy by boolean("piggy", false) {
        this.name = Translated("config.cs.lines.piggy")
        this.description = Translated("config.cs.lines.piggy.desc")
    }

    val showPetMax by boolean("pet_max", true) {
        this.name = Translated("config.cs.lines.pet_max")
        this.description = Translated("config.cs.lines.pet_max.desc")
    }

    val showHypixelPowder by boolean("hypixel_powder", true) {
        this.name = Translated("config.cs.lines.hypixel_powder")
        this.description = Translated("config.cs.lines.hypixel_powder.desc")
    }
}
