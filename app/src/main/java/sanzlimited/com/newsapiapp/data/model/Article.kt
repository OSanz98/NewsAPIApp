package sanzlimited.com.newsapiapp.data.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.Objects

@Entity(
    tableName = "articles",
//    ignoredColumns = ["_score", "twitter_account"]
)
data class Article(

    @PrimaryKey()
    @NonNull val _id: String,
    /*@SerializedName("_score")
    val _score: Any?,*/
    @SerializedName("author")
    val author: String?,
    @SerializedName("authors")
    val authors: String?,
    @SerializedName("clean_url")
    val clean_url: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("excerpt")
    val excerpt: String?,
    @SerializedName("is_opinion")
    val is_opinion: Boolean?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("media")
    val media: String?,
    @SerializedName("published_date")
    val published_date: String?,
    @SerializedName("published_date_precision")
    val published_date_precision: String?,
    @SerializedName("rank")
    val rank: Int?,
    @SerializedName("rights")
    val rights: String?,
    @SerializedName("summary")
    val summary: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("topic")
    val topic: String?,
//    @SerializedName("twitter_account")
//    val twitter_account: Any?
):Serializable