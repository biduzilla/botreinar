package com.ricky.botreinar.presentation.treino_detalhe

sealed interface TreinoDetalheEvent {
    object OnSave : TreinoDetalheEvent
    object ShowDialogForm : TreinoDetalheEvent
    data class OnDeleteTreino(val idTreino: Long) : TreinoDetalheEvent
    data class OnChangeNome(val nome: String) : TreinoDetalheEvent
    data class OnChangeDescricao(val descricao: String) : TreinoDetalheEvent
    data class OnChangeSerie(val serie: Int) : TreinoDetalheEvent
    data class OnChangeRepeticao(val repeticao: Int) : TreinoDetalheEvent
    data class OnChangeDescansoMin(val min: Int) : TreinoDetalheEvent
    data class OnChangeDescansoSeg(val seg: Int) : TreinoDetalheEvent
    data class OnChangeFinalizadoExer(val isFinalizado: Boolean, val id: Long) : TreinoDetalheEvent
}
