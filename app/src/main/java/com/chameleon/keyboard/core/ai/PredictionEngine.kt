package com.chameleon.keyboard.core.ai

import android.content.Context
import com.chameleon.keyboard.domain.model.Prediction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PredictionEngine(private val context: Context) {

    private val commonWords = mapOf(
        "hol" to listOf("hola", "hold", "holistic"),
        "com" to listOf("como", "comer", "comprar"),
        "qu" to listOf("que", "quien", "quiero"),
        "est" to listOf("estoy", "estas", "esto"),
        "grac" to listOf("gracias", "gracia", "gracioso"),
        "buen" to listOf("bueno", "buenas", "buenos"),
        "hac" to listOf("hacer", "hace", "haces"),
        "tien" to listOf("tiene", "tienes", "tiempo")
    )

    suspend fun predict(context: String, maxSuggestions: Int = 3): List<Prediction> {
        return withContext(Dispatchers.Default) {
            val words = context.trim().split(" ")
            val lastWord = words.lastOrNull()?.lowercase() ?: ""

            if (lastWord.isEmpty()) {
                return@withContext getCommonStartWords()
            }

            findCommonPredictions(lastWord).take(maxSuggestions)
        }
    }

    private fun findCommonPredictions(prefix: String): List<Prediction> {
        return commonWords
            .filterKeys { it.startsWith(prefix) }
            .flatMap { it.value }
            .map { Prediction(it, 0.8f, "common") }
    }

    private fun getCommonStartWords(): List<Prediction> {
        return listOf(
            Prediction("hola", 0.9f, "common"),
            Prediction("como", 0.85f, "common"),
            Prediction("que", 0.8f, "common")
        )
    }

    fun learn(text: String) {
        // TODO: Implementar aprendizaje en futuras versiones
    }
}
