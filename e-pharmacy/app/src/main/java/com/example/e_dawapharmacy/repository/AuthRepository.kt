package com.example.e_dawapharmacy.repository

import com.example.e_dawapharmacy.data.ValidateEmailBody
import com.example.e_dawapharmacy.utils.APIConsumer
import com.example.e_dawapharmacy.utils.RequestStatus
import com.example.e_dawapharmacy.utils.SimplifiedMessage
import kotlinx.coroutines.flow.flow

class AuthRepository(private val consumer: APIConsumer) {
   /* fun validateEmailAddress(body: ValidateEmailBody) = flow {
        emit(RequestStatus.Waiting)
        val response = consumer.validateEmailAddress(body)
        if (response.isSuccessful) {
            emit(RequestStatus.Success(response.body()!!))
        } else {
            emit(
                RequestStatus.Error(
                    SimplifiedMessage.get(
                        response.errorBody()!!.byteStream().reader().readText()
                    )
                )
            )
        }
    }*/
}