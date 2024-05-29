package com.example.socialmediapostapp;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {

    private CircleImageView imgPick;
    ImageView imgButton;
    TextInputEditText edtName, edtDesignation, edtCompanyName, edtAboutMe, edtContactNo, edtWhatsappNo, edtEmail, edtAddress, edtServices;
    TextInputLayout inputName, inputDesignation, inputCompanyName, inputAboutMe, inputContactNo, inputWhatsappNo, inputEmail, inputAddress, inputServices;
    private Button btnSubmit;
    RadioGroup rgGroup;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //ID Binding
        initBinding();

        //TODO: Topic No (2.2) ImagePicker && CircleAvatar
        ActivityResultLauncher<PickVisualMediaRequest> pickMedia = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), uri -> {
            if (uri != null) {
                this.uri=uri;
                //TODO: Topic No (2.3.1) Glide or Picasso
                Glide
                        .with(HomeActivity.this)
                        .load(uri)
                        .centerCrop()
                        .placeholder(R.drawable.ic_launcher_background)
                        .into(imgPick);

                Log.d("PhotoPicker", "Selected URI: " + uri);
            } else {
                Log.d("PhotoPicker", "No media selected");
            }
        });

        //ImagePicker Click
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickMedia.launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
            }
        });

        //RadioGroup
        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rbYes) {
                    inputWhatsappNo.setVisibility(View.GONE);
                } else {
                    inputWhatsappNo.setVisibility(View.VISIBLE);
                }
            }
        });


        //ButtonSubmit Click
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isaBoolean(edtName)) {
                    inputName.setError("Enter Name");
                    edtName.requestFocus();
                } else if (isaBoolean(edtDesignation)) {
                    inputDesignation.setError("Enter Designation");
                    edtDesignation.requestFocus();
                } else if (isaBoolean(edtCompanyName)) {
                    inputCompanyName.setError("Enter Company Name");
                    edtCompanyName.requestFocus();
                } else if (isaBoolean(edtAboutMe)) {
                    inputAboutMe.setError("Enter AboutMe");
                    edtAboutMe.requestFocus();
                } else if (isaBoolean(edtContactNo)) {
                    inputContactNo.setError("Enter Contact");
                    edtContactNo.requestFocus();
                } else if (isaBoolean(edtEmail)) {
                    inputEmail.setError("Enter Email");
                    edtEmail.requestFocus();
                } else if (isaBoolean(edtAddress)) {
                    inputAddress.setError("Enter Address");
                    edtAddress.requestFocus();
                } else if (isaBoolean(edtServices)) {
                    inputServices.setError("Enter Services");
                    edtServices.requestFocus();
                } else if (uri==null) {
                    Toast.makeText(HomeActivity.this, "Image Select", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent= new Intent(HomeActivity.this,CardActivity.class);
                    intent.putExtra("name",edtName.getText().toString());
                    intent.putExtra("desi",edtDesignation.getText().toString());
                    intent.putExtra("company",edtCompanyName.getText().toString());
                    intent.putExtra("aboutme",edtAboutMe.getText().toString());
                    intent.putExtra("contact",edtContactNo.getText().toString());
                    intent.putExtra("email",edtEmail.getText().toString());
                    intent.putExtra("address",edtAddress.getText().toString());
                    intent.putExtra("services",edtServices.getText().toString());
                    intent.putExtra("img",uri.toString());
                    startActivity(intent);
                }
            }
        });


        //OnBackPress
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                //TODO: Topic No (2.4) Default & Custom Dialog
                defaultExitDialog();
                // customExitDialog();
            }
        });
    }


    private boolean isaBoolean(EditText edt) {
        return edt.getText().toString().trim().isEmpty();
    }

    private void initBinding() {
        imgPick = findViewById(R.id.imgPick);
        imgButton = findViewById(R.id.imgButton);
        edtName = findViewById(R.id.edtName);
        edtDesignation = findViewById(R.id.edtDesignation);
        edtCompanyName = findViewById(R.id.edtCompanyName);
        edtAboutMe = findViewById(R.id.edtAboutMe);
        edtContactNo = findViewById(R.id.edtContactNo);
        edtWhatsappNo = findViewById(R.id.edtWhatsappNo);
        edtEmail = findViewById(R.id.edtEmail);
        edtAddress = findViewById(R.id.edtAddress);
        edtServices = findViewById(R.id.edtServices);


        inputName = findViewById(R.id.inputName);
        inputDesignation = findViewById(R.id.inputDesignation);
        inputCompanyName = findViewById(R.id.inputCompanyName);
        inputAboutMe = findViewById(R.id.inputAboutMe);
        inputContactNo = findViewById(R.id.inputContactNo);
        inputEmail = findViewById(R.id.inputEmail);
        inputAddress = findViewById(R.id.inputAddress);
        inputServices = findViewById(R.id.inputServices);
        inputWhatsappNo = findViewById(R.id.inputWhatsappNo);
        btnSubmit = findViewById(R.id.btnSubmit);
        rgGroup = findViewById(R.id.rgGroup);

    }

    //ExitDialog Code
    void defaultExitDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(HomeActivity.this);
        alertDialog.setTitle("Are you sure to Exit!");
        alertDialog.setMessage(getString(R.string.app_name));
        alertDialog.setPositiveButton("Yes", (dialogInterface, i) -> {
            finish();
        });
        alertDialog.setNegativeButton("No", (dialogInterface, i) -> {
            dialogInterface.dismiss();
        });
        alertDialog.show();
    }

    void customExitDialog() {
        Dialog dialog = new Dialog(HomeActivity.this);
        dialog.setContentView(R.layout.exit_dialog);

        Button btnYes = dialog.findViewById(R.id.btnYes);
        Button btnNo = dialog.findViewById(R.id.btnNo);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }


}