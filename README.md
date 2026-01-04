# ⌚ DỰ ÁN QUẢN LÝ MUA BÁN ĐỒNG HỒ - HOÀNG ANH APACHE (MySQL)

> **Hệ thống Quản lý Đồng hồ kết nối Cơ sở dữ liệu MySQL thông qua XAMPP.**

## 🌟 Chức năng chi tiết

### 1. Đăng nhập hệ thống
* Người dùng nhập tên tài khoản và mật khẩu để truy cập giao diện chính.
* **Cơ chế thông báo:**
    * Nhập lỗi/sai thông tin: Hệ thống báo lỗi và yêu cầu nhập lại.
    * Đăng nhập đúng: Hiện thông báo thành công và chuyển vào phần mềm.

### 2. Giao diện chính & Quản lý sản phẩm
* **Thông tin người dùng:** Hiển thị tên tài khoản đang đăng nhập trên giao diện.
* **Chức năng quản lý (CRUD):** Thực hiện Thêm, Sửa, Xóa đồng hồ.
* **Bẫy lỗi (Validation):**
    * Cảnh báo khi chưa chọn sản phẩm thao tác.
    * Báo lỗi khi Mã sản phẩm bị trùng.
    * Báo lỗi khi định dạng Ngày/Tháng/Năm không đúng.
* **Thao tác nhanh:** Nhấp đúp (Double-click) vào sản phẩm để chọn mua hàng.

### 3. Tìm kiếm & Thống kê
* **Tìm kiếm:** Lọc sản phẩm theo Tên, Thương hiệu hoặc Tầm giá.
* **Thống kê:** Thống kê dữ liệu theo nhiều tiêu chí lựa chọn khác nhau.

### 4. Mua hàng & Thanh toán
* **Quy trình mua:** Chọn sản phẩm (nhấp đúp) -> Nhập số lượng mua.
* **Kiểm soát kho:** Hệ thống kiểm tra số lượng tồn kho (không cho phép mua vượt quá số lượng hiện có).
* **Hóa đơn:** Điền thông tin cá nhân người mua và chọn hình thức thanh toán.
* **Hình thức thanh toán:**
    * Thanh toán Tiền mặt.
    * Chuyển khoản (Quét mã QR).
* **Hoàn tất:** Hiện thông báo "Mua hàng thành công" sau khi thanh toán.

### 5. Hệ thống & Kết nối
* **Admin:** Xem thông tin liên hệ của Admin.
* **Cơ sở dữ liệu:** Kết nối MySQL thông qua XAMPP.

---

## 📸 Hình ảnh Minh họa

### 🔐 1. Đăng nhập & Giao diện Chính
| Giao diện Đăng nhập | Giao diện Quản lý Chính |
|:---:|:---:|
| <img src="https://github.com/user-attachments/assets/ceddd6b1-09f6-45cd-89e2-3cc2801e9859" width="100%" /> | <img src="https://github.com/user-attachments/assets/f39caa27-e349-4174-ae29-45001119a26c" width="100%" /> |

### 🔍 2. Tìm kiếm & Thống kê
| Chức năng Tìm kiếm | Chức năng Thống kê |
|:---:|:---:|
| <img src="https://github.com/user-attachments/assets/c04a207f-484b-4002-a24c-766a9623f274" width="100%" /> | <img src="https://github.com/user-attachments/assets/031323e3-b933-4aaf-8719-af9a510ce52f" width="100%" /> |

### 🛒 3. Quy trình Mua hàng & Hóa đơn
| Chọn sản phẩm (Double click) | Nhập thông tin Hóa đơn |
|:---:|:---:|
| <img src="https://github.com/user-attachments/assets/54eba2b8-5b2f-4292-b9cb-e59b279fe7ed" width="100%" /> | <img src="https://github.com/user-attachments/assets/3878cd2e-0b3d-4a7e-9d9e-d6f1aa2fdb43" width="100%" /> |

### 💸 4. Thanh toán & Thông báo
| Thanh toán Tiền mặt | Thanh toán Chuyển khoản (QR) | Thông báo Thành công |
|:---:|:---:|:---:|
| <img src="https://github.com/user-attachments/assets/3b181a07-ec17-4f39-80af-01764f5e4897" width="100%" /> | <img src="https://github.com/user-attachments/assets/d630c666-0a3b-4ade-9325-b74124705ad3" width="100%" /> | <img src="https://github.com/user-attachments/assets/f06b57e7-b51c-49ed-acbb-81307a7fcb5b" width="100%" /> |

### ⚙️ 5. Thông tin Admin & Kết nối XAMPP
| Thông tin Admin | Kết nối MySQL (XAMPP) |
|:---:|:---:|
| <img src="https://github.com/user-attachments/assets/72f9a7ba-bb70-40c2-a87a-27ce54a5e6ac" width="100%" /> | <img src="https://github.com/user-attachments/assets/18a49219-1315-446c-b41d-e22097b72dc3" width="100%" /> <br> <img src="https://github.com/user-attachments/assets/0c5fa6a6-3153-4589-b475-feb00478a056" width="100%" /> |

## 👨‍💻 Tác giả

**Hoàng Anh Apache**
* Dự án Quản lý Mua bán Đồng hồ (MySQL Version).
