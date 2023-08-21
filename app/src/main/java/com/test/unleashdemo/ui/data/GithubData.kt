package com.test.unleashdemo.ui.data


data class GithubData(
    val description: String?,
    val name: String?,
    val fullName: String?,
    val ownerName: String?,
    val ownerAvatarUrl: String?,
    val stargazersCount: Int?,
    val licenseName: String?,
    val repoUrl: String?,
    val language: String?,
    val watchersCount: Int?,
    val forksCount: Int?,
    val topics: List<String>?
)