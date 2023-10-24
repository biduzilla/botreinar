package com.ricky.botreinar.domain.repository

import com.ricky.botreinar.data.dao.CardioDao
import com.ricky.botreinar.domain.model.CardioWithCorrida
import kotlinx.coroutines.flow.Flow

interface CardioRepository {
    fun getAllCardios(): Flow<List<CardioWithCorrida>>
    fun getCardioById(idCardio: Long): Flow<CardioWithCorrida>
    suspend fun insertCardio(cardio: CardioDao)
    suspend fun updateCardio(cardio: CardioDao)
    suspend fun deleteCardio(cardio: CardioDao)
    suspend fun deleteCardioById(idCardio: Long)
}