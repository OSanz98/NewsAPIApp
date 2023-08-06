package sanzlimited.com.newsapiapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    val _id: String? = null,
    val _score: Any?,
    val author: String?,
    val authors: String?,
    val clean_url: String?,
    val country: String?,
    val excerpt: String?,
    val is_opinion: Boolean?,
    val language: String?,
    val link: String?,
    val media: String?,
    val published_date: String?,
    val published_date_precision: String?,
    val rank: Int?,
    val rights: String?,
    val summary: String?,
    val title: String?,
    val topic: String?,
    val twitter_account: Any?
):Serializable