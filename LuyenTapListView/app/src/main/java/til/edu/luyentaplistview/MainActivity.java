package til.edu.luyentaplistview;

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
        //B1. Chuẩn bị dữ liệu
        listViewNNLT = findViewById(R.id.LVNNLT);
        //B1. Chuẩn bị dữ liệu, hard-code
        dsNgonNguLT = new ArrayList<String>();
        dsNgonNguLT.add("Python");
        dsNgonNguLT.add("Java");
        dsNgonNguLT.add("Ruby");
        dsNgonNguLT.add("C");
        dsNgonNguLT.add("JavaScript");

        //B2
        ArrayAdapter<String> adapterNNLT;
        adapterNNLT = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsNgonNguLT);

        //B3. gắn Adapter
        listViewNNLT.setAdapter(adapterNNLT);

        //B4. Gắn bộ lắng nghe và xử lí sự kiện
        listViewNNLT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Code xử lí ở dây
                //Chú ý: biến position đã chứa vị trí của item được click
                String giatriDuocChon = dsNgonNguLT.get(position);

                //Thông báo lên
                Toast.makeText(MainActivity.this, giatriDuocChon, Toast.LENGTH_SHORT).show();
            }
        });

    }
}