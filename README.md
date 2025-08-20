# 🧪 Selenium QA Automation Portfolio

Proyek ini adalah **portofolio Automation Testing** menggunakan:
- [Selenium WebDriver](https://www.selenium.dev/)
- [TestNG](https://testng.org/)
- [Extent Report](https://extentreports.com/) untuk reporting
- [Maven](https://maven.apache.org/) sebagai build & dependency management

Demo website yang digunakan: [saucedemo.com](https://www.saucedemo.com/)  
(Studi kasus: **Login** & **Checkout Flow**)

---

📂 Struktur Project
``` 
QA_Automation_Selenium_StudyCase/
├── pom.xml
├── src/test/java/
│ ├── tests/
│ │ ├── BaseTest.java
│ │ ├── LoginTest.java
│ │ └── CheckoutTest.java
├── test-output/
└── ExtentReport.html # Report hasil test
```
---

## 🧾 Studi Kasus 

✅ Login Test

- Valid Login → user standard_user berhasil masuk ke halaman inventory.

- Invalid Login → user salah mendapat pesan error.

🛒 Checkout Flow Test

- Login dengan user standard_user

- Tambah produk ke keranjang

- Isi data checkout

- Selesaikan pesanan → verifikasi pesan "Thank you for your order!"

📊 Reporting (Extent Report)

- Extent Report akan menghasilkan:

- Status Pass / Fail / Skip

- Log detail per test
