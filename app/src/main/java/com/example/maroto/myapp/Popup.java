package com.example.maroto.myapp;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Popup {
    public Dialog create(Context context, View mainView) {
        final Dialog popup = new Dialog(context);
        popup.setContentView(R.layout.activity_dialog);
        popup.setTitle("Confirmation");

        TextView nameText = (TextView) popup.findViewById(R.id.nameText);
        TextView ageText = (TextView) popup.findViewById(R.id.ageText);
        TextView nationalityText = (TextView) popup.findViewById(R.id.nationalityText);
        EditText nameInput = (EditText) mainView.findViewById(R.id.nameInput);
        EditText ageInput = (EditText) mainView.findViewById(R.id.ageInput);
        Spinner nationalityInput = (Spinner) mainView.findViewById(R.id.nationalityInput);
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

        nameText.setText(nameInput.getText());
        ageText.setText(ageInput.getText());
        nationalityText.setText(nationalityInput.getSelectedItem().toString());

        popup.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        return popup;
    }
}
