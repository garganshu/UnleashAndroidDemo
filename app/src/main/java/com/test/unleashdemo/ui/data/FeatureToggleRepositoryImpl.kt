package com.test.unleashdemo.ui.data

import com.test.unleashdemo.ui.domain.FeatureToggleRepository

class FeatureToggleRepositoryImpl(
    private val remoteDataStore: FeatureToggleRemoteDataStore
) : FeatureToggleRepository {

    override suspend fun isDetailToggleEnabled(): Boolean {
        return remoteDataStore.isDetailToggleEnabled()
    }
}