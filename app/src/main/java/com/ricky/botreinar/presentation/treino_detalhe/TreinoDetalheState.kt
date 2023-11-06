package com.ricky.botreinar.presentation.treino_detalhe

import com.ricky.botreinar.domain.dto.ExercicioDTO
import com.ricky.botreinar.domain.model.Exercicio

data class TreinoDetalheState(
    val exercicios: List<ExercicioDTO> = emptyList(),
    val tipoTreino: String = "",
    val nome: String = "",
    val descricao: String = "",
    val series: Int = 0,
    val repeticoes: Int = 0,
    val descansoMin: Int = 0,
    val descansoSeg: Int = 0,
    var onErrorNome: Boolean = false,
    var onErrorDescricao: Boolean = false,
    var onErrorSerie: Boolean = false,
    var onErrorRepeticao: Boolean = false,
    val isShowDialog: Boolean = false,
    val isFinalizado: Boolean = false
)
