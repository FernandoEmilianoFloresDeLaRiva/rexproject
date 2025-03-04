package com.example.rexproject.create_user.domain.dtos

data class CreateUserDto(val username : String, val token : String){
    fun isValid() : Boolean {
        return username.isNotEmpty() && token.isNotEmpty()
    }
}
