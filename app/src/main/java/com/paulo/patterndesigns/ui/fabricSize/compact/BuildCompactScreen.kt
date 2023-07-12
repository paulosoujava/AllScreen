package com.paulo.patterndesigns.ui.fabricSize.compact

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paulo.patterndesigns.R
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BuildCompactScreen() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    // icons to mimic drawer destinations
    val items = listOf(Icons.Default.Build, Icons.Default.Face, Icons.Default.Email)
    val selectedItem = remember { mutableStateOf(items[0]) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(Modifier.height(12.dp))
                items.forEach { item ->
                    NavigationDrawerItem(
                        icon = { Icon(item, contentDescription = null) },
                        label = { Text(item.name) },
                        selected = item == selectedItem.value,
                        onClick = {
                            scope.launch { drawerState.close() }
                            selectedItem.value = item
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                stickyHeader {
                    Row(
                        modifier = Modifier.fillMaxWidth().background(Color.White.copy(0.94f)),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(onClick = {  scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = null)

                        }
                        RoundedBoxWithRow()
                    }
                }
                //BANNER
                item {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {

                        items(10) {
                            Box(
                                modifier = Modifier
                                    .padding(20.dp)
                                    .size(300.dp, 180.dp)
                                    .background(Color.DarkGray),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.prod),
                                    contentDescription = "Imagem do Produto",
                                    modifier = Modifier
                                        .size(250.dp)
                                        .padding(top = 16.dp, bottom = 16.dp)
                                        .clip(shape = RoundedCornerShape(4.dp))
                                )
                            }
                        }
                    }
                }
                //CARDS
                item {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {
                        //PROMOTION
                        item {
                            Box(
                                modifier = Modifier
                                    .size(980.dp, 440.dp)
                            ) {
                                Column {
                                    Text(
                                        text = "Promoções",
                                        style = TextStyle(
                                            fontSize = 28.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black
                                        ),
                                        modifier = Modifier.padding(start = 12.dp)
                                    )
                                    LazyRow(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                    ) {
                                        items(10) {
                                            CardComponent(Color.Black)
                                        }
                                    }

                                }
                            }
                        }
                    }
                    // + SELLERS
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {

                        item {
                            Box(
                                modifier = Modifier
                                    .size(980.dp, 350.dp)
                            ) {
                                Column {
                                    Text(
                                        text = " + Vendidos",
                                        style = TextStyle(
                                            fontSize = 28.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black
                                        ),
                                        modifier = Modifier.padding(start = 12.dp)
                                    )
                                    LazyRow(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                    ) {
                                        items(10) {
                                            CardComponent(Color.Red)
                                        }
                                    }

                                }
                            }
                        }
                    }
                }

            }
        }
    )
}
@Composable
fun CardComponent(color: Color) {
    Card(
        modifier = Modifier
            .size(280.dp, 310.dp)
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = color
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Título do Produto",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
            Image(
                painter = painterResource(R.drawable.prod),
                contentDescription = "Imagem do Produto",
                modifier = Modifier
                    .size(150.dp)
                    .padding(top = 16.dp, bottom = 16.dp)
                    .clip(shape = RoundedCornerShape(4.dp))
            )
            Text(
                text = "Subtítulo do Produto",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White
                )
            )
            Divider(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "R$ 99.99",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White,
                        textDecoration = TextDecoration.LineThrough
                    )
                )
                Text(
                    text = "R$ 79.99",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Composable
fun RoundedBoxWithRow() {
    Box(
        modifier = Modifier
            .padding(7.dp)
            .height(45.dp)
            .width(350.dp)
            .background(
                Color.LightGray,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(6.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Pesquisar ...",
                modifier = Modifier
                    .weight(2f)
                    .padding(end = 8.dp)
            )
            IconButton(
                onClick = {  }
            ) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Botão de pesquisa"
                )
            }
        }
    }
}
