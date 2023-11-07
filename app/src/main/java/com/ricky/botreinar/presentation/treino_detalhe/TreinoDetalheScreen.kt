package com.ricky.botreinar.presentation.treino_detalhe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ricky.botreinar.R
import com.ricky.botreinar.presentation.treino_detalhe.components.CardExercicio
import com.ricky.botreinar.presentation.treino_detalhe.components.DialogExercicioForm
import com.ricky.botreinar.presentation.treino_detalhe.components.DialogText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TreinoDetalheScreen(
    state: TreinoDetalheState,
    onEvent: (TreinoDetalheEvent) -> Unit
) {

    if (state.isShowDialog) {
        DialogExercicioForm(
            state = state,
            onDimiss = { onEvent(TreinoDetalheEvent.ShowDialogForm) },
            onChangeNome = { onEvent(TreinoDetalheEvent.OnChangeNome(it)) },
            onChangeDescricao = { onEvent(TreinoDetalheEvent.OnChangeDescricao(it)) },
            onChangeSerie = { onEvent(TreinoDetalheEvent.OnChangeSerie(it)) },
            onChangeRepeticao = { onEvent(TreinoDetalheEvent.OnChangeRepeticao(it)) },
            onChangeDescansoMin = { onEvent(TreinoDetalheEvent.OnChangeDescansoMin(it)) },
            onChangeDescansoSeg = { onEvent(TreinoDetalheEvent.OnChangeDescansoSeg(it)) },
            onSave = { onEvent(TreinoDetalheEvent.OnSave) }
        )
    }

    if (state.isFinalizado) {
        DialogText(
            onDimiss = { onEvent(TreinoDetalheEvent.DismissDialogFinalizar) },
            onAction = { onEvent(TreinoDetalheEvent.FinalizarTreino) },
            labelAction = R.string.finalizar,
            labelDimiss = R.string.cancelar,
            title = R.string.finalizar_treino
        )
    }

    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = {
            Text(
                text = state.tipoTreino,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
        })
    }, floatingActionButton = {
        FloatingActionButton(onClick = { onEvent(TreinoDetalheEvent.ShowDialogForm) }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(id = R.string.salvar)
            )
        }
    }) { paddingValues ->
        LazyColumn(
            Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.exercicios) { exercicio ->
                CardExercicio(
                    exercicio = exercicio,
                    modifier = Modifier.padding(8.dp),
                    isFinalizado = {
                        onEvent(
                            TreinoDetalheEvent.OnChangeFinalizadoExer(
                                isFinalizado = it,
                                id = exercicio.idExercicio
                            )
                        )
                    })
            }
        }
    }
}