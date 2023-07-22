package com.example.easysushi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.easysushi.ui.MainScreen
import com.example.easysushi.ui.RootScreen
import com.example.easysushi.ui.theme.EasySushiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasySushiTheme {
                RootScreen()
            }
        }
    }
}
