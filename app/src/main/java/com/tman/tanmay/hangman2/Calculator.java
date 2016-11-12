package com.tman.tanmay.hangman2;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by TANMAY on 04-Nov-16.
 */
public class Calculator {//extends AppCompatActivity {


    //final TextView hangman=(TextView) findViewById(R.id.hang);
    //final TextView cword=(TextView) findViewById(R.id.word);

    private TextView display;
    private TextView display2;
    public void setTextView(TextView t){
        this.display = t;
    }
    public void setTextView2(TextView t){
        this.display2 = t;
    }

    String hang;
    String exp;
    String word1,cword1,word2,cword2;
    int pos,n;
    int n1,fact;
    boolean flag,mis,flag2;
    //public int foo(){return 1;}
    public Calculator() {
        hang="HANGMAN";
        exp="";
        word1="captain america";
        word2="intersteller";
        cword1="_a__ai_ a_e_i_a";
        cword2="i__e___e__e_";
        pos=0;
        n=0;
        flag=true;
        mis=false;
        flag2=true;
    }
    public Calculator(String word2,String cword2) {
        hang="HANGMAN";
        exp="";
        word1=word2; //"intersteller"; //"iron man";
        //word2="inception";
        cword1=cword2; //"i__e___e__e_";//cword2;   //"i_o_ _a_";
        //="i__e__io_";
        pos=0;
        n=0;
        flag=false;
        mis=false;
        flag2=true;
        n1=0;
        fact=0;
        //display=cword;
        //display2=hangman;
    }
    void calc(char c ){
       try {
           mis = false;
           n1++;
           if (n1 == 1)
               display.setText(cword1);

           for (int i = 0; i < word1.length(); i++) {
               if (word1.charAt(i) == c) {
                   pos = i;
                   flag = true;
                   mis = true;
               }
               if (flag) {
                   cword1 = cword1.substring(0, pos) + word1.charAt(i) + cword1.substring(pos + 1, cword1.length());

                   flag = false;

                   display.setText(cword1);

               } else {
                   if (c == '*') {
                       flag2 = false;
                   }
                /*

                String h="";
                for (int j=0;j<n;j++)
                {
                    h="*"+h;
                }
                hang=h+hang.substring(n,hang.length());*/
                   //display2.setText(hang);
                   //mis=false;
               }
               if (i == word1.length() - 1) {
                   flag = false;
               }
           }

           if (mis == false && c != 'T')//&& flag2)
           {
               n++;
               String h = "";
               for (int j = 0; j < n; j++) {
                   h = h + "*";
               }
               hang = h + hang.substring(n, hang.length());
               display2.setText(hang);
           }

           if (n == 7) {
               //display.setText("");
               fact=1;
               display2.setText("YOU lost :( \n PLAYER 1 WINS");
               display.setText("your word was "+word1 );

           }

           boolean flag0 = true;
           char[] ch1 = word1.toCharArray();
           char[] ch2 = cword1.toCharArray();
           for (int i = 0; i < ch1.length; i++) {
               if (ch1[i] != ch2[i]) {
                   // flag0 = false;
               }
               if (ch2[i] == '-') {
                   flag0 = false;
               }
           }

           if (flag0) {
               fact=1;
               display2.setText("PLAYER 2 WINS :)");
               display.setText("  ..LOL..  ");

               //imageButton.setEnabled(false);
               //Toast.makeText(Calculator.this,"go do studies",Toast.LENGTH_LONG).show();
           }

       }
       catch (Exception e) {

           //display
           //finish();
           //finishActivity(myIntent);
           //exp = "";
           //display.setText(exp);

       }
    }

}
