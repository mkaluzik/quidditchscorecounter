package com.example.android.quidditchmatchcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    static final String SCORE_TEAM_A = "1";
    static final String SCORE_TEAM_B = "2";
    static final String IS_IN_PROGRESS = "3";
    private static final String TAG = "MainActivity";
    Button SnitchA;
    Button SnitchB;
    // Tracks the score for Team A
    int scoreTeamA = 0;
    // Tracks the score for Team B
    int scoreTeamB = 0;
    // Is the match still in progress or finished? Use 0 for in progress and 1 for finished
    int isTheMatchActive = 0;
    TextView scoreViewB;
    TextView scoreViewA;
    View.OnClickListener myhandler = new View.OnClickListener() {
        public void onClick(View v) {
            String whoCaughtTheSnitch = "";
            if (isTheMatchActive == 0) {
                switch (v.getId()) {
                    case R.id.snitchTeamA:
                        scoreTeamA = scoreTeamA + 150;
                        displayforTeam(scoreTeamA, scoreViewA);
                        whoCaughtTheSnitch = "The snitch has been caught by Griffindor's catcher! The match is over now.";
                        break;
                    case R.id.snitchTeamB:
                        scoreTeamB = scoreTeamB + 150;
                        displayforTeam(scoreTeamB, scoreViewB);
                        whoCaughtTheSnitch = "The snitch has been caught by Slytherin's catcher! The match is over now.";
                        break;
                }
                showToast(whoCaughtTheSnitch);
                whoIsTheWinner();
                isTheMatchActive = 1;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreViewB = (TextView) findViewById(R.id.team_b_score);
        scoreViewA = (TextView) findViewById(R.id.team_a_score);
        SnitchA = (Button) findViewById(R.id.snitchTeamA);
        SnitchB = (Button) findViewById(R.id.snitchTeamB);
        SnitchA.setOnClickListener(myhandler);
        SnitchB.setOnClickListener(myhandler);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save custom values into the bundle
        savedInstanceState.putInt(SCORE_TEAM_A, scoreTeamA);
        savedInstanceState.putInt(SCORE_TEAM_B, scoreTeamB);
        savedInstanceState.putInt(IS_IN_PROGRESS, isTheMatchActive);
        Log.d(TAG, "onSaveInstanceState() returned: " + SCORE_TEAM_A + SCORE_TEAM_B + IS_IN_PROGRESS);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

//    each goal is + 10 points
//    snitch is for + 150 points

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        // Restore state members from saved instance
        scoreTeamA = savedInstanceState.getInt(SCORE_TEAM_A);
        scoreTeamB = savedInstanceState.getInt(SCORE_TEAM_B);
        isTheMatchActive = savedInstanceState.getInt(IS_IN_PROGRESS);
        displayforTeam(scoreTeamB, scoreViewB);
        displayforTeam(scoreTeamA, scoreViewA);
        Log.d(TAG, "onRestoreInstanceState() returned: " + SCORE_TEAM_A + SCORE_TEAM_B + IS_IN_PROGRESS);
    }

    /**
     * Decide who is the winner of this match
     */

    public void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }


    public void whoIsTheWinner() {

        String winner = "";
        if (scoreTeamA > scoreTeamB) {
            winner = "Griffindor";

        } else {
            winner = "Slytherin";
        }

        String winnerString = "The winner is " + winner;
        showToast(winnerString);
    }


    /**
     * Increase the score for Team A by 10 points.
     */
    public void addOneGoalForTeamA(View v) {
        if (isTheMatchActive == 0) {
            scoreTeamA = scoreTeamA + 10;
            displayforTeam(scoreTeamA, scoreViewA);
        }
    }


    /**
     * Increase the score for Team B by 10 points.
     */
    public void addOneGoalForTeamB(View v) {
        if (isTheMatchActive == 0) {
            scoreTeamB = scoreTeamB + 10;
            displayforTeam(scoreTeamB, scoreViewB);
        }
    }


    public void displayforTeam(int score, TextView scoreView) {
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Bludger hits one of the players from the oposite team
     */
    public void bludgerHitGriffindor(View v) {
        if (isTheMatchActive == 0) {
            String whoWasHit = "Ooops! One of the bludgers hits Griffindor's player. That must have hurt...";
            showToast(whoWasHit);
        }
    }

    /**
     * Bludger hits one of the players from the oposite team
     */
    public void bludgerHitSlytherin(View v) {
        if (isTheMatchActive == 0) {
            String whoWasHit = "Ooops! One of the bludgers hits Slytherin's player. That must have hurt...";
            showToast(whoWasHit);
        }
    }


    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayforTeam(scoreTeamB, scoreViewB);
        displayforTeam(scoreTeamA, scoreViewA);
        isTheMatchActive = 0;
    }
}
