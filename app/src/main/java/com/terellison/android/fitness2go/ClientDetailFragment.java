package com.terellison.android.fitness2go;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

public class ClientDetailFragment extends Fragment {
    private Client mClient;
    private TextView mClientName;
    private TextView mClientPhn;
    private TextView mClientDOB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        UUID clientId = (UUID) getActivity().getIntent()
                .getSerializableExtra(ClientDetailActivity.EXTRA_CLIENT_ID);
        mClient = ClientSingleton.get(getActivity()).getClient(clientId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_client_detail, container, false);

        mClientName = (TextView)v.findViewById(R.id.client_name);
        mClientName.setText(mClient.getClientName());

        mClientPhn = (TextView)v.findViewById(R.id.client_phn);
        mClientPhn.setText(mClient.getClientPhn());

        mClientDOB = (TextView)v.findViewById(R.id.client_dob);
        mClientDOB.setText(mClient.getClientDOB());

        return v;
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
    return true;
    }


}
