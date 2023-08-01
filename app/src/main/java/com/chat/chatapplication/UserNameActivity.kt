package com.chat.chatapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.chat.chatapplication.databinding.ActivityUserNameBinding

class UserNameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etUserName.doAfterTextChanged {
            val username = it.toString()
            binding.btnJoin.isEnabled = username.isNotEmpty()
        }

        binding.btnJoin.setOnClickListener {
            val username = binding.etUserName.text.toString()
            if (username.isNotEmpty()) {
                val intent = Intent(this, ChatActivity::class.java)
                intent.putExtra(ChatActivity.USERNAME, username)
                startActivity(intent)
            }
        }
    }
}