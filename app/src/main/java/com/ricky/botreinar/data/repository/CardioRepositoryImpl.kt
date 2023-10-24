package com.ricky.botreinar.data.repository

import com.ricky.botreinar.data.dao.CardioDao
import com.ricky.botreinar.domain.model.CardioWithCorrida
import com.ricky.botreinar.domain.repository.CardioRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CardioRepositoryImpl @Inject constructor(private val dao: CardioDao) : CardioRepository {
    override fun getAllCardios(): Flow<List<CardioWithCorrida>> = dao.getAllCardios()

    override fun getCardioById(idCardio: Long): Flow<CardioWithCorrida> =
        dao.getCardioById(idCardio)

    override suspend fun insertCardio(cardio: CardioDao) = dao.insertCardio(cardio)

    override suspend fun updateCardio(cardio: CardioDao) = dao.updateCardio(cardio)

    override suspend fun deleteCardio(cardio: CardioDao) = dao.deleteCardio(cardio)

    override suspend fun deleteCardioById(idCardio: Long) = dao.deleteCardioById(idCardio)
}