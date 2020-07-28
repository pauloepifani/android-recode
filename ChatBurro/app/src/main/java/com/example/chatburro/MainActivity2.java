package com.example.chatburro;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static com.example.chatburro.MainActivity.messagesSend;

public class MainActivity2 extends AppCompatActivity {

  public static final String EXTRA_MESSAGE2 = "id_extra_message2";
  public static final int TEXT_REQUEST = 1234;
  public static ArrayList<String> messagesReply = new ArrayList<>();

  @RequiresApi(api = Build.VERSION_CODES.N)
  @Override
  protected void onCreate(Bundle savedInstanceState) {

    Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);

    ConstraintLayout layout = findViewById(R.id.layout);
    final TextView mTextView4 = findViewById(R.id.textView4);
    final EditText mEditText = findViewById(R.id.editText2);
    final Button mButtonReply = findViewById(R.id.buttonReply);

    mButtonReply.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);

            messagesReply.add(mEditText.getText().toString());
            intent.putExtra(EXTRA_MESSAGE2, messagesReply);
            startActivityForResult(intent, TEXT_REQUEST);
          }
        });

//    Intent intent = getIntent();
    List<String> messagesReceived = messagesSend;
//        Objects.requireNonNull(intent.getStringArrayListExtra(MainActivity.EXTRA_MESSAGE));

    for (String message : messagesReceived) {
      TextView textViewTest = new TextView(this);
      textViewTest.setBackgroundColor(0xFF70FDA9);
      textViewTest.setTextSize(20);
      textViewTest.setText(message);
      layout.addView(textViewTest);
    }

  }

  @Override
  public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }
}
