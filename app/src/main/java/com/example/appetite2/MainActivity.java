package com.example.appetite2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.concurrent.ThreadLocalRandom;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button chooseButton;
    EditText editTextArray[] = new EditText[5];
    String possibleChoices[] = new String[5];
    int randomChoice;
    int choiceSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // populate string with null values
        for (int i = 0; i < 5; i++) {
            possibleChoices[i] = null;
        }

        // spinner stuff
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numbers, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // edittext stuff
        editTextArray[0] = (EditText) findViewById(R.id.editText1);
        editTextArray[1] = (EditText) findViewById(R.id.editText2);
        editTextArray[2] = (EditText) findViewById(R.id.editText3);
        editTextArray[3] = (EditText) findViewById(R.id.editText4);
        editTextArray[4] = (EditText) findViewById(R.id.editText5);
        for (int i = 0; i < 5; i++) {
            editTextArray[i].setVisibility(View.INVISIBLE);
        }


        // choose button
        chooseButton = (Button) findViewById(R.id.button);
        chooseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                // start new activity
                Random r = new Random();
                int randomNum = r.nextInt(choiceSize);
                randomChoice = randomNum;
                pickChoice(randomChoice);
            }
        });
    }

    public void pickChoice (int choice) {

        // pick one of the choices
        String chosenOne = editTextArray[choice].getText().toString();

        if (chosenOne != null) {
            Intent intent = new Intent(this, ChoiceActivity.class);
            intent.putExtra("message", chosenOne);
            startActivity(intent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // on selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // showing selected spinner item
        // chooseButton.setText(item);
        int choiceNum = Integer.parseInt(item);
        for (int i = 0; i < choiceNum; i++) {
            editTextArray[i].setVisibility(View.VISIBLE);
        }
        for (int i = choiceNum; i < 5; i++) {
            editTextArray[i].setVisibility(View.INVISIBLE);
        }

        choiceSize = choiceNum;

        //Random rand = null;
        //int randomNum = rand.nextInt(choiceNum);
        //int randomNum = choiceNum-1;
        //randomChoice = randomNum;

        /*
        Random r = new Random();
        int randomNum = r.nextInt(choiceNum);
        randomChoice = randomNum;
        */

    }
    public void onNothingSelected(AdapterView<?> arg0) {

    }

}