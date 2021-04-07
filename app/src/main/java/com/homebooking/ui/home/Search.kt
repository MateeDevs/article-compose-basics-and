package com.homebooking.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalTextToolbar
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val OutlinedTextFieldTopPadding = 8.dp

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun Search() {
    var searchValue by remember { mutableStateOf(TextFieldValue()) }

    Row(
        Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 16.dp)
    ) {
        SearchBox(
            searchValue, { searchValue = it },
            Modifier
                .fillMaxSize()
                .weight(0.1f)
        )

        Spacer(Modifier.width(16.dp))

        Button(
            onClick = { LocalTextToolbar },
            shape = MaterialTheme.shapes.medium,
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = OutlinedTextFieldTopPadding)
                .aspectRatio(1f)
        ) {
            Icon(Icons.Default.Search, "search")
        }
    }
}

@Composable
fun SearchBox(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = TextFieldDefaults.outlinedTextFieldColors(
        unfocusedBorderColor = Color.LightGray,
        placeholderColor = Color.LightGray
    )

    // Corner issue: https://issuetracker.google.com/issues/181322957
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text("Search favorite house...") },
        singleLine = true,
        colors = colors,
        modifier = modifier
    )
}