package com.example.exercise2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var drawableId = R.drawable.angular

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_edit_bg.setOnClickListener {
            val i = Intent(this, SettingBackgroundActivity::class.java)
            startActivityForResult(i, REQUEST_EDT_BG)
        }

        btn_edit_title.setOnClickListener {
            val i = Intent(this, SettingTitleActivity::class.java)
            startActivityForResult(i, REQUEST_EDT_TITLE)
        }

        Picasso.get().load(drawableId).into(ivBg)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_EDT_BG) {
            if (resultCode == Activity.RESULT_OK){
                val drawableId = data?.getIntExtra(DRAWABALE_ID, R.drawable.angular)
                Picasso.get().load(drawableId!!).into(ivBg)
            }
        } else if (requestCode == REQUEST_EDT_TITLE) {
            if (resultCode == Activity.RESULT_OK) {
                val positionColor = data?.getIntExtra(COLOR_ID, -1)
                val title = data?.getStringExtra(TITLE)
                handleDataOfTitle(positionColor, title)
            }
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
