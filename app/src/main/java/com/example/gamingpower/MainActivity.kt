package com.example.gamingpower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gamingpower.ViewModel.GiveawaysViewModel
import com.example.gamingpower.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import org.koin.androidx.viewmodel.ext.android.viewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val loginViewModel :GiveawaysViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loginViewModel.giveAway.hasActiveObservers()

    }
}