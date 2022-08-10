package com.kiwi.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.kiwi.android.core.Theme
import com.kiwi.android.core.collectOn
import com.kiwi.android.databinding.ActivityMainBinding
import com.kiwi.android.domain.preferences.Preferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeThemeUpdates()
    }

    private fun observeThemeUpdates() {
        preferences.observeTheme().collectOn(this) {
            AppCompatDelegate.setDefaultNightMode(
                when (it) {
                    Theme.DARK -> AppCompatDelegate.MODE_NIGHT_YES
                    Theme.LIGHT -> AppCompatDelegate.MODE_NIGHT_NO
                }
            )
        }
    }
}