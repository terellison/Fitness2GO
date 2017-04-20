package com.terellison.android.fitness2go;

/**
 * Created by Magnuson Hotel on 4/19/2017.
 */

public class Client {

    private String mClientName;
    private String mClientPhn;
    private String mClientAddress;


    public void Client(String mClientName, String mClientPhn, String mClientAddress) {
            mClientName = this.mClientName;
            mClientPhn = this.mClientPhn;
            mClientAddress = this.mClientAddress;
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
}
