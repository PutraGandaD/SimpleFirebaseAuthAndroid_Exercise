package com.putragandad.simplefirebaseexercise

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.module.AppGlideModule
import com.google.firebase.auth.FirebaseAuth
import com.putragandad.simplefirebaseexercise.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val email = intent.getStringExtra("email")
        val displayName = intent.getStringExtra("name")
        val id = intent.getStringExtra("uid")
        val photoUrl = intent.getStringExtra("photoUrl")

        binding.tvContentEmail.text = email
        binding.tvContentName.text = displayName
        binding.tvContentUid.text = id

        binding.btnLogout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}