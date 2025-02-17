package gay.j10a1n15.customscoreboard.config.categories

import com.teamresourceful.resourcefulconfigkt.api.CategoryKt

object BackgroundConfig : CategoryKt("Background") {

    val enabled by boolean(true) {
        this.name = Translated("config.cs.background.enabled")
        this.description = Translated("config.cs.background.enabled.desc")
    }

    val backgroundColor by color("color", 0xA0000000.toInt()) {
        this.name = Translated("config.cs.background.color")
        this.description = Translated("config.cs.background.color.desc")
        this.allowAlpha = true
    }

    val padding by int(5) {
        this.name = Translated("config.cs.background.padding")
        this.description = Translated("config.cs.background.padding.desc")
        this.range = 0..20
        this.slider = true
    }

    val margin by int(0) {
        this.name = Translated("config.cs.background.margin")
        this.description = Translated("config.cs.background.margin.desc")
        this.range = 0..20
        this.slider = true
    }

    val radius by int(5) {
        this.name = Translated("config.cs.background.radius")
        this.description = Translated("config.cs.background.radius.desc")
        this.range = 0..20
        this.slider = true
    }

}
