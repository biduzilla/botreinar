package com.ricky.botreinar.presentation.treinos

import androidx.lifecycle.ViewModel
import com.ricky.botreinar.domain.repository.TreinoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TreinoViewModel @Inject constructor(private val repository: TreinoRepository):ViewModel() {
}