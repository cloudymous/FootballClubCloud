package com.example.cloudymous.footballclubcloud.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class FavoriteMatchDbHelper(ctx: Context) :
    ManagedSQLiteOpenHelper(ctx, "com.example.cloudymous.footballclubcloud.db.FavoriteMatch.db", null, 1) {
    companion object {
        private var instance: FavoriteMatchDbHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): FavoriteMatchDbHelper {
            if (instance == null) {
                instance = FavoriteMatchDbHelper(ctx.applicationContext)
            }
            return instance as FavoriteMatchDbHelper
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
            FavoriteMatch.EVENT_HOMETEAM to TEXT,
            FavoriteMatch.EVENT_HOMESCORE to TEXT,
            FavoriteMatch.EVENT_AWAYTEAM to TEXT,
            FavoriteMatch.EVENT_AWAYSCORE to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(FavoriteMatch.TABLE_FAVORITE_MATCH, true)
    }
}

val Context.databaseFavoriteMatch: FavoriteMatchDbHelper
    get() = FavoriteMatchDbHelper(applicationContext)