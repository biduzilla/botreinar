package com.ricky.botreinar.presentation.treinos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricky.botreinar.domain.repository.TreinoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TreinoViewModel @Inject constructor(private val repository: TreinoRepository) : ViewModel() {

    private val _state = MutableStateFlow(TreinosState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllTreinos().collect { treinos ->
                _state.update {
                    it.copy(
                        treinos = treinos
                    )
                }
            }
        }
    }

    fun onEvent(event: TreinosEvent) {
        when (event) {
            is TreinosEvent.OnChangeDescricao -> {

            }

            is TreinosEvent.OnChangeLetra -> TODO()
            is TreinosEvent.OnDelete -> TODO()
            TreinosEvent.OnSave -> TODO()
            TreinosEvent.ShowDialogForm -> TODO()
        }
    }
}