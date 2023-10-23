package com.ricky.botreinar.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ricky.botreinar.domain.model.CardioWithCorrida
import kotlinx.coroutines.flow.Flow

@Dao
interface CardioDao {
    @Query("SELECT * FROM CARDIO")
    fun getAllCardios(): Flow<List<CardioWithCorrida>>

    @Query("SELECT * FROM CARDIO WHERE ID_CARDIO =:idCardio")
    suspend fun getCardioById(idCardio: Long): CardioWithCorrida

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardio(cardio: CardioDao)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCardio(cardio: CardioDao)

    @Delete
    suspend fun deleteCardio(cardio: CardioDao)

    @Query("DELETE FROM CARDIO WHERE ID_CARDIO =:idCardio")
    suspend fun deleteCardioById(idCardio: Long)
}