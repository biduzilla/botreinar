package com.ricky.botreinar.presentation.treinos

import com.ricky.botreinar.domain.model.Treino
import com.ricky.botreinar.presentation.treino_detalhe.TreinoDetalheEvent

data class TreinosState(
    var treinos: List<Treino> = emptyList(),
    var letra: String = "",
    var descricao: String = "",
    var onErrorLetra: Boolean = false,
    var onErrorDescricao: Boolean = false,
    var isShowDialog: Boolean = false
)
