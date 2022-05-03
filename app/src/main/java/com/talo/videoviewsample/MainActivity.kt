package com.talo.videoviewsample

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import com.talo.videoviewsample.R.*
import com.talo.videoviewsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mediaController: MediaController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        video()
    }
    private fun video(){
        if (mediaController == null){
            mediaController = MediaController(this)
            mediaController!!.setAnchorView(this.binding.videoView)
        }
        binding.videoView.setMediaController(mediaController)
        binding.videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + raw.sample))
        binding.videoView.requestFocus()
        binding.videoView.start()
        binding.videoView.setOnCompletionListener {
            Toast.makeText(applicationContext, "Video End", Toast.LENGTH_SHORT).show()
        }
        binding.videoView.setOnErrorListener { _, _, _ ->
            Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
            false
        }

    }
}