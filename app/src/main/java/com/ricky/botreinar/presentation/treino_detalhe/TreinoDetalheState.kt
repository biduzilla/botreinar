package com.ricky.botreinar.presentation.treino_detalhe

import com.ricky.botreinar.domain.model.Exercicio

data class TreinoDetalheState(
    val exercicios: List<Exercicio> = emptyList(),
    val tipoTreino: String,
    val nome: String,
    val descricao: String,
    val series: Int,
    val repeticoes: Int,
    val descansoMin: Int,
    val descansoSeg: Int,
    val onErrorNome: Boolean,
    val onErrorDescricao: Boolean,
    val onErrorSerie: Boolean,
    val onErrorRepeticao: Boolean,
)
