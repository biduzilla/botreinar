package com.ricky.botreinar.presentation.treino_detalhe.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ricky.botreinar.R
import com.ricky.botreinar.ui.theme.BoTreinarTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldCompose(
    modifier: Modifier = Modifier,
    value: String,
    isError: Boolean,
    @StringRes label: Int,
    keyboardType: KeyboardType = KeyboardType.Text,
    icon: ImageVector? = null,
    ime: ImeAction = ImeAction.Next,
    onChange: (String) -> Unit
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Column(
            Modifier.padding(
                vertical = 8.dp,
                horizontal = 16.dp
            )
        ) {
            Text(
                text = stringResource(id = label),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                ),
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = value,
                onValueChange = { onChange(it) },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                ),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences,
                    autoCorrect = true,
                    keyboardType = keyboardType,
                    imeAction = ime
                ),
                leadingIcon = if (icon != null) {
                    { Icon(imageVector = icon, contentDescription = stringResource(id = label)) }
                } else {
                    null
                }
            )
            TextError(isErro = isError)
        }
    }
}

@Preview
@Composable
private fun TextFieldComposePreview() {
    BoTreinarTheme {
        TextFieldCompose(
            value = "teste",
            isError = true,
            label = R.string.nome_exercicio,
            onChange = {}
        )
    }
}