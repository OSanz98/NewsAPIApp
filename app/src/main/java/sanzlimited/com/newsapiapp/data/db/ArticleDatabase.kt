package sanzlimited.com.newsapiapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import sanzlimited.com.newsapiapp.data.model.Article

@Database(
    entities = [Article::class],
    version = 1,
    exportSchema = false
)
abstract class ArticleDatabase: RoomDatabase() {
    abstract fun getArticleDAO():ArticleDAO
}