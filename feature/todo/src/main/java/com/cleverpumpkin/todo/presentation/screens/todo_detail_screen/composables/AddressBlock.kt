package com.cleverpumpkin.todo.presentation.screens.todo_detail_screen.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.cleverpumpkin.core.presentation.theme.TodoAppTheme
import com.cleverpumpkin.todo.R

@Composable
fun AddressBlock(
    onClick: () -> Unit,
    addressText: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
            .then(modifier),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = stringResource(id = R.string.address),
            style = TodoAppTheme.typography.body,
            color = TodoAppTheme.colorScheme.labelPrimary
        )

        Text(
            text = addressText.ifEmpty { stringResource(R.string.choose_address) },
            style = TodoAppTheme.typography.subhead,
            color = if (addressText.isEmpty()) TodoAppTheme.colorScheme.labelTertiary else TodoAppTheme.colorScheme.blue
        )

    }
}

@PreviewLightDark
@Composable
fun PreviewAddressBlock() {
    TodoAppTheme {
        AddressBlock({}, "Volgograd", modifier = Modifier.fillMaxWidth())
    }
}
