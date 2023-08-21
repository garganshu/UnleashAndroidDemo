package com.test.unleashdemo.ui.data

import com.test.unleashdemo.utils.Response
import com.test.unleashdemo.utils.getUnleashResponse
import io.getunleash.UnleashClient

class MainRemoteDataStoreImpl(
    private val apiService: ApiService,
    private val unleashClient: UnleashClient
) : MainRemoteDataStore {
    override suspend fun getData(): Response<List<GithubDataModel>> {
        return getUnleashResponse {
            apiService.getMostStarredRepositories().items.orEmpty()
        }
    }

    override suspend fun isDetailToggleEnabled(): Boolean {
        return unleashClient.isEnabled("GithubDetailsEnabled", false)
    }

}