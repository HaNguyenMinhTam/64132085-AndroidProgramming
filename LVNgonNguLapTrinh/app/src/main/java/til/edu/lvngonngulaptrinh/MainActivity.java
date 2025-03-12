package til.edu.lvngonngulaptrinh;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewNNLT;
    ArrayList<String> dsNgonNguLT;
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
        listViewNNLT = findViewById(R.id.lvNNLT);

        //B1. Chuẩn bị dữ liệu, hard-code
        dsNgonNguLT = new ArrayList<String>();
        dsNgonNguLT.add("Python");
        dsNgonNguLT.add("PhP");
        dsNgonNguLT.add("Java");

        //B2
        ArrayAdapter<String> adapterNNLT;
        adapterNNLT = new ArrayAdapter<String>( this,
                                                android.R.layout.simple_list_item_1,
                                                dsNgonNguLT);

        //B3. Gắn adapter
        listViewNNLT.setAdapter(adapterNNLT);

        //B4. Gắn bộ lắng nghe va xử lí sự kiện
        listViewNNLT.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                //Code xử lý ở đây
                //Chú ý: biến position đã chứa vị trí cúa item được click
                String giaTriDuocChon = dsNgonNguLT.get(position);
                //Làm gì đó với giá trị này thì tùy
                //Đơn giản, Toast lên
                Toast.makeText(MainActivity.this, giaTriDuocChon, Toast.LENGTH_LONG).show();
            }
        });
    }
}