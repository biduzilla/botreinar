package com.ricky.botreinar.presentation.treino_detalhe.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ricky.botreinar.R
import com.ricky.botreinar.ui.theme.BoTreinarTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldNumberCompose(
    textSize: TextUnit = 64.sp,
    modifier: Modifier = Modifier,
    value: Int = 0,
    @StringRes label: Int,
    ime: ImeAction = ImeAction.Next,
    onChange: (Int) -> Unit,
) {
    Column(
        modifier
            .padding(
                vertical = 8.dp,
                horizontal = 16.dp
            )
            .widthIn(max = 100.dp)
    ) {

        OutlinedTextField(
            modifier = Modifier,
            value = value.toString(),
            onValueChange = { onChange(it.toInt()) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                keyboardType = KeyboardType.Number,
                autoCorrect = true,
                imeAction = ime
            ),
            textStyle = TextStyle(
                fontSize = textSize,
                textAlign = TextAlign.Center
            )
        )
        Text(
            text = stringResource(id = label),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            ),
        )
    }
}

@Preview
@Composable
private fun TextFieldNumberComposePreview() {
    BoTreinarTheme {
        TextFieldNumberCompose(
            label = R.string.nome_exercicio,
            onChange = {}
        )
    }
}