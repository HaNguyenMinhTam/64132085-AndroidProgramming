package til.edu.congtrunhanchiaanonymouslisten;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //Khai báo các đối tượng gắn với điều khiển tương ứng
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKetQua;
Button nutCong, nutTru, nutNhan, nutChia;
void TimDieuKhien(){
    editTextSo1 = (EditText)findViewById(R.id.edtSo1);
    editTextSo2 = (EditText)findViewById(R.id.edtSo2);
    editTextKetQua = (EditText)findViewById(R.id.edtKetQua);
    nutCong = (Button)findViewById(R.id.btnCong);
    nutTru = (Button)findViewById(R.id.btnTru);
    nutNhan = (Button)findViewById(R.id.btnNhan);
    nutChia = (Button)findViewById(R.id.btnChia);

}
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
        TimDieuKhien();
        nutCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code xử lý công ở đây
                //Nhập edittext số 1 và 2
                //Lấy dữ liệu từ 2 điều khiển đó
                String sothu1 = editTextSo1.getText().toString();
                String sothu2 = editTextSo2.getText().toString();

                //Chuyển dữ liệu từ chuỗi sang số
                float so1 = Float.parseFloat(sothu1);
                float so2 = Float.parseFloat(sothu2);

                //Tính toán
                float Tong = so1 + so2;

                //Hiện kết quả
                //Tìm edittext KetQua

                //Chuẩn bị dữ liệu xuất, biến thành dạng chuỗi
                String chuoiKetQua = String.valueOf(Tong);

                //Gán kết quả lên điều khiển
                editTextKetQua.setText(chuoiKetQua);
            }
        });
        nutTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code xử lý trừ ở đây
                //Nhập edittext số 1 và 2
                //Lấy dữ liệu từ 2 điều khiển đó
                String sothu1 = editTextSo1.getText().toString();
                String sothu2 = editTextSo2.getText().toString();
                //Chuyển dữ liệu từ chuỗi sang số
                float so1 = Float.parseFloat(sothu1);
                float so2 = Float.parseFloat(sothu2);
                //Tính toán
                float Tong = so1 - so2;
                //Hiện kết quả
                //Tìm edittext KetQua
                //Chuẩn bị dữ liệu xuất, biến thành dạng chuỗi
                String chuoiKetQua = String.valueOf(Tong);

                //Gán kết quả lên điều khiển
                editTextKetQua.setText(chuoiKetQua);

            }
        });
        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xu lý nhan ơ day
//Code xử lý nhân ở đây
                //Nhập edittext số 1 và 2


                //Lấy dữ liệu từ 2 điều khiển đó
                String sothu1 = editTextSo1.getText().toString();
                String sothu2 = editTextSo2.getText().toString();

                //Chuyển dữ liệu từ chuỗi sang số
                float so1 = Float.parseFloat(sothu1);
                float so2 = Float.parseFloat(sothu2);

                //Tính toán
                float Tong = so1 * so2;

                //Hiện kết quả
                //Tìm edittext KetQua


                //Chuẩn bị dữ liệu xuất, biến thành dạng chuỗi
                String chuoiKetQua = String.valueOf(Tong);

                //Gán kết quả lên điều khiển
                editTextKetQua.setText(chuoiKetQua);
            }
        });
        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xu ly chia ở đây
//Code xử lý chia ở đây
                //Nhập edittext số 1 và 2


                //Lấy dữ liệu từ 2 điều khiển đó
                String sothu1 = editTextSo1.getText().toString();
                String sothu2 = editTextSo2.getText().toString();

                //Chuyển dữ liệu từ chuỗi sang số
                float so1 = Float.parseFloat(sothu1);
                float so2 = Float.parseFloat(sothu2);

                //Tính toán
                float Tong = so1 / so2;

                //Hiện kết quả
                //Tìm edittext KetQua


                //Chuẩn bị dữ liệu xuất, biến thành dạng chuỗi
                String chuoiKetQua = String.valueOf(Tong);

                //Gán kết quả lên điều khiển
                editTextKetQua.setText(chuoiKetQua);
            }
        });
    }
}