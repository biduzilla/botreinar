package com.ricky.botreinar.data.repository

import com.ricky.botreinar.data.dao.HistoricoDao
import com.ricky.botreinar.domain.enums.TipoEnum
import com.ricky.botreinar.domain.model.CardioWithCorrida
import com.ricky.botreinar.domain.model.Historico
import com.ricky.botreinar.domain.model.TreinoWithExercicio
import com.ricky.botreinar.domain.repository.CardioRepository
import com.ricky.botreinar.domain.repository.HistoricoRepository
import com.ricky.botreinar.domain.repository.TreinoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HistoricoRepositoryImpl @Inject constructor(
    private val dao: HistoricoDao,
    private val treinoRepository: TreinoRepository,
    private val cardioRepository: CardioRepository,
) :
    HistoricoRepository {
    override fun getAllHistoricos(): Flow<List<Historico>> = dao.getAllHistoricos()

    override fun getHistoricoById(idHistorico: Long): Flow<Historico> =
        dao.getHistoricoById(idHistorico)

    override suspend fun insertHistorico(historico: Historico) = dao.insertHistorico(historico)

    override suspend fun updateHistorico(historico: Historico) = dao.updateHistorico(historico)

    override suspend fun deleteHistorico(historico: Historico) = dao.deleteHistorico(historico)

    override suspend fun deleteHistoricoById(idHistorico: Long) =
        dao.deleteHistoricoById(idHistorico)

//    suspend fun getHistoricoByIdTreino(idHistorico: Long): Flow<TreinoWithExercicio> {
//        return getHistoricoById(idHistorico)
//            .filter { historico -> historico.tipo == TipoEnum.TREINO }
//            .map { historico -> treinoRepository.getTreinoById(historico.idTreino) }
//            .filterNotNull()
//            .first()
//    }
//
//    suspend fun getHistoricoByIdCardio(idHistorico: Long):Flow<CardioWithCorrida>{
//        return getHistoricoById(idHistorico)
//            .filter { historico -> historico.tipo == TipoEnum.CARDIO }
//            .map { historico -> cardioRepository.getCardioById(historico.idTreino) }
//            .filterNotNull()
//            .first()
//    }
}