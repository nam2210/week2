package com.example.exercise2;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.ivBg)
    ImageView ibBg;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        Button btnExample = (Button) findViewById(R.id.btnSave);
        btnExample.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private static final int REQUEST_EDT_TITLE = 1;
    private static final int REQUEST_EDT_BG = 2;

    @OnClick(R.id.btn_edit_bg)
    public void onChangeBackgroundClick(View view){

        Intent i = new Intent(this, SettingBackgroundActivity.class);
        i.putExtra("key_string", "value_string");
        i.putExtra("key_int", 1);
        i.putExtra("key_boolean", true);
        startActivity(i);


        Bundle data = getIntent().getExtras();
        if (data != null) {
            String stringValue = data.getString("key_string");
            int intValue = data.getInt("key_int");
            boolean boolValue = data.getBoolean("key_boolean");
        }



    }

    @OnClick(R.id.btn_edit_title)
    public void onChangeTitleClick(View view){
        Intent i = new Intent(this, SettingTitleActivity.class);
        startActivityForResult(i, REQUEST_EDT_TITLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_EDT_BG){
            //todo get data
        } else if (requestCode == REQUEST_EDT_TITLE){
            if (resultCode == RESULT_OK){
                int positionColor = data.getIntExtra("color_id", -1);
                String title = data.getStringExtra("title");
                handleDataOfTitle(positionColor, title);
            }
        }
    }

    private void handleDataOfTitle(int positionColor, String title){
        switch (positionColor){
            case 0:
                tvTitle.setTextColor(ContextCompat.getColor(this, R.color.pink));
                break;
            case 1:
                tvTitle.setTextColor(ContextCompat.getColor(this, R.color.purple));
                break;
            case 2:
                tvTitle.setTextColor(ContextCompat.getColor(this, R.color.indigo));
                break;
            case 3:
                tvTitle.setTextColor(ContextCompat.getColor(this, R.color.blue));
                break;
            case 4:
                tvTitle.setTextColor(ContextCompat.getColor(this, R.color.teal));
                break;
            case 5:
                tvTitle.setTextColor(ContextCompat.getColor(this, R.color.green));
                break;
        }
        tvTitle.setText(title);
    }
}
