package com.ricky.botreinar.domain.repository

import com.ricky.botreinar.data.dao.CardioDao
import com.ricky.botreinar.domain.model.Cardio
import com.ricky.botreinar.domain.model.CardioWithCorrida
import kotlinx.coroutines.flow.Flow

interface CardioRepository {
    fun getAllCardios(): Flow<List<CardioWithCorrida>>
    fun getCardioById(idCardio: Long): Flow<CardioWithCorrida>
    suspend fun insertCardio(cardio: Cardio)
    suspend fun updateCardio(cardio: Cardio)
    suspend fun deleteCardio(cardio: Cardio)
    suspend fun deleteCardioById(idCardio: Long)
}