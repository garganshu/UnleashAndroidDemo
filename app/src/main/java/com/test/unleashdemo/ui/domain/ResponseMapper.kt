package com.test.unleashdemo.ui.domain

import com.test.unleashdemo.ui.data.GithubData
import com.test.unleashdemo.ui.data.GithubDataModel

interface ResponseMapper {
    fun toGithubDataList(dataModelList: List<GithubDataModel>): List<GithubData>
}