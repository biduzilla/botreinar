package com.ricky.botreinar.data.repository

import com.ricky.botreinar.data.dao.ExercicioDao
import com.ricky.botreinar.domain.model.Exercicio
import com.ricky.botreinar.domain.repository.ExercicioRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExercicioRepositoryImpl @Inject constructor(private val dao: ExercicioDao) :
    ExercicioRepository {
    override fun getAllExercicios(): Flow<List<Exercicio>> = dao.getAllExercicios()

    override fun getExercicioById(idExercicio: Long): Flow<Exercicio> =
        dao.getExercicioById(idExercicio)

    override suspend fun insertExercicio(exercicio: Exercicio) = dao.insertExercicio(exercicio)

    override suspend fun updateExercicio(exercicio: Exercicio) = dao.updateExercicio(exercicio)

    override suspend fun deleteExercicio(exercicio: Exercicio) = dao.deleteExercicio(exercicio)

    override suspend fun deleteExercicioById(idExercicio: Long) =
        dao.deleteExercicioById(idExercicio)
}