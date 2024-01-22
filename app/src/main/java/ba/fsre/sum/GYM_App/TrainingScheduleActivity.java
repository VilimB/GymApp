package ba.fsre.sum.GYM_App;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TrainingScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_schedule);

        // Ovdje možete dohvatiti informaciju o odabranoj vrsti vježbi iz Intent-a
        // Intent intent = getIntent();
        // String selectedExerciseType = intent.getStringExtra("EXERCISE_TYPE");

        // Ovisno o vrsti vježbi, prilagodite prikaz rasporeda treninga

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnChooseAnotherTraining = findViewById(R.id.btnChooseAnotherTraining);
        btnChooseAnotherTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Povratak na GymActivity
                Intent intent = new Intent(TrainingScheduleActivity.this, GymActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
