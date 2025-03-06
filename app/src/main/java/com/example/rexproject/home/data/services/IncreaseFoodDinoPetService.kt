package com.example.rexproject.home.data.services

import com.example.rexproject.core.data.api.RetroFitClient
import com.example.rexproject.home.data.api.IncreaseFoodDinoPetApi
import com.example.rexproject.home.domain.models.DinoPetStatsAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class IncreaseFoodDinoPetService {
    private val increaseFoodDinoPetApi = RetroFitClient.createService(IncreaseFoodDinoPetApi::class.java)

    suspend fun increaseFoodDinoPetById(id: Int) : Result<DinoPetStatsAdapter> {
        return withContext(Dispatchers.IO){
            try {
                val response = increaseFoodDinoPetApi.increaseFoodDinoPet(id)
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