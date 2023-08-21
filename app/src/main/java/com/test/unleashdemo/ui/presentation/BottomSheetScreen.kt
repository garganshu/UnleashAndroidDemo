package com.test.unleashdemo.ui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.test.unleashdemo.R
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetScreen(
    sheetContent: @Composable () -> Unit,
    content: @Composable (CoroutineScope, ModalBottomSheetState) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    ModalBottomSheetLayout(
        sheetShape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        sheetElevation = 8.dp,
        sheetContentColor = Color.Red,
        modifier = Modifier.background(Color.White),
        sheetState = modalSheetState,
        scrimColor = colorResource(id = R.color.background),
        sheetContent = {
            sheetContent()
        }, content = {
            content(coroutineScope, modalSheetState)
        })
}