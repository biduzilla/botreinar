package com.ricky.botreinar.presentation.treino_detalhe.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ricky.botreinar.R
import com.ricky.botreinar.domain.dto.ExercicioDTO
import com.ricky.botreinar.ui.theme.BoTreinarTheme

@Composable
fun CardExercicio(
    modifier: Modifier = Modifier,
    exercicio: ExercicioDTO,
    isFinalizado: (Boolean) -> Unit,
    onRemoverExercicio: () -> Unit = {}
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    var isShowDialog by remember {
        mutableStateOf(false)
    }

    if (isShowDialog) {
        DialogText(
            onDimiss = { isShowDialog = false },
            onAction = {
                onRemoverExercicio()
                isShowDialog = false
            },
            labelAction = R.string.apagar,
            labelDimiss = R.string.cancelar
        )
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Column(
                Modifier
                    .padding(16.dp)
                    .weight(4f),
                verticalArrangement = Arrangement.Center,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Checkbox(modifier = Modifier.scale(2f),
                        checked = exercicio.finalizado,
                        onCheckedChange = {
                            isFinalizado(it)
                        })
                    Spacer(Modifier.width(16.dp))
                    Column {
                        Text(
                            text = exercicio.nome,
                            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                        )
                        Spacer(Modifier.height(16.dp))
                        Text(
                            text = "${exercicio.repeticao}x${exercicio.series}",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
                if (!expanded) {
                    Column(
                        Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = exercicio.descricao,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(8.dp),
                            textAlign = TextAlign.Center
                        )
                        TimerProgressBar(totalTime = 1000L)
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(8.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { isShowDialog = true }) {
                    Icon(
                        modifier = Modifier.scale(1.2f),
                        imageVector = Icons.Filled.Delete,
                        contentDescription = stringResource(id = R.string.apagar)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        modifier = Modifier.scale(1.2f),
                        imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = null
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun CardExericioPreview() {
    BoTreinarTheme {
        CardExercicio(
            exercicio = ExercicioDTO(
                nome = "Teste Nome",
                descricao = "Descrição teste",
                repeticao = 3,
                series = 12,
                descanso = 600L,
                finalizado = true
            ),
            isFinalizado = {}
        )
    }
}