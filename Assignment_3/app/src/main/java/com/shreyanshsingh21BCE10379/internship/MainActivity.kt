package com.shreyanshsingh21BCE10379.internship

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shreyanshsingh21BCE10379.internship.ui.theme.ExternshipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExternshipTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    val context = LocalContext.current
    val radioOptions = listOf("Amazon", "Google", "YouTube", "Flipkart")
    val images =
        listOf(R.drawable.amazon, R.drawable.google, R.drawable.youtube, R.drawable.flipkart)
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
    var x = 0

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds,
            alpha = 0.3f
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(bottom = 40.dp),
                fontFamily = FontFamily.Cursive
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Username") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Person, contentDescription = "Username Icon"
                    )
                },
                modifier = Modifier.padding(top = 10.dp, bottom = 20.dp),
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Lock, contentDescription = "Password Icon"
                    )
                },
                modifier = Modifier.padding(bottom = 20.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column(horizontalAlignment = Alignment.Start) {
                radioOptions.forEach { text ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (text == selectedOption),
                                onClick = { onOptionSelected(text) }
                            )
                            .padding(horizontal = 50.dp)
                    ) {
                        RadioButton(
                            selected = (text == selectedOption),
                            modifier = Modifier.padding(all = 8.dp),
                            onClick = {
                                onOptionSelected(text)
                            }
                        )
                        Image(
                            painter = painterResource(images[x]),
                            contentDescription = "Logo",
                            modifier = Modifier.size(40.dp)
                        )
                        Text(
                            text = text,
                            style = MaterialTheme.typography.headlineSmall,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                        x++
                    }
                }
            }

            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {
                    val url = when (selectedOption) {
                        radioOptions[0] -> "https://www.amazon.in/"
                        radioOptions[1] -> "https://www.google.co.in/"
                        radioOptions[2] -> "https://www.youtube.com/"
                        radioOptions[3] -> "https://www.flipkart.com/"
                        else -> ""
                    }
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    context.startActivity(intent)
                }
            ) {
                Text(text = "Open Website", style = MaterialTheme.typography.titleLarge)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExternshipTheme {
        LoginScreen()
    }
}
