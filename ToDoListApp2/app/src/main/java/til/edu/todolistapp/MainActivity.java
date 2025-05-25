package til.edu.todolistapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<TASKS> lstTDL;
    TaskRVadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Tọa kết nối đến CSDL
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("TASKS");

        //Lắng nghe và xử lí
        lstTDL = new ArrayList<TASKS>();
        databaseReference.addValueEventListener(ngheFB);

        //Tìm điều khiển
        RecyclerView recyclerView = findViewById(R.id.rcvVCL);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        adapter = new TaskRVadapter(lstTDL);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);

        // Xử lý sự kiện click FloatingActionButton
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Chuyển sang màn AddTaskActivity
                Intent intent = new Intent(MainActivity.this, activity_them_task.class);
                startActivity(intent);
            }
        });
    }
    ValueEventListener ngheFB = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            lstTDL.clear();
            // Lấy dữ liệu từ biến snapshot, đưa vào một biến ds để xử lí
            for (DataSnapshot obj: snapshot.getChildren()){
                TASKS task = obj.getValue(TASKS.class);
                lstTDL.add(task);
        //        Log.w("To-Do List App", "Tên việc làm : " + task.getTen());
            }
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
}