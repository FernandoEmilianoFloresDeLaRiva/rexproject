package com.example.rexproject.home.data.api

import com.example.rexproject.core.domain.constants.ApiConstants
import com.example.rexproject.home.domain.adapters.DinoPetStatsAdapter
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GetDinoPetByIdApi {
    @GET("${ApiConstants.DINOPET_BASE_URL}/{id}")
    suspend fun getDinoPetById(@Path("id") id: Int): Response<DinoPetStatsAdapter>
}