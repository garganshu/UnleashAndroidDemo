package com.test.unleashdemo.ui.data

import io.getunleash.UnleashClient

class FeatureToggleRemoteDataStoreImpl(
    private val unleashClient: UnleashClient
) : FeatureToggleRemoteDataStore {

    override suspend fun isDetailToggleEnabled(): Boolean {
        return unleashClient.isEnabled("GithubDetailsEnabled", true)
    }
}