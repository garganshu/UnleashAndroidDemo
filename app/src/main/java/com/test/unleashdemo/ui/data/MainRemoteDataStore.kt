package com.test.unleashdemo.ui.data

import com.test.unleashdemo.utils.Response

interface MainRemoteDataStore {
    suspend fun getData(): Response<List<GithubDataModel>>
    suspend fun isDetailToggleEnabled(): Boolean
}