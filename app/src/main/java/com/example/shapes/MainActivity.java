package com.example.shapes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
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
/**
 * This program runs the popular game, 15 Puzzles.
 * The goal of this game is to have a sequence of 1-15 by changing the random order to a
 * sequential order
 *
 * @author David Le
 * @version 9/27/2021 Fall 2021
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button [] buttons = new Button[17];
    private Button resetGame;
    private int count; //this is a counter for generate15();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //loops through button array and "initialize" them to be ready to be clicked
        for(int i = 1; i < buttons.length;i++)
        {
            String buttonID = "square" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = (Button) findViewById(resourceID);
            buttons[i].setOnClickListener(this);
            buttons[i].setBackgroundColor(Color.GRAY);

        }
        //initialize reset button
        Button resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(this);
        buttons[16].setBackgroundColor(Color.TRANSPARENT);

        //INIT GAME


        //randomize puzzle on app launch
        generate15();
        //checks to see if the user wins by pure chance of the board initializing
        checkWin();
        //because how generate15() works, you need to set the most bottom right invisible (no text)
        //at the beginning.
        //this needs to only happen once per application launch
        buttons[16].setText("");

    }
    /**
     * Generate15()
     * Goes through each visible button in the array, and assign a random value in the range 1-15
     * with no duplicates
     */
    public void generate15()
    {
        //changes the background to black
        //this is to remove the winning screen (green background) if you want to play again.
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.BLACK);

        //I learned about Collections.shuffles from Dr.Triblehorn
        //A random assort of numbers in the range 1-15 with no duplicates
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=1; i<16; i++)
        {
            list.add(i);
        }
        Collections.shuffle(list);

        //Because list array is smaller than buttons array
        //add a 0 integer to index 0 to prevent out of bounds error with the upcoming for loop
        list.add(0,0);

        //loops through all the buttons
        outerloop:
        for(int i=1;i<buttons.length;i++)
        {
            //keep track of our current position.
            count++;
            //once we hit the empty spot in the puzzle. Get out of this for loop
            if((String.valueOf(buttons[i].getTag()).equals("16")))
            {
                break outerloop;

            }
            //set the face of the squares(buttons) to a random value from 1-15
            buttons[i].setText(String.valueOf(list.get(i)));
        }

        //increase the list array size to prevent out of bounds error.
        list.add(0,1);

        //resume the search in the buttons array after that empty space.
        //Again, this is necessary to prevent out of bounds error/ the value for square16-
        //-Most bottom right can't be reached
        for(int i = count+1; i<list.size();i++)
        {
            buttons[i].setText(String.valueOf(list.get(i)));
        }
        count=0;//reset counter

    }

    /**
     * Checks which button the user pressed and calls the appropriate method call
     * If user clicks on resetButton, the board is shuffled
     * If user clicks on any puzzle buttons, calls check( int ), int = button value
     */
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
    /**
     * This method will "move" the puzzle piece to where there's an empty space and only if there's
     * an empty space and calls checkWin() to see if their "move" brings them to the winning state.
     *
     */
    public void check(int square_num)
    {

        // RIGHT
        //Checks to see if the adjacent button is within the bounds and then
        //checks the tags of the button pressed and see if adjacent button
        //is an "invisible". "invisible" is determined by the tag "16"
        if (square_num +1 < 17 && String.valueOf(buttons[square_num + 1].getTag()).equals("16"))
        {

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
        //Checks LEFT
        //Checks to see if looking at the adjacent button is within the bounds
        //checks the tags of the button pressed and see if adjacent button
        //is an "invisible". "invisible" is determined by the tag "16"
        if (square_num-1 > 0 &&String.valueOf(buttons[square_num - 1].getTag()).equals("16"))
        {

            buttons[square_num - 1].setText(buttons[square_num].getText());
            buttons[square_num -1 ].setTag(buttons[square_num].getTag());
            buttons[square_num - 1].setBackgroundColor(Color.GRAY);

            buttons[square_num].setBackgroundColor(Color.TRANSPARENT);
            buttons[square_num].setTag("16");
            buttons[square_num].setText("");
            checkWin();
            return;

        }
        //Checks BOTTOM
        //Checks to see if looking at the adjacent button is within the bounds
        //checks the tags of the button pressed and see if adjacent button
        //is an "invisible". "invisible" is determined by the tag "16"
        if (square_num +4 < 17 && String.valueOf(buttons[square_num + 4].getTag()).equals("16"))
        {

            buttons[square_num + 4].setText(buttons[square_num].getText());
            buttons[square_num + 4].setTag(buttons[square_num].getTag());
            buttons[square_num + 4].setBackgroundColor(Color.GRAY);

            buttons[square_num].setBackgroundColor(Color.TRANSPARENT);
            buttons[square_num].setTag("16");
            buttons[square_num].setText("");
            checkWin();
            return;

        }
        //Checks TOP
        //Checks to see if looking at the adjacent button is within the bounds
        //checks the tags of the button pressed and see if adjacent button
        //is an "invisible". "invisible" is determined by the tag "16"
        if (square_num -4 > 0 && String.valueOf(buttons[square_num - 4].getTag()).equals("16"))
        {

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
    /**
     * Checks if the user has properly ordered the puzzle in 1-15 order
     * Notifies the user of winnning by displaying text and changing background
     * to green.
     */
    public void checkWin()
    {
        //loops through the button array
        for(int i = 1; i < buttons.length-2;i++)
        {
            //Edge cases
            if(String.valueOf(buttons[i].getText()).equals("") ||
                    String.valueOf(buttons[i+1].getText()).equals(""))
            {
                return;
            }
            //Edge cases
            if(! (Integer.parseInt(String.valueOf(buttons[i].getText())) +1 ==
                    Integer.parseInt(String.valueOf(buttons[i+1].getText()))))
            {
                return;
            }
        }
            //win notification
            View view = this.getWindow().getDecorView();
            view.setBackgroundColor(Color.GREEN);
            Toast.makeText(getApplicationContext(),"You won!",Toast.LENGTH_SHORT).show();
    }
}