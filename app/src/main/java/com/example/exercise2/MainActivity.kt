package com.example.exercise2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //todo #1 click nút edt title  ra màn hình SettingTitleActivity

        //todo #2 click nút edit background nhảy ra màn hình EditBackgroundActivity

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_EDT_BG) {
            //todo get data
        } else if (requestCode == REQUEST_EDT_TITLE) {
            //todo #3 nhận dữ liệu trả về từ EditSettingActivity

        }
    }



    private fun handleDataOfTitle(positionColor: Int?, title: String?) {
        when (positionColor) {
            0 -> tvTitle!!.setTextColor(ContextCompat.getColor(this, R.color.pink))
            1 -> tvTitle!!.setTextColor(ContextCompat.getColor(this, R.color.purple))
            2 -> tvTitle!!.setTextColor(ContextCompat.getColor(this, R.color.indigo))
            3 -> tvTitle!!.setTextColor(ContextCompat.getColor(this, R.color.blue))
            4 -> tvTitle!!.setTextColor(ContextCompat.getColor(this, R.color.teal))
            5 -> tvTitle!!.setTextColor(ContextCompat.getColor(this, R.color.green))
        }
        tvTitle!!.text = title
    }

    companion object {
        private val REQUEST_EDT_TITLE = 1
        private val REQUEST_EDT_BG = 2
    }
}
