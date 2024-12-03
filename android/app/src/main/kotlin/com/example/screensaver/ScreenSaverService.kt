package com.example.screensaver

import android.net.Uri
import android.service.dreams.DreamService
import android.widget.FrameLayout
import android.widget.VideoView

class ScreenSaverService : DreamService() {
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        isInteractive = false  // Disable touch interaction
        isFullscreen = true    // Enable full-screen mode

        // Create a FrameLayout to hold the VideoView
        val layout = FrameLayout(this)
        val videoView = CustomVideoView(this)

        // Set video URI and looping
        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.screensaver_video))
        videoView.setOnCompletionListener {
            videoView.start() // Loop the video
        }

        // Add VideoView to layout and set it as content view
        layout.addView(videoView)
        setContentView(layout)

        videoView.start()
    }

    // Custom VideoView to adjust scaling
    class CustomVideoView(context: android.content.Context) : VideoView(context) {
        override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
            // Force the video to fit the width and height of the screen (landscape fullscreen)
            val screenWidth = MeasureSpec.getSize(widthMeasureSpec)
            val screenHeight = MeasureSpec.getSize(heightMeasureSpec)
            setMeasuredDimension(screenWidth, screenHeight)
        }
    }
}