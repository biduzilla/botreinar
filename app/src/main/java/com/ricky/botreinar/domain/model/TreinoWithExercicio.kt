package com.ricky.botreinar.domain.model

import androidx.room.Embedded
import androidx.room.Relation

data class TreinoWithExercicio(
    @Embedded val treino: Treino,
    @Relation(
        parentColumn = "ID_TREINO",
        entityColumn = "ID_EXERCICIO"
    )
    var exercicios: List<Exercicio> = emptyList()
)
