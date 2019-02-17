package com.comp1601.tipntax;


<<<<<<< HEAD
import android.content.Intent;
import android.graphics.Color;
=======
>>>>>>> aa55875eec292fb00e2e95f548cb2fd42213c325
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

<<<<<<< HEAD
    private EditText nameInput;
    private Button mEnterNameButton;
=======
//    private static final Object View = ;
    //    private EditText mFoodAmount;
//    private EditText mTipAmount;
//    private EditText mTaxAmount;
//    private Button mSendEmailButton;
    private Button mEnterNameButton;
//    private TextView mAmount;


>>>>>>> aa55875eec292fb00e2e95f548cb2fd42213c325

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        mEnterNameButton = findViewById(R.id.enter_button);
        nameInput = findViewById(R.id.name_prompt);

        mEnterNameButton.setOnClickListener(v -> {

            if(!nameInput.getText().toString().equals("")){
                Intent i = new Intent(MainActivity.this, OptionMenu.class);
                i.putExtra("un", nameInput.getText().toString());
                startActivity(i);
            }else{
                nameInput.setHint("Please input your name");
                nameInput.setHintTextColor(Color.RED);
            }
        });
=======
       
        //

        // Edit Texts
//        mHomeSubmitButton = findViewById();
//
// Buttons
        mEnterNameButton =findViewById(R.id.enter_button);
//
//        TipNTaxCalculator calculator = new TipNTaxCalculator();


//        mEnterNameButton.setOnClickListener(v -> {
//            //Handle the calculate button click
//            // creates a naew instance of the TipNTaxCalculator CLASS
//            /** Called when the user taps the Send button */
//            public void sendMessage(View view) {
//                // Do something in response to button
//
//            }
//
//
//        });
//
//
>>>>>>> aa55875eec292fb00e2e95f548cb2fd42213c325





    }
}