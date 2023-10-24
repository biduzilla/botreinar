package com.ricky.botreinar.domain.repository

import com.ricky.botreinar.domain.model.Historico
import kotlinx.coroutines.flow.Flow

interface HistoricoRepository {
    fun getAllHistoricos(): Flow<List<Historico>>
    fun getHistoricoById(idHistorico: Long): Flow<Historico>
    suspend fun insertHistorico(historico: Historico)
    suspend fun updateHistorico(historico: Historico)
    suspend fun deleteHistorico(historico: Historico)
    suspend fun deleteHistoricoById(idHistorico: Long)
}