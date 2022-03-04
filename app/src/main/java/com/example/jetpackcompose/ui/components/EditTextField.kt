package com.example.jetpackcompose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

/**
 * Created by Ajin Kumar on 04,March,2022
 */

@Composable
fun EditTextField(label: String, placeHolder: String, onValueChange: (String) -> Unit) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        value = text,
//            leadingIcon = { Icon(imageVector = Icon, contentDescription = "emailIcon") },
        trailingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
        onValueChange = {
            text -> onValueChange(text.text)
        },
        label = { Text(text = label) },
        placeholder = { Text(text = placeHolder) },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    )
}