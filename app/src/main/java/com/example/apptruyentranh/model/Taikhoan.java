package com.example.apptruyentranh.model;

public class Taikhoan {
    private int mID;
    private String mTentaikhoan;
    private String mMatkhau;
    private String mGmail;


    public Taikhoan(String mTentaikhoan, String mMatkhau, String mGmail) {
        this.mTentaikhoan = mTentaikhoan;
        this.mMatkhau = mMatkhau;
        this.mGmail = mGmail;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmTentaikhoan() {
        return mTentaikhoan;
    }

    public void setmTentaikhoan(String mTentaikhoan) {
        this.mTentaikhoan = mTentaikhoan;
    }

    public String getmMatkhau() {
        return mMatkhau;
    }

    public void setmMatkhau(String mMatkhau) {
        this.mMatkhau = mMatkhau;
    }

    public String getmGmail() {
        return mGmail;
    }

    public void setmGmail(String mGmail) {
        this.mGmail = mGmail;
    }
}
