package com.example.labo7.database

import android.app.assist.AssistContent
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GithubRepo::class],version = 1,exportSchema = false)
public abstract class RoomDB: RoomDatabase(){
    abstract fun repoDapo(): GithubDao

    companion object{
        private var INSTANCE: RoomDB? = null

        fun getInstace(appContext: Context): RoomDB{
            val tempInstance = INSTANCE

            if(tempInstance != null) return tempInstance

            synchronized(this){
                val instance = Room.databaseBuilder(appContext,RoomDB::class.java,"RepoDB")
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}