package com.ricky.botreinar.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ricky.botreinar.domain.model.Corrida
import kotlinx.coroutines.flow.Flow

@Dao
interface CorridaDao {
    @Query("SELECT * FROM CORRIDA")
    fun getAllCorridas(): Flow<List<Corrida>>

    @Query("SELECT * FROM CORRIDA WHERE ID_CORRIDA= :idCorrida")
    fun getCorridaById(idCorrida: Long): Flow<Corrida>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCorrida(corrida: Corrida)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCorrida(corrida: Corrida)

    @Delete
    suspend fun deleteCorrida(corrida: Corrida)

    @Query("DELETE FROM CORRIDA WHERE ID_CORRIDA= :idCorrida")
    suspend fun deleteCorridaById(idCorrida: Long)
}