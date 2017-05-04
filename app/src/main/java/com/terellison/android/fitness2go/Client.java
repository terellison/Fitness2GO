package com.terellison.android.fitness2go;

import android.widget.ImageView;

import java.util.UUID;

/**
 * Created by Magnuson Hotel on 4/19/2017.
 */

public class Client {

    private String mClientName;
    private String mClientPhn;
    private String mClientAddress;
    private UUID mId;
    private String mClientDOB;
    private ImageView mClientPhoto;

    public void Client() {
        mId = UUID.randomUUID();
    }



    public void Client(String mClientName, String mClientPhn, String mClientDOB) {
            mClientName = this.mClientName;
            mClientPhn = this.mClientPhn;
            mClientAddress = this.mClientAddress;
            mClientDOB = this.mClientDOB;
            mClientPhoto = this.mClientPhoto;
            mId = UUID.randomUUID();
        }

    public void setClientPhn(String clientPhn) {
        mClientPhn = clientPhn;
    }

    public void setClientAddress(String clientAddress) {
        mClientAddress = clientAddress;
    }

    public String getClientName() {
        return mClientName;
    }

    public String getClientPhn() {
        return mClientPhn;
    }

    public String getClientAddress() {
        return mClientAddress;
    }

    public void setClientName(String clientName) {
        mClientName = clientName;
    }

    public String getClientDOB() {
        return mClientDOB;
    }

    public void setClientDOB(String mClientDOB) {
        this.mClientDOB = mClientDOB;
    }

    public ImageView getmClientPhoto() {
        return mClientPhoto;
    }

    public void setmClientPhoto(ImageView mClientPhoto) {
        this.mClientPhoto = mClientPhoto;
    }

    public UUID getUUID() {
        return mId;
    }
}
