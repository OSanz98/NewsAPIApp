package sanzlimited.com.newsapiapp.data.model

data class UserInput(
    val countries: List<String>,
    val from: String,
    val lang: Any,
    val not_countries: Any,
    val not_lang: Any,
    val not_sources: List<Any>,
    val page: Int,
    val size: Int,
    val sources: Any,
    val topic: String
)