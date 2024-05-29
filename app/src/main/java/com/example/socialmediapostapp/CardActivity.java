package com.example.socialmediapostapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileOutputStream;

public class CardActivity extends AppCompatActivity {

    String[] imageList = {"https://img.freepik.com/premium-vector/circle-doodle-seamless-vector-pattern-design_687646-505.jpg?size=626&ext=jpg", "https://img.freepik.com/premium-vector/abstract-asian-styled-fish-scales-seamless-pattern-vector-geometric-line-art-print-fabric-paper_490768-369.jpg",};
    private ImageView bgImg, imgLocation, imgPerson, imgEmail, imgCall, imgShare;
    FloatingActionButton btnEdit, btnSave;
    RelativeLayout relative1, mainView;
    private TextView txtName, txtDesignation, txtCompanyName, txtServices, txtAboutMe, txtContact, txtEmail, txtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        //ID Binding
        initBinding();

        //getIntent
        String name = getIntent().getStringExtra("name");
        String desi = getIntent().getStringExtra("desi");
        String company = getIntent().getStringExtra("company");
        String aboutme = getIntent().getStringExtra("aboutme");
        String contact = getIntent().getStringExtra("contact");
        String email = getIntent().getStringExtra("email");
        String address = getIntent().getStringExtra("address");
        String services = getIntent().getStringExtra("services");
        String uri = getIntent().getStringExtra("img");

        txtName.setText(name);
        txtDesignation.setText(desi);
        txtCompanyName.setText(company);
        txtContact.setText(contact);
        txtAboutMe.setText(aboutme);
        txtEmail.setText(email);
        txtAddress.setText(address);
        txtServices.setText(services);
        Glide.with(CardActivity.this).load(uri).centerCrop().into(imgPerson);

        Glide.with(CardActivity.this).load(imageList[0]).centerCrop().into(bgImg);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editDialog();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveImage();
            }
        });

        imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareImage();
            }
        });

    }

    private void initBinding() {
        bgImg = findViewById(R.id.bgImg);
        imgCall = findViewById(R.id.imgCall);
        imgEmail = findViewById(R.id.imgEmail);
        imgPerson = findViewById(R.id.imgPerson);
        imgLocation = findViewById(R.id.imgLocation);
        btnEdit = findViewById(R.id.btnEdit);
        relative1 = findViewById(R.id.relative1);
        relative1.setBackgroundColor(0xff1A237E);
        txtName = findViewById(R.id.txtName);
        txtDesignation = findViewById(R.id.txtDesignation);
        txtCompanyName = findViewById(R.id.txtCompanyName);
        txtAboutMe = findViewById(R.id.txtAboutMe);
        txtContact = findViewById(R.id.txtContact);
        txtEmail = findViewById(R.id.txtEmail);
        txtAddress = findViewById(R.id.txtAddress);
        txtServices = findViewById(R.id.txtServices);
        mainView = findViewById(R.id.mainView);
        btnSave = findViewById(R.id.btnSave);
        imgShare = findViewById(R.id.imgShare);

    }

    private void editDialog() {
        Dialog dialog = new Dialog(CardActivity.this);
        dialog.setContentView(R.layout.edit_dialog_layout);

        LinearLayout color1 = dialog.findViewById(R.id.color1);
        LinearLayout color2 = dialog.findViewById(R.id.color2);
        LinearLayout color3 = dialog.findViewById(R.id.color3);
        LinearLayout color4 = dialog.findViewById(R.id.color4);
        LinearLayout color5 = dialog.findViewById(R.id.color5);
        LinearLayout color6 = dialog.findViewById(R.id.color6);
        LinearLayout color7 = dialog.findViewById(R.id.color7);

        ImageView bgImg1 = dialog.findViewById(R.id.bgImg1);
        ImageView bgImg2 = dialog.findViewById(R.id.bgImg2);
        ImageView bgImg3 = dialog.findViewById(R.id.bgImg3);
        ImageView bgImg4 = dialog.findViewById(R.id.bgImg4);
        ImageView bgImg5 = dialog.findViewById(R.id.bgImg5);
        ImageView bgImg6 = dialog.findViewById(R.id.bgImg6);


        TextView fontStyle1 = dialog.findViewById(R.id.fontStyle1);
        TextView fontStyle2 = dialog.findViewById(R.id.fontStyle2);
        TextView fontStyle3 = dialog.findViewById(R.id.fontStyle3);
        TextView fontStyle4 = dialog.findViewById(R.id.fontStyle4);
        TextView fontStyle5 = dialog.findViewById(R.id.fontStyle5);
        TextView fontStyle6 = dialog.findViewById(R.id.fontStyle6);
        TextView fontStyle7 = dialog.findViewById(R.id.fontStyle7);
        TextView fontStyle8 = dialog.findViewById(R.id.fontStyle8);

        color1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relative1.setBackgroundColor(getColor(R.color.green));
                imgCall.setColorFilter(getColor(R.color.green));
                imgEmail.setColorFilter(getColor(R.color.green));
                imgLocation.setColorFilter(getColor(R.color.green));
            }
        });
        color2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relative1.setBackgroundColor(getColor(R.color.amber));
                imgCall.setColorFilter(getColor(R.color.amber));
                imgEmail.setColorFilter(getColor(R.color.amber));
                imgLocation.setColorFilter(getColor(R.color.amber));
            }
        });
        color3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relative1.setBackgroundColor(getColor(R.color.red));
                imgCall.setColorFilter(getColor(R.color.red));
                imgEmail.setColorFilter(getColor(R.color.red));
                imgLocation.setColorFilter(getColor(R.color.red));
            }
        });
        color4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relative1.setBackgroundColor(getColor(R.color.purple));
                imgCall.setColorFilter(getColor(R.color.purple));
                imgEmail.setColorFilter(getColor(R.color.purple));
                imgLocation.setColorFilter(getColor(R.color.purple));
            }
        });
        color5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relative1.setBackgroundColor(getColor(R.color.pink));
                imgCall.setColorFilter(getColor(R.color.pink));
                imgEmail.setColorFilter(getColor(R.color.pink));
                imgLocation.setColorFilter(getColor(R.color.pink));
            }
        });
        color6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relative1.setBackgroundColor(getColor(R.color.blue));
                imgCall.setColorFilter(getColor(R.color.blue));
                imgEmail.setColorFilter(getColor(R.color.blue));
                imgLocation.setColorFilter(getColor(R.color.blue));
            }
        });
        color7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relative1.setBackgroundColor(getColor(R.color.primaryColor));
                imgCall.setColorFilter(getColor(R.color.primaryColor));
                imgEmail.setColorFilter(getColor(R.color.primaryColor));
                imgLocation.setColorFilter(getColor(R.color.primaryColor));
            }
        });

        bgImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bgImg.setImageDrawable(getDrawable(R.drawable.bg1));
            }
        });
        bgImg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bgImg.setImageDrawable(getDrawable(R.drawable.bg2));
            }
        });
        bgImg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bgImg.setImageDrawable(getDrawable(R.drawable.bg3));
            }
        });
        bgImg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bgImg.setImageDrawable(getDrawable(R.drawable.bg4));
            }
        });
        bgImg5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bgImg.setImageDrawable(getDrawable(R.drawable.bg5));
            }
        });
        bgImg6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bgImg.setImageDrawable(getDrawable(R.drawable.bg6));
            }
        });

        fontStyle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtName.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.poppins));
                txtDesignation.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.poppins));
                txtCompanyName.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.poppins));
            }
        });
        fontStyle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtName.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font1));
                txtDesignation.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font1));
                txtCompanyName.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font1));
            }
        });
        fontStyle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtName.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font2));
                txtDesignation.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font2));
                txtCompanyName.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font2));
            }
        });
        fontStyle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtName.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font3));
                txtDesignation.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font3));
                txtCompanyName.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font3));
            }
        });
        fontStyle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtName.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font4));
                txtDesignation.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font4));
                txtCompanyName.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font4));
            }
        });
        fontStyle6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtName.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font5));
                txtDesignation.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font5));
                txtCompanyName.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font5));
            }
        });
        fontStyle7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtName.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font6));
                txtDesignation.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font6));
                txtCompanyName.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font6));
            }
        });
        fontStyle8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtName.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font7));
                txtDesignation.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font7));
                txtCompanyName.setTypeface(ResourcesCompat.getFont(CardActivity.this, R.font.font7));
            }
        });

        dialog.show();
    }

    //Save Image Code
    void saveImage() {
        mainView.destroyDrawingCache();
        mainView.setDrawingCacheEnabled(true);
        Bitmap bitmap = mainView.getDrawingCache();
        String file = getFilename();
        try {
            FileOutputStream ostream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, ostream);
            ostream.close();
            mainView.invalidate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mainView.setDrawingCacheEnabled(false);
        }
    }

    private String getFilename() {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/DigiCard");
        if (!file.exists()) {
            file.mkdirs();
        }
        String uriSting = (file.getAbsolutePath() + "/"
                + System.currentTimeMillis() + ".jpg");
        return uriSting;
    }


    //Share Image as Bitmap
    void shareImage() {
        mainView.destroyDrawingCache();
        mainView.setDrawingCacheEnabled(true);
        Bitmap bitmap = mainView.getDrawingCache();
        String bitmapPath = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "title", null);
        Uri bitmapUri = Uri.parse(bitmapPath);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/jpeg");
        intent.putExtra(Intent.EXTRA_STREAM, bitmapUri);
        startActivity(Intent.createChooser(intent, "Share Image"));

    }
}