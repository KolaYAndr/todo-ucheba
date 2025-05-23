package com.cleverpumpkin.todo.presentation.composable_elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.cleverpumpkin.core.presentation.theme.TodoAppTheme
import com.cleverpumpkin.todo.R

@Composable
fun DeleteButton(
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = { onDelete() },
        modifier = modifier,
        colors = ButtonDefaults.textButtonColors(
            contentColor = TodoAppTheme.colorScheme.red,
            disabledContentColor = TodoAppTheme.colorScheme.labelDisable
        ),
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Icon(
            modifier = Modifier.minimumInteractiveComponentSize(),
            painter = painterResource(id = R.drawable.delete),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = stringResource(id = R.string.delete),
            style = TodoAppTheme.typography.button
        )
    }
}

@PreviewLightDark
@Composable
fun PreviewDeleteButton() {
    TodoAppTheme {
        DeleteButton(
            onDelete = { },
            modifier = Modifier.background(TodoAppTheme.colorScheme.backPrimary)
        )
    }
}
