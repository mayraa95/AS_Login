package com.mayaanugrahsyafira202102344.login;

public class MahasiswaModel
{
    private String NIM;
    private String Nama;

    public
    String getNIM() {
        return NIM;
    }

    public
    void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public
    String getNama() {
        return Nama;
    }

    public
    void setNama(String nama) {
        Nama = nama;
    }

    public
    String getJenisKelamin() {
        return JenisKelamin;
    }

    public
    void setJenisKelamin(String jenisKelamin) {
        JenisKelamin = jenisKelamin;
    }

    public
    String getJP() {
        return JP;
    }

    public
    void setJP(String JP) {
        this.JP = JP;
    }

    private String JenisKelamin;
    private String JP;
}