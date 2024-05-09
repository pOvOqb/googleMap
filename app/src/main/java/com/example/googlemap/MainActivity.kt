package com.example.googlemap

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import com.example.googlemap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private var mGoogleMap: GoogleMap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragmentt) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {
        mGoogleMap = googleMap // dkfjakl
        // 여기에 지도가 준비되었을 때의 작업을 추가할 수 있습니다.
    }
}

    class MainActivity2 : AppCompatActivity() {
        private  lateinit var  binding : ActivityMainBinding //바인딩을 선언

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater) //활동의 메인 바인딩은 레이아웃 팽창기와 동일
            setContentView(R.layout.activity_main) //바인딩뷰를 콘텐츠뷰로 설정

            fetchCurrencyData().start()
        }

        private fun fetchCurrencyData(): Thread {
            return Thread {
                val url = URL("https://open.er-api.com/v6/latest/aud")
                val connection = url.openConnection() as HttpsURLConnection

                if (connection.responseCode == 200){
                    val inputSystem = connection.inputStream
                    println(inputSystem.toString())
                }
                else {
                    println("Falled Connection")
                }
            }
        }
    }