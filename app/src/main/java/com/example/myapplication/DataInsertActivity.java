package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityDataInsertBinding;

public class DataInsertActivity extends AppCompatActivity {
    ActivityDataInsertBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Add Note");
        String type = getIntent().getStringExtra("type");
        if (type.equals("update")) {
            setTitle("Update Note");
            binding.title.setText(getIntent().getStringExtra("title"));
            binding.disp.setText(getIntent().getStringExtra("disp"));
            int id=getIntent().getIntExtra("id",0);
            binding.add.setText("Update Note");
            binding.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("title", binding.title.getText().toString());
                    intent.putExtra("disp", binding.disp.getText().toString());
                    intent.putExtra("id",id);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });

        }
        else {
            binding.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("title", binding.title.getText().toString());
                    intent.putExtra("disp", binding.disp.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DataInsertActivity.this, MainActivity.class));
    }
}