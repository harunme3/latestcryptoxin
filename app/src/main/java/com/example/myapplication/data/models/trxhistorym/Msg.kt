package com.example.myapplication.data.models.trxhistorym

data class Msg(
    val message: String,
    val result: List<Result>,
    val status: String
)