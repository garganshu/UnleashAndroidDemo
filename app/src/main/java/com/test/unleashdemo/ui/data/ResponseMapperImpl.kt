package com.test.unleashdemo.ui.data

import com.test.unleashdemo.ui.domain.ResponseMapper

class ResponseMapperImpl : ResponseMapper {
    override fun toGithubDataList(dataModelList: List<GithubDataModel>): List<GithubData> {
        return dataModelList.map {
            GithubData(
                description = it.description,
                name = it.name,
                fullName = it.fullName,
                ownerName = it.ownerDetails?.name,
                ownerAvatarUrl = it.ownerDetails?.avatarUrl,
                stargazersCount = it.stargazersCount,
                licenseName = it.licenseDetails?.name,
                repoUrl = it.repoUrl,
                language = it.language,
                watchersCount = it.watchersCount,
                forksCount = it.forksCount,
                topics = it.topics,
            )
        }
    }
}