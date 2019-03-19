package com.example.exercise2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.EditText

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder

class SettingTitleActivity : AppCompatActivity() {


    private lateinit var unbinder: Unbinder

    @BindView(R.id.viewSample)
    internal var viewPreview: View? = null

    @BindView(R.id.edt)
    internal var editText: EditText? = null

    private var colorPosition = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_title)
        unbinder = ButterKnife.bind(this)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onDestroy() {
        super.onDestroy()
        unbinder.unbind()
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

    @OnClick(R.id.iv1)
    fun onClickColor1(view: View) {
        //pink
        colorPosition = 0
        viewPreview!!.setBackgroundColor(ContextCompat.getColor(this, R.color.pink))
    }

    @OnClick(R.id.iv2)
    fun onClickColor2(view: View) {
        //purple
        colorPosition = 1
        viewPreview!!.setBackgroundColor(ContextCompat.getColor(this, R.color.purple))
    }

    @OnClick(R.id.iv3)
    fun onClickColor3(view: View) {
        //indigo
        colorPosition = 2
        viewPreview!!.setBackgroundColor(ContextCompat.getColor(this, R.color.indigo))
    }

    @OnClick(R.id.iv4)
    fun onClickColor4(view: View) {
        //blue
        colorPosition = 3
        viewPreview!!.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
    }

    @OnClick(R.id.iv5)
    fun onClickColor5(view: View) {
        //teal
        colorPosition = 4
        viewPreview!!.setBackgroundColor(ContextCompat.getColor(this, R.color.teal))
    }

    @OnClick(R.id.iv6)
    fun onClickColor6(view: View) {
        //green
        colorPosition = 5
        viewPreview!!.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
    }

    @OnClick(R.id.btnSave)
    fun onClickCOlor7(view: View) {
        //todo finish this screen
        val text = editText!!.text.toString()
        val i = Intent()
        i.putExtra("color_id", colorPosition)
        i.putExtra("title", text)
        setResult(Activity.RESULT_OK, i)
        finish()
    }


}
