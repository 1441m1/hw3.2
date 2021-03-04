package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
        ImageView view ;
        EditText textEdit;
        Button button;
        String uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        view = findViewById(R.id.imageView);
        textEdit = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button3);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String text = String.valueOf(textEdit.getText());
        Intent intent =  new Intent();
        intent.putExtra("text",text);
        intent.putExtra("image", uri);
        setResult(1,intent);
        finish();
    }
    public void getphoto (View view){
        Intent intent = new Intent(Intent.ACTION_PICK );
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode==RESULT_OK && data != null){
            uri = data.getData().toString();
        }
    }
}