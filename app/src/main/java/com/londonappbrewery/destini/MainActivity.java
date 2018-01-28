package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryText;
    Button mTopButton;
    Button mBottomButton;
    int mStoryIndex;
    int mButtonIndex;

    int[] mStoryLineString = {
        R.string.T1_Story,
        R.string.T2_Story,
        R.string.T3_Story,
        R.string.T4_End,
        R.string.T5_End,
        R.string.T6_End
    };

    int[] mButtonStoryLine = {
            R.string.T1_Ans1,
            R.string.T1_Ans2,
            R.string.T2_Ans1,
            R.string.T2_Ans2,
            R.string.T3_Ans1,
            R.string.T3_Ans2,
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryText = (TextView) findViewById(R.id.storyTextView);
        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);




        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStoryIndex == 0) {
                    mStoryIndex = 2;
                    mButtonIndex = 4;
                    upDate();

                }
                else if (mStoryIndex == 2) {
                    mStoryIndex = 5;
                    upDate();
                }
                else if (mStoryIndex == 1) {
                    mStoryIndex = 2;
                    mButtonIndex = 4;
                    upDate();

                }






            }
        });




        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStoryIndex == 0) {
                    mStoryIndex = 1;
                    mButtonIndex = 2;
                    upDate();

                }

                else if(mStoryIndex == 1) {
                    mStoryIndex = 3;
                    upDate();

                }
                else if (mStoryIndex == 2) {
                    mStoryIndex = 4;
                    upDate();
                }

            }
        });
    }


    protected void upDate(){
        mStoryText.setText(mStoryLineString[mStoryIndex]);
        if (mStoryIndex > 2) {
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);

        }
        else {
            mTopButton.setText(mButtonStoryLine[mButtonIndex]);
            mBottomButton.setText(mButtonStoryLine[mButtonIndex+1]);
        }

        if (mStoryIndex > 2) {

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("Keep up the great work!!");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    finish();
                }
            });
            alert.show();

        }


    }
}
