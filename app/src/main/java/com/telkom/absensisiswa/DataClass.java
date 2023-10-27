package com.telkom.absensisiswa;

public class DataClass {

    private String dataNama;
    private String dataTanggaldanwaktu;
    private String dataLokasi;
    private String dataKeterangan;
    private String dataImage;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDataNama() {
        return dataNama;
    }

    public String getDataTanggaldanwaktu() {
        return dataTanggaldanwaktu;
    }

    public String getDataLokasi() {
        return dataLokasi;
    }

    public String getDataKeterangan() {
        return dataKeterangan;
    }

    public String getDataImage() {
        return dataImage;
    }

    public DataClass(String dataNama, String dataTanggaldanwaktu, String dataLokasi, String dataKeterangan, String dataImage) {
        this.dataNama = dataNama;
        this.dataTanggaldanwaktu = dataTanggaldanwaktu;
        this.dataLokasi = dataLokasi;
        this.dataKeterangan = dataKeterangan;
        this.dataImage = dataImage;
    }

    public DataClass(){

    }
}
