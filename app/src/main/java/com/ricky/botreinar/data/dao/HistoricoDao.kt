package com.ricky.botreinar.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ricky.botreinar.domain.model.Historico
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoricoDao {
    @Query("SELECT * FROM HISTORICO")
    fun getAllHistoricos(): Flow<List<Historico>>

    @Query("SELECT * FROM HISTORICO WHERE ID_HISTORICO = :idHistorico")
    fun getHistoricoById(idHistorico: Long): Flow<Historico>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistorico(historico: Historico)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateHistorico(historico: Historico)

    @Delete
    suspend fun deleteHistorico(historico: Historico)

    @Query("DELETE FROM HISTORICO WHERE ID_HISTORICO= :idHistorico")
    suspend fun deleteHistoricoById(idHistorico: Long)
}