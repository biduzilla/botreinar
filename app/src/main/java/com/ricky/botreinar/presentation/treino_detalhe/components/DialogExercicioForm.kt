package com.ricky.botreinar.presentation.treino_detalhe.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ricky.botreinar.R
import com.ricky.botreinar.presentation.treino_detalhe.TreinoDetalheEvent
import com.ricky.botreinar.presentation.treino_detalhe.TreinoDetalheState
import com.ricky.botreinar.ui.theme.BoTreinarTheme

@Composable
fun DialogExercicioForm(
    state: TreinoDetalheState,
    modifier: Modifier = Modifier,
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
                    isError = state.onErrorDescricao,
                    label = R.string.descricao_exercicio,
                    onChange = { onChangeDescricao(it) }
                )
                TextFieldCompose(
                    value = state.series.toString(),
                    isError = state.onErrorSerie,
                    label = R.string.serie_exercicio,
                    onChange = { onChangeSerie(it.toInt()) }
                )
                TextFieldCompose(
                    value = state.repeticoes.toString(),
                    isError = state.onErrorRepeticao,
                    label = R.string.repeticao_exercicio,
                    onChange = { onChangeRepeticao(it.toInt()) }
                )
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    TextFieldNumberCompose(
                        label = R.string.minutos,
                        onChange = { onChangeDescansoMin(it) },
                        textSize = 48.sp
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = ":",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                    TextFieldNumberCompose(
                        label = R.string.segundos,
                        onChange = { onChangeDescansoSeg(it) },
                        textSize = 48.sp
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                Button(onClick = onSave) {
                    Text(text = stringResource(id = R.string.salvar))
                }
            }
        }
    }
}

@Preview
@Composable
fun DialogExercicioFormPreview() {
    BoTreinarTheme {
        DialogExercicioForm(
            state = TreinoDetalheState(),
            onDimiss = { /*TODO*/ },
            onChangeNome = {},
            onChangeDescricao = {},
            onChangeSerie = {},
            onChangeRepeticao = {},
            onChangeDescansoMin = {},
            onChangeDescansoSeg = {},
            onSave = {}
        )
    }
}

