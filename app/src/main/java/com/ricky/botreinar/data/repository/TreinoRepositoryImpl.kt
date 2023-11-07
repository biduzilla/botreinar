package com.ricky.botreinar.data.repository

import com.ricky.botreinar.data.dao.TreinoDao
import com.ricky.botreinar.domain.model.Treino
import com.ricky.botreinar.domain.model.TreinoWithExercicio
import com.ricky.botreinar.domain.repository.TreinoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TreinoRepositoryImpl @Inject constructor(private val dao: TreinoDao) : TreinoRepository {
    override fun getAllTreinosWithExercicios(): Flow<List<TreinoWithExercicio>> =
        dao.getAllTreinosWithExercicio()

    override fun getAllTreinos(): Flow<List<Treino>> = dao.getAllTreinos()

    override fun getTreinoById(idTreino: Long): Flow<TreinoWithExercicio> =
        dao.getTreinoById(idTreino)

    override suspend fun insertTreino(treino: Treino) = dao.insertTreino(treino)

    override suspend fun updateTreino(treino: Treino) = dao.updateTreino(treino)

    override suspend fun deleteTreino(treino: Treino) = dao.deleteTreino(treino)

    override suspend fun deleteTreinoById(idTreino: Long) = dao.deleteTreinoById(idTreino)
}