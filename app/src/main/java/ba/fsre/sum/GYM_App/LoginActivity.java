package ba.fsre.sum.GYM_App;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Check if the user is already logged in
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            // User is already logged in, redirect to MainActivity
            redirectToMainActivity();
        } else {
            // User not logged in, show login screen
            setContentView(R.layout.activity_login);

            // Initialize UI elements
            emailEditText = findViewById(R.id.editTextEmail);
            passwordEditText = findViewById(R.id.editTextPassword);
            Button loginButton = findViewById(R.id.buttonLogin);
            Button registerButton = findViewById(R.id.buttonRegister);

            loginButton.setOnClickListener(v -> loginUser());
            registerButton.setOnClickListener(v -> openRegisterActivity());
        }
    }

    private void redirectToMainActivity() {
        Intent i = new Intent(LoginActivity.this, GymActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear the activity stack
        startActivity(i);
        finish(); // Ensure LoginActivity is closed and removed from the back stack
    }

    private void loginUser() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Unesite vašu email adresu i lozinku", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(LoginActivity.this, "Prijava uspješna", Toast.LENGTH_SHORT).show();
                redirectToMainActivity();
            } else {
                Toast.makeText(LoginActivity.this, "Greška prilikom prijave: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openRegisterActivity() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
