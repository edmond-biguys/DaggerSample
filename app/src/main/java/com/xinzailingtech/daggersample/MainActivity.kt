package com.xinzailingtech.daggersample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding
import com.xinzailingtech.daggersample.databinding.ActivityMainBinding
import com.xinzailingtech.daggersample.login.*
import com.xinzailingtech.mylibrary.SettingsActivity
import javax.inject.Inject


class MainActivity : BaseActivity() {

    private val TAG = "MainActivity"

    private val binding by contentView<MainActivity, ActivityMainBinding>(
        R.layout.activity_main
    )

//    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MainViewModel>()


    @Inject lateinit var userLocalDataSource: UserLocalDataSource
    @Inject lateinit var userRemoteDataSource: UserRemoteDataSource


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate: ")

        (applicationContext as App).appGraph.inject(this)


        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater).also {
//            setContentView(it.root)
//        }

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.startModifyUserName()


        viewModel.userNameLiveData.observe(this) { user ->
//            binding.user = user
        }

        binding.button.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.buttonSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }



    }

    override fun onResume() {
        super.onResume()

        Log.i("MainActivity", "userLocalDataSource: $userLocalDataSource ")
        Log.i("MainActivity", "userRemoteDataSource: $userRemoteDataSource ")



        Log.i("MainActivity", "onResume: ------------------------------------------------------")
    }
}