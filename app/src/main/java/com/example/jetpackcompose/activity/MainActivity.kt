package com.example.jetpackcompose.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.widget.ThemedSpinnerAdapter
import androidx.compose.foundation.*
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.material.TextField
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.components.AppToolBar
import com.example.jetpackcompose.ui.components.EditTextField
import com.example.jetpackcompose.ui.components.LoadingScreen


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


                AppToolBar(modifier = Modifier
                    .fillMaxWidth(), title = "AK") {
                }

                Divider(color = Color.Black)

                SetTextStyling("Test Text")

                LabelAndPlaceHolder()

                Divider(color = Color.Black)

                EditTextField(label = "Email", placeHolder = "Enter your E-mail", onValueChange =  {
                    Toast.makeText(this@MainActivity, "val $it", Toast.LENGTH_SHORT).show()
                })

                Divider(color = Color.Black)

                ProfileCardComposable()

                Divider(color = Color.Black)

                RoundedCornerCardComponent()
            }
        }
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
    fun MainActivityComposable() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.primary
        )
        { ProfileCardComposable() }
    }

    @Composable
    fun ProfileCardComposable() {
        Card(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.primary)
        ) {
            Row(modifier = Modifier.height(intrinsicSize = IntrinsicSize.Max)) {
                ProfilePictureComposable()
                ProfileContentComposable()
            }
        }
    }

    @Composable
    fun ProfilePictureComposable() {
        Card(
            shape = CircleShape,
            border = BorderStroke(2.dp, color = MaterialTheme.colors.primary),
            modifier = Modifier.size(48.dp),
            elevation = 4.dp
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(48.dp),

                contentDescription = "Profile picture holder"
            )
        }
    }

    @Composable
    fun ProfileContentComposable() {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 8.dp),
            verticalArrangement = Arrangement1.aligned(Alignment.CenterVertically)
        ) {
            Text("Catalin Ghita", fontWeight = FontWeight.Bold)
            Text(
                text = "Active now",
                style = MaterialTheme.typography.body2
            )
        }
    }

    @Composable
    fun RoundedCornerCardComponent() {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color(0xFFFFA867.toInt()),
            border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Green)),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .clickable(onClick = {
                    Toast
                        .makeText(this, "Thanks for clicking!", Toast.LENGTH_SHORT)
                        .show()
                })
        ) {
            Text(
                text = "Rounded Corner Card",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(16.dp)
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
                IconButton(onClick = {

                }) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Btn")
                }
            },

            backgroundColor = Color.Cyan,
            contentColor = Color.White,
            elevation = 2.dp
        )
    }

    @Composable
    fun TextFieldComponent2(value: String, onValueChange: (String) -> Unit, placeholder: String) {
        TextField(
            value = value,
            onValueChange = { textFieldValue -> onValueChange(textFieldValue) },
            placeholder = { Text(placeholder, color = MaterialTheme.colors.secondary) }
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF00FF00, widthDp = 50, heightDp = 100)
@Composable
fun WithGreenBackground() {
    Text("Hello World")
}
