package com.ricky.botreinar.presentation.treinos

import androidx.lifecycle.ViewModel
import com.ricky.botreinar.domain.repository.TreinoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class TreinoViewModel @Inject constructor(private val repository: TreinoRepository) : ViewModel() {

    private val _state = MutableStateFlow(TreinosState())
    val state = _state.asStateFlow()

    fun onEvent(event: TreinosEvent){

    }
}