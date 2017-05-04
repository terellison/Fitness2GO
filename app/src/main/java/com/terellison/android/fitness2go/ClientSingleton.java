package com.terellison.android.fitness2go;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Student on 4/26/2017.
 */

public class ClientSingleton {
    private static ClientSingleton sClientSingleton;
    private List<Client> mClients;

    public static ClientSingleton get(Context context) {

        if (sClientSingleton == null) {
            sClientSingleton = new ClientSingleton(context);
        }
        return sClientSingleton;
    }

    private ClientSingleton(Context context) {
        mClients = new ArrayList<>();
        for (int i =0; i < 100; i++) {
            Client client = new Client();
            client.setClientName("Client #" + i);
            client.setClientPhn("" + (i * 1000000000));
            client.setClientAddress((i * 100) + " Claremont Ave");
            mClients.add(client);
        }
    }

    public List<Client> getClients() {
        return mClients;
    }

    public Client getClient(UUID id) {
        for (Client client : mClients) {
            if (client.getUUID().equals(id)) {
                return client;
            }
        }
        return null;
    }

    public void AddClient(String mClientName, String mClientPhn, String mClientDOB){
        Client client = new Client();
        client.setClientName(mClientName);
        client.setClientPhn(mClientPhn);
        client.setClientDOB(mClientDOB);
        mClients.add(client);

    }
}