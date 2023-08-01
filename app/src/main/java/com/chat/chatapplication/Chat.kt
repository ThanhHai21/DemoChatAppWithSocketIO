package com.chat.chatapplication

data class Chat(
    val username: String,
    val text: String,
    val isSelf: Boolean = false
)