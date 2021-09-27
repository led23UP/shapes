package com.example.shapes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button [] buttons = new Button[17];
    private Button resetGame;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 1; i < buttons.length;i++)
        {
            String buttonID = "square" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = (Button) findViewById(resourceID);
            buttons[i].setOnClickListener(this);
            buttons[i].setBackgroundColor(Color.GRAY);

        }
        buttons[16].setBackgroundColor(Color.TRANSPARENT);


    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
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
                Log.i("Text","check50");
                break;
            case R.id.square16:
                check(16);

        }

    }

    public void check(int square_num)
    {
        Log.i("Text","first");


            if (square_num +1 < 17 &&String.valueOf(buttons[square_num + 1].getText()).equals("invisible")) {
                Log.i("Text", "1");
                buttons[square_num + 1].setText(buttons[square_num].getText());
                buttons[square_num + 1].setBackgroundColor(Color.GRAY);

                buttons[square_num].setBackgroundColor(Color.TRANSPARENT);
                buttons[square_num].setText("invisible");
                return;
            }
            if (square_num-1 > 0 &&String.valueOf(buttons[square_num - 1].getText()).equals("invisible")) {
                Log.i("Text", "2");
                buttons[square_num - 1].setText(buttons[square_num].getText());
                buttons[square_num - 1].setBackgroundColor(Color.GRAY);

                buttons[square_num].setBackgroundColor(Color.TRANSPARENT);
                buttons[square_num].setText("invisible");
                return;

            }
                if (square_num +4 < 17 && String.valueOf(buttons[square_num + 4].getText()).equals("invisible")) {
                    Log.i("Text", "3");
                    buttons[square_num + 4].setText(buttons[square_num].getText());
                    buttons[square_num + 4].setBackgroundColor(Color.GRAY);

                    buttons[square_num].setBackgroundColor(Color.TRANSPARENT);
                    buttons[square_num].setText("invisible");
                    return;

                }
        if (square_num -4 > -1 && String.valueOf(buttons[square_num - 4].getText()).equals("invisible")) {
            Log.i("Text", "4");
            buttons[square_num - 4].setText(buttons[square_num].getText());
            buttons[square_num - 4].setBackgroundColor(Color.GRAY);

            buttons[square_num].setBackgroundColor(Color.TRANSPARENT);
            buttons[square_num].setText("invisible");
            return;

        }


    }
}