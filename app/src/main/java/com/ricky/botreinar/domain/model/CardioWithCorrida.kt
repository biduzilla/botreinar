package com.ricky.botreinar.domain.model

import androidx.room.Embedded
import androidx.room.Relation

data class CardioWithCorrida(
    @Embedded val cardio: Cardio,
    @Relation(
        parentColumn = "ID_CARDIO",
        entityColumn = "ID_CORRIDA"
    )
    var corridas: List<Corrida> = emptyList()
)
