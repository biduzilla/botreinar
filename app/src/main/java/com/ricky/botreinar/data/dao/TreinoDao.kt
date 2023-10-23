package com.ricky.botreinar.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ricky.botreinar.domain.model.Treino
import com.ricky.botreinar.domain.model.TreinoWithExercicio
import kotlinx.coroutines.flow.Flow

@Dao
interface TreinoDao {
    @Query("SELECT * FROM TREINO")
    fun getAllTreinos(): Flow<List<TreinoWithExercicio>>

    @Query("SELECT * FROM TREINO WHERE ID_TREINO =:idTreino")
    suspend fun getTreinoById(idTreino: Long): TreinoWithExercicio

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTreino(treino: Treino)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTreino(treino: Treino)

    @Delete
    suspend fun deleteTreino(treino: Treino)

    @Query("DELETE FROM TREINO WHERE ID_TREINO =:idTreino")
    suspend fun deleteTreinoById(idTreino: Long)
}
