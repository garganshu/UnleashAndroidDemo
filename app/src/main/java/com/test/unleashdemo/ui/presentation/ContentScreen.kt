package com.test.unleashdemo.ui.presentation

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.test.unleashdemo.R
import com.test.unleashdemo.ui.data.GithubData
import com.test.unleashdemo.utils.ViewState

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ContentScreen(
    viewState: ViewState<List<GithubData>>,
    onItemClick: (GithubData) -> Unit,
    isRefreshing: Boolean,
    onRefresh: () -> Unit
) {
    val context = LocalContext.current
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = onRefresh
    )
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (viewState) {
            is ViewState.Loading -> {
                CircularProgressIndicator()
            }
            is ViewState.Error -> {
                Toast.makeText(
                    context,
                    viewState.error,
                    Toast.LENGTH_LONG
                ).show()
            }
            is ViewState.Success -> {
                val dataList = viewState.data
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .pullRefresh(pullRefreshState)
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.Black),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        items(dataList.size) { i ->
                            val data = dataList[i]
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        onItemClick(data)
                                    },
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(18.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column(modifier = Modifier.fillMaxWidth(0.6f)) {
                                        TextData(
                                            text = data.name.orEmpty(),
                                            textSize = 24f,
                                            fontWeight = FontWeight.Bold
                                        )
                                        TextData(text = data.description.orEmpty(), textSize = 18f)
                                    }
                                    AsyncImage(
                                        modifier = Modifier
                                            .size(82.dp)
                                            .clip(CircleShape)
                                            .border(
                                                BorderStroke(
                                                    4.dp,
                                                    color = colorResource(id = R.color.purple_500)
                                                ), shape = CircleShape
                                            ),
                                        model = data.ownerAvatarUrl,
                                        contentDescription = data.description,
                                        contentScale = ContentScale.Crop,
                                        error = painterResource(id = R.drawable.github_logo),
                                        fallback = painterResource(id = R.drawable.github_logo),
                                    )
                                }
                            }
                        }
                    }
                    PullRefreshIndicator(
                        modifier = Modifier.align(Alignment.TopCenter),
                        refreshing = isRefreshing,
                        state = pullRefreshState
                    )
                }
            }
        }
    }
}

@Composable
private fun TextData(
    modifier: Modifier = Modifier,
    text: String?,
    textSize: Float,
    color: Color = Color.Black,
    fontWeight: FontWeight = FontWeight.Normal
) {
    if (!text.isNullOrEmpty()) {
        Text(
            text = text,
            color = color,
            fontSize = TextUnit(textSize, TextUnitType.Sp),
            modifier = modifier.padding(8.dp),
            maxLines = 3,
            fontWeight = fontWeight,
            overflow = TextOverflow.Ellipsis
        )
    }
}