package com.forcom.holoediting.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.createchance.imageeditor.utils.Logger;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IImagePickerLister {
    private static final int PICK_IMAGE_GALLERY_REQUEST_CODE = 609;
    private static final int REQUEST_CHOOSE_IMAGE_FOR_VIDEO = 3;
    private static final int REQUEST_CODE_VIDEO_GENERATE = 6;
    TextView tv_generate_video;
    private String TAG = "MainActivity";
    private static final int REQUEST_CODE_PERMISSION = 4;
    private String currentPhotoPath = "";
    public static final int STORAGE_REQUEST_CODE = 613;
    public static final int CAMERA_STORAGE_REQUEST_CODE = 611;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_generate_video = findViewById(R.id.tv_generate_video);
        tv_generate_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                chooseImages(REQUEST_CHOOSE_IMAGE_FOR_VIDEO, 100);
                if (checkStoragePermissions(MainActivity.this)) {
                    showImagePickerDialog(MainActivity.this, MainActivity.this);
                }
                else {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            11111);
                }

            }
        });

        // request permissions
//        if (ContextCompat.checkSelfPermission(this,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED ||
//                ContextCompat.checkSelfPermission(this,
//                        Manifest.permission.READ_EXTERNAL_STORAGE)
//                        != PackageManager.PERMISSION_GRANTED ||
//                ContextCompat.checkSelfPermission(this,
//                        Manifest.permission.CAMERA)
//                        != PackageManager.PERMISSION_GRANTED) {
            // No explanation needed; request the permission
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                            Manifest.permission.READ_EXTERNAL_STORAGE,
//                            Manifest.permission.CAMERA},
//                    REQUEST_CODE_PERMISSION);
//        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {

//            case 11111:
//                if (grantResults.length > 0 && permissions[0].equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                    // check whether storage permission granted or not.
//                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                        //do what you want;
//                        showImagePickerDialog(MainActivity.this, MainActivity.this);
//                        Toast.makeText(this, "Hiếu", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//
//
//                break;
            case REQUEST_CODE_PERMISSION:
                if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED ||
                        ContextCompat.checkSelfPermission(this,
                                Manifest.permission.READ_EXTERNAL_STORAGE)
                                != PackageManager.PERMISSION_GRANTED ||
                        ContextCompat.checkSelfPermission(this,
                                Manifest.permission.CAMERA)
                                != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "We need permissions to work！", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
                if (requestCode == CAMERA_STORAGE_REQUEST_CODE && grantResults.length == 2) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                        shouldShowPermissionSettingPage("A",this);
                    }

                    else if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_DENIED) {
                        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                            shouldShowPermissionSettingPage("A",this);
                        } else {
                            shouldShowPermissionSettingPage("A",this);
                        }
                    } else if (grantResults[0] == PackageManager.PERMISSION_DENIED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                            shouldShowPermissionSettingPage("A",this);
                        } else {
                            shouldShowPermissionSettingPage("A",this);
                        }
                    } else {
                        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA) ||
                                !ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                            shouldShowPermissionSettingPage("A",this);
                        } else {
                            shouldShowPermissionSettingPage("A",this);
                        }
                    }
                } else if (requestCode == STORAGE_REQUEST_CODE) {
                    if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                        openImagesDocument();
                    else {
                        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                            shouldShowPermissionSettingPage("A",this);
                        } else {
                            shouldShowPermissionSettingPage("A",this);
                        }
                    }
                }
                break;
        }
    }

    public static void showImagePickerDialog(@NonNull Context callingClassContext, final IImagePickerLister imagePickerLister) {
        new MaterialDialog.Builder(callingClassContext)
                .items(R.array.imagePicker)
                .canceledOnTouchOutside(true)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View itemView, int position, CharSequence text) {
                        if (position == 0)
                            imagePickerLister.onOptionSelected(ImagePickerEnum.FROM_GALLERY);
                        else if (position == 1)
                            imagePickerLister.onOptionSelected(ImagePickerEnum.FROM_CAMERA);
                        dialog.dismiss();
                    }
                }).show();
    }

    private void chooseImages(int requestCode, int maxCount) {
        Matisse.from(MainActivity.this)
                .choose(MimeType.of(MimeType.JPEG, MimeType.PNG))
                .countable(true)
                .maxSelectable(maxCount)
                .gridExpectedSize(getResources()
                        .getDimensionPixelSize(R.dimen.grid_expected_size))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .theme(R.style.Matisse_Dracula)
                .thumbnailScale(0.85f)
                .imageEngine(new GlideEngine())
                .forResult(requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case PICK_IMAGE_GALLERY_REQUEST_CODE:
                if (data != null) {

                    try {
                        Uri sourceUri = data.getData();
                        File file = getImageFile();
                        Uri destinationUri = Uri.fromFile(file);
                        Bitmap mBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                        VideoGenerateActivity.start(this, REQUEST_CODE_VIDEO_GENERATE, destinationUri.getPath(), mBitmap);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

//                    List<String> mediaPathList = Matisse.obtainPathResult(data);
//                    Logger.d(TAG, "onActivityResult: " + mediaPathList);
//                    VideoGenerateActivity.start(this, REQUEST_CODE_VIDEO_GENERATE, mediaPathList);
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }

    private File getImageFile() throws IOException {
        String imageFileName = "JPEG_" + System.currentTimeMillis() + "_";
        File storageDir = new File(
                Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DCIM
                ), "Camera"
        );
//        System.out.println(storageDir.getAbsolutePath());
        if (storageDir.exists()){
            storageDir.mkdirs();
            System.out.println("File exists");
        }

//        else
//            System.out.println("File not exists");
            File file = File.createTempFile(imageFileName, "lll", this.getCacheDir());
        currentPhotoPath = "file:" + file.getAbsolutePath();
        return file;
    }

    private void openImagesDocument() {
        Intent pictureIntent = new Intent(Intent.ACTION_GET_CONTENT);
        pictureIntent.setType("image/*");
        pictureIntent.addCategory(Intent.CATEGORY_OPENABLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            String[] mimeTypes = new String[]{"image/jpeg", "image/png"};
            pictureIntent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
        }
        startActivityForResult(Intent.createChooser(pictureIntent, "Select Picture"), PICK_IMAGE_GALLERY_REQUEST_CODE);
    }

    @Override
    public void onOptionSelected(ImagePickerEnum imagePickerEnum) {
        if (imagePickerEnum == ImagePickerEnum.FROM_GALLERY && checkStoragePermissions(this))
            openImagesDocument();
    }

    public static boolean checkStoragePermissions(@NonNull Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_REQUEST_CODE);
            return false;
        }
        return true;

    }
    public static void shouldShowPermissionSettingPage(String title, final Activity activity) {
        AlertDialog alertDialog = new AlertDialog.Builder(activity)
                .setTitle(title)
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setMessage("Permission")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        openAppPermissionPage(activity);
                    }
                })
                .create();
        alertDialog.show();
    }

    public static void openAppPermissionPage(Context context) {
        final Intent i = new Intent();
        i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        i.addCategory(Intent.CATEGORY_DEFAULT);
        i.setData(Uri.parse("package:" + context.getPackageName()));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        context.startActivity(i);
    }
}


