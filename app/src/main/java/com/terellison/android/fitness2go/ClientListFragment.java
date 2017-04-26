package com.terellison.android.fitness2go;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Student on 4/26/2017.
 */

public class ClientListFragment extends Fragment {

    private RecyclerView mClientRecyclerView;
    private ClientAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceStae) {
        View view = inflater.inflate(R.layout.fragment_client_list, container, false);

        mClientRecyclerView = (RecyclerView) view.findViewById(R.id.client_recycler_view);
        mClientRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        ClientSingleton clientSingleton = ClientSingleton.get(getActivity());
        List<Client> clients = clientSingleton.getClients();

        mAdapter = new ClientAdapter(clients);
        mClientRecyclerView.setAdapter(mAdapter);
    }

    public class ClientHolder extends RecyclerView.ViewHolder {
        public TextView mClientNameTextView;

        public ClientHolder(View itemView) {
            super(itemView);

            mClientNameTextView = (TextView) itemView;
        }

    }

    private class ClientAdapter extends RecyclerView.Adapter<ClientHolder> {

        private List<Client> mClients;

        public ClientAdapter(List<Client> clients) {
            mClients = clients;
        }


        @Override
        public ClientHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
            return new ClientHolder(view);
        }

        @Override
        public void onBindViewHolder(ClientHolder holder, int position) {
            Client client = mClients.get(position);
            holder.mClientNameTextView.setText(client.getClientName());
        }

        @Override
        public int getItemCount() {
            return mClients.size();
        }
    }
}
