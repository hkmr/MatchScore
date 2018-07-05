package com.example.android.matchscore;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int team_a_total;
    private int team_b_total;
    private int total_3_A;
    private int total_3_B;
    private int total_2_A;
    private int total_2_B;
    private int total_1_A;
    private int total_1_B;


    MainActivity(){
        this.setValues();
    }

    private void setValues(){
        this.team_a_total =0;
        this.team_b_total = 0;
        this.total_1_A = 0;
        this.total_1_B = 0;
        this.total_2_A = 0;
        this.total_2_B = 0;
        this.total_3_A = 0;
        this.total_3_B = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateTeamA();
        updateTeamB();
    }

    public void score3A(View view){
        addScoreForA(3);
        this.total_3_A++;
        updateTeamA();
    }

    public void score3B(View view){
        addScoreForB(3);
        this.total_3_B++;
        updateTeamB();
    }

    public void score2A(View view){
        addScoreForA(2);
        this.total_2_A++;
        updateTeamA();
    }

    public void score2B(View view){
        addScoreForB(2);
        this.total_2_B++;
        updateTeamB();
    }

    public void score1A(View view){
        addScoreForA(1);
        this.total_1_A++;
        updateTeamA();
    }

    public void score1B(View view){
        addScoreForB(1);
        this.total_1_B++;
        updateTeamB();
    }

    private void addScoreForA(int num){
        this.team_a_total = this.team_a_total + num;
    }

    private void addScoreForB(int num){
        this.team_b_total = this.team_b_total + num;
    }

    private void updateTeamA(){
        TextView total_a_view = (TextView) findViewById(R.id.team_a_total);
        total_a_view.setText(String.valueOf(this.team_a_total));
    }
    private void updateTeamB(){
        TextView total_b_view = (TextView) findViewById(R.id.team_b_total);
        total_b_view.setText(String.valueOf(this.team_b_total));
    }

    public void showResult(View view){
        TextView result_message = (TextView) findViewById(R.id.result_message);

        if(team_a_total > team_b_total){
            result_message.setText("Congratulations , Team A won the match !!");
        }
        else if(team_b_total > team_a_total){
            result_message.setText("Congratulations, Team B won the match !!");
        }
        else{
            result_message.setTextColor(Color.YELLOW);
            result_message.setText("Oops, It's a Tie match !!");
        }

        result_message.setVisibility(View.VISIBLE);
        setScoreBoard();

//        Intent example
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("geo:47.6, -122.3"));
//        if(intent.resolveActivity(getPackageManager()) != null){
//            startActivity(intent);
//        }

    }

    private void setScoreBoard(){

        LinearLayout scoreBoard = findViewById(R.id.score_board);
        scoreBoard.setVisibility(View.VISIBLE);

        TextView team_a_3 = (TextView) findViewById(R.id.team_a_3_points);
        team_a_3.setText("3 points = "+ total_3_A);

        TextView team_a_2 = (TextView) findViewById(R.id.team_a_2_points);
        team_a_2.setText("2 points = "+ total_2_A);

        TextView team_a_1 = (TextView) findViewById(R.id.team_a_1_points);
        team_a_1.setText("1 points = "+ total_1_A);

        TextView team_b_3 = (TextView) findViewById(R.id.team_b_3_points);
        team_b_3.setText("3 points = "+ total_3_B);

        TextView team_b_2 = (TextView) findViewById(R.id.team_b_2_points);
        team_b_2.setText("2 points = "+ total_2_B);

        TextView team_b_1 = (TextView) findViewById(R.id.team_b_1_points);
        team_b_1.setText("1 points = "+ total_1_B);



    }

    public void reset(View view){

        this.setValues();
        LinearLayout scoreBoard = findViewById(R.id.score_board);
        scoreBoard.setVisibility(View.GONE);
        TextView result_message = (TextView) findViewById(R.id.result_message);
        result_message.setVisibility(View.GONE);
        updateTeamA();
        updateTeamB();
    }

}
