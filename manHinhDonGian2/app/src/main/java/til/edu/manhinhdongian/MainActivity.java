package til.edu.manhinhdongian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button nutMH2;
    Button nutMH3;
    void TimDieuKhien(){
        nutMH2 = (Button)findViewById(R.id.btnMH2);
        nutMH3 = (Button)findViewById(R.id.btnMH3);
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
        //Tìm điều khiển nut bấm
        TimDieuKhien();
        //Gắn bộ lắng nghe suwj kiện
        nutMH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xử lý chuyển màn hình
                //B1. Tạo một Intent 2 tham số: 1) màn hình hiện tại this, 2) màn hình chuyển tới class
                Intent intentMH2 = new Intent(MainActivity.this, MH2Activity.class);

                //B2. Gửi
                startActivity(intentMH2);
            }
        });

        nutMH3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xử lý chuyển màn hình
                //B1. Tạo một Intent 2 tham số: 1) màn hình hiện tại this, 2) màn hình chuyển tới class
                Intent intentMH3 = new Intent(MainActivity.this, MH3Activity.class);

                //B2. Gửi
                startActivity(intentMH3);
            }
        });
    }

}