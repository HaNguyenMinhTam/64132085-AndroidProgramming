package til.edu.tinhtong;

import android.os.Bundle;
import android.widget.EditText;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    //Đây là bộ lắng nghe và xử lí sự kiện click lên nut tính tổng
    public void XuLyCong(View view){
        //Tìm tham chiếu đến điều khiển trên tệp XML
        EditText editTextSoA = findViewById(R.id.edtA);
        EditText editTextSoB = findViewById(R.id.edtB);
        EditText editTextKetQua = findViewById(R.id.edtKetQua);

        //Lấy dữ liệu về ở điều khiển số A và B
        String strA = editTextSoA.getText().toString();
        String strB = editTextSoB.getText().toString();

        //Chuyển dữ liệu sang dạng số
        int so_A = Integer.parseInt(strA);
        int so_B = Integer.parseInt(strB);

        //Tính toán theo yêu cầu
        int tong = so_A + so_B; //6
        String strTong = String.valueOf(tong); //Chuyển sang dạng chuỗi: "6"

        //Hiện ra màn hình
        editTextKetQua.setText(strTong);

    }
}