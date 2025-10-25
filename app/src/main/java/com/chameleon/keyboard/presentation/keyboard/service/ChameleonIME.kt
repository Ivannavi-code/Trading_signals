package com.chameleon.keyboard.presentation.keyboard.service

import android.inputmethodservice.InputMethodService
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import android.widget.Button
import android.graphics.Color
import com.chameleon.keyboard.core.theme.ThemeManager
import com.chameleon.keyboard.data.local.prefs.PreferencesManager

class ChameleonIME : InputMethodService() {

    private lateinit var themeManager: ThemeManager
    private lateinit var preferencesManager: PreferencesManager

    override fun onCreate() {
        super.onCreate()
        themeManager = ThemeManager(this)
        preferencesManager = PreferencesManager(this)
    }

    override fun onCreateInputView(): View {
        val keyboardView = createSimpleKeyboard()
        
        // Aplicar transparencia
        val transparency = preferencesManager.getTransparency()
        keyboardView.alpha = transparency
        
        return keyboardView
    }

    private fun createSimpleKeyboard(): View {
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#6200EE"))
            setPadding(8, 8, 8, 8)
        }

        // Fila 1: Q-P
        val row1 = createKeyRow(listOf("Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"))
        layout.addView(row1)

        // Fila 2: A-L
        val row2 = createKeyRow(listOf("A", "S", "D", "F", "G", "H", "J", "K", "L"))
        layout.addView(row2)

        // Fila 3: Z-M con Shift y Delete
        val row3 = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }
        
        row3.addView(createSpecialKey("⬆️") {
            // TODO: Shift
        })
        
        listOf("Z", "X", "C", "V", "B", "N", "M").forEach { key ->
            row3.addView(createKey(key))
        }
        
        row3.addView(createSpecialKey("⌫") {
            val ic = currentInputConnection
            ic?.deleteSurroundingText(1, 0)
        })
        
        layout.addView(row3)

        // Fila 4: Espacio y Enter
        val row4 = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }
        
        row4.addView(createSpecialKey("😀") {
            // TODO: Emojis
        })
        
        row4.addView(createKey("ESPACIO", 4f) {
            val ic = currentInputConnection
            ic?.commitText(" ", 1)
        })
        
        row4.addView(createSpecialKey("↵") {
            val ic = currentInputConnection
            ic?.commitText("\n", 1)
        })
        
        layout.addView(row4)

        return layout
    }

    private fun createKeyRow(keys: List<String>): LinearLayout {
        val row = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }
        
        keys.forEach { key ->
            row.addView(createKey(key))
        }
        
        return row
    }

    private fun createKey(text: String, weight: Float = 1f, customAction: (() -> Unit)? = null): Button {
        return Button(this).apply {
            this.text = text
            textSize = 18f
            setTextColor(Color.BLACK)
            setBackgroundColor(Color.WHITE)
            layoutParams = LinearLayout.LayoutParams(
                0,
                120,
                weight
            ).apply {
                setMargins(4, 4, 4, 4)
            }
            
            setOnClickListener {
                if (customAction != null) {
                    customAction()
                } else {
                    val ic = currentInputConnection
                    ic?.commitText(text.lowercase(), 1)
                }
            }
        }
    }

    private fun createSpecialKey(text: String, action: () -> Unit): Button {
        return Button(this).apply {
            this.text = text
            textSize = 18f
            setTextColor(Color.BLACK)
            setBackgroundColor(Color.parseColor("#EEEEEE"))
            layoutParams = LinearLayout.LayoutParams(
                0,
                120,
                1.5f
            ).apply {
                setMargins(4, 4, 4, 4)
            }
            
            setOnClickListener { action() }
        }
    }

    override fun onStartInput(attribute: EditorInfo?, restarting: Boolean) {
        super.onStartInput(attribute, restarting)
        // TODO: Detectar app y cambiar tema
    }
}
