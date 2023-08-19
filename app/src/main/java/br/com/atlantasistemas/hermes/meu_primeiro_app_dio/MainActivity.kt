package br.com.atlantasistemas.hermes.meu_primeiro_app_dio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val handler = Handler(Looper.getMainLooper())
    private var currentIndex = 0
    private val stringIds = listOf(R.string.apresentacao, R.string.ingles, R.string.espanhol)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateString()
    }

    private fun updateString() {
        val nextStringId = stringIds[currentIndex]
        val nextString = resources.getString(nextStringId)

        val textView = findViewById<TextView>(R.id.text_view)
        textView.text = nextString

        currentIndex = (currentIndex + 1) % stringIds.size

        handler.postDelayed({ updateString() }, 5000)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }

}