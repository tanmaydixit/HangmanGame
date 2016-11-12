package com.tman.tanmay.hangman2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myButton = (Button) findViewById(R.id.mybutton);
        //Object systemService = Context.getSystemService(Context.AUDIO_SERVICE);

        final EditText input=(EditText) findViewById(R.id.input);
        ImageView image = (ImageView) findViewById(R.id.image);
        image.setImageResource(R.drawable.hangman);
        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Second.class);
                //String myName = "Tanmay";
                //myIntent.putExtra("Name","Tanmay");
                String word = input.getText().toString();
                word=word.toLowerCase();
                //word=word.replaceAll("\\s+","");
                myIntent.putExtra("Age", word);

                String cword="";
                char[] arr=word.toCharArray();
                for(int i = 0; i < word.length(); i++)
                {
                    if(arr[i]!='i' && arr[i]!='e' && arr[i]!='a' && arr[i]!='u' && arr[i]!='o' && arr[i]!=' ')
                    {
                        arr[i]='-';
                    }
                }
                for(int i = 0; i<word.length(); i++)
                {
                    cword = cword + arr[i];
                }
                //cword=cword.toLowerCase();

                myIntent.putExtra("Name",cword);
                Toast.makeText(MainActivity.this,"give the phone to player 2",Toast.LENGTH_LONG).show();
                startActivity(myIntent);
            }
        };

        myButton.setOnClickListener(myListener);
    }
}