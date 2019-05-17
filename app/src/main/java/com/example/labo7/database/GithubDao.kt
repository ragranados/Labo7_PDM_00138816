package com.example.labo7.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GithubDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo: GithubRepo)

    @Query(value = "SELECT * FROM repos")
    fun getAllRepos(): LiveData<List<GithubRepo>>

    @Query("DELETE FROM repos")
    fun nukeTable()
}