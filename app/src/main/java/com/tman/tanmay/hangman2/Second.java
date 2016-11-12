package com.tman.tanmay.hangman2;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
public class Second extends AppCompatActivity {

    //ImageButton imageButton;
    MediaPlayer mp;
    int fact;
    //setContentView(R.layout.activity_main);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player2);
        TextView textView = (TextView) findViewById(R.id.input1);
        String word1 = getIntent().getStringExtra("Age");
        String cword1= getIntent().getStringExtra("Name");
        //imageButton.setEnabled(true);

        final TextView hang=(TextView) findViewById(R.id.hang);
        final TextView cword=(TextView) findViewById(R.id.word);
        final ImageButton imageButton=(ImageButton)findViewById(R.id.imageButton1);

        final EditText input1=(EditText) findViewById(R.id.input1);


        fact=0;
         /*
         final String word1="captain america";
          final String word2="inception";
          final String cword1="_a__ai_ a_e_i_a";
          final String cword2="i__e__io_";
          */

        final Calculator obj=new Calculator(word1,cword1);
        //final Calculator obj2=new Calculator(word2,cword2);


        obj.setTextView(cword);
        //int t = obj.foo();

        obj.setTextView2(hang);




        Toast.makeText(Second.this,"player 2 press enter & start guessing ",Toast.LENGTH_LONG).show();
        Button enter=(Button) findViewById(R.id.button);
      //Button enter2=(Button) findViewById(R.id.button2);
        final Context context = this;

        //mp = MediaPlayer.create(context, R.raw.sound);

        View.OnClickListener Listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //imageButton.setEnabled(false);

            String numA = input1.getText().toString();
            char c;

            if(numA.length() == 0) {c='T';}
            else {
                numA=numA.replaceAll("\\s+","");
                c=numA.charAt(0);}
            obj.calc(c);
            if(fact==1 || obj.fact==1 )
                imageButton.setEnabled(true);


            input1.setText("");
        }
    };


     enter.setOnClickListener(Listener);
        if(fact==1 || obj.fact==0 )
            imageButton.setEnabled(false);



        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Second.this,"GAME restarting ... . . . ",Toast.LENGTH_LONG).show();
                //finish();
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }

}
