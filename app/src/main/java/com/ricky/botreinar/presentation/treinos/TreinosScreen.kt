package com.ricky.botreinar.presentation.treinos

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.ricky.botreinar.R
import com.ricky.botreinar.common.convertToString
import com.ricky.botreinar.navigation.Screens
import com.ricky.botreinar.presentation.treinos.components.CardRounded
import com.ricky.botreinar.presentation.treinos.components.DialogTreinoForm
import com.ricky.botreinar.ui.theme.BoTreinarTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TreinosScreens(
    navController: NavController,
    state: TreinosState,
    onEvent: (TreinosEvent) -> Unit
) {

    if (state.isShowDialog) {
        DialogTreinoForm(
            state = state,
            onDimiss = { onEvent(TreinosEvent.ShowDialogForm) },
            onChangeDescricao = { onEvent(TreinosEvent.OnChangeDescricao(it)) },
            onChangeLetra = { onEvent(TreinosEvent.OnChangeLetra(it)) },
            onSave = { onEvent(TreinosEvent.OnSave) }
        )
    }
    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = {
            Text(
                text = stringResource(id = R.string.meus_treinos),
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
        })
    }, floatingActionButton = {
        FloatingActionButton(onClick = { onEvent(TreinosEvent.ShowDialogForm) }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(id = R.string.salvar)
            )
        }
    }) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            items(state.treinos) {
                CardRounded(title = it.letra,
                    description = it.descricao,
                    onDelete = { onEvent(TreinosEvent.OnDelete(it.idTreino)) },
                    description2 = it.data.convertToString(),
                    onClick = {
                        navController.navigate(Screens.TreinoDetalheScreen.route + "/${it.idTreino}")
                    })
            }
        }
    }
}

@Preview
@Composable
private fun TreinoScreenPreview() {
    val context = LocalContext.current
    BoTreinarTheme {
        TreinosScreens(NavController(context), TreinosState(), {})
    }
}