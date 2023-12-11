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

        // Get instance of Firebase
        auth = FirebaseAuth.getInstance()

        // Set Dashboard info based on currentUser status
        binding.tvContentEmail.text = auth.currentUser?.email
        binding.tvContentName.text = auth.currentUser?.displayName
        binding.tvContentUid.text = auth.currentUser?.uid

        val profileImageUri = auth.currentUser?.photoUrl

        Glide.with(this)
            .load(profileImageUri)
            .into(binding.ivAccount)

        binding.btnLogout.setOnClickListener {
            auth.signOut() // Trigger logout
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}