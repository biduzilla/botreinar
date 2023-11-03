package com.ricky.botreinar.presentation.treino_detalhe.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ricky.botreinar.R
import com.ricky.botreinar.presentation.treino_detalhe.TreinoDetalheEvent
import com.ricky.botreinar.presentation.treino_detalhe.TreinoDetalheState

@Composable
fun DialogExercicioForm(
    state: TreinoDetalheState,
    modifier: Modifier,
    onDimiss: () -> Unit,
    onChangeNome: (String) -> Unit,
    onChangeDescricao: (String) -> Unit,
    onChangeSerie: (Int) -> Unit,
    onChangeRepeticao: (Int) -> Unit,
    onChangeDescansoMin: (Int) -> Unit,
    onChangeDescansoSeg: (Int) -> Unit,
    onSave: () -> Unit
) {
    Dialog(onDismissRequest = { onDimiss() }) {
        Card(modifier = modifier, shape = RoundedCornerShape(10.dp)) {
            Column(
                Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextFieldCompose(
                    value = state.nome,
                    isError = state.onErrorNome,
                    label = R.string.nome_exercicio,
                    onChange = { onChangeNome(it) }
                )
                TextFieldCompose(
                    value = state.descricao,
                    isError = state.onErrorNome,
                    label = R.string.descricao_exercicio,
                    onChange = { onChangeDescricao(it) }
                )
                TextFieldCompose(
                    value = state.series.toString(),
                    isError = state.onErrorNome,
                    label = R.string.serie_exercicio,
                    onChange = { onChangeSerie(it.toInt()) }
                )
                TextFieldCompose(
                    value = state.repeticoes.toString(),
                    isError = state.onErrorNome,
                    label = R.string.repeticao_exercicio,
                    onChange = { onChangeRepeticao(it.toInt()) }
                )
                Row(Modifier.fillMaxWidth()) {

                }
            }
        }
    }
}

