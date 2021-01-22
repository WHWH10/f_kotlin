package com.example.myapplication.안드로이드_Essential

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityPermissionBinding

class PermissionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPermissionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPermissionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.ask.setOnClickListener {
            val cameraPermission = ContextCompat.checkSelfPermission(
                this@PermissionActivity,
                android.Manifest.permission.CAMERA
            )

            if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
                // 권한이 없는 경우
                ActivityCompat.requestPermissions(
                    this@PermissionActivity,
                    arrayOf(android.Manifest.permission.CAMERA),
                    1000
                )
            } else {
                // 권한이 있는 경우
                Log.d("Permission", "Camera Permission True")
            }

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 1000) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 승낙
                Log.d("Permission", "허용 & 코드 받음 :: $requestCode")
            } else {
                // 거절
                Log.d("Permission", "거절 & 코드 :: $requestCode")
            }
        }
    }
}