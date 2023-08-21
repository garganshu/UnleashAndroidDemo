package com.test.unleashdemo.ui.data

import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("items")
    val items: List<GithubDataModel>?
)

data class GithubDataModel(
    @SerializedName("description")
    val description: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("full_name")
    val fullName: String?,
    @SerializedName("owner")
    val ownerDetails: OwnerDetailsDataModel?,
    @SerializedName("stargazers_count")
    val stargazersCount: Int?,
    @SerializedName("license")
    val licenseDetails: LicenseDataModel?,
    @SerializedName("html_url")
    val repoUrl: String?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("watchers_count")
    val watchersCount: Int?,
    @SerializedName("forks_count")
    val forksCount: Int?,
    @SerializedName("topics")
    val topics: List<String>?
)

data class OwnerDetailsDataModel(
    @SerializedName("login")
    val name: String?,
    @SerializedName("avatar_url")
    val avatarUrl: String?
)

data class LicenseDataModel(
    @SerializedName("name")
    val name: String?
)