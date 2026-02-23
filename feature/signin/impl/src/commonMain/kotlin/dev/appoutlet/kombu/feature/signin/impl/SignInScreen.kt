package dev.appoutlet.kombu.feature.signin.impl

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.composables.icons.lucide.ChartLine
import com.composables.icons.lucide.Eye
import com.composables.icons.lucide.EyeOff
import com.composables.icons.lucide.Lock
import com.composables.icons.lucide.LogIn
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.User
import com.composables.icons.lucide.X
import dev.appoutlet.kombu.core.ui.component.layout.Screen
import dev.appoutlet.kombu.core.ui.modifier.widthInNarrow
import kombu.feature.signin.impl.generated.resources.Res
import kombu.feature.signin.impl.generated.resources.sign_in_button
import kombu.feature.signin.impl.generated.resources.sign_in_password
import kombu.feature.signin.impl.generated.resources.sign_in_password_placeholder
import kombu.feature.signin.impl.generated.resources.sign_in_subtitle
import kombu.feature.signin.impl.generated.resources.sign_in_title
import kombu.feature.signin.impl.generated.resources.sign_in_username
import kombu.feature.signin.impl.generated.resources.sign_in_username_placeholder
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SignInScreen() {
    val viewModel = koinViewModel<SignInViewModel>()
    Screen<SignInViewData, SignInAction, SignInEvent>(
        viewModelProvider = { viewModel },
        onAction = ::onAction,
        onTryAgain = viewModel::onLoad
    ) { _, onEvent ->
        Scaffold { paddingValues ->
            Box(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState()).padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(modifier = Modifier.size(64.dp), imageVector = Lucide.ChartLine, contentDescription = null)
                    Text(
                        text = stringResource(Res.string.sign_in_title),
                        style = MaterialTheme.typography.displayMedium
                    )
                    ElevatedCard(modifier = Modifier.widthInNarrow().padding(vertical = 16.dp)) {
                        SignInForm(onEvent)
                    }
                }
            }
        }
    }
}

@Composable
private fun SignInForm(onEvent: (SignInEvent) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        var username by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }

        Text(text = stringResource(Res.string.sign_in_subtitle), style = MaterialTheme.typography.titleLarge)

        UsernameField(username, onUsernameChange = { username = it })
        PasswordField(password, onPasswordChange = { password = it })

        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 24.dp),
            onClick = { onEvent(SignInEvent.OnSubmit(username, password)) },
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Icon(modifier = Modifier.size(24.dp), imageVector = Lucide.LogIn, contentDescription = null)
                Text(text = stringResource(Res.string.sign_in_button))
            }
        }
    }
}

@Composable
private fun PasswordField(
    password: String,
    onPasswordChange: (String) -> Unit,
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val visualTransformation = if (passwordVisible) {
        VisualTransformation.None
    } else {
        PasswordVisualTransformation()
    }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
        value = password,
        onValueChange = onPasswordChange,
        singleLine = true,
        visualTransformation = visualTransformation,
        label = {
            Text(
                text = stringResource(Res.string.sign_in_password),
                style = MaterialTheme.typography.bodyMedium
            )
        },
        placeholder = {
            Text(
                text = stringResource(Res.string.sign_in_password_placeholder),
                style = MaterialTheme.typography.bodyMedium
            )
        },
        leadingIcon = { Icon(Lucide.Lock, contentDescription = null) },
        trailingIcon = {
            AnimatedContent(targetState = passwordVisible) { visible ->
                IconButton(onClick = { passwordVisible = !visible }) {
                    Icon(
                        imageVector = if (visible) Lucide.EyeOff else Lucide.Eye,
                        contentDescription = null
                    )
                }
            }
        }
    )
}

@Composable
private fun UsernameField(username: String, onUsernameChange: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
        value = username,
        onValueChange = onUsernameChange,
        singleLine = true,
        label = { Text(stringResource(Res.string.sign_in_username)) },
        placeholder = { Text(stringResource(Res.string.sign_in_username_placeholder)) },
        leadingIcon = { Icon(Lucide.User, contentDescription = null) },
        trailingIcon = {
            AnimatedVisibility(visible = username.isNotEmpty()) {
                IconButton(onClick = { onUsernameChange("") }) {
                    Icon(Lucide.X, contentDescription = null)
                }
            }
        }
    )
}

private suspend fun onAction(action: SignInAction) {
    when (action) {
        SignInAction.NavigateToHome -> {
            // Handle navigation to home screen
        }
    }
}
