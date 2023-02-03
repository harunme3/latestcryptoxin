package com.example.myapplication.data.models.createaccountmodel

data class KeyPair(
    val compressedPublicKey: String,
    val privateKey: String,
    val publicKey: String,
    val publicKeyBytes: List<Int>
)