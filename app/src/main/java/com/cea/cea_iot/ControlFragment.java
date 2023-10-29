package com.cea.cea_iot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ControlFragment extends AppCompatActivity {
    CardView card_temp, card_humd, card_light, card_soil;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_fragment);

        card_temp = findViewById(R.id.card_air_temp);
        card_humd =findViewById(R.id.card_humdity);
        card_light = findViewById(R.id.cardlight);
        card_soil = findViewById(R.id.card_soil_moisture);

        dialog = new Dialog(getApplicationContext());

        card_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogTemp();
            }
        });

        card_humd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogHumdity();
            }
        });

        card_light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogLight();
            }
        });

        card_soil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogSoil();
            }
        });

    }

    private void openDialogTemp() {
        dialog.setContentView(R.layout.temp_layout_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewClose = dialog.findViewById(R.id.imageViewClose);

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
    private void openDialogLight() {
        dialog.setContentView(R.layout.light_layout_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewClose = dialog.findViewById(R.id.imageViewClose);

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void openDialogHumdity() {
        dialog.setContentView(R.layout.humidity_layout_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewClose = dialog.findViewById(R.id.imageViewClose);

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void openDialogSoil() {
        dialog.setContentView(R.layout.soil_layout_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewClose = dialog.findViewById(R.id.imageViewClose);

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
