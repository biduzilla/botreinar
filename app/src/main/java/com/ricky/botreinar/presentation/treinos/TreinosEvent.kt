package com.ricky.botreinar.presentation.treinos

sealed interface TreinosEvent {
    object ShowDialogForm : TreinosEvent
    data class OnChangeDescricao(val descricao: String) : TreinosEvent
    data class OnChangeLetra(val letra: String) : TreinosEvent
    data class OnDelete(val idTreino: Long) : TreinosEvent
    object OnSave : TreinosEvent
}