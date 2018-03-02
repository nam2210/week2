package com.example.exercise2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class SettingTitleActivity extends AppCompatActivity {


    Unbinder unbinder;

    @BindView(R.id.viewSample)
    View viewPreview;

    @BindView(R.id.edt)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_title);
        unbinder = ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private int colorPosition = -1;

    @OnClick(R.id.iv1)
    public void onClickColor1(View view) {
        //pink
        colorPosition = 0;
        viewPreview.setBackgroundColor(ContextCompat.getColor(this, R.color.pink));
    }

    @OnClick(R.id.iv2)
    public void onClickColor2(View view) {
        //purple
        colorPosition = 1;
        viewPreview.setBackgroundColor(ContextCompat.getColor(this, R.color.purple));
    }

    @OnClick(R.id.iv3)
    public void onClickColor3(View view) {
        //indigo
        colorPosition = 2;
        viewPreview.setBackgroundColor(ContextCompat.getColor(this, R.color.indigo));
    }

    @OnClick(R.id.iv4)
    public void onClickColor4(View view) {
        //blue
        colorPosition = 3;
        viewPreview.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
    }

    @OnClick(R.id.iv5)
    public void onClickColor5(View view) {
        //teal
        colorPosition = 4;
        viewPreview.setBackgroundColor(ContextCompat.getColor(this, R.color.teal));
    }

    @OnClick(R.id.iv6)
    public void onClickColor6(View view) {
        //green
        colorPosition = 5;
        viewPreview.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
    }

    @OnClick(R.id.btnSave)
    public void onClickCOlor7(View view) {
        //todo finish this screen
        String text = editText.getText().toString();
        Intent i = new Intent();
        i.putExtra("color_id", colorPosition);
        i.putExtra("title", text);
        setResult(RESULT_OK, i);
        finish();
    }


}
