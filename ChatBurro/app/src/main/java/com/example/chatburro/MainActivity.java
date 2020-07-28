package com.example.chatburro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static com.example.chatburro.MainActivity2.messagesReply;

public class MainActivity extends AppCompatActivity {

  public static final String EXTRA_MESSAGE = "id_extra_message";
  public static final int TEXT_REQUEST = 5454;
  public static ArrayList<String> messagesSend = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final TextView mTextView2 = findViewById(R.id.textView2);
    final EditText mEditText = findViewById(R.id.editText);
    final Button mButtonSend = findViewById(R.id.buttonSend);

    mButtonSend.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);

            messagesSend.add(mEditText.getText().toString());
            intent.putExtra(EXTRA_MESSAGE, messagesSend);
            startActivityForResult(intent, TEXT_REQUEST);
          }
        });

//    Intent intent = getIntent();

    try {
      List<String> messagesReceived = messagesReply;
//          Objects.requireNonNull(intent.getStringArrayListExtra(MainActivity2.EXTRA_MESSAGE2));
      Iterator<String> allMessages = messagesReceived.iterator();
      StringBuilder concatenatedMessages = new StringBuilder();

      while (allMessages.hasNext()) {
        concatenatedMessages.append(allMessages.next());
        if (allMessages.hasNext()) {
          concatenatedMessages.append("\n");
        }
      }

      mTextView2.setText(concatenatedMessages.toString());
    } catch (Exception ignored) {}
  }
}
