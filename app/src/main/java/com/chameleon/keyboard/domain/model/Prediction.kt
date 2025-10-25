package com.chameleon.keyboard.domain.model

data class Prediction(
    val text: String,
    val confidence: Float,
    val source: String
)
