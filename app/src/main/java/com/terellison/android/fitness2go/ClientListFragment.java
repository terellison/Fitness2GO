package com.terellison.android.fitness2go;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    public class ClientHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        private Client mClient;
        public TextView mClientNameTextView;
        public TextView mClientPhnTextView;
        public TextView mClientDOBTextView;
        public ImageView mClientPhotoImageView;

        public ClientHolder(View itemView) {
            super(itemView);
            //itemView.setOnClickListener(this);

            mClientNameTextView = (TextView)
                    itemView.findViewById(R.id.list_client_name);
            /*
            mClientPhnTextView = (TextView)
                    itemView.findViewById(R.id.list_client_phn);
            mClientDOBTextView = (TextView)
                    itemView.findViewById(R.id.list_client_dob);
            */
        }

        @Override
        public void onClick(View v) {
            Intent intent = ClientDetailActivity.newIntent(getActivity(), mClient.getUUID());
            startActivity(intent);
        }

        public void bindClient(Client client) {
            mClient = client;
            mClientNameTextView.setText(mClient.getClientName());
            //mClientPhnTextView.setText(mClient.getClientPhn());
            //mClientDOBTextView.setText(mClient.getClientDOB());
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
                    .inflate(R.layout.list_item_client, parent, false);
            return new ClientHolder(view);
        }

        @Override
        public void onBindViewHolder(ClientHolder holder, int position) {
            Client client = mClients.get(position);
            //holder.bindClient(client);
            holder.mClientNameTextView.setText(client.getClientName());
        }

        @Override
        public int getItemCount() {
            return mClients.size();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_add_client) {
            Intent i = new Intent(getActivity(), AddClientActivity.class);
            startActivity(i);
        }
        if (id == R.id.item_log_out) {
            Toast.makeText(getActivity(), R.string.logout_text, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getActivity(), LoginActivity.class);
            startActivity(i);
        }
        return true;
    }
}
