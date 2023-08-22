package com.test.unleashdemo.ui.data

interface FeatureToggleRemoteDataStore {
    suspend fun isDetailToggleEnabled(): Boolean
}