package com.test.unleashdemo.ui.data

import com.test.unleashdemo.utils.Response
import com.test.unleashdemo.utils.getUnleashResponse

class MainRemoteDataStoreImpl(
    private val apiService: ApiService
) : MainRemoteDataStore {
    override suspend fun getData(): Response<List<GithubDataModel>> {
        return getUnleashResponse {
            apiService.getMostStarredRepositories().items.orEmpty()
        }
    }
}