package til.edu.intentlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnXacnhan = (Button)findViewById(R.id.btnOK);

        btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xử lý dữ liệu đăng nhập
                //Lấy dữ liệu
                //B1. Tìm tham chiếu đến DK
                EditText edtTenDN = (EditText)findViewById(R.id.edtUsername);
                EditText edtPass = (EditText)findViewById(R.id.edtPassword);
                //Lâ dữ liệu
                String tenDangnhap = edtTenDN.getText().toString();
                String mk = edtPass.getText().toString();
                //Kiểm tra mật khẩu
                if(tenDangnhap.equals("hatam") && mk.equals("123"))
                {
                    //Chuyển qua màn hình home
                    Intent iQuiz = new Intent(LoginActivity.this, HomeActivity.class);
                    //Gởi dữ liệu vào iQuiz, dạng key-value, key đợc dùng để bên kia lọc ra dữ lệu
                    iQuiz.putExtra("ten_dang_nhap", tenDangnhap);
                    iQuiz.putExtra("mat_khau", mk);

                    //Gửi đi
                    startActivity(iQuiz);
                }
                else{
                    Toast.makeText(LoginActivity.this, "BẠN NHẬP SAI THÔNG TIN", Toast.LENGTH_LONG);
                }
            }
        });
    }
}