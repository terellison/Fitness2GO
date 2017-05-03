package com.terellison.android.fitness2go;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import java.util.UUID;

public class ClientDetailActivity extends SingleFragmentActivity {

    public static final String EXTRA_CLIENT_ID =
            "com.terellison.android.fitness2go.client_id";

    public static Intent newIntent(Context packageContext, UUID clientID) {
        Intent intent = new Intent(packageContext, ClientDetailActivity.class);
        intent.putExtra(EXTRA_CLIENT_ID, clientID);
        return intent;
    }
  @Override
  protected Fragment createFragment() {
      return new ClientDetailFragment();
  }
}
