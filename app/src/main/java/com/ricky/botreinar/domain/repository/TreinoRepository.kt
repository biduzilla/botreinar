package com.ricky.botreinar.domain.repository

import com.ricky.botreinar.domain.model.Treino
import com.ricky.botreinar.domain.model.TreinoWithExercicio
import kotlinx.coroutines.flow.Flow

interface TreinoRepository {
    fun getAllTreinosWithExercicios(): Flow<List<TreinoWithExercicio>>
    fun getAllTreinos(): Flow<List<Treino>>
    fun getTreinoById(idTreino: Long): Flow<TreinoWithExercicio>
    suspend fun insertTreino(treino: Treino)
    suspend fun updateTreino(treino: Treino)
    suspend fun deleteTreino(treino: Treino)
    suspend fun deleteTreinoById(idTreino: Long)
}