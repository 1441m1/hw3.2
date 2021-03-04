package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView view ;
    TextView textView;
    Button button;
    Button button2;
    String text ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      view = findViewById(R.id.imageView);
      textView = findViewById(R.id.textView);
      button = findViewById(R.id.button);
      button2 = findViewById(R.id.button2);
      button.setOnClickListener(this);
      button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==button.getId()){
            toSecondActivity();
        }else {
            toGmail();
        }
    }

    private void toGmail() {
        String uriText =
                "mailto:youremail@gmail.com" +
                        "?subject=" + Uri.encode("your subject line here") +
                        "&body=" + Uri.encode(text);

        Uri uri = Uri.parse(uriText);

        Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
        sendIntent.setData(uri);
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(sendIntent, "Send message"));
        }
    }

    private void toSecondActivity() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
             text = data.getStringExtra("text");
            textView.setText(text);
            view.setImageURI(Uri.parse(data.getStringExtra("image")));
        }



    }
}