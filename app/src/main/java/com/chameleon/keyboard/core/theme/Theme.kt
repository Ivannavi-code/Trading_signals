package com.chameleon.keyboard.core.theme

sealed class Theme {
    abstract val name: String
    abstract val primaryColor: Int
    abstract val secondaryColor: Int
    abstract val textColor: Int
    abstract val backgroundColor: Int
    abstract val gradient: IntArray

    object Default : Theme() {
        override val name = "Default"
        override val primaryColor = 0xFF6200EE.toInt()
        override val secondaryColor = 0xFF3700B3.toInt()
        override val textColor = 0xFFFFFFFF.toInt()
        override val backgroundColor = 0xFF121212.toInt()
        override val gradient = intArrayOf(0xFF6200EE.toInt(), 0xFF3700B3.toInt())
    }

    object WhatsApp : Theme() {
        override val name = "WhatsApp"
        override val primaryColor = 0xFF25D366.toInt()
        override val secondaryColor = 0xFF128C7E.toInt()
        override val textColor = 0xFFFFFFFF.toInt()
        override val backgroundColor = 0xFF075E54.toInt()
        override val gradient = intArrayOf(0xFF25D366.toInt(), 0xFF128C7E.toInt())
    }

    object Instagram : Theme() {
        override val name = "Instagram"
        override val primaryColor = 0xFFE4405F.toInt()
        override val secondaryColor = 0xFFC13584.toInt()
        override val textColor = 0xFFFFFFFF.toInt()
        override val backgroundColor = 0xFF000000.toInt()
        override val gradient = intArrayOf(
            0xFFF58529.toInt(),
            0xFFDD2A7B.toInt(),
            0xFF8134AF.toInt(),
            0xFF515BD4.toInt()
        )
    }

    object Twitter : Theme() {
        override val name = "Twitter"
        override val primaryColor = 0xFF1DA1F2.toInt()
        override val secondaryColor = 0xFF14171A.toInt()
        override val textColor = 0xFFFFFFFF.toInt()
        override val backgroundColor = 0xFF14171A.toInt()
        override val gradient = intArrayOf(0xFF1DA1F2.toInt(), 0xFF14171A.toInt())
    }

    object YouTube : Theme() {
        override val name = "YouTube"
        override val primaryColor = 0xFFFF0000.toInt()
        override val secondaryColor = 0xFF282828.toInt()
        override val textColor = 0xFFFFFFFF.toInt()
        override val backgroundColor = 0xFF0F0F0F.toInt()
        override val gradient = intArrayOf(0xFFFF0000.toInt(), 0xFF282828.toInt())
    }

    object Gaming : Theme() {
        override val name = "Gaming"
        override val primaryColor = 0xFF00FF00.toInt()
        override val secondaryColor = 0xFFFF00FF.toInt()
        override val textColor = 0xFFFFFFFF.toInt()
        override val backgroundColor = 0xFF000000.toInt()
        override val gradient = intArrayOf(
            0xFF8B00FF.toInt(),
            0xFFFF1493.toInt(),
            0xFFFF0000.toInt()
        )
    }
}
