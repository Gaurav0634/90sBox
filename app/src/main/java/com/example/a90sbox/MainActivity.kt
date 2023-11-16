package com.example.a90sbox


import TitleAdapter
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    data class Item(val title: String, val url: String)
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar?.title = "90sBox"

        val recyclerView = findViewById<RecyclerView>(R.id.RecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = listOf(
            Item(" -> Super Mario Bros", "https://jcw87.github.io/c2-smb1/"),
            Item(" -> MoonLander", "https://asquidboi.github.io/gfiles/moonlander/"),
            Item(" -> MotoX", "https://asquidboi.github.io/gfiles/motox3m/"),
            Item(" -> Riddle School", "https://asquidboi.github.io/gfiles/riddleschool/"),
            Item(" -> Alien Hominid", "https://asquidboi.github.io/gfiles/alienhominid/"),
            Item(" -> Champion Island", "https://asquidboi.github.io/gfiles/champion-island/"),
            Item(" -> Amoung Us", "https://asquidboi.github.io/gfiles/among-us/"),
            Item(" -> Edge Surf", "https://asquidboi.github.io/gfiles/edgesurf/"),
            Item(" -> Elastic Man", "https://asquidboi.github.io/gfiles/elastic-man/"),
            Item(" -> Flappy Bird", "https://asquidboi.github.io/gfiles/flappybird/"),
        )

        val adapter = TitleAdapter(items)
        recyclerView.adapter = adapter

        // Initialize MediaPlayer
        prepareSound()

        adapter.setOnItemClickListener { item: Item ->
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("url", item.url)
            startActivity(intent)

            mediaPlayer?.start()
        }
    }

    private fun prepareSound() {
        mediaPlayer = MediaPlayer.create(this, R.raw.sound)
        mediaPlayer?.setOnCompletionListener {
            // Release the MediaPlayer when sound is completed
            it.release()
            mediaPlayer = null
        }
    }
    override fun onResume() {
        super.onResume()
        prepareSound()
    }


    override fun onDestroy() {
        mediaPlayer?.release()
        mediaPlayer = null
        super.onDestroy()
    }
}
