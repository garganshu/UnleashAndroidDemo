package com.test.unleashdemo.ui.domain

interface FeatureToggleRepository {
    suspend fun isDetailToggleEnabled(): Boolean
}