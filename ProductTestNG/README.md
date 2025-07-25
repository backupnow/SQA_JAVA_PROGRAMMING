
---

## 📊 Insight & Report ProductTestNG

**Sheet 1 – Summary**

| Parameter       | Sekuensial | Paralel  |
|-----------------|------------|----------|
| Jumlah Test     | 5          | 5        |
| Thread Count    | 1          | 4        |
| Total Time (s)  | 7.004      | 9.329    |
| Status          | SUCCESS    | SUCCESS  |
| Avg Durasi/Test | ~1.469 s   | ~1.442 s |

**Sheet 2 – Detail Durasi per Method**

| Method                       | Durasi 29ms Suite | Durasi 85ms Suite |
|------------------------------|-------------------|-------------------|
| testTambahProdukKeKeranjang  | 2 ms              | 5 ms              |
| testHapusProdukDariKeranjang | 16 ms             | 20 ms             |
| testKeranjangKosong          | 5 ms              | 20 ms             |
| testHargaNegatif             | 3 ms              | 20 ms             |
| testSetPriceInvalid          | 3 ms              | 20 ms             |

**Sheet 3 – Insight**

- Eksekusi paralel lebih efisien jika test-case independen.
- Durasi antar method bisa berubah tergantung beban sistem.
- Sekuensial cocok untuk pengujian kecil dan linear, mudah dianalisis dan hemat resource.
- Paralel cocok untuk pengujian kompleks atau banyak test case, 
  meskipun ada sedikit overhead sinkronisasi antar-thread.