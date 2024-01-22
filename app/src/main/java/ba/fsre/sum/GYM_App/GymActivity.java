package ba.fsre.sum.GYM_App;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GymActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnPushExercises = findViewById(R.id.btnPushExercises);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnPullExercises = findViewById(R.id.btnPullExercises);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnLegExercises = findViewById(R.id.btnLegExercises);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnStartTraining = findViewById(R.id.btnStartTraining);

        btnPushExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Logika za odabrane vježbe guranja
            }
        });

        btnPullExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Logika za odabrane vježbe povlačenja
            }
        });

        btnLegExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Logika za odabrane vježbe nogu
            }
        });

        btnStartTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Logika za početak treninga
                // Primjer prijelaza na drugu aktivnost
                Intent intent = new Intent(GymActivity.this, TrainingScheduleActivity.class);
                startActivity(intent);
            }
        });

        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pokrenite LoginActivity
                Intent intent = new Intent(GymActivity.this, LoginActivity.class);
                startActivity(intent);
                // Zatvorite trenutnu aktivnost (GymActivity)
                finish();
            }
        });

    }
}
