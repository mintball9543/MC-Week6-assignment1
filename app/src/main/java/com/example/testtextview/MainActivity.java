package com.example.testtextview;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    SeekBar seekBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = (DatePicker) findViewById(R.id.datepicker);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        textView = (TextView) findViewById(R.id.tv);

        //초기 progress bar설정
        Calendar calendar = Calendar.getInstance();
        calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        seekBar.setMax(maxDay);
        seekBar.setProgress(datePicker.getDayOfMonth());
        textView.setText(String.format("Seekbar progress: %d / %d", seekBar.getProgress(), seekBar.getMax()));

        //datepicker의 날짜가 변경될 때
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(year, monthOfYear, dayOfMonth);
                int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                seekBar.setMax(maxDay);
                seekBar.setProgress(dayOfMonth);
            }
        });

        //seekbar가 변경될 때
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText(String.format("Seekbar progress: %d / %d", progress, seekBar.getMax()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}