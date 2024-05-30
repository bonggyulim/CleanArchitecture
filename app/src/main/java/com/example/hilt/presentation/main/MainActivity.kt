package com.example.hilt.presentation.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hilt.R
import com.example.hilt.databinding.ActivityMainBinding
import com.example.hilt.presentation.mypage.main.MyPageFragment
import com.example.hilt.presentation.popular.main.PopularVideoFragment
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val db = Firebase.firestore
        val user = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815,
        )
        db.collection("users").add(user)

        
        initBtn()
    }

    fun initBtn() {
        binding.apply {
            MyPage.setOnClickListener{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fl, MyPageFragment())
                    commit()
                }
            }

            Popular.setOnClickListener {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fl, PopularVideoFragment())
                    commit()
                }
            }
        }


    }
}