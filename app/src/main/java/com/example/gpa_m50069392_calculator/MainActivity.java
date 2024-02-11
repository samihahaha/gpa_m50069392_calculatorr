package com.example.gpa_m50069392_calculator;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupGradeCalculator(R.id.course1Input, R.id.course1Button, R.id.course1Output);
        setupGradeCalculator(R.id.course2Input, R.id.course2Button, R.id.course2Output);
        setupGradeCalculator(R.id.course3Input, R.id.course3Button, R.id.course3Output);
        setupGradeCalculator(R.id.course4Input, R.id.course4Button, R.id.course4Output);
        setupGradeCalculator(R.id.course5Input, R.id.course5Button, R.id.course5Output);

        Button clearPageButton = findViewById(R.id.clearPageButton);
        clearPageButton.setOnClickListener(v -> clearPage());
    }

    private void setupGradeCalculator(int editTextId, int buttonId, int outputTextId) {
        EditText inputField = findViewById(editTextId);
        Button calculateButton = findViewById(buttonId);
        TextView outputField = findViewById(outputTextId);

        calculateButton.setOnClickListener(v -> {
            String inputText = inputField.getText().toString();
            if (inputText.isEmpty()) {
                inputField.setError("Input cannot be empty");
                return;
            }

            int score = Integer.parseInt(inputText);
            String grade = calculateGrade(score);
            outputField.setText(grade);

            // Set background color based on score
            if (score < 60) {
                outputField.setBackgroundColor(Color.RED);
            } else if (score <= 79) {
                outputField.setBackgroundColor(Color.YELLOW);
            } else {
                outputField.setBackgroundColor(Color.GREEN);
            }
        });
    }

    private String calculateGrade(int score) {
        if (score >= 93) return "A";
        if (score >= 90) return "A-";
        if (score >= 87) return "B+";
        if (score >= 83) return "B";
        if (score >= 80) return "B-";
        if (score >= 77) return "C+";
        if (score >= 73) return "C";
        if (score >= 70) return "C-";
        if (score >= 67) return "D+";
        if (score >= 63) return "D";
        if (score >= 60) return "D-";
        return "F";
    }

    private void clearPage() {
        int[] inputFields = {R.id.course1Input, R.id.course2Input, R.id.course3Input, R.id.course4Input, R.id.course5Input};
        int[] outputFields = {R.id.course1Output, R.id.course2Output, R.id.course3Output, R.id.course4Output, R.id.course5Output};

        for (int fieldId : inputFields) {
            EditText inputField = findViewById(fieldId);
            inputField.setText("");
        }

        for (int fieldId : outputFields) {
            TextView outputField = findViewById(fieldId);
            outputField.setText("");
            outputField.setBackgroundColor(Color.TRANSPARENT);
        }
    }
}
