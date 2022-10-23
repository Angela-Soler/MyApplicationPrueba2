package com.finsol.myapplicationprueba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityPhoto extends AppCompatActivity {

    //Declaracion de variables
    static final int peticion_captura_imagen = 100;
    static final int peticion_acceso_camara = 201;

    ImageView objetoImagen;
    Button btntakepotho;
    String pathImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        objetoImagen = findViewById(R.id.imageView);
        btntakepotho = findViewById(R.id.btntakephoto);

        btntakepotho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                permisos();
            }
        });
    }

    private void permisos() {
        //Validar si el permiso está otorgado para tomar foto
        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            //Otorgar el permiso si no se tiene
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, peticion_acceso_camara);
        }
        else{
            //tomarFoto();
            TakePhotoDir();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == peticion_acceso_camara){
            if (grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
            {
                //tomarFoto();
                TakePhotoDir();
            }
        }
    }

    private void tomarFoto() {
        Intent intentFoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (intentFoto.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intentFoto, peticion_captura_imagen);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /*if (requestCode == peticion_captura_imagen)
        {
            Bundle extras = data.getExtras();
            Bitmap imagen = (Bitmap) extras.get("data");
            objetoImagen.setImageBitmap(imagen);

        }*/
        if (requestCode == peticion_captura_imagen && resultCode == RESULT_OK)
        {
            File foto = new File(pathImage);
            objetoImagen.setImageURI(Uri.fromFile(foto));

        }

    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName, /* prefix */
                ".jpg", /* suffix */
                storageDir /* directory */);
        // Save a file: path for use with ACTION_VIEW intents
        pathImage = image.getAbsolutePath();
        Log.i("FOTO", pathImage.toString());

        return image;
    }

    private void TakePhotoDir()
    {
        Intent Intenttakephoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(Intenttakephoto.resolveActivity(getPackageManager())!= null)
        {
            File foto  = null;

        try
        {
            foto = createImageFile();
        }catch (Exception ex)
        {
            ex.toString();
        }
        if(foto != null)
        {
            Uri fotoUri = FileProvider.getUriForFile(this, "com.finsol.myapplicationprueba.fileprovider",foto);
            Intenttakephoto.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri);
            startActivityForResult(Intenttakephoto, peticion_captura_imagen);
        }
    }
    }
}