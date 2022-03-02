package com.example.jetpackcompose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement as Arrangement1
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.material.TextField
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                Modifier
                    .fillMaxSize() // first, set the max size
                    .verticalScroll(rememberScrollState()) // then set the scroll
            ) {
                Surface(color = MaterialTheme.colors.background) {
                    ToolbarWidget();
                }

                ButtonComponent(
                    intent = Intent(this@MainActivity, SampleListActivity::class.java),
                    buttonText = "Samplet"
                )

                Divider(color = Color.Black)

                ButtonComponent(
                    intent = Intent(this@MainActivity, SampleListActivity::class.java),
                    buttonText = "List"
                )

                Divider(color = Color.Black)

                ButtonComponent(
                    intent = Intent(this@MainActivity, SampleListActivity::class.java),
                    buttonText = "List"
                )

                Divider(color = Color.Black)

                ButtonComponent(
                    intent = Intent(this@MainActivity, SampleListActivity::class.java),
                    buttonText = "List"
                )

                Divider(color = Color.Black)

                ButtonComponent(
                    intent = Intent(this@MainActivity, SampleListActivity::class.java),
                    buttonText = "List"
                )

                Divider(color = Color.Black)

                ButtonComponent(
                    intent = Intent(this@MainActivity, SampleListActivity::class.java),
                    buttonText = "List"
                )

                Divider(color = Color.Black)

                ButtonComponent(
                    intent = Intent(this@MainActivity, SampleListActivity::class.java),
                    buttonText = "List"
                )

                Divider(color = Color.Black)

                ButtonComponent(
                    intent = Intent(this@MainActivity, SampleListActivity::class.java),
                    buttonText = "List"
                )

                Divider(color = Color.Black)

                SetTextStyling("Test Text")

                LabelAndPlaceHolder()

                TextFieldWithIcons()

            }
        }
    }

    override fun onResume() {
        super.onResume()
    }

    @Composable
    fun LabelAndPlaceHolder() {
        var text by remember { mutableStateOf(TextFieldValue("")) }

        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = { Text(text = "Name") },
            placeholder = { Text(text = "Name") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            )
    }

    @Composable
    fun TextFieldWithIcons() {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        return OutlinedTextField(
            value = text,
//            leadingIcon = { Icon(imageVector = Icon, contentDescription = "emailIcon") },
            trailingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
            onValueChange = {
                text = it
            },
            label = { Text(text = "Email address") },
            placeholder = { Text(text = "Enter your e-mail") },
        )
    }

    @Composable
    fun ButtonComponent(intent: Intent, buttonText: String) {
        Button(
            onClick = {
                startActivity(intent)
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                text = buttonText,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ToolbarWidget();
    }

    @Composable
    fun ToolbarWidget() {
        TopAppBar(
            title = {
                Text(text = "JetPack Compose")
            },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Btn")
                }
            },
            backgroundColor = Color.Cyan,
            contentColor = Color.White,
            elevation = 2.dp
        )
    }


    @Composable
    fun SetTextStyling(displayText: String, style: TextStyle? = null, maxLines: Int? = null) {
        Text(
            text = displayText,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .heightIn(30.dp),
            style = style ?: TextStyle.Default,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis,
            maxLines = maxLines ?: Int.MAX_VALUE,
            textAlign = TextAlign.Center
        )
    }




    data class User(val name :String, val maxLine :Int)

    class SampleUserProvider: PreviewParameterProvider<User> {
        override val values = sequenceOf(User("Jens", 5) ,User("Jim", 44))
    }


}



@Preview(showBackground = true, backgroundColor = 0xFF00FF00, widthDp = 50, heightDp = 100)
@Composable
fun WithGreenBackground() {
    Text("Hello World")
}
