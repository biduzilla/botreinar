package com.ricky.botreinar.domain.repository

import com.ricky.botreinar.domain.model.Corrida
import kotlinx.coroutines.flow.Flow

interface CorridaRepository {
    fun getAllCorridas(): Flow<List<Corrida>>
    fun getCorridaById(idCorrida: Long): Flow<Corrida>
    suspend fun insertCorrida(corrida: Corrida)
    suspend fun updateCorrida(corrida: Corrida)
    suspend fun deleteCorrida(corrida: Corrida)
    suspend fun deleteCorridaById(idCorrida: Long)
}