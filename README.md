1. Màn hình & video chi tiết
   - Ứng dụng bán cafe tìm kiếm, xem chi tiết, thêm vào giỏ hàng, đánh dấu yêu thích, thanh toán và xem lịch sử đơn.
     Có luồng xác thực cơ bản (đăng nhập/đăng ký/đổi mật khẩu), giao diện tối hiện đại, thanh tab mờ
   - Link Video: https://drive.google.com/file/d/1_eUNkkyZp-8tBh3xpUkdZnuBhs8qA1aI/view?usp=drive_link
2. Các tính năng chính
   - Xác thực người dùng: Đăng nhập, đăng ký, đặt lại mật khẩu; lưu userId bằng AsyncStorage; đăng xuất trong Settings.
   - Duyệt danh mục sản phẩm: Trang chủ hiển thị Coffee và Coffee Beans; phân loại theo danh mục; hỗ trợ tìm kiếm theo tên.
   - Chi tiết sản phẩm: Xem mô tả, nguyên liệu, rating; chọn size/giá; kiểm tra trạng thái yêu thích theo người dùng.
   - Yêu thích (Favorites): Thêm/xóa khỏi yêu thích từ trang chi tiết; màn Favourites liệt kê và điều hướng về chi tiết.
   - Giỏ hàng (Cart): Thêm từ Home/Details; tăng/giảm số lượng theo size; xóa sản phẩm (giữ để xóa có xác nhận); tính tổng tiền động.
   - Thanh toán: Chọn phương thức (Credit Card, Google/Apple/Amazon Pay); tạo bản ghi thanh toán; tự động dọn giỏ hàng sau khi thanh toán; hiệu ứng Lottie thành công.
   - Lịch sử đơn hàng: Liệt kê các thanh toán trước đó (số tiền, ngày); nút “Download” kèm hiệu ứng.
   - Thông tin cá nhân: Xem/sửa tên, đổi mật khẩu (kiểm tra mật khẩu cũ, validate đầu vào).
3. Hướng phát triển
   -  Phân chia role Admin, Người bán, Người mua
   -  Tích hợp các cổng thanh toán như Momo/ZaloPay/Mbbank
   -  Tích hợp thêm đặt hàng giao hàng
   -  Tích hợp ưu đãi và những dịch vụ như đánh giá phản hồi
   -  Thông kê
   - Backend
     - Nâng cấp bảo mật với JWT.
     - Trường hợp app chỉ dùng nội bộ (quán cafe → khách quét QR để gọi món) thì có thể giản lược bảo mật.
     - Dữ liệu chuẩn hóa với Swagger để dễ quản lý và tích hợp.
    
