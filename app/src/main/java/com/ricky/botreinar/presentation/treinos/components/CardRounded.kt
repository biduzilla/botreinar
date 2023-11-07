package com.ricky.botreinar.presentation.treinos.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ricky.botreinar.ui.theme.BoTreinarTheme

@Composable
fun CardRounded(
    modifier: Modifier = Modifier,
    corners: Dp = 20.dp,
    title: String,
    description: String,
    border: Dp = 5.dp,
    onClick: () -> Unit,
    onDelete: () -> Unit,
) {
    Surface(
        modifier = modifier.clickable { onClick() },
        shape = RoundedCornerShape(corners),
        border = BorderStroke(width = border, color = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column {
            Row(
                Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                IconButton(onClick = onDelete) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(
                    top = 16.dp,
                    bottom = 32.dp,
                    start = 16.dp,
                    end = 16.dp
                )
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
private fun CardRoundedPreview() {
    BoTreinarTheme {
        CardRounded(
            title = "Teste",
            description = "TesteTesteTesteTesteTesteTesteTesteTesteTesteTeste",
            onClick = {},
            onDelete = {}
        )
    }
}