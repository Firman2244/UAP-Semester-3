# Kalkulator Hitung Luas Bangun Datar

Program ini adalah kalkulator untuk menghitung luas berbagai jenis bangun datar, yaitu *Persegi, **Persegi Panjang, dan **Segitiga. Program ini menggunakan **Java Swing* untuk antarmuka grafis (GUI), dan *Apache POI* untuk menyimpan hasil perhitungan ke dalam file Word. Program ini juga memungkinkan pengguna untuk memperbarui atau menghapus entri dalam tabel hasil perhitungan.

## Fitur Utama
- *Menghitung Luas*:
    - Persegi: Menghitung luas persegi berdasarkan panjang sisi.
    - Persegi Panjang: Menghitung luas persegi panjang berdasarkan panjang dan lebar.
    - Segitiga: Menghitung luas segitiga berdasarkan alas dan tinggi.
- *Tabel Hasil Perhitungan*: Hasil perhitungan ditampilkan dalam tabel dengan gambar bangun datar terkait.
- *Penyimpanan Hasil: Hasil perhitungan dapat disimpan dalam file Word menggunakan **Apache POI*.
- *Update dan Hapus*: Memungkinkan pengguna untuk memperbarui atau menghapus hasil perhitungan yang sudah ada.

## Cara Menggunakan

1. *Menghitung Luas*:
    - Klik tombol yang sesuai untuk bangun datar yang ingin dihitung (Persegi, Persegi Panjang, atau Segitiga).
    - Masukkan parameter yang diminta (panjang sisi untuk Persegi, panjang dan lebar untuk Persegi Panjang, alas dan tinggi untuk Segitiga).
    - Klik "Hitung" dan hasil luas akan ditampilkan di tabel.

2. *Tabel Hasil*:
    - Hasil perhitungan akan ditampilkan dalam tabel yang mencakup jenis bangun, parameter yang digunakan, dan hasil perhitungan luas.
    - Gambar bangun datar terkait akan ditampilkan di kolom "Bangun Ruas".

3. *Update dan Hapus*:
    - Untuk memperbarui entri, pilih baris yang ingin diupdate dan klik tombol "Update".
    - Untuk menghapus entri, pilih baris yang ingin dihapus dan klik tombol "Delete".

4. *Menyimpan Hasil*:
    - Setelah perhitungan, hasil akan disimpan dalam file Word. Anda dapat mengunduhnya atau menggunakan file tersebut untuk keperluan lain.

5. *Keluar Aplikasi*:
    - Klik tombol "Keluar" untuk menutup aplikasi.

## Persyaratan Sistem

- *Java Development Kit (JDK)* versi 8 atau lebih tinggi.
- *Apache POI* untuk mengelola file Word (.docx).

## Penggunaan

### Menghitung Luas Bangun Datar
- *Persegi*: Masukkan panjang sisi dan hitung luasnya.
- *Persegi Panjang*: Masukkan panjang dan lebar untuk menghitung luas.
- *Segitiga*: Masukkan alas dan tinggi untuk menghitung luas.

### Update dan Hapus Entri
- Untuk memperbarui atau menghapus data perhitungan, pilih baris yang sesuai di tabel dan gunakan tombol "Update" atau "Delete".

### Menyimpan Hasil
- Setiap hasil perhitungan dapat disimpan dalam file Word untuk dokumentasi lebih lanjut.

## Struktur Proyek

- *src/*: Berisi kode sumber aplikasi.
- *lib/*: Berisi pustaka pihak ketiga, termasuk Apache POI.
- *images/*: Berisi gambar bangun datar yang digunakan dalam aplikasi.

## Contoh Hasil Tabel

| Jenis Bangun     | Parameter          | Luas           | Bangun Ruas |
|------------------|--------------------|----------------|-------------|
| Persegi          | Sisi = 5 cm        | 25 cm²         | ![Persegi](images/persegi.jpg) |
| Persegi Panjang | Panjang = 6 cm, Lebar = 4 cm | 24 cm²         | ![Persegi Panjang](images/persegipanjang.jpg) |
| Segitiga         | Alas = 6 cm, Tinggi = 4 cm  | 12 cm²         | ![Segitiga](images/segitiga.jpg) |