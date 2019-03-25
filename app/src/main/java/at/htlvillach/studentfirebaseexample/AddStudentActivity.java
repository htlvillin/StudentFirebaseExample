package at.htlvillach.studentfirebaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddStudentActivity extends AppCompatActivity {

    private Button btnAddRecord;
    private EditText etFirstName;
    private EditText etLastName;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference collectionReference;

   // private DatabaseManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = FirebaseFirestore.getInstance();
        collectionReference = db.collection("Student");
        setContentView(R.layout.activity_add_student);
        setTitle("Add Record");

        setContentView(R.layout.activity_add_student);

        etFirstName =  findViewById(R.id.etFirstName);
        etLastName =  findViewById(R.id.etLastName);

        btnAddRecord =  findViewById(R.id.add_record);
        btnAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String firstName = etFirstName.getText().toString();
                final String lastName = etLastName.getText().toString();
                    // Create a new student with a first and last name
        Map<String, Object> students = new HashMap<>();
        students.put("_id", 99);
        students.put("firstname", firstName);
        students.put("lastname", lastName);

// Add a new document with a generated ID
        db.collection("Student")
                .add(students)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("Test", "DocumentSnapshot added with ID: " + documentReference.getId());
                        Toast.makeText(AddStudentActivity.this, "Datensatz hinzugefügt", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Test", "Error adding document", e);
                        Toast.makeText(AddStudentActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnCanceledListener(new OnCanceledListener() {
                    @Override
                    public void onCanceled() {
                        Toast.makeText(AddStudentActivity.this, "OnCancelled", Toast.LENGTH_SHORT).show();
                    }
                });

               Intent main = new Intent(AddStudentActivity.this, StudentsActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
            }
        });




    }
}
