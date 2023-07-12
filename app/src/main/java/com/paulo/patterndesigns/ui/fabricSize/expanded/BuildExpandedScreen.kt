package com.paulo.patterndesigns.ui.fabricSize.expanded

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BuildExpandedScreen() {
    Row {
        //MENU
        LazyColumn(
            modifier = Modifier
                .width(300.dp)
                .background(Color.Red)
        ) {
            stickyHeader {
                Box(
                    modifier = Modifier
                        .background(Color.Black)
                        .fillMaxSize()
                        .padding(20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "MENU", style = TextStyle(
                            color = Color.White,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

            }
            items(40) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "MENU $it")
                }
                Divider()
            }
        }

        //CONTENT
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            stickyHeader {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ){
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
                                .size(500.dp, 300.dp)
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
                                .size(980.dp, 440.dp)
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
}
@Composable
fun RoundedBoxWithRow() {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .width(450.dp)
            .background(Color.LightGray,
                shape = RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Pesquisar na Loja Paulão E-commerce",
                modifier = Modifier.weight(2f).padding(end = 8.dp)
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

@Composable
fun CardComponent(color: Color) {
    Card(
        modifier = Modifier
            .size(280.dp, 420.dp)
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
                    .size(250.dp)
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
