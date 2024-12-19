package fpoly.chiennvph50713_duanmau.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;



import fpoly.chiennvph50713_duanmau.R;
import fpoly.chiennvph50713_duanmau.adapter.SachAdapter;
import fpoly.chiennvph50713_duanmau.dao.SachDAO;
import fpoly.chiennvph50713_duanmau.model.Sach;


public class QuanlysachFragment extends Fragment {
    RecyclerView recyclerView;
    SachDAO sachDAO;
    ArrayList<Sach> list;
    LinearLayoutManager linearLayoutManager;
    SachAdapter adapter;
    Button btn_themsach;

//   SearchView searchView;
private SearchView searchView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(fpoly.chiennvph50713_duanmau.R.layout.fragment_quanlysach, container, false);
        recyclerView = view.findViewById(R.id.recycler_sach);
        btn_themsach = view.findViewById(R.id.btn_themsach);

        btn_themsach.setOnClickListener(v -> {
            themSach();
        });

        loadData();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    private void themSach() {
        TextInputEditText edt_tensach, edt_giathuesach, edt_tenloaisach,edt_sotrang;
        Button btn_huySach, btn_themSach;
        
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_bottomsheet_themsach, null);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
        
        edt_tensach = view.findViewById(R.id.edt_tensach);
        edt_giathuesach = view.findViewById(R.id.edt_giathue);
        edt_tenloaisach = view.findViewById(R.id.edt_tenloaisach_sach);
        edt_sotrang = view.findViewById(R.id.edt_sotrang);

        btn_themSach = view.findViewById(R.id.btn_themtensach);
        btn_huySach = view.findViewById(R.id.btn_huySach);
        
        btn_themSach.setOnClickListener(v -> {
            String tensach = edt_tensach.getText().toString();
            String giathuesach = edt_giathuesach.getText().toString();
            String maloai = edt_tenloaisach.getText().toString();
            String sotrang = edt_sotrang.getText().toString();
            if (tensach.isEmpty()||giathuesach.isEmpty()||maloai.isEmpty()){
                Toast.makeText(getContext(), "Vui lòng không để trống", Toast.LENGTH_SHORT).show();
            }else {
              boolean check =  sachDAO.addSach(tensach,Integer.parseInt(giathuesach),Integer.parseInt(maloai),sotrang);
              loadData();
              if (check){
                  Toast.makeText(getContext(), "Thêm sách thành công", Toast.LENGTH_SHORT).show();
              } else {
                  Toast.makeText(getContext(), "Thêm sách thất bại", Toast.LENGTH_SHORT).show();
              }
            }
            bottomSheetDialog.dismiss();
        });

        btn_huySach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
            }
        });

    }

    private void loadData() {
        sachDAO = new SachDAO(getContext());
        list = sachDAO.dsSach();
        adapter = new SachAdapter(list, getContext(),sachDAO);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        inflater.inflate(R.menu.menu_search,menu);
//        super.onCreateOptionsMenu(menu, inflater);
//
//        // Lấy item từ SearchView
//        MenuItem searchItem = menu.findItem(R.id.search_thanhvien);
//
//       SearchView searchView = (SearchView) searchItem.getActionView();
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                adapter.getFilter().filter(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return true;
//            }
//        });
//    }

    @SuppressLint("ResourceType")
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
        super.onCreateOptionsMenu(menu, inflater);

        // Lấy item SearchView từ menu
        MenuItem searchItem = menu.findItem(R.id.search_thanhvien);

        searchView = (android.widget.SearchView) searchItem.getActionView();

        // Thiết lập listener cho SearchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Xử lý sự kiện khi người dùng nhấn nút tìm kiếm trên bàn phím
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Xử lý sự kiện khi người dùng nhập/chỉnh sửa nội dung tìm kiếm
//                filterThanhVien(newText);
                adapter.getFilter().filter(newText);
                return true;
            }
        });
    }
}