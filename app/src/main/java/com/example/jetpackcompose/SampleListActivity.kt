package com.example.jetpackcompose

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Ajin Kumar on 25,February,2022
 */
class SampleListActivity : AppCompatActivity() {
    private val listItems: List<ListItem> = listOf(
        ListItem("hi"),
        ListItem("hello"),
        ListItem("Test 235"),
        ListItem("A Test 3"),
        ListItem("B Test 4"),
        ListItem("A Test 5"),
        ListItem("C Test Test"),
        ListItem("X Test 10")
    )

    @OptIn(ExperimentalFoundationApi::class)
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayList(items = listItems)
//            LazyRowExample(listItems)

        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    @ExperimentalFoundationApi
    @Composable
    fun DisplayList(items: List<ListItem>) {
        val listState = rememberLazyListState()

        LazyColumn(modifier = Modifier.fillMaxSize(1F), state = listState) {
            val grouped = items.groupBy { it.name[0] }
            grouped.forEach { initial, items ->
                stickyHeader {
                    Text(
                        text = initial.toString(),
                        modifier = Modifier.padding(10.dp)
                    )
                }
                items(items) { item ->
                    ListItem(item = item)

                }
            }
        }
    }

    @Composable
    fun LazyRowExample(items: List<ListItem>) {
        // implement LazyRow
        LazyRow(
            contentPadding = PaddingValues(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.fillMaxSize(1F)
        ) {
            // display items horizontally
            items(items) { item ->
                ListItem(item = item)
            }
        }
    }

    @Composable
    fun ListItem(item: ListItem) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .height(60.dp)
                .background(color = Color.Gray)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
                    .clickable(onClick = {
                        Toast.makeText(this@SampleListActivity, "click"+item.name, Toast.LENGTH_SHORT).show()
                    }),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "user icon",
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .align(CenterVertically)
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .align(CenterVertically),
                    text = item.name,
                    color = Color.White,
                    fontSize = 16.sp
                )

                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .align(CenterVertically),
                    text = item.name,
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
            /*  Row(
              modifier = Modifier
                  .align(CenterEnd)
          ) {
              Image(
                  painter = painterResource(id = R.drawable.ic_mail),
                  contentDescription = "mail button",
                  modifier = Modifier
                      .align(CenterVertically)
                      .padding(8.dp)
              )
          }*/
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        ScrollsTheme {
            ListItem(item = ListItem("Jane Njoki"))
        }

    }
}