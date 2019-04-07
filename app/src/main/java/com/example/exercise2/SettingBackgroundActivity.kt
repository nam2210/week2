package com.example.exercise2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_setting_background.*
import kotlinx.android.synthetic.main.activity_setting_title.*


class SettingBackgroundActivity : AppCompatActivity() {
    val TAG : String = SettingBackgroundActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_background)
    }

    var drawablId = R.drawable.angular
    fun onClick1(v : View){
        Log.e(TAG, "click abc")
        Picasso.get().load(R.drawable.angular).into(iv_viewSample)
        drawablId = R.drawable.angular
    }

    fun onClick2(v : View){
        Log.e(TAG, "click abc")
        Picasso.get().load(R.drawable.flutter).into(iv_viewSample)
        drawablId = R.drawable.flutter
    }

    fun onClick3(v : View){
        Log.e(TAG, "click abc")
        Picasso.get().load(R.drawable.golang).into(iv_viewSample)
        drawablId = R.drawable.golang
    }

    fun onClick4(v : View){
        Log.e(TAG, "click abc")
        Picasso.get().load(R.drawable.kotlin).into(iv_viewSample)
        drawablId = R.drawable.kotlin
    }

    fun onClick5(v : View){
        Log.e(TAG, "click abc")
        Picasso.get().load(R.drawable.nodejs).into(iv_viewSample)
        drawablId = R.drawable.nodejs
    }

    fun onClick6(v : View){
        Log.e(TAG, "click abc")
        Picasso.get().load(R.drawable.python).into(iv_viewSample)
        drawablId = R.drawable.python
    }

    fun onBackClick(v : View){
        Log.e(TAG, "click abc")
        var i = Intent()
        i.putExtra(DRAWABALE_ID, drawablId)
        setResult(Activity.RESULT_OK, i)
        finish()

    }
}
