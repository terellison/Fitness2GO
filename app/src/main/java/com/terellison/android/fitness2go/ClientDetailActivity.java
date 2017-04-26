package com.terellison.android.fitness2go;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class ClientDetailActivity extends SingleFragmentActivity {

  @Override
  protected Fragment createFragment() {
      return new ClientDetailFragment();
  }
}
