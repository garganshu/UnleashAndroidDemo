package com.test.unleashdemo.ui.data

import com.test.unleashdemo.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/search/repositories")
    suspend fun getMostStarredRepositories(
        @Query("q") query: String = Constants.STARS_QUERY,
        @Query("sort") sort: String = Constants.STAR_SORT_ORDER,
        @Query("per_page") page: Int = Constants.PER_PAGE
    ): DataModel
}