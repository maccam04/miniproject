package com.macsanityapps.capsl.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.macsanityapps.capsl.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun setToolbarTitle(title : String){
        require(title.isNotBlank()) { "Toolbar title cannot be blank"}

        toolbar_title.text = title
    }

}
