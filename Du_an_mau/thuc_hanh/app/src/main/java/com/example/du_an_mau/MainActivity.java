package com.example.du_an_mau;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.example.du_an_mau.DAO.ThuThuDAO;
import com.example.du_an_mau.Fragmant.HomeFrag;
import com.example.du_an_mau.Fragmant.SachFrag;
import com.example.du_an_mau.Fragmant.TheLoaiFrag;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;

    Toolbar toolbar;

    NavigationView nav;

    //khai báo trình quản l

    FragmentManager fm;

    HomeFrag homeFrag;

    SachFrag sachFrag;

    TheLoaiFrag theLoaiFrag;

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

        drawerLayout = findViewById(R.id.main);
        toolbar = findViewById(R.id.toobar);
        nav = findViewById(R.id.nav_drawer);

        Button btntun = findViewById(R.id.btntun);



        // Thêm sự kiện nhấn cho btntun để mở ngăn kéo
        btntun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        //--------khoi tao các giá trị Fragmant
        fm = getSupportFragmentManager();
        homeFrag = new HomeFrag();
        sachFrag = new SachFrag();
        theLoaiFrag = new TheLoaiFrag();

        //hien thi fragmant home
        fm.beginTransaction().add(R.id.frag_container, homeFrag).commit();




        View view = nav.getHeaderView(0);
        TextView tvtitle = view.findViewById(R.id.tv_title_heard);
        //su lý chuyen doi Fragmet
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              //đổi fragmant ở đây
                int idMenu = item.getItemId();
                if(idMenu == R.id.mnu_qsach) {
                    fm.beginTransaction().replace(R.id.frag_container,sachFrag).commit();
                }else {
                    fm.beginTransaction().replace(R.id.frag_container, theLoaiFrag).commit();
                }


                drawerLayout.closeDrawer(GravityCompat.START);
                setTitle(item.getTitle());

                return false;
            }
        });



    }


}