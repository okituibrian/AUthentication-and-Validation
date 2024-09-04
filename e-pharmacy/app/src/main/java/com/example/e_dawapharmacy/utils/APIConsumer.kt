package com.example.e_dawapharmacy.utils

import com.example.e_dawapharmacy.data.UniqueEmailValidationResponse
import com.example.e_dawapharmacy.data.ValidateEmailBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface APIConsumer {

    @POST()
    fun validateEmailAddress(@Body body: ValidateEmailBody): Response<UniqueEmailValidationResponse>

}