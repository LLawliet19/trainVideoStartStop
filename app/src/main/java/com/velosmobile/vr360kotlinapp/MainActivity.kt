package com.velosmobile.vr360kotlinapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.video_ui.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import com.velosmobile.vr360kotlinapp.Constant
import com.velosmobile.vr360kotlinapp.Constant.cities


/**
 * Configures the MonoscopicView and launches 2D 360 video
 */
class MainActivity : AppCompatActivity() {

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cities.put("Qutub Minar Delhi", 5000);
        cities.put("Taj Mahal Agra", 9000);
        cities.put("Hawa Mahal Jaipur Rajasthan", 13000);
        cities.put("Gateway of India Mumbai Maharashtra", 17000);
        cities.put("Murudeshwar Temple Karnataka", 21000);
        cities.put("City Palace Udaipur, Rajasthan", 25000);
        cities.put("Bahai Temple (Lotus Temple), New Delhi", 29000);
        cities.put("Mysore Palace, Mysore Karnataka", 33000);
        cities.put("India Gate Delhi", 37000);
        cities.put("Konark temple Odisha", 41000);
        cities.put("RED Fort Delhi", 45000);
        cities.put("Charminar Hyderabad Telanganaa", 49000);
        cities.put("Golden Temple Amritsar", 53000);
        cities.put("Ajanta elora caves aurangabad", 57000);
        cities.put("Jama Masjid, Delhi", 61000);
        cities.put("Basilica of Bom Jesus", 65000);

        // Configure the MonoscopicView which will render the video and UI.
        videoView.initialize(videoUiView)

        // Remember to place your 360 video file into res/raw/vrsample.mp4
        MainScope().launch {
            videoView.loadMedia(video = R.raw.train, horizontalDegrees = 360f)
        }
    }

    override fun onResume() {
        super.onResume()
        videoView.onResume()
    }

    override fun onPause() {
        // MonoscopicView is a GLSurfaceView so it needs to pause & resume rendering. It's also
        // important to pause MonoscopicView's sensors & the video player.
        videoView.onPause()
        super.onPause()
    }

    /**
     * Remember to do videoView.destroy() in onDestroyView() instead if you are using a fragment.
     */
    override fun onDestroy() {
        videoView.destroy()
        super.onDestroy()
    }
}