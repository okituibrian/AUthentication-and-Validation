package com.example.e_dawapharmacy

import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.e_dawapharmacy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener {
    private lateinit var mbinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mbinding.root)
        mbinding.fullNameEt.onFocusChangeListener = this
        mbinding.emailEt.onFocusChangeListener = this
        mbinding.passwordEt.onFocusChangeListener = this
        mbinding.cPasswordEt.onFocusChangeListener = this

    }

        private fun validateFullName(): Boolean {
            var errorMessage: String? = null
           val value: String = mbinding.fullNameEt.text.toString()
            if(value.isEmpty()){
                errorMessage = "Full Name is required"
            }
            if(errorMessage != null){
                mbinding.fullNameTl.apply {
                    isErrorEnabled = true
                    error = errorMessage
                }
            }
            return errorMessage == null
        }

    private fun validateEmail(): Boolean{
        var errorMessage: String? = null
        val value: String = mbinding.emailEt.text.toString()
        if(value.isEmpty()){
            errorMessage = " Email is required"
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            errorMessage = "Email address is invalid"
        }
        if(errorMessage != null){
            mbinding.emailTl.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validatePassword(): Boolean{
        var errorMessage: String? = null
        val value: String = mbinding.passwordEt.text.toString()
        if(value.isEmpty()){
            errorMessage = "password is required"
        }
        else if(value.length < 4 ){
            errorMessage = "password must be 4 characters long"
        }
        if(errorMessage != null){
            mbinding.passwordTl.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validateConfirmPassword(): Boolean{
        var errorMessage: String? = null
        val value: String = mbinding.cPasswordEt.text.toString()
        if (value.isEmpty()){
            errorMessage = "Confirm Password is Required"
        }
        else if(value.length < 4){
            errorMessage = "Confirm password must be 4 characters long"
        }
        if(errorMessage != null){
            mbinding.cPasswordTl.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validatePasswordAndConfirmPassword(): Boolean{
        var errorMessage: String? = null
        val password = mbinding.passwordEt.text.toString()
        val confirmPassword = mbinding.cPasswordEt.text.toString()
        if(password != confirmPassword){
            errorMessage = "Password and Confirm password do not match"
        }
        if(errorMessage != null){
            mbinding.cPasswordTl.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }





    override fun onClick(view: View?) {

    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {

        if(view != null){
            when(view.id){
                R.id.fullNameEt -> {
                    if(hasFocus){
                        if (mbinding.fullNameTl.isErrorEnabled){
                            mbinding.fullNameTl.isErrorEnabled = false
                        }
                }else{
                    validateFullName()

                    }
                }
                R.id.emailEt -> {
                    if(hasFocus){
                        if (mbinding.emailTl.isErrorEnabled){
                            mbinding.emailTl.isErrorEnabled = false
                        }
                }else{
                    validateEmail()

                    }
                }
                R.id.passwordEt -> {
                    if(hasFocus){
                        if (mbinding.passwordTl.isErrorEnabled){
                            mbinding.passwordTl.isErrorEnabled = false
                        }
                    }else{
                        if (validatePassword() && mbinding.cPasswordEt.text!!.isNotEmpty() && validateConfirmPassword() &&
                            validatePasswordAndConfirmPassword()){
                            if (mbinding.cPasswordTl.isErrorEnabled){
                                mbinding.cPasswordTl.isErrorEnabled = false
                            }
                           // mbinding.cPasswordTl.startIconDrawable =
                        }
                    }

                }
                R.id.cPasswordEt -> {
                    if (hasFocus){
                        if (mbinding.cPasswordTl.isErrorEnabled){
                            mbinding.cPasswordTl.isErrorEnabled = false
                        }
                    }else{
                        validateConfirmPassword()
                    }
                }
            }
        }
    }

    override fun onKey(view: View?, event: Int, keyEvent: KeyEvent?): Boolean {
       return false
    }

}

