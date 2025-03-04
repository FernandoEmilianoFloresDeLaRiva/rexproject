package com.example.rexproject.create_user.data.services

import com.example.rexproject.core.data.api.RetroFitClient
import com.example.rexproject.core.domain.adapters.UserAdapter
import com.example.rexproject.create_user.data.api.CreateUserApi
import com.example.rexproject.create_user.domain.dtos.CreateUserDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CreateUserService {
    private val createUserApi = RetroFitClient.createService(CreateUserApi::class.java)

    suspend fun createUser(reqUser : CreateUserDto) : Result<UserAdapter> {
        return withContext(Dispatchers.IO){
            try {
                val response = createUserApi.createUser(reqUser)
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