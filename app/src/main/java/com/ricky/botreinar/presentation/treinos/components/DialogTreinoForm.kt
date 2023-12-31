package com.ricky.botreinar.presentation.treinos.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ricky.botreinar.R
import com.ricky.botreinar.presentation.treino_detalhe.components.TextFieldCompose
import com.ricky.botreinar.presentation.treinos.TreinosState
import com.ricky.botreinar.ui.theme.BoTreinarTheme

@Composable
fun DialogTreinoForm(
    state: TreinosState,
    modifier: Modifier = Modifier,
    onDimiss: () -> Unit,
    onChangeDescricao: (String) -> Unit,
    onChangeLetra: (String) -> Unit,
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
                    value = state.letra,
                    isError = state.onErrorLetra,
                    label = R.string.letra_treino,
                    onChange = { onChangeLetra(it) }
                )
                TextFieldCompose(
                    value = state.descricao,
                    isError = state.onErrorDescricao,
                    label = R.string.descricao_treino,
                    onChange = { onChangeDescricao(it) }
                )

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
        DialogTreinoForm(
            state = TreinosState(),
            onDimiss = { /*TODO*/ },
            onChangeDescricao = {},
            onChangeLetra = {},
            onSave = {}
        )
    }
}

