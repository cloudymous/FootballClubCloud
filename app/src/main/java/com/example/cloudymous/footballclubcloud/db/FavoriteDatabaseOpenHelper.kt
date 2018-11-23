package com.example.cloudymous.footballclubcloud.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.cloudymous.footballclubcloud.model.FavoriteMatch
import org.jetbrains.anko.db.*

class FavoriteDatabaseOpenHelper(ctx: Context) :
    ManagedSQLiteOpenHelper(ctx, "com.example.cloudymous.footballclubcloud.model.FavoriteMatch.db", null, 1) {
    companion object {
        private var instance: FavoriteDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): FavoriteDatabaseOpenHelper {
            if (instance == null) {
                instance = FavoriteDatabaseOpenHelper(ctx.applicationContext)
            }
            return instance as FavoriteDatabaseOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(
            FavoriteMatch.TABLE_FAVORITE_MATCH,
            true,
            FavoriteMatch.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            FavoriteMatch.EVENT_ID to TEXT + UNIQUE,
            FavoriteMatch.EVENT_DATE to TEXT,
            FavoriteMatch.EVENT_TIME to TEXT,
            FavoriteMatch.EVENT_HOME_TEAM to TEXT,
            FavoriteMatch.EVENT_AWAY_TEAM to TEXT,
            FavoriteMatch.EVENT_HOME_SCORE to TEXT,
            FavoriteMatch.EVENT_AWAY_SCORE to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(FavoriteMatch.TABLE_FAVORITE_MATCH, true)
    }
}

val Context.databaseFavorite: FavoriteDatabaseOpenHelper
    get() = FavoriteDatabaseOpenHelper(applicationContext)