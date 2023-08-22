package com.test.unleashdemo.ui.data

import com.test.unleashdemo.ui.domain.FeatureToggleRepository
import com.test.unleashdemo.ui.domain.MainRepository
import com.test.unleashdemo.ui.domain.MainUseCase
import com.test.unleashdemo.utils.Response

class MainUseCaseImpl(
    private val mainRepository: MainRepository,
    private val featureToggleRepository: FeatureToggleRepository
) : MainUseCase {
    override suspend fun getData(): Response<List<GithubData>> {
        return mainRepository.getData()
    }

    override suspend fun isDetailToggleEnabled(): Boolean {
        return featureToggleRepository.isDetailToggleEnabled()
    }
}