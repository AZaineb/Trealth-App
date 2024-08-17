package com.example.trealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetailsActivity extends AppCompatActivity {
    private final String[] package_details={
            "Blood Pressure Test\n" + "Cholesterol Test\n" + "Blood Sugar Test\n" + "Body Mass Index (BMI)\n" +
                    "Urinalysis\n" + "Thyroid Function Tests\n" + "Chest X-Ray\n" + "Lung Function Tests\n" +
                    "Pap Test\n" + "Mammogram\n" + "Colonoscopy\n" + "Bone Density Test\n" + "Skin Exam",
            "Fasting Plasma Glucose (FPG)\n" + "Random Plasma Glucose (RPG)\n" + "Postprandial Blood Sugar(PPBS)\n"
                    + "HbA1C Test\n" + "Oral glucose tolerance(OGTT)",
            "Covid-19 Antibody-IgG",
            "T4\n" + "TPO antibodies\n" + "Thyroid scan\n" + "Thyroid-stimulating hormone\n" + "T3 tests",
            "Anti HBs test\n" + "Acetylcholine receptor antibodies\n" + "Vitamin D" + "Igg immunity blood test profile 1" +
                    "Antinuclear antibody\n" + "Complete blood count\n" + "Iron Studies"
    };


    TextView tv,price;
    Button back,add;
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tv = findViewById(R.id.textViewCartPackageName);
        price = findViewById(R.id.textViewLDCost);
        ed = findViewById(R.id.editTextLDMultiLines);
        back = findViewById(R.id.buttonCartBack);
        add = findViewById(R.id.buttonCheckout);

        // Get data from intent
        Intent intent = getIntent();
        String itemName = intent.getStringExtra("Package");
        String itemPrice = intent.getStringExtra("itemPrice");
        //String itemShortText = intent.getStringExtra("itemShortText");

        // Set data to views
        tv.setText(itemName);
        price.setText(itemPrice);


        //ed.setText(itemShortText);


        // Example of changing views based on item clicked

        if (itemName != null) {
            switch (itemName) {
                case "Package 1 :  Full Body Checkup":
                    // Set specific text for Package 1
                    Intent intent22 = new Intent(this, OrderDetailsActivity.class);
                    intent22.putExtra("Name","Package1");
                    ed.setText(package_details[0]);
                    break;
                case "Package 2 :  Blood Glucose Fasting":
                    // Set specific text for Package 2
                    ed.setText(package_details[1]);
                    break;
                case "Package 3 :  Covid-19":
                    // Set specific text for Package 3
                    ed.setText(package_details[2]);
                    break;
                case "Package 4 :  Immunity Check":
                    // Set specific text for Package 4
                    ed.setText(package_details[3]);
                    break;
                default:
                    // Set a default text if the item name doesn't match any of the predefined cases
                    ed.setText("Default short paragraph for unknown package");
                    break;
            }
        }


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class));
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LabTestDetailsActivity.this, "Package recorded in your account", Toast.LENGTH_SHORT).show();
            }
        });


    }
}