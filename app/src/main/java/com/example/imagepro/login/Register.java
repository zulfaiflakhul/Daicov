package com.example.imagepro.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imagepro.MainActivity;
import com.example.imagepro.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    EditText emailReg, passReg, passReg2, nameReg;
    ImageButton Save;
    TextView login;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase db;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameReg = findViewById(R.id.et_reg_nama);
        emailReg = findViewById(R.id.et_reg_email);
        passReg = findViewById(R.id.et_reg_password);
        passReg2 = findViewById(R.id.et_reg_password2);
        login = findViewById(R.id.login);
        Save = findViewById(R.id.btn_save);
        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference("User");

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = nameReg.getText().toString();
                String email = emailReg.getText().toString().trim();
                String password = passReg.getText().toString().trim();
                String password2 = passReg2.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    emailReg.setError("Masukkan Email");
                }

                if (TextUtils.isEmpty(password)){
                    passReg.setError("Masukkan Password");
                }

                if (TextUtils.isEmpty(password2)){
                    passReg2.setError("Masukkan Password");
                }

                if (password.length() < 8){
                    passReg.setError("Password minimal 8 karakter");
                }

                if (password.equals(password2)){

                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){

                                User user = new User();
                                user.setNama(nameReg.getText().toString());
                                user.setEmail(emailReg.getText().toString());
                                user.setPassword(passReg.getText().toString());

                                databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Toast.makeText(Register.this, "Berhasil membuat Akun", Toast.LENGTH_LONG).show();
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(Register.this, "Gagal membuat akun", Toast.LENGTH_LONG).show();
                                    }
                                });

                                FirebaseDatabase.getInstance().getReference("User")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                GlobalVar.currentUser = snapshot.getValue(User.class);
                                                Intent home = new Intent(Register.this, Login.class);
                                                startActivity(home);
                                                finish();
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError error) {

                                            }
                                        });
                            } else {
                                Toast.makeText(Register.this, "Gagal membuat akun", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                } else {
                    Toast.makeText(Register.this, "Email / Password Salah", Toast.LENGTH_LONG).show();
                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });
    }

    private void showData(){

        Intent intent = getIntent();
    }
}