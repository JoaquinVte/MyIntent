package com.jovialsa.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private ImageButton mImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.nombreEditText);
        mImageButton = (ImageButton) findViewById(R.id.entrarButton);

        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mNombre = mEditText.getText().toString();

                if(mNombre.isEmpty()){
                    mEditText.setError("Introduce tu nombre");
                }else{
                    Log.i(this.getClass().toString(),mNombre);
                    Intent mandarDatos = new Intent(MainActivity.this,HubActivity.class);
                    mandarDatos.putExtra("nombre",mNombre);
                    startActivity(mandarDatos);
                    finish();
                }
            }
        });
    }
}
