package com.test.unleashdemo.ui.data

import com.test.unleashdemo.ui.domain.ResponseMapper
import com.test.unleashdemo.ui.domain.MainRepository
import com.test.unleashdemo.utils.Response
import com.test.unleashdemo.utils.responseMap

class MainRepositoryImpl(
    private val remoteDataStore: MainRemoteDataStore,
    private val mapper: ResponseMapper
) : MainRepository {
    override suspend fun getData(): Response<List<GithubData>> {
        return remoteDataStore.getData().responseMap {
            mapper.toGithubDataList(dataModelList = it)
        }
    }

    override suspend fun isDetailToggleEnabled(): Boolean {
        return remoteDataStore.isDetailToggleEnabled()
    }
}