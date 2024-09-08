package com.example.e_dawapharmacy.view

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.e_dawapharmacy.R
import com.example.e_dawapharmacy.data.ValidateEmailBody
import com.example.e_dawapharmacy.databinding.ActivityMainBinding
import com.example.e_dawapharmacy.repository.AuthRepository
import com.example.e_dawapharmacy.utils.APIService
import com.example.e_dawapharmacy.view_model.RegisterActivityViewModel
import com.example.e_dawapharmacy.view_model.RegisterActivityViewModelFactory

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener,
    View.OnKeyListener {
    private lateinit var mbinding: ActivityMainBinding
    private lateinit var mViewModel: RegisterActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mbinding.root)
        mbinding.fullNameEt.onFocusChangeListener = this
        mbinding.emailEt.onFocusChangeListener = this
        mbinding.passwordEt.onFocusChangeListener = this
        mbinding.cPasswordEt.onFocusChangeListener = this
        mViewModel = ViewModelProvider(this, RegisterActivityViewModelFactory(AuthRepository(APIService.getService()), application)).get(RegisterActivityViewModel::class.java)
            setupObservers()

    }
private fun setupObservers(){
    mViewModel.getIsLoading().observe(this){
       mbinding.progressBar.isVisible = it
    }

    mViewModel.getIsUniqueEmail().observe(this){
        if(it) {
            mbinding.emailTl.apply {
                if (isErrorEnabled) isErrorEnabled = false
                setStartIconDrawable(R.drawable.check_circle_24)
                setStartIconTintList(ColorStateList.valueOf(Color.GREEN))

            }
        }else {
            mbinding.emailTl.apply {
                if (startIconDrawable != null ) startIconDrawable = null
                isErrorEnabled = true
                error = "Email is already taken"
            }
        }
    }
    mViewModel.getError().observe(this){
        val formErrorKeys = arrayOf("fullName. email, password")
        val message = StringBuilder()
        it.map { entry ->
            if (formErrorKeys.contains(entry.key)){
                when(entry.key){
                    "fullName"->{
                        mbinding.fullNameTl.apply {
                            isErrorEnabled = true
                            error = entry.value
                        }
                    }
                    "email" ->{
                        mbinding.emailTl.apply {
                            isErrorEnabled = true
                            error = entry.value
                        }
                    }
                    "password"->{
                        mbinding.passwordTl.apply {
                            isErrorEnabled = true
                            error = entry.key
                        }
                    }
                }
            }else{
                message.append(entry.value).append("\n")
            }
            if (message.isNotEmpty()){
                AlertDialog.Builder(this)
                    .setIcon(R.drawable.info_24)
                    .setTitle("INFORMATION")
                    .setMessage(message)
                    .setPositiveButton("OK"){dialogue, _->dialogue !!.dismiss()}
                    .show()
            }
        }
    }
    mViewModel.getUser().observe(this){

    }
}
    private fun validateFullName(): Boolean {
        var errorMessage: String? = null
        val value: String = mbinding.fullNameEt.text.toString()
        if (value.isEmpty()) {
            errorMessage = "Full Name is required"
        }
        if (errorMessage != null) {
            mbinding.fullNameTl.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validateEmail(): Boolean {
        var errorMessage: String? = null
        val value: String = mbinding.emailEt.text.toString()
        if (value.isEmpty()) {
            errorMessage = " Email is required"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            errorMessage = "Email address is invalid"
        }
        if (errorMessage != null) {
            mbinding.emailTl.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validatePassword(): Boolean {
        var errorMessage: String? = null
        val value: String = mbinding.passwordEt.text.toString()
        if (value.isEmpty()) {
            errorMessage = "password is required"
        } else if (value.length < 4) {
            errorMessage = "password must be 4 characters long"
        }
        if (errorMessage != null) {
            mbinding.passwordTl.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validateConfirmPassword(): Boolean {
        var errorMessage: String? = null
        val value: String = mbinding.cPasswordEt.text.toString()
        if (value.isEmpty()) {
            errorMessage = "Confirm Password is Required"
        } else if (value.length < 4) {
            errorMessage = "Confirm password must be 4 characters long"
        }
        if (errorMessage != null) {
            mbinding.cPasswordTl.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validatePasswordAndConfirmPassword(): Boolean {
        var errorMessage: String? = null
        val password = mbinding.passwordEt.text.toString()
        val confirmPassword = mbinding.cPasswordEt.text.toString()
        if (password != confirmPassword) {
            errorMessage = "Password and Confirm password do not match"
        }
        if (errorMessage != null) {
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

        if (view != null) {
            when (view.id) {
                R.id.fullNameEt -> {
                    if (hasFocus) {
                        if (mbinding.fullNameTl.isErrorEnabled) {
                            mbinding.fullNameTl.isErrorEnabled = false
                        }
                    } else {
                        validateFullName()

                    }
                }

                R.id.emailEt -> {
                    if (hasFocus) {
                        if (mbinding.emailTl.isErrorEnabled) {
                            mbinding.emailTl.isErrorEnabled = false
                        }
                    } else {
                        if (validateEmail()) {
                            mViewModel.validateEmailAddress(ValidateEmailBody(mbinding.emailEt.text.toString()))
                        }

                    }
                }

                R.id.passwordEt -> {
                    if (hasFocus) {
                        if (mbinding.passwordTl.isErrorEnabled) {
                            mbinding.passwordTl.isErrorEnabled = false
                        }
                    } else {
                        if (validatePassword() && mbinding.cPasswordEt.text!!.isNotEmpty() && validateConfirmPassword() &&
                            validatePasswordAndConfirmPassword()
                        ) {
                            if (mbinding.cPasswordTl.isErrorEnabled) {
                                mbinding.cPasswordTl.isErrorEnabled = false
                            }
                            mbinding.cPasswordTl.apply {
                                setStartIconDrawable(R.drawable.check_circle_24)
                                setStartIconTintList(ColorStateList.valueOf(Color.GREEN))
                            }
                        }
                    }
                }

                R.id.cPasswordEt -> {
                    if (hasFocus) {
                        if (mbinding.cPasswordTl.isErrorEnabled) {
                            mbinding.cPasswordTl.isErrorEnabled = false
                        }
                    } else {
                        if (validateConfirmPassword() && validatePassword() && validatePasswordAndConfirmPassword()) {
                            if (mbinding.cPasswordTl.isErrorEnabled) {
                                mbinding.cPasswordTl.isErrorEnabled = false
                            }
                            mbinding.cPasswordTl.apply {
                                setStartIconDrawable(R.drawable.check_circle_24)
                                setStartIconTintList(ColorStateList.valueOf(Color.GREEN))
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
        return false
    }
}
