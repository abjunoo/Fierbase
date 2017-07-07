package com.example.junoo.fierbase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity{

    private EditText editText,editText2,editText3;
    private Button btn;

    FirebaseDatabase database;
    DatabaseReference myref;

    private long now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);  // 이름
        editText2 = (EditText)findViewById(R.id.editText2);  // 날짜
        editText3 = (EditText)findViewById(R.id.editText3);  // 오픈

        btn = (Button)findViewById(R.id.send);

        database = FirebaseDatabase.getInstance();
        myref = database.getReference("message");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DTO dto = new DTO();
                String name = editText.getText().toString();
                editText2.setText(dto.getDate());
                int isOpen = Integer.parseInt(editText.getText().toString());

                dto.setName(name);
                dto.setDate(dto.getDate());
                dto.setFlag(isOpen);


                myref.setValue(dto);
            }
        });

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //String value = dataSnapshot.getValue(String.class);
                //Toast.makeText(MainActivity.this, ""+value, Toast.LENGTH_SHORT).show();
                //Log.i("데이터변화",value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("실패","냐옹냐옹");
            }
        });
    }
}
