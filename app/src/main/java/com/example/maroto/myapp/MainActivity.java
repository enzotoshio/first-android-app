package com.example.maroto.myapp;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(context, R.layout.activity_main, null);
        setContentView(view);
        setNationalityDropdown();
        setReserveButton(view);
    }

    public void setNationalityDropdown() {
        Spinner dropdown = (Spinner) findViewById(R.id.nationalityInput);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.nationality_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new SpinnerActivity());
    }

    public void setReserveButton(final View view){
        Button reserveButton = (Button) findViewById(R.id.reserveButton);
        //final View mainView = this.getWindow().getDecorView();
        reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog popup = new Popup().create(context, view);

                popup.show();
            }
        });
    }
}
