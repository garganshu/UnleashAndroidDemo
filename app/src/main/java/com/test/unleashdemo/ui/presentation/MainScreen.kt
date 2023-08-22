package com.test.unleashdemo.ui.presentation

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.test.unleashdemo.R
import com.test.unleashdemo.ui.data.GithubData
import com.test.unleashdemo.utils.browseUrl
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onFinish: () -> Unit
) {
    val selectedData: MutableState<GithubData?> = remember { mutableStateOf(null) }
    val context = LocalContext.current
    BottomSheetScreen(sheetContent = {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(84.dp)
                    .clip(CircleShape),
                model = selectedData.value?.ownerAvatarUrl,
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            TextData(
                text = selectedData.value?.name,
                textSize = 32f,
                fontWeight = FontWeight.Bold
            )
            TextData(text = "(${selectedData.value?.fullName})", textSize = 18f)
            TextData(text = selectedData.value?.repoUrl, textSize = 24f, color = Color.Blue, modifier = Modifier.clickable {
                context.browseUrl(selectedData.value?.repoUrl)
            })
            TextData(
                text = stringResource(
                    R.string.stars,
                    selectedData.value?.stargazersCount.toString()
                ), textSize = 22f
            )
            TextData(
                text = stringResource(
                    R.string.license_info,
                    selectedData.value?.licenseName.toString()
                ), textSize = 22f
            )
            TextData(text = selectedData.value?.description, textSize = 18f)
        }
    },
        content = { scope, state ->
            val isRefreshing by viewModel.isRefreshing.collectAsState()
            ContentScreen(
                viewState = viewModel.dataFlow.collectAsState().value, onItemClick = { data ->
                    viewModel.fetchDetailToggleState()
                    if (viewModel.isDetailToggleEnabled.value) {
                        selectedData.value = data
                        scope.launch {
                            if (state.isVisible) {
                                state.hide()
                            } else {
                                state.show()
                            }
                        }
                    } else {
                        Toast.makeText(
                            context,
                            R.string.flag_disabled,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                },
                isRefreshing = isRefreshing,
                onRefresh = {
                    viewModel.fetchData()
                }
            )
            BackHandler {
                scope.launch {
                    if (state.isVisible)
                        state.hide()
                    else
                        onFinish()
                }
            }
        }
    )
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
            fontWeight = fontWeight,
            textAlign = TextAlign.Center
        )
    }
}