package com.ricky.botreinar.presentation.treinos.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
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
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(corners),
        border = BorderStroke(width = border, color = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(4f)
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
            IconButton(modifier = Modifier.weight(1f), onClick = onClick) {
                Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = title)
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
            onClick = {}
        )
    }
}