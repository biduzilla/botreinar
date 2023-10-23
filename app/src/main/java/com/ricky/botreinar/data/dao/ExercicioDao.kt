package com.ricky.botreinar.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ricky.botreinar.domain.model.Exercicio
import kotlinx.coroutines.flow.Flow

@Dao
interface ExercicioDao {
    @Query("SELECT * FROM EXERCICIO")
    fun getAllExercicios():Flow<List<Exercicio>>

    @Query("SELECT * FROM EXERCICIO WHERE ID_EXERCICIO = :idExercicio")
    fun getExercicioById(idExercicio: Long):Flow<Exercicio>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercicio(exercicio: Exercicio)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateExercicio(exercicio: Exercicio)

    @Delete
    suspend fun deleteExercicio(exercicio: Exercicio)

    @Query("DELETE FROM EXERCICIO WHERE ID_EXERCICIO= :idExercicio")
    suspend fun deleteExercicioById(idExercicio: Long)
}