package com.example.e_dawapharmacy.utils

import com.example.e_dawapharmacy.data.RegisterBody
import com.example.e_dawapharmacy.data.RegisterResponse
import com.example.e_dawapharmacy.data.UniqueEmailValidationResponse
import com.example.e_dawapharmacy.data.ValidateEmailBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface APIConsumer {

   /* @POST()
    fun validateEmailAddress(@Body body: ValidateEmailBody): Response<UniqueEmailValidationResponse>
*/

    @POST("demo/add-user")
    suspend fun registerUser(@Body body: RegisterBody): Response<RegisterResponse>
}