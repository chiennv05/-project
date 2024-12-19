package com.example.asm.test;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.asm.R;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView; // Import TextView
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivityketban extends AppCompatActivity {

    private EditText edtFriendEmail;
    private Button btnAddFriend;
    private RecyclerView rvFriendList;
    private RecyclerView rvRequests;
    private TextView tvFriendCount; // Thêm TextView để hiển thị số lượng bạn bè

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    private FriendAdapter friendAdapter;
    private List<String> friendList;

    private RequestAdapter requestAdapter;
    private List<String> requestList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_activityketban);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtFriendEmail = findViewById(R.id.edtFriendEmail);
        btnAddFriend = findViewById(R.id.btnAddFriend);
        rvFriendList = findViewById(R.id.rvFriendList);
        rvRequests = findViewById(R.id.rvRequests);
        tvFriendCount = findViewById(R.id.tvFriendCount); // Khởi tạo TextView

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        friendList = new ArrayList<>();
        friendAdapter = new FriendAdapter(this, friendList);
        rvFriendList.setLayoutManager(new LinearLayoutManager(this));
        rvFriendList.setAdapter(friendAdapter);

        requestList = new ArrayList<>();
        requestAdapter = new RequestAdapter(this, requestList, this::acceptFriendRequest);
        rvRequests.setLayoutManager(new LinearLayoutManager(this));
        rvRequests.setAdapter(requestAdapter);

        btnAddFriend.setOnClickListener(view -> addFriend());
        getFriendsList();
        getFriendRequests();
    }

    private void addFriend() {
        String email = edtFriendEmail.getText().toString().trim();
        if (!email.isEmpty()) {
            FirebaseUser user = mAuth.getCurrentUser();
            if (user != null) {
                String userId = user.getUid();
                // Lưu yêu cầu kết bạn vào Firestore
                Map<String, Object> request = new HashMap<>();
                request.put("email", email);
                request.put("status", "pending");

                db.collection("friendRequests").document(userId).collection("requests")
                        .document(email).set(request)
                        .addOnSuccessListener(aVoid -> {
                            Toast.makeText(MainActivityketban.this, "Yêu cầu kết bạn đã được gửi", Toast.LENGTH_SHORT).show();
                        })
                        .addOnFailureListener(e -> {
                            Toast.makeText(MainActivityketban.this, "Lỗi khi gửi yêu cầu: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        });
            }
        } else {
            Toast.makeText(MainActivityketban.this, "Vui lòng nhập email", Toast.LENGTH_SHORT).show();
        }
    }

    private void getFriendsList() {
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            String userId = user.getUid();

            db.collection("friends").document(userId).collection("list")
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            friendList.clear();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String friendEmail = document.getString("email");
                                friendList.add(friendEmail);
                            }
                            friendAdapter.notifyDataSetChanged();
                            // Cập nhật số lượng bạn bè
                            tvFriendCount.setText("Số lượng bạn bè: " + friendList.size());
                        } else {
                            Toast.makeText(MainActivityketban.this, "Lỗi khi tải danh sách bạn bè", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    private void getFriendRequests() {
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            String userId = user.getUid();

            db.collection("friendRequests").document(userId).collection("requests")
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            requestList.clear();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String friendEmail = document.getString("email");
                                requestList.add(friendEmail);
                            }
                            requestAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(MainActivityketban.this, "Lỗi khi tải yêu cầu kết bạn", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    private void acceptFriendRequest(String friendEmail) {
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            String userId = user.getUid();

            // Cập nhật yêu cầu kết bạn
            Map<String, Object> requestUpdate = new HashMap<>();
            requestUpdate.put("status", "accepted");

            db.collection("friendRequests").document(userId).collection("requests")
                    .document(friendEmail).update(requestUpdate)
                    .addOnSuccessListener(aVoid -> {
                        // Cập nhật danh sách bạn bè
                        Map<String, Object> friendData = new HashMap<>();
                        friendData.put("email", friendEmail);

                        // Sử dụng SetOptions.merge() để không ghi đè dữ liệu hiện có
                        db.collection("friends").document(userId).collection("list")
                                .document(friendEmail).set(friendData, SetOptions.merge())
                                .addOnSuccessListener(aVoid1 -> {
                                    db.collection("friends").document(friendEmail).collection("list")
                                            .document(userId).set(friendData, SetOptions.merge())
                                            .addOnSuccessListener(aVoid2 -> {
                                                Toast.makeText(MainActivityketban.this, "Đã chấp nhận yêu cầu kết bạn", Toast.LENGTH_SHORT).show();
                                                getFriendsList(); // Cập nhật danh sách bạn bè
                                                getFriendRequests(); // Cập nhật danh sách yêu cầu kết bạn
                                            });
                                });
                    });
        }
    }
}
