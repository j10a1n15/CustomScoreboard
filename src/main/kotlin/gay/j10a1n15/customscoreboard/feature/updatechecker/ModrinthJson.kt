package gay.j10a1n15.customscoreboard.feature.updatechecker

import com.google.gson.annotations.Expose

data class ModrinthJson(
    @Expose val name: String,
    @Expose val version_number: String,
    @Expose val date_published: String,
)
