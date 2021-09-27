package com.example.shapes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button [] buttons = new Button[17];
    private Button resetGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //loops through button array and "initialize" them to be ready to be clicked
        for(int i = 1; i < buttons.length;i++)
        {
            String buttonID = "square" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = (Button) findViewById(resourceID);
            buttons[i].setOnClickListener(this);
            buttons[i].setBackgroundColor(Color.GRAY);

        }

        Button resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(this);
        buttons[16].setBackgroundColor(Color.TRANSPARENT);

        //generate15();


    }

    public void generate15()
    {

        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.BLACK);
        /*
        HashSet<Integer> used = new HashSet<Integer>();
        for(int i = 1; i < buttons.length-1;i++)
        {


                int add = (int)(Math.random() *15+1); //this is the int we are adding
                while (used.contains(add)) { //while we have already used the number
                    add = (int) (Math.random() * 15 +1); //generate a new one because it's already used
                }
                //by this time, add will be unique
                used.add(add);
                //result[i] = add;

            buttons[i].setText(String.valueOf(add));
        }
        */


    }


    @Override
    public void onClick(View v) {
        //checks which button is pressed
        switch(v.getId()) {
            case R.id.resetButton:
                generate15();
                break;
            case R.id.square1:
                check(1);
                break;
            case R.id.square2:
                check(2);
                break;
            case R.id.square3:
                check(3);
                break;
            case R.id.square4:
                check(4);
                break;
            case R.id.square5:
                check(5);
                break;
            case R.id.square6:
                check(6);
                break;
            case R.id.square7:
                check(7);
                break;
            case R.id.square8:
                check(8);
                break;
            case R.id.square9:
                check(9);
                break;
            case R.id.square10:
                check(10);
                break;
            case R.id.square11:
                check(11);
                break;
            case R.id.square12:
                check(12);
                break;
            case R.id.square13:
                check(13);
                break;
            case R.id.square14:
                check(14);
                break;
            case R.id.square15:
                check(15);
                break;
            case R.id.square16:
                check(16);

        }

    }

    public void check(int square_num)
    {

            // RIGHT
            //checks the tags of the button pressed and see if adjacent button
            //is an "invisible". "invisible" is determined by the tag "16"
            if (square_num +1 < 17 && String.valueOf(buttons[square_num + 1].getTag()).equals("16")) {

                //change adjacent button to match original button pressed
                buttons[square_num + 1].setText(buttons[square_num].getText());
                buttons[square_num +1 ].setTag(buttons[square_num].getTag());
                buttons[square_num + 1].setBackgroundColor(Color.GRAY);

                //make original button pressed invisible and carry the invisible values
                buttons[square_num].setBackgroundColor(Color.TRANSPARENT);
                buttons[square_num].setTag("16");
                buttons[square_num].setText("");
                checkWin();
                return;
            }
            //LEFT
            if (square_num-1 > 0 &&String.valueOf(buttons[square_num - 1].getTag()).equals("16")) {

                buttons[square_num - 1].setText(buttons[square_num].getText());
                buttons[square_num -1 ].setTag(buttons[square_num].getTag());
                buttons[square_num - 1].setBackgroundColor(Color.GRAY);

                buttons[square_num].setBackgroundColor(Color.TRANSPARENT);
                buttons[square_num].setTag("16");
                buttons[square_num].setText("");
                checkWin();
                return;

            }
                //BOTTOM
                if (square_num +4 < 17 && String.valueOf(buttons[square_num + 4].getTag()).equals("16")) {

                    buttons[square_num + 4].setText(buttons[square_num].getText());
                    buttons[square_num + 4].setTag(buttons[square_num].getTag());
                    buttons[square_num + 4].setBackgroundColor(Color.GRAY);

                    buttons[square_num].setBackgroundColor(Color.TRANSPARENT);
                    buttons[square_num].setTag("16");
                    buttons[square_num].setText("");
                    checkWin();
                    return;

                }
        //TOP
        if (square_num -4 > 0 && String.valueOf(buttons[square_num - 4].getTag()).equals("16")) {
            Log.i("Text", "4");
            buttons[square_num - 4].setText(buttons[square_num].getText());
            buttons[square_num -4 ].setTag(buttons[square_num].getTag());
            buttons[square_num - 4].setBackgroundColor(Color.GRAY);

            buttons[square_num].setBackgroundColor(Color.TRANSPARENT);
            buttons[square_num].setTag("16");
            buttons[square_num].setText("");
            checkWin();
            return;

        }


    }

    public void checkWin()
    {
        //loops through the button array
        for(int i = 1; i < buttons.length-2;i++)
        {

            if(String.valueOf(buttons[i].getText()).equals("") ||
                    String.valueOf(buttons[i+1].getText()).equals(""))
            {
                return;
            }

            if(! (Integer.parseInt(String.valueOf(buttons[i].getText())) +1 ==
                    Integer.parseInt(String.valueOf(buttons[i+1].getText())))) {
                return;
            }

        }
            //win notification
            View view = this.getWindow().getDecorView();
            view.setBackgroundColor(Color.GREEN);

            Log.i("Text","you win!");
            Toast.makeText(getApplicationContext(),"You won!",Toast.LENGTH_SHORT).show();




    }
}