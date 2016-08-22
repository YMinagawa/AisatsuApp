package jp.techacademy.yoshihiro.minagawa.aisatsuapp;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int mHour;
    int mMinute;

    TextView mTextView2, mTextView3;
    TimePickerDialog mTimePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);

        mTextView2 = (TextView)findViewById(R.id.textView2);
        mTextView3 = (TextView)findViewById(R.id.textView3);


        Calendar calendar = Calendar.getInstance();
        mHour = calendar.get(Calendar.HOUR_OF_DAY);
        mMinute = calendar.get(Calendar.MINUTE);

        showTimePickerDialog();

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button1){
            showTimePickerDialog();
        }else if(v.getId()==R.id.button2){
            setAisatsu();
        }
    }

    private void showTimePickerDialog(){

        //時間設定ダイアログの生成
        mTimePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener(){
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
                        mHour = hourOfDay;
                        mMinute = minute;
                        mTextView2.setText(mHour+"時" + mMinute + "分");
                        Log.d("UI-PARTS", String.valueOf(mHour)+":"+String.valueOf(mMinute));
                    }
                },
                mHour,
                mMinute,
                true);

        //表示
        mTimePickerDialog.show();
    }

    private void setAisatsu(){
        Log.d("setAisatsu", String.valueOf(mHour));
        if(2 <= mHour && mHour < 10){
            mTextView3.setText("おはよう");
        }else if(10 <= mHour && mHour < 18){
            mTextView3.setText("こんにちは");
        }else{
            mTextView3.setText("こんばんは");
        }
    }
}
