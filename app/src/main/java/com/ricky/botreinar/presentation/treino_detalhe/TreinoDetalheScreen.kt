package com.ricky.botreinar.presentation.treino_detalhe

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TreinoDetalheScreen(
    state: TreinoDetalheState,
    onEvent: (TreinoDetalheEvent) -> Unit
) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = {
            Text(
                text = state.tipoTreino,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
        })
    }, floatingActionButton = {
        FloatingActionButton(onClick = { onEvent(TreinoDetalheEvent.OnSave)}) {

        }
    }) {paddingValues ->

    }
}