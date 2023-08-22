package com.test.unleashdemo.ui.domain

import com.test.unleashdemo.ui.data.GithubData
import com.test.unleashdemo.utils.Response

interface MainUseCase {
    suspend fun getData(): Response<List<GithubData>>
    suspend fun isDetailToggleEnabled(): Boolean
}