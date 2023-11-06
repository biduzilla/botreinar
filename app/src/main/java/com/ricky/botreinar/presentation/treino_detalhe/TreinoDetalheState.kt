package com.ricky.botreinar.presentation.treino_detalhe

import com.ricky.botreinar.domain.model.Exercicio

data class TreinoDetalheState(
    val exercicios: List<Exercicio> = emptyList(),
    val tipoTreino: String = "",
    val nome: String = "",
    val descricao: String = "",
    val series: Int = 0,
    val repeticoes: Int = 0,
    val descansoMin: Int = 0,
    val descansoSeg: Int = 0,
    val onErrorNome: Boolean = false,
    val onErrorDescricao: Boolean = false,
    val onErrorSerie: Boolean = false,
    val onErrorRepeticao: Boolean = false,
)
