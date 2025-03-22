package til.edu.luyentapcongtrunhanchia;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
    //Xử lý cộng
    public void XuLyCong(View v){
        //Code xử lý cộng ở đây
        EditText editTextSo1 = (EditText)findViewById(R.id.edtSo1);
        EditText editTextSo2 = (EditText)findViewById(R.id.edtSo2);
        EditText editTextKQ = (EditText)findViewById(R.id.edtKetQua);

        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();

        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);

        float Tong = soA + soB;
        String chuoiKQ = String.valueOf(Tong);

        editTextKQ.setText(chuoiKQ);
    }
    //Xử lý trừ
    public void XuLyTru(View v){
        //Code xử lý trừ ở đây
        //b1 Lấy dữ liệu 2 số
        //b1.1 tìm edittext số 1 và 2
        EditText editTextSo1 = (EditText)findViewById(R.id.edtSo1);
        EditText editTextSo2 = (EditText)findViewById(R.id.edtSo2);
        EditText editTextKQ = (EditText)findViewById(R.id.edtKetQua);

        //b1.2 Lấy dữ liệu từ 2 điều khiê
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();

        //b1.3 chuyển dữ liệu từ chuỗi sang số
        float a = Float.parseFloat(soThu1);
        float b = Float.parseFloat(soThu2);

        //b2 tính toán
        float Hieu = a - b;

        //b3.1 chuẩn bị dữ liệu suất, biến thành dạng chuỗi
        String chuoiKQ = String.valueOf(Hieu);

        //b3.2 Gasn kết quả lên đều khiển
        editTextKQ.setText(chuoiKQ);
    }
    //Xử lý nhân
    public void XuLyNhan(View v){
        //Code xử lý nhân ở đây
        //Tìm điều khiển số 1, 2 và điều khiển kê quả
        EditText editTextSo1 = (EditText)findViewById(R.id.edtSo1);
        EditText editTextSo2 = (EditText)findViewById(R.id.edtSo2);
        EditText editTextKQ = (EditText) findViewById(R.id.edtKetQua);

        //Lấy dữ lệu từ 2 điều khiển
        String sothu1 = editTextSo1.getText().toString();
        String sothu2 = editTextSo2.getText().toString();

        //Chuyển dữ liệu từ chuỗi sang số
        float a = Float.parseFloat(sothu1);
        float b = Float.parseFloat(sothu2);

        //Tính toán
        float Tich = a * b;

        //Chuẩn bị dữ liệu suất, biến thành dạng chuỗi
        String chuoiKQ = String.valueOf(Tich);

        //Gán kết quả cho điều khiển
        editTextKQ.setText(chuoiKQ);
    }
    //Xử lý chia
    public void XuLyChia(View v){
        //code xử lys chia ở đây
        //b1.1 Tím các điều khiển
        EditText editTextSo1 = (EditText) findViewById(R.id.edtSo1);
        EditText editTextSo2 = (EditText) findViewById(R.id.edtSo2);
        EditText editTextKQ = (EditText)findViewById(R.id.edtKetQua);

        //Lấy dữ liệu từ 2 điều khiê
        String sothu1 = editTextSo1.getText().toString();
        String sothu2 = editTextSo2.getText().toString();

        //Chuyển đổi dữ liệu tuwf chuỗi sang số
        float a = Float.parseFloat(sothu1);
        float b = Float.parseFloat(sothu2);

        //Tính toán
        float Thuong = a / b;

        //Chuẩn b dữ liệu suất, chuyển tuwf số sang chuỗi
        String chuoiKQ = String.valueOf(Thuong);

        // Gán kết quả lên điều khiển
        editTextKQ.setText(chuoiKQ);
    }
}