package com.ricky.botreinar.presentation.treinos

import com.ricky.botreinar.domain.model.Treino

data class TreinosState(var treinos: List<Treino> = emptyList())
