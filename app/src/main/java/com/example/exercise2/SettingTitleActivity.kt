package com.example.exercise2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_setting_title.*


class SettingTitleActivity : AppCompatActivity() {

    private var colorPosition = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_title)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val bundle = intent.extras
        val text = bundle?.getString(TITLE, "")
        val colorIndex = bundle?.getInt(COLOR_INDEX, 0)
        edt.setText(text)
        viewSample!!.setBackgroundColor(ContextCompat.getColor(this, Utils.generateColorIdFromIndex(colorIndex ?: 0)))
        title = "Title"
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }

    fun onClickColor1(view: View) {
        //pink
        colorPosition = 0
        viewSample!!.setBackgroundColor(ContextCompat.getColor(this, R.color.pink))
    }

    fun onClickColor2(view: View) {
        //purple
        colorPosition = 1
        viewSample!!.setBackgroundColor(ContextCompat.getColor(this, R.color.purple))
    }

    fun onClickColor3(view: View) {
        //indigo
        colorPosition = 2
        viewSample!!.setBackgroundColor(ContextCompat.getColor(this, R.color.indigo))
    }

    fun onClickColor4(view: View) {
        //blue
        colorPosition = 3
        viewSample!!.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
    }

    fun onClickColor5(view: View) {
        //teal
        colorPosition = 4
        viewSample!!.setBackgroundColor(ContextCompat.getColor(this, R.color.teal))
    }

    fun onClickColor6(view: View) {
        //green
        colorPosition = 5
        viewSample!!.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
    }

    fun onBackClick(view: View) {
        val text = edt!!.text.toString()
        val i = Intent()
        i.putExtra("color_id", colorPosition)
        i.putExtra("title", text)
        setResult(Activity.RESULT_OK, i)
        finish()
    }


}
