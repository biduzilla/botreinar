package com.ricky.botreinar.data.repository

import com.ricky.botreinar.data.dao.CorridaDao
import com.ricky.botreinar.domain.model.Corrida
import com.ricky.botreinar.domain.repository.CorridaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CorridaRepositoryImpl @Inject constructor(private val dao:CorridaDao):CorridaRepository {
    override fun getAllCorridas(): Flow<List<Corrida>> = dao.getAllCorridas()

    override fun getCorridaById(idCorrida: Long): Flow<Corrida> = dao.getCorridaById(idCorrida)

    override suspend fun insertCorrida(corrida: Corrida) = dao.insertCorrida(corrida)

    override suspend fun updateCorrida(corrida: Corrida) = dao.updateCorrida(corrida)

    override suspend fun deleteCorrida(corrida: Corrida) = dao.deleteCorrida(corrida)

    override suspend fun deleteCorridaById(idCorrida: Long) = dao.deleteCorridaById(idCorrida)
}