package com.ricky.botreinar.presentation.treino_detalhe.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ricky.botreinar.R
import com.ricky.botreinar.domain.model.Exercicio
import com.ricky.botreinar.ui.theme.BoTreinarTheme

@Composable
fun CardExercicio(
    modifier: Modifier,
    exercicio: Exercicio,
    onRemoverExercicio: () -> Unit
) {

    var expanded by remember {
        mutableStateOf(false)
    }

    var isShowDialog by remember {
        mutableStateOf(false)
    }
    Card(modifier = modifier
        .fillMaxWidth()
        .clickable { expanded = !expanded }) {
        Box {
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 12.dp,
                        vertical = 8.dp
                    )
            ) {
                IconButton(onClick = { isShowDialog = true }) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = stringResource(id = R.string.apagar)
                    )
                }
            }
            Row{

            }
        }
    }
}

@Preview
@Composable
fun CardExericioPreview() {
    BoTreinarTheme {
//        CardExercicio()
    }
}