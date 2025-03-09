package til.edu.intentlogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Lấy Intent về
        Intent intentTuLogin = getIntent();
        //Lọc ra lấy dữ liệu
        String tenDN_NhanDuoc = intentTuLogin.getStringExtra("ten_dang_nhap");
        //Gán vào điều khiển
        TextView tvTenDN = (TextView)findViewById(R.id.tvUserName);
        tvTenDN.setText(tenDN_NhanDuoc);
    }
}