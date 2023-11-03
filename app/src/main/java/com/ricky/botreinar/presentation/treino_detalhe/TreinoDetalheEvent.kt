package com.ricky.botreinar.presentation.treino_detalhe

sealed interface TreinoDetalheEvent{
    object OnSave:TreinoDetalheEvent
    object ShowDialogForm:TreinoDetalheEvent

    data class OnDeleteTreino(val idTreino:Long):TreinoDetalheEvent
    data class OnChangeNome(val nome:String):TreinoDetalheEvent
    data class OnChangeDescricao(val descricao:String):TreinoDetalheEvent
}