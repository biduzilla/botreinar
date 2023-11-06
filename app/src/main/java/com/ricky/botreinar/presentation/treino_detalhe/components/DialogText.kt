package com.ricky.botreinar.presentation.treino_detalhe.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ricky.botreinar.R
import com.ricky.botreinar.ui.theme.BoTreinarTheme

@Composable
fun DialogText(
    modifier: Modifier = Modifier,
    onDimiss: () -> Unit,
    onAction: () -> Unit,
    @StringRes labelAction: Int,
    @StringRes labelDimiss: Int,
) {

    AlertDialog(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        text = {
            Text(
                text = stringResource(id = R.string.titulo_apagar_exercicio),
                style = MaterialTheme.typography.bodyLarge
            )
        },
        onDismissRequest = { onDimiss() },
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { onAction() }) {
                    Text(text = stringResource(id = labelAction))
                }
                Button(onClick = { onDimiss() }) {
                    Text(text = stringResource(id = labelDimiss))
                }
            }
        },
    )
}

@Preview
@Composable
private fun DialogAddProdutoPreview() {
    BoTreinarTheme {
        DialogText(
            onAction = {},
            onDimiss = {},
            labelAction = R.string.apagar,
            labelDimiss = R.string.cancelar
        )
    }
}