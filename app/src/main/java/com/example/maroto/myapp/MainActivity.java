package com.example.maroto.myapp;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNationalityDropdown();
        setReserveButton();
    }

    public void setNationalityDropdown() {
        Spinner dropdown = (Spinner) findViewById(R.id.nationalityInput);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.nationality_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new SpinnerActivity());
    }

    public void setReserveButton(){
        Button reserveButton = (Button) findViewById(R.id.reserveButton);

        reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog popup = new Dialog(context);
                popup.setContentView(R.layout.activity_dialog);
                popup.setTitle("Confirmation");

                Button confirmButton = (Button) popup.findViewById(R.id.confirmButton);
                Button cancelButton = (Button) popup.findViewById(R.id.cancelButton);

                confirmButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popup.dismiss();
                    }
                });

                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popup.dismiss();
                    }
                });

                popup.show();
            }
        });
    }
}
