package com.ricky.botreinar.presentation.treinos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricky.botreinar.domain.model.Treino
import com.ricky.botreinar.domain.repository.TreinoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
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
                _state.update {
                    it.copy(
                        descricao = event.descricao,
                        onErrorDescricao = false
                    )
                }
            }

            is TreinosEvent.OnChangeLetra -> {
                _state.update {
                    it.copy(
                        letra = event.letra,
                        onErrorLetra = false,
                    )
                }
            }

            is TreinosEvent.OnDelete -> {
                viewModelScope.launch {
                    repository.deleteTreinoById(event.idTreino)
                }
            }

            TreinosEvent.OnSave -> {
                if (_state.value.letra.isBlank()) {
                    _state.update {
                        it.copy(
                            onErrorLetra = true
                        )
                    }
                    return
                }
                if (_state.value.descricao.isBlank()) {
                    _state.update {
                        it.copy(
                            onErrorDescricao = true
                        )
                    }
                    return
                }

                val treino = Treino(
                    letra = _state.value.letra,
                    data = LocalDate.now(),
                    descricao = _state.value.descricao
                )
                viewModelScope.launch {
                    repository.insertTreino(treino)
                }

                _state.update {
                    it.copy(
                        letra = "",
                        descricao = "",
                        isShowDialog = false
                    )
                }
            }

            TreinosEvent.ShowDialogForm -> {
                _state.update {
                    it.copy(
                        isShowDialog = !_state.value.isShowDialog
                    )
                }
            }
        }
    }
}