package com.ricky.botreinar.domain.dto

import androidx.room.ColumnInfo
import com.ricky.botreinar.domain.model.Exercicio

data class ExercicioDTO(
    var idExercicio: Long = 0L,
    var nome: String = "",
    var descricao: String = "",
    var repeticao: Int = 0,
    var series: Int = 0,
    var descanso: Long = 0L,
    var finalizado: Boolean = false
)
