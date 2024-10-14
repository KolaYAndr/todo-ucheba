package com.cleverpumpkin.auth.auth_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cleverpumpkin.auth.R
import com.cleverpumpkin.core.presentation.theme.TodoAppTheme

@Composable
fun AuthScreen(
    state: State<AuthScreenUiState>,
    onYandexAuth: () -> Unit,
    onNavigateForward: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier) { paddingValues ->
        Column(
            modifier = Modifier
                .background(TodoAppTheme.colorScheme.backPrimary)
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (state.value) {
                AuthScreenUiState.Loading -> {
                    CircularProgressIndicator()
                }

                AuthScreenUiState.Logged -> onNavigateForward()
                AuthScreenUiState.NotLogged -> {
                    Icon(
                        painter = painterResource(R.drawable.logo), contentDescription = null,
                        modifier = Modifier.size(200.dp)
                    )
                    Text(text = stringResource(R.string.todo), fontSize = 40.sp)

                    Button(
                        shape = RoundedCornerShape(8.dp),
                        onClick = { onYandexAuth() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = TodoAppTheme.colorScheme.backSecondary,
                            contentColor = TodoAppTheme.colorScheme.labelSecondary
                        ),
                        modifier = Modifier.padding(top = 32.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.icons8_yandex_logo__1_),
                            contentDescription = null
                        )
                        Text(
                            text = stringResource(R.string.yandex_login).uppercase(),
                            style = TodoAppTheme.typography.button
                        )
                    }

                }
            }

        }
    }
}
