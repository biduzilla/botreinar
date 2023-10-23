package com.ricky.botreinar.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ricky.botreinar.domain.model.CardioWithCorrida
import com.ricky.botreinar.domain.model.Treino
import com.ricky.botreinar.domain.model.TreinoWithExercicio
import kotlinx.coroutines.flow.Flow

@Dao
interface Cardio {
    @Query("SELECT * FROM CARDIO")
    fun getAllCardios(): Flow<List<CardioWithCorrida>>

    @Query("SELECT * FROM CARDIO WHERE ID_CARDIO =:idCardio")
    suspend fun getCardioById(idCardio: Long): CardioWithCorrida

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardio(cardio: Cardio)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCardio(cardio: Cardio)

    @Delete
    suspend fun deleteCardio(cardio: Cardio)

    @Query("DELETE FROM CARDIO WHERE ID_CARDIO =:idCardio")
    suspend fun deleteCardioById(idCardio: Long)
}