package com.example.cloudymous.footballclubcloud.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.cloudymous.footballclubcloud.model.DetailMatch
import org.jetbrains.anko.db.*

class FavoriteDatabaseOpenHelper(ctx: Context) :
    ManagedSQLiteOpenHelper(ctx, "com.example.cloudymous.footballclubcloud.model.DetailMatch.db", null, 1) {
    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instance == null) {
                instance = MyDatabaseOpenHelper(ctx.applicationContext)
            }
            return instance as MyDatabaseOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(
            DetailMatch.TABLE_FAVORITE_MATCH,
            true,
            DetailMatch.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            DetailMatch.EVENT_ID to TEXT + UNIQUE,
            DetailMatch.EVENT_DATE to TEXT,
            DetailMatch.EVENT_TIME to TEXT,
            DetailMatch.EVENT_HOME_TEAM_ID to TEXT,
            DetailMatch.EVENT_HOME_TEAM to TEXT,
            DetailMatch.EVENT_AWAY_TEAM_ID to TEXT,
            DetailMatch.EVENT_AWAY_TEAM to TEXT,
            DetailMatch.EVENT_HOME_SCORE to TEXT,
            DetailMatch.EVENT_AWAY_SCORE to TEXT,
            DetailMatch.EVENT_HOME_REDCARDS to TEXT,
            DetailMatch.EVENT_AWAY_REDCARDS to TEXT,
            DetailMatch.EVENT_HOME_YELLOWCARDS to TEXT,
            DetailMatch.EVENT_AWAY_YELLOWCARDS to TEXT,
            DetailMatch.EVENT_HOME_GOALKEEPER to TEXT,
            DetailMatch.EVENT_AWAY_GOALKEEPER to TEXT,
            DetailMatch.EVENT_HOME_LINEDEFENSE to TEXT,
            DetailMatch.EVENT_AWAY_LINEDEFENSE to TEXT,
            DetailMatch.EVENT_HOME_LINEMID to TEXT,
            DetailMatch.EVENT_AWAY_LINEMID to TEXT,
            DetailMatch.EVENT_HOME_LINEFORWARD to TEXT,
            DetailMatch.EVENT_AWAY_LINEFORWARD to TEXT,
            DetailMatch.EVENT_HOME_SUBTITUTES to TEXT,
            DetailMatch.EVENT_AWAY_SUBTITUTES to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(DetailMatch.TABLE_FAVORITE_MATCH, true)
    }
}

val Context.databaseFavorite: FavoriteDatabaseOpenHelper
    get() = FavoriteDatabaseOpenHelper(applicationContext)