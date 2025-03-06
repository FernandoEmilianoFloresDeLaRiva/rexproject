package com.example.rexproject.home.data.api

import com.example.rexproject.core.domain.constants.ApiConstants
import com.example.rexproject.home.domain.adapters.DinoPetStatsAdapter
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Path

interface IncreaseFoodDinoPetApi {
    @POST("${ApiConstants.DINOPET_BASE_URL}/{id}/increase-food")
    suspend fun increaseFoodDinoPet(@Path("id") id: Int) : Response<DinoPetStatsAdapter>
}