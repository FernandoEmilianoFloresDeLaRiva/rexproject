package com.example.rexproject.home.data.services

import com.example.rexproject.core.data.api.RetroFitClient
import com.example.rexproject.home.data.api.GetDinoPetByIdApi
import com.example.rexproject.home.domain.models.DinoPetStatsAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetDinoPetByIdService {
    private val getDinoPetByIdApi = RetroFitClient.createService(GetDinoPetByIdApi::class.java)

    suspend fun getDinoPetById(id: Int) : Result<DinoPetStatsAdapter> {
        return withContext(Dispatchers.IO){
            try {
                val response = getDinoPetByIdApi.getDinoPetById(id)
                if(response.isSuccessful){
                    val body = response.body()
                    if(body != null){
                        Result.success(body)
                    }else{
                        Result.failure(Exception("Empty response body"))
                    }
                }else{
                    val resError = "Error: ${response.code()} - ${response.message()}"
                    Result.failure(Exception(resError))
                }
            }catch (e : Exception){
                Result.failure(e)
            }
        }
    }
}