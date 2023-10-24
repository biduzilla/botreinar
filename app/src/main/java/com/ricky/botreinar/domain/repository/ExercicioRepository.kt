package com.ricky.botreinar.domain.repository

import com.ricky.botreinar.domain.model.Exercicio
import kotlinx.coroutines.flow.Flow

interface ExercicioRepository {
    fun getAllExercicios(): Flow<List<Exercicio>>
    fun getExercicioById(idExercicio: Long): Flow<Exercicio>
    suspend fun insertExercicio(exercicio: Exercicio)
    suspend fun updateExercicio(exercicio: Exercicio)
    suspend fun deleteExercicio(exercicio: Exercicio)
    suspend fun deleteExercicioById(idExercicio: Long)
}