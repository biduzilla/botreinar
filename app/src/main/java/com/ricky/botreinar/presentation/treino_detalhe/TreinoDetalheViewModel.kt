package com.ricky.botreinar.presentation.treino_detalhe

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricky.botreinar.common.Constants
import com.ricky.botreinar.domain.dto.ExercicioDTO
import com.ricky.botreinar.domain.model.Exercicio
import com.ricky.botreinar.domain.repository.ExercicioRepository
import com.ricky.botreinar.domain.repository.TreinoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TreinoDetalheViewModel @Inject constructor(
    private val treinoRepository: TreinoRepository,
    private val exercicioRepository: ExercicioRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(TreinoDetalheState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            savedStateHandle.get<Long>(Constants.TREINO_ID)?.let { treinoId ->
                treinoRepository.getTreinoById(treinoId).collect { treino ->
                    val dto = treino.exercicios.map { e ->
                        ExercicioDTO(
                            idExercicio = e.idExercicio,
                            nome = e.nome,
                            descricao = e.descricao,
                            repeticao = e.repeticao,
                            series = e.series,
                            descanso = e.descanso
                        )
                    }
                    _state.update {
                        it.copy(exercicios = dto)
                    }
                }
            }
        }
    }

    fun onEvent(event: TreinoDetalheEvent) {
        when (event) {
            is TreinoDetalheEvent.OnChangeDescansoMin -> {
                _state.update {
                    it.copy(descansoMin = event.min)
                }
            }

            is TreinoDetalheEvent.OnChangeDescansoSeg -> _state.update {
                it.copy(descansoSeg = event.seg)
            }

            is TreinoDetalheEvent.OnChangeDescricao -> _state.update {
                it.copy(
                    descricao = event.descricao,
                    onErrorDescricao = false
                )
            }

            is TreinoDetalheEvent.OnChangeNome -> {
                _state.update {
                    it.copy(
                        nome = event.nome,
                        onErrorNome = false
                    )
                }
            }

            is TreinoDetalheEvent.OnChangeRepeticao -> {
                _state.update {
                    it.copy(
                        repeticoes = event.repeticao,
                        onErrorRepeticao = false
                    )
                }
            }

            is TreinoDetalheEvent.OnChangeSerie -> {
                _state.update {
                    it.copy(
                        series = event.serie,
                        onErrorSerie = false
                    )
                }
            }

            is TreinoDetalheEvent.OnDeleteTreino -> {
                viewModelScope.launch { treinoRepository.deleteTreinoById(event.idTreino) }

            }

            TreinoDetalheEvent.OnSave -> {
                if (_state.value.nome.isBlank()) {
                    _state.value.onErrorNome = true
                    return
                }
                if (_state.value.descricao.isBlank()) {
                    _state.value.onErrorDescricao = true
                    return
                }
                if (_state.value.series == 0) {
                    _state.value.onErrorSerie = true
                    return
                }
                if (_state.value.repeticoes == 0) {
                    _state.value.onErrorRepeticao = true
                    return
                }

                val exercicio = Exercicio(
                    nome = _state.value.nome.trim(),
                    descricao = _state.value.descricao.trim(),
                    series = _state.value.series,
                    repeticao = _state.value.repeticoes,
                    descanso = _state.value.descansoSeg.plus(_state.value.descansoMin).toLong()
                )
                viewModelScope.launch {
                    exercicioRepository.insertExercicio(exercicio)
                    _state.update {
                        it.copy(
                            nome = "",
                            descricao = "",
                            repeticoes = 0,
                            series = 0,
                            descansoSeg = 0,
                            descansoMin = 0
                        )
                    }
                }
            }

            TreinoDetalheEvent.ShowDialogForm -> {
                _state.update { it.copy(isShowDialog = !_state.value.isShowDialog) }
            }

            is TreinoDetalheEvent.OnChangeFinalizadoExer -> {
                val exercicio = _state.value.exercicios.find {
                    it.idExercicio == event.id
                }
                exercicio?.let {
                    exercicio.finalizado = event.isFinalizado

                    val exericiosAtualizado = _state.value.exercicios.map {
                        if (it.idExercicio == event.id) {
                            exercicio
                        } else {
                            it
                        }
                    }

                    _state.update {
                        it.copy(exercicios = exericiosAtualizado)
                    }
                }


            }
        }
    }
}