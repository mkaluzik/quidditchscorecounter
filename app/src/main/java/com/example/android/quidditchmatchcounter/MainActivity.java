package com.example.android.quidditchmatchcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Tracks the score for Team A
    int scoreTeamA = 0;

    // Tracks the score for Team B
    int scoreTeamB = 0;


    // Is the match still in progress or finished? Use 0 for in progress and 1 for finished
    int isTheMatchActive = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    each goal is + 10 points
//    snitch is for + 150 points

    /**
    * Decide who is the winner of this match
    */
    public void whoIsTheWinner(){

        String winner ="";
        if (scoreTeamA > scoreTeamB) {
            winner="Griffindor";

        } else {

            winner="Slytherin";

        }
        Toast.makeText(getApplicationContext(), "The winner is "+ winner+"!",
                Toast.LENGTH_SHORT).show();
    }


    /**
     * Increase the score for Team A by 10 points.
     */
    public void addOneGoalForTeamA(View v) {
        if (isTheMatchActive == 0) {
            scoreTeamA = scoreTeamA + 10;
            displayForTeamA(scoreTeamA);
        }
    }


    /**
     * Increase the score for Team B by 10 points.
     */
    public void addOneGoalForTeamB(View v) {
        if (isTheMatchActive == 0) {
            scoreTeamB = scoreTeamB + 10;
            displayForTeamB(scoreTeamB);
        }
    }



    /**
     * Increase the score for Team A by 150 points and end the match. Then decide which team wins the match.
     */
    public void snitchCaughtByTeamA(View v) {
        if (isTheMatchActive == 0) {
        scoreTeamA = scoreTeamA + 150;
        displayForTeamA(scoreTeamA);


            Toast.makeText(getApplicationContext(), "The snitch has been catched by Griffindor's catcher! The match is over now.",
                    Toast.LENGTH_SHORT).show();
            whoIsTheWinner();
        }
        isTheMatchActive = 1;

    }


    /**
     * Increase the score for Team B by 150 points and end the match. Then decide which team wins the match.
     */
    public void snitchCaughtByTeamB(View v) {
        if (isTheMatchActive == 0) {
        scoreTeamB = scoreTeamB + 150;
        displayForTeamB(scoreTeamB);

            Toast.makeText(getApplicationContext(), "The snitch has been catched by Slytherin's catcher! The match is over now.",
                    Toast.LENGTH_SHORT).show();
        whoIsTheWinner();
        }
        isTheMatchActive = 1;


    }



    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Bludger hits one of the players from the oposite team
     */
    public void bludgerHitGriffindor(View v){
        if (isTheMatchActive == 0) {
            Toast.makeText(getApplicationContext(), "Ooops! One of the bludgers hits Griffindor's player. That must have hurt...",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Bludger hits one of the players from the oposite team
     */
    public void bludgerHitSlytherin(View v){
        if (isTheMatchActive == 0) {
            Toast.makeText(getApplicationContext(), "Ooops! One of the bludgers hits Slytherin's player. That must have hurt...",
                    Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        isTheMatchActive = 0;
    }

}
