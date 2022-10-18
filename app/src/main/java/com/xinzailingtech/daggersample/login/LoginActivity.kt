package com.xinzailingtech.daggersample.login

import android.os.Bundle
import android.util.Log
import com.xinzailingtech.daggersample.App
import com.xinzailingtech.daggersample.BaseActivity
import com.xinzailingtech.daggersample.R
import com.xinzailingtech.daggersample.databinding.ActivityLoginBinding
import javax.inject.Inject

class LoginActivity : BaseActivity() {
    private val TAG = "LoginActivity"
    private lateinit var binding: ActivityLoginBinding

    @Inject lateinit var loginViewModel: LoginViewModel

    @Inject lateinit var userLocalDataSource: UserLocalDataSource
    @Inject lateinit var userRemoteDataSource: UserRemoteDataSource

    @Inject lateinit var loginService: LoginService

    lateinit var loginGraph: LoginGraph

    override fun onCreate(savedInstanceState: Bundle?) {
        loginGraph = (applicationContext as App).appGraph.loginGraph().create()
        loginGraph.inject(this)

        Log.i(TAG, "onCreate: after inject init $loginService")
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        val loginUsernameFragment = LoginUsernameFragment.newInstance()
        val loginPasswordFragment = LoginPasswordFragment.newInstance()

        val transaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.fl_username, loginUsernameFragment)
        transaction.add(R.id.fl_password, loginPasswordFragment)
        transaction.commit()

        Log.i(TAG, "onCreate: loginViewModel $loginViewModel")
    }

    override fun onResume() {
        super.onResume()
        try {
            Log.i("LoginActivity", "userLocalDataSource: $userLocalDataSource ")
            Log.i("LoginActivity", "userRemoteDataSource: $userRemoteDataSource ")

            if (this::loginViewModel.isInitialized) {
                loginViewModel.start()
            } else {
                Log.i("LoginActivity", "onResume: ")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}