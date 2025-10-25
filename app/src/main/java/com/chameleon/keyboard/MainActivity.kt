package com.chameleon.keyboard

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.view.Gravity
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Crear layout principal
        val mainLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#1E1E1E"))
            setPadding(40, 60, 40, 40)
            gravity = Gravity.CENTER_HORIZONTAL
        }
        
        // Logo/Título
        val title = TextView(this).apply {
            text = "🦎"
            textSize = 72f
            gravity = Gravity.CENTER
            setPadding(0, 0, 0, 20)
        }
        
        val appName = TextView(this).apply {
            text = "Teclado Camaleón"
            textSize = 32f
            setTextColor(Color.WHITE)
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
            setPadding(0, 0, 0, 40)
        }
        
        val subtitle = TextView(this).apply {
            text = "El teclado que se adapta a ti"
            textSize = 16f
            setTextColor(Color.parseColor("#AAAAAA"))
            gravity = Gravity.CENTER
            setPadding(0, 0, 0, 60)
        }
        
        // Botón 1: Activar Teclado
        val btnEnable = createButton("1️⃣ Activar Teclado", "#6200EE") {
            openKeyboardSettings()
        }
        
        // Botón 2: Seleccionar Teclado
        val btnSelect = createButton("2️⃣ Seleccionar Teclado", "#03DAC6") {
            openInputMethodPicker()
        }
        
        // Separador
        val separator = View(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                2
            ).apply {
                setMargins(0, 40, 0, 40)
            }
            setBackgroundColor(Color.parseColor("#333333"))
        }
        
        // Botón Configuración
        val btnSettings = createButton("⚙️ Configuración", "#333333") {
            // TODO: Abrir settings
        }
        
        // Botón Temas
        val btnThemes = createButton("🎨 Temas", "#333333") {
            // TODO: Abrir temas
        }
        
        // Info
        val info = TextView(this).apply {
            text = "v1.0.0 - Hecho con ❤️"
            textSize = 12f
            setTextColor(Color.parseColor("#666666"))
            gravity = Gravity.CENTER
            setPadding(0, 60, 0, 0)
        }
        
        // Agregar todo al layout
        mainLayout.addView(title)
        mainLayout.addView(appName)
        mainLayout.addView(subtitle)
        mainLayout.addView(btnEnable)
        mainLayout.addView(btnSelect)
        mainLayout.addView(separator)
        mainLayout.addView(btnSettings)
        mainLayout.addView(btnThemes)
        mainLayout.addView(info)
        
        setContentView(mainLayout)
    }
    
    private fun createButton(text: String, color: String, onClick: () -> Unit): Button {
        return Button(this).apply {
            this.text = text
            textSize = 18f
            setTextColor(Color.WHITE)
            setBackgroundColor(Color.parseColor(color))
            isAllCaps = false
            setPadding(40, 30, 40, 30)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 0, 0, 16)
            }
            setOnClickListener { onClick() }
        }
    }
    
    private fun openKeyboardSettings() {
        startActivity(Intent(Settings.ACTION_INPUT_METHOD_SETTINGS))
    }
    
    private fun openInputMethodPicker() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager
        imm.showInputMethodPicker()
    }
}
