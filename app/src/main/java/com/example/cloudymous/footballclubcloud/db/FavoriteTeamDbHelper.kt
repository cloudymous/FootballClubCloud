package com.example.cloudymous.footballclubcloud.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class FavoriteTeamDbHelper(ctx: Context) :
    ManagedSQLiteOpenHelper(ctx, "com.example.cloudymous.footballclubcloud.model.FavoriteTeam.db", null, 1) {
    companion object {
        private var instance: FavoriteTeamDbHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): FavoriteTeamDbHelper {
            if (instance == null) {
                instance = FavoriteTeamDbHelper(ctx.applicationContext)
            }
            return instance as FavoriteTeamDbHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {

        db.createTable(
            FavoriteTeam.TABLE_FAVORITE, true,
            FavoriteTeam.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            FavoriteTeam.TEAM_ID to TEXT + UNIQUE,
            FavoriteTeam.TEAM_NAME to TEXT,
            FavoriteTeam.TEAM_BADGE to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(FavoriteMatch.TABLE_FAVORITE_MATCH, true)
    }
}

val Context.databaseFavoriteTeam: FavoriteTeamDbHelper
    get() = FavoriteTeamDbHelper(applicationContext)