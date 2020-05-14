package com.asysyifazahrasalsabila.pat_emergencycall

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    lateinit var detail: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name = intent.getStringExtra("name")
        detail = intent.getStringExtra("detail")
        val photo = intent.getIntExtra("photo", 0)

        val txtName: TextView = findViewById(R.id.detailNama)
        val txtDetail: TextView = findViewById(R.id.detailIsi)
        val imgPhoto: ImageView = findViewById(R.id.detailPhoto)

        txtName.text = name
        txtDetail.text = detail
        Glide.with(this).load(photo).into(imgPhoto)

        btnTelp.setOnClickListener {
            if (Build.VERSION.SDK_INT < 23) {
                phoneCall()
            } else {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    phoneCall()
                } else {
                    val PERMISSIONS_STORAGE = arrayOf<String> (Manifest.permission.CALL_PHONE)

                    // request permissions
                    ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, 9)
                }
            }
        }

        fun onRequestPermissionsResult(
            requestCode: Int, 
            permissions: Array<out String>,
            grantResults: IntArray
        ) {
            var permissionGranted = false
            when (requestCode) {
                9 -> permissionGranted = grantResults[0] == PackageManager.PERMISSION_GRANTED
            }

            if (permissionGranted) {
                phoneCall()
            } else {
                Toast.makeText(this, "You don't assign permission", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun phoneCall() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel: " + detail)
            this.startActivity(callIntent)
        } else {
            Toast.makeText(this, "You don't assign permission", Toast.LENGTH_SHORT).show()
        }
    }

}
