package com.rameshwor.agronepal.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.rameshwor.agronepal.R;

public class SettingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        spinner= (Spinner) findViewById(R.id.spinner);

        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.languages,android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this,"You have selected"+item,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this,"You have selected nothing.",Toast.LENGTH_SHORT).show();
    }
}
