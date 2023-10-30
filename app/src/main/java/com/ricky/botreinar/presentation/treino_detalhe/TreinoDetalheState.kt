package com.ricky.botreinar.presentation.treino_detalhe

import com.ricky.botreinar.domain.model.Exercicio

data class TreinoDetalheState(val exercicios: List<Exercicio> = emptyList())
