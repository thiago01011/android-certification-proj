package com.example.toastapp_java;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "ToastAppMain";

    private int lastToastEnabledType;
    private int[] position = new int[2];

    private Button buttonUp;
    private Button buttonDown;
    private Button buttonLeft;
    private Button buttonRight;

    private Button fireSimpleToast;
    private Button fireCustomToast;

    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recovering buttons references
        buttonUp = findViewById(R.id.button_up);
        buttonUp.setOnClickListener(this);

        buttonDown = findViewById(R.id.button_down);
        buttonDown.setOnClickListener(this);

        buttonLeft = findViewById(R.id.button_left);
        buttonLeft.setOnClickListener(this);

        buttonRight = findViewById(R.id.button_right);
        buttonRight.setOnClickListener(this);

        fireSimpleToast = findViewById(R.id.button_simple_toast);
        fireSimpleToast.setOnClickListener(this);

        fireCustomToast = findViewById(R.id.button_custom_toast);
        fireCustomToast.setOnClickListener(this);
    }

    // There are two common ways of listening to a click:
    // 1. Create a method and add it in xml or
    // 2. Implement onClick passing this as parameter.
   @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button_simple_toast:
                enableButtons();
                placeToast(R.id.button_simple_toast);
                break;
            case R.id.button_custom_toast:
                enableButtons();
                placeToast(R.id.button_custom_toast);
                break;
            case R.id.button_up:
                position[1] -= 150;
                placeToast(R.id.button_up);
                break;
            case R.id.button_down:
                position[1] += 150;
                placeToast(R.id.button_down);
                break;
            case R.id.button_left:
                position[0] -= 150;
                placeToast(R.id.button_left);
                break;
            case R.id.button_right:
                position[0] += 150;
                placeToast(R.id.button_right);
                break;
        }
    }

    public void enableButtons() {
        if (!buttonUp.isEnabled()) {
            buttonUp.setEnabled(true);
            buttonDown.setEnabled(true);
            buttonLeft.setEnabled(true);
            buttonRight.setEnabled(true);
        }
    }

    private void resetToastPosition() {
        position[0] = 0;
        position[1] = 800;
    }

    private void placeToast(int id) {
        if (id == R.id.button_simple_toast) {
            toast = Toast.makeText(getApplicationContext(), "Simple toast!", Toast.LENGTH_SHORT);
            resetToastPosition();
        } else if (id == R.id.button_custom_toast) {
            toast = new Toast(getApplicationContext());
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));
            toast.setView(layout);
            toast.setDuration(Toast.LENGTH_SHORT);
            resetToastPosition();
        }

        if (!(id == R.id.button_simple_toast || id == R.id.button_custom_toast)) {
            toast.setGravity(Gravity.NO_GRAVITY, position[0], position[1]);
        }
        toast.show();
    }
}
