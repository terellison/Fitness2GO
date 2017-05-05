package com.terellison.android.fitness2go;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class AddClientActivity extends AppCompatActivity {

    private Button mAddClientButton;
    private EditText mAddClientName;
    private EditText mAddClientPhn;
    private EditText mAddClientDOB;
    private ImageButton mPhotoButton;
    private ImageView mPhotoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);

        mAddClientName = (EditText)findViewById(R.id.add_client_name);
        mAddClientPhn = (EditText)findViewById(R.id.add_client_phn);
        mAddClientDOB = (EditText)findViewById(R.id.add_client_dob);

        final ClientSingleton clientSingleton = ClientSingleton.get(AddClientActivity.this);

        mAddClientButton = (Button)findViewById(R.id.add_client_button);
        mAddClientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //retrieve values
                clientSingleton.AddClient(mAddClientName.getText().toString(),
                        mAddClientPhn.getText().toString(),
                        mAddClientDOB.getText().toString());
            }
        });
        mPhotoButton = (ImageButton)findViewById(R.id.client_camera);
        mPhotoView = (ImageView)findViewById(R.id.client_photo);
    }
}
