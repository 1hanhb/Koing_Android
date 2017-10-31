package com.tourwith.koing.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.tourwith.koing.R;

/**
 * Created by MSI on 2017-10-31.
 */

public class TourInfoFilterActivity extends AppCompatActivity {
    private Intent intent;
    private String area;
    private String tourType;
    private Button tourInfoFilterButton;
    private Spinner tourInfoFilterAreaSpinner;
    private Spinner tourInfoFilterTypeSpinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_info_filter);

        getSupportActionBar().hide();

        intent = new Intent();

        tourInfoFilterButton = (Button)findViewById(R.id.tour_info_filter_button);
        tourInfoFilterAreaSpinner = (Spinner)findViewById(R.id.tour_info_filter_area_spinner);
        tourInfoFilterTypeSpinner = (Spinner)findViewById(R.id.tour_info_filter_type_spinner);

        tourInfoFilterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("area",area);
                intent.putExtra("tourType",tourType);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        tourInfoFilterAreaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                area = parent.getItemAtPosition(position)+"";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        tourInfoFilterTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tourType = parent.getItemAtPosition(position)+"";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
