package com.test.unleashdemo.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.unleashdemo.ui.data.GithubData
import com.test.unleashdemo.ui.domain.MainUseCase
import com.test.unleashdemo.utils.Response
import com.test.unleashdemo.utils.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val useCase: MainUseCase
) : ViewModel() {

    private val _dataFlow: MutableStateFlow<ViewState<List<GithubData>>> =
        MutableStateFlow(ViewState.Loading(setLoading = true))
    val dataFlow: StateFlow<ViewState<List<GithubData>>> = _dataFlow

    private val _isDetailToggleEnabled: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isDetailToggleEnabled: StateFlow<Boolean> = _isDetailToggleEnabled

    private val _isRefreshing: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    fun fetchData() {
        viewModelScope.launch {
            val viewState = when (val response = useCase.getData()) {
                is Response.Success -> {
                    ViewState.Success(response.data)
                }
                is Response.Failure -> {
                    ViewState.Error(response.error)
                }
            }
            _dataFlow.emit(viewState)
            _isRefreshing.emit(false)
        }
    }

    fun fetchDetailToggleState() {
        viewModelScope.launch {
            val isEnabled = useCase.isDetailToggleEnabled()
            _isDetailToggleEnabled.value = isEnabled
        }
    }

}