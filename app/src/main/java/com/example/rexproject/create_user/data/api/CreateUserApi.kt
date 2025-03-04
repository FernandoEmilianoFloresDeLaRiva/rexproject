package com.example.rexproject.create_user.data.api

import com.example.rexproject.core.domain.adapters.UserAdapter
import com.example.rexproject.core.domain.constants.ApiConstants
import com.example.rexproject.create_user.domain.dtos.CreateUserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface CreateUserApi {
    @POST(ApiConstants.USER_BASE_URL)
    suspend fun createUser(@Body userDto: CreateUserDto) : Response<UserAdapter>
}