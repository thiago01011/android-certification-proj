package com.example.toastapp_java;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Toast toast;
    private int posX, posY;
    private final int SIMPLE_TOAST = 0;
    private final int CUSTOM_TOAST = 1;
    private Button buttonUp;
    private Button buttonDown;
    private Button buttonLeft;
    private Button buttonRight;
    private int lastToastEnabledType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recovering buttons references
        buttonUp = findViewById(R.id.button_up);
        buttonDown = findViewById(R.id.button_down);
        buttonLeft = findViewById(R.id.button_left);
        buttonRight = findViewById(R.id.button_right);

        posX = 0;
        posY = 0;
    }

    public void enableButtons() {
        if (!buttonUp.isEnabled()) {
            buttonUp.setEnabled(true);
            buttonDown.setEnabled(true);
            buttonLeft.setEnabled(true);
            buttonRight.setEnabled(true);
        }
    }

    public void fireToast(View v) {
        enableButtons();
        Toast.makeText(getApplicationContext(), "Simple toast!", Toast.LENGTH_LONG).show();
        lastToastEnabledType = SIMPLE_TOAST;
    }

    public void fireCustomToast(View v) {
        enableButtons();

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));

        toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

        lastToastEnabledType = CUSTOM_TOAST;
    }

    public void moveUp(View v) {
        posY += 10;

        if (lastToastEnabledType == SIMPLE_TOAST) {
            Toast.makeText(getApplicationContext(), "Simple toast!", Toast.LENGTH_LONG).show();
        } else {

        }

        toast.setGravity(Gravity.NO_GRAVITY, posX, posY);
    }

    public void moveDown(View view) {
    }

    public void moveRight(View view) {
    }

    public void moveLeft(View view) {
    }
}
