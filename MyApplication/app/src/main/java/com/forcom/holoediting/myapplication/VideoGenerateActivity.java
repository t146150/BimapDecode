package com.forcom.holoediting.myapplication;

//import com.forcom.holoediting.myapplication.transitions.AbstractTransition;
//import com.forcom.holoediting.myapplication.transitions.AngularTransition;
//import com.forcom.holoediting.myapplication.transitions.BounceTransition;
//import com.forcom.holoediting.myapplication.transitions.BowTieHorizontalTransition;
//import com.forcom.holoediting.myapplication.transitions.BowTieVerticalTransition;
//import com.forcom.holoediting.myapplication.transitions.BurnTransition;
//import com.forcom.holoediting.myapplication.transitions.ButterflyWaveScrawlerTransition;
//import com.forcom.holoediting.myapplication.transitions.CannabisLeafTransition;
//import com.forcom.holoediting.myapplication.transitions.CircleCropTransition;
//import com.forcom.holoediting.myapplication.transitions.CircleOpenTransition;
//import com.forcom.holoediting.myapplication.transitions.CircleTransition;
//import com.forcom.holoediting.myapplication.transitions.ColorDistanceTransition;
//import com.forcom.holoediting.myapplication.transitions.ColorPhaseTransition;
//import com.forcom.holoediting.myapplication.transitions.CrazyParametricFunTransition;
//import com.forcom.holoediting.myapplication.transitions.CrossHatchTransition;
//import com.forcom.holoediting.myapplication.transitions.CrossWarpTransition;
//import com.forcom.holoediting.myapplication.transitions.CrossZoomTransition;
//import com.forcom.holoediting.myapplication.transitions.CubeTransition;
//import com.forcom.holoediting.myapplication.transitions.DirectionalTransition;
//import com.forcom.holoediting.myapplication.transitions.DirectionalWarpTransition;
//import com.forcom.holoediting.myapplication.transitions.DirectionalWipeTransition;
//import com.forcom.holoediting.myapplication.transitions.DoomScreenTransition;
//import com.forcom.holoediting.myapplication.transitions.DoorWayTransition;
//import com.forcom.holoediting.myapplication.transitions.DreamyTransition;
//import com.forcom.holoediting.myapplication.transitions.DreamyZoomTransition;
//import com.forcom.holoediting.myapplication.transitions.FadeColorTransition;
//import com.forcom.holoediting.myapplication.transitions.FadeGrayScaleTransition;
//import com.forcom.holoediting.myapplication.transitions.FadeTransition;
//import com.forcom.holoediting.myapplication.transitions.FlyEyeTransition;
//import com.forcom.holoediting.myapplication.transitions.GlitchDisplaceTransition;
//import com.forcom.holoediting.myapplication.transitions.GlitchMemoriesTransition;
//import com.forcom.holoediting.myapplication.transitions.GridFlipTransition;
//import com.forcom.holoediting.myapplication.transitions.HeartTransition;
//import com.forcom.holoediting.myapplication.transitions.HexagonalTransition;
//import com.forcom.holoediting.myapplication.transitions.InvertedPageCurlTransition;
//import com.forcom.holoediting.myapplication.transitions.KaleidoScopeTransition;
//import com.forcom.holoediting.myapplication.transitions.LinearBlurTransition;
//import com.forcom.holoediting.myapplication.transitions.LuminanceMeltTransition;
//import com.forcom.holoediting.myapplication.transitions.MorphTransition;
//import com.forcom.holoediting.myapplication.transitions.MosaicTransition;
//import com.forcom.holoediting.myapplication.transitions.MultiplyBlendTransition;
//import com.forcom.holoediting.myapplication.transitions.PerlinTransition;
//import com.forcom.holoediting.myapplication.transitions.PinWheelTransition;
//import com.forcom.holoediting.myapplication.transitions.PixelizeTransition;
//import com.forcom.holoediting.myapplication.transitions.PolarFunctionTransition;
//import com.forcom.holoediting.myapplication.transitions.PolkaDotsCurtainTransition;
//import com.forcom.holoediting.myapplication.transitions.RadialTransition;
//import com.forcom.holoediting.myapplication.transitions.RandomSquaresTransition;
//import com.forcom.holoediting.myapplication.transitions.RippleTransition;
//import com.forcom.holoediting.myapplication.transitions.RotateScaleFadeTransition;
//import com.forcom.holoediting.myapplication.transitions.SimpleZoomTransition;
//import com.forcom.holoediting.myapplication.transitions.SquaresWireTransition;
//import com.forcom.holoediting.myapplication.transitions.SqueezeTransition;
//import com.forcom.holoediting.myapplication.transitions.StereoViewerTransition;
//import com.forcom.holoediting.myapplication.transitions.SwapTransition;
//import com.forcom.holoediting.myapplication.transitions.SwirlTransition;
//import com.forcom.holoediting.myapplication.transitions.UndulatingBurnOutTransition;
//import com.forcom.holoediting.myapplication.transitions.WaterDropTransition;
//import com.forcom.holoediting.myapplication.transitions.WindTransition;
//import com.forcom.holoediting.myapplication.transitions.WindowBlindsTransition;
//import com.forcom.holoediting.myapplication.transitions.WindowSliceTransition;
//import com.forcom.holoediting.myapplication.transitions.WipeDownTransition;
//import com.forcom.holoediting.myapplication.transitions.WipeLeftTransition;
//import com.forcom.holoediting.myapplication.transitions.WipeRightTransition;
//import com.forcom.holoediting.myapplication.transitions.WipeUpTransition;
//import com.forcom.holoediting.myapplication.transitions.ZoomInCirclesTransition;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.createchance.imageeditor.IEManager;
import com.createchance.imageeditor.IEPreviewView;
import com.createchance.imageeditor.transitions.AbstractTransition;
import com.createchance.imageeditor.utils.Logger;
import com.forcom.holoediting.myapplication.model.Transition;
import com.forcom.holoediting.myapplication.utils.AssetsUtil;
import com.forcom.holoediting.myapplication.utils.DensityUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VideoGenerateActivity extends AppCompatActivity implements View.OnClickListener {
    private String mImagePathList;
    private Bitmap mBitmap;
    private static String TAG = "VideoGenerateActivity";
    private long mTotalDuration;
    // views
    private IEPreviewView mVwPreview;
    private ImageView mIvPlayControl;
    private TextView mTvCurBgmFile, mTvTime, mTvTransition;
    private HorizontalThumbnailListView mVwThumbnailList;
    private int mCurClipIndex = 0;
    private TransitionSelectWindow mVwTransitionSelect;
    private List<Transition> mTransitionList;
    private static boolean mIsStarted;
    private static final String EXTRA_IMAGE_PATH_LIST = "image path list";
    private static final String EXTRA_IMAGE_BITMAP = "mBitmap";
    @Override
    public void onClick(View view) {

    }

    private HorizontalThumbnailListView.ImageGroupListener mImageGroupListener = new HorizontalThumbnailListView.ImageGroupListener() {
        @Override
        public void onImageGroupProcess(int index, float progress, boolean isFromUser) {
            super.onImageGroupProcess(index, progress, isFromUser);

            mCurClipIndex = index;

            Log.d(TAG, "onImageGroupProcess: " + index + ", progress: " + progress + ", is from user: " + isFromUser);
            long position = (long) (progress * mTotalDuration);
            IEManager.getInstance().seek((long) (IEManager.getInstance().getTotalDuration() * progress));
            mTvTime.setText(String.format(Locale.getDefault(), "%02d:%02d", position / (60 * 1000), (position / 1000) % 60));
            mTvTransition.setText(mVwThumbnailList.getCurImageGroup().getStringExtra());

        }

        @Override
        public void onImageGroupClicked(int index) {
            super.onImageGroupClicked(index);
            Logger.d(TAG, "onImageGroupClicked, index: " + index);
            showTransitionSelection();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_generate);
//        mImagePathList = new ArrayList<>();
//        mImagePathList.add("/storage/emulated/0/DCIM/Camera/IMG_20190928_100835.jpg");
//        mImagePathList.add("/storage/emulated/0/DCIM/Camera/IMG_20190928_100835.jpg");

        Intent intent = getIntent();
        if (intent != null) {
            mImagePathList = intent.getStringExtra(EXTRA_IMAGE_PATH_LIST).replace("file:/", "file://");
            mBitmap = intent.getParcelableExtra(EXTRA_IMAGE_BITMAP);
        }

        if (mImagePathList == null ) {
            Logger.e(TAG, "Image path list can not be null or empty!");
            Toast.makeText(this, "Start failed!", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
//        mImagePathList = mImagePathList.replace("file:/", "file://");
        // for debug
//        for (String path : mImagePathList) {
//            Logger.d(TAG, "Image path: " + path);
//        }
        initClipList();
        findViewById(R.id.btn_cancel).setOnClickListener(this);
        findViewById(R.id.btn_done).setOnClickListener(this);
        mVwPreview = findViewById(R.id.vw_preview);
        mIvPlayControl = findViewById(R.id.iv_play_control);
        mIvPlayControl.setOnClickListener(this);
        mVwThumbnailList = findViewById(R.id.vw_thumbnail_list);
        mTvCurBgmFile = findViewById(R.id.tv_current_bgm_file);
        mTvTime = findViewById(R.id.tv_time);
        mTvTransition = findViewById(R.id.tv_transition);
        findViewById(R.id.btn_add_bgm).setOnClickListener(this);
        findViewById(R.id.btn_edit_bgm).setOnClickListener(this);
        findViewById(R.id.btn_delete_bgm).setOnClickListener(this);
        findViewById(R.id.btn_edit_bgm).setEnabled(false);
        findViewById(R.id.btn_delete_bgm).setEnabled(false);

        initThumbnailList();
        initTransitionList();
        // init IE
        IEManager.getInstance().startEngine();
        IEManager.getInstance().attachPreview(mVwPreview);
    }

    private void initClipList() {
//        for (int i = 0; i < mImagePathList.size(); i++) {
//            IEManager.getInstance().addClip(mImagePathList.get(i), 3000);
//            mTotalDuration += 3000;
//        }
//        Uri uri = Uri.parse("android.resource://" + BuildConfig.APPLICATION_ID + "/" + R.drawable.hinh);
        IEManager.getInstance().addClip(mImagePathList, 3000);
        mTotalDuration += 3000;
    }


    private void initThumbnailList() {
        int imageSize = DensityUtil.dip2px(this, 40);
        int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
        int groupPadding = DensityUtil.dip2px(this, 8);
        mVwThumbnailList.setImageHeight(imageSize);
        mVwThumbnailList.setImageWidth(imageSize);
        mVwThumbnailList.setStartPaddingWidth(screenWidth / 2 - groupPadding);
        mVwThumbnailList.setEndPaddingWidth(screenWidth / 2 - groupPadding);
        mVwThumbnailList.setGroupPaddingWidth(groupPadding);
        mVwThumbnailList.setPaddingVerticalHeight(DensityUtil.dip2px(this, 2));
        mVwThumbnailList.setSelectedGroupBg(getResources().getDrawable(R.drawable.shape_solid_white_corner_10));
        mVwThumbnailList.setImageGroupListener(mImageGroupListener);
        // todo: one thumbnail stands for 1000ms default.
//        Uri uri=Uri.parse(mImagePathList + ".jpg");
//
//        InputStream imageStream = null;
//        try {
//            imageStream = getContentResolver().openInputStream(uri);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        Bitmap bm = BitmapFactory.decodeStream(imageStream);
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//
//        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the mBitmap object
//
//        byte[] decodedBytes = baos.toByteArray();

//        Bitmap img_captured_image = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(mImagePathList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        Bitmap yourSelectedImage =BitmapFactory.decodeStream(fis);
//            Bitmap mBitmap = BitmapFactory.decodeFile(mImagePathList);
            List<HorizontalThumbnailListView.ImageItem> imageItemList = new ArrayList<>();
            imageItemList.add(new HorizontalThumbnailListView.ImageItem(mBitmap, imageSize, 0, imageSize));
            imageItemList.add(new HorizontalThumbnailListView.ImageItem(mBitmap, imageSize, 0, imageSize));
            imageItemList.add(new HorizontalThumbnailListView.ImageItem(mBitmap, imageSize, 0, imageSize));
            mVwThumbnailList.newImageGroup(imageItemList);


//        }
    }

    private void initTransitionList() {
        mTransitionList = AssetsUtil.parseJsonToList(this, "transitions/transition_list.json", Transition.class);
    }

    private void showTransitionSelection() {
        if (mVwTransitionSelect == null) {
            mVwTransitionSelect = new TransitionSelectWindow(this, mTransitionList,
                    new TransitionSelectWindow.TransitionSelectListener() {
                        @Override
                        public void onTransitionSelected(Transition transition) {
                            Logger.d(TAG, "Transition selected: " + transition);

                            IEManager.getInstance().setTransition(mCurClipIndex, getTransitionById(transition.mId), 2000, false);
                            mVwThumbnailList.getCurImageGroup().setStringExtra(transition.mName);
                            mTvTransition.setText(transition.mName);
                        }

                        @Override
                        public void onTransitionDeleted() {
                            Logger.d(TAG, "Transition deleted.");

                            IEManager.getInstance().removeTransition(mCurClipIndex, false);
                            mVwThumbnailList.getCurImageGroup().setStringExtra(null);
                            mTvTransition.setText(null);
                            Toast.makeText(VideoGenerateActivity.this, "Transition deleted!", Toast.LENGTH_SHORT).show();
                        }
                    });
            mVwTransitionSelect.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    WindowManager.LayoutParams lp = getWindow().getAttributes();
                    lp.alpha = 1f;
                    getWindow().setAttributes(lp);
                }
            });
        }
        mVwTransitionSelect.showAtLocation(findViewById(R.id.vw_root),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        // set dark background color.
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.7f;
        getWindow().setAttributes(lp);
    }

    private AbstractTransition getTransitionById(int id) {
        AbstractTransition transition = null;
//
//        switch (id) {
//            case 0:
//                transition = new WindowSliceTransition();
//                break;
//            case 1:
//                transition = new InvertedPageCurlTransition();
//                break;
//            case 2:
//                transition = new AngularTransition();
//                break;
//            case 3:
//                transition = new BounceTransition();
//                break;
//            case 4:
//                transition = new BowTieHorizontalTransition();
//                break;
//            case 5:
//                transition = new BowTieVerticalTransition();
//                break;
//            case 6:
//                transition = new BurnTransition();
//                break;
//            case 7:
//                transition = new ButterflyWaveScrawlerTransition();
//                break;
//            case 8:
//                transition = new CannabisLeafTransition();
//                break;
//            case 9:
//                transition = new CircleTransition();
//                break;
//            case 10:
//                transition = new CircleCropTransition();
//                break;
//            case 11:
//                transition = new CircleOpenTransition();
//                break;
//            case 12:
//                transition = new ColorPhaseTransition();
//                break;
//            case 13:
//                transition = new ColorDistanceTransition();
//                break;
//            case 14:
//                transition = new CrazyParametricFunTransition();
//                break;
//            case 15:
//                transition = new CrossHatchTransition();
//                break;
//            case 16:
//                transition = new CrossWarpTransition();
//                break;
//            case 17:
//                transition = new CrossZoomTransition();
//                break;
//            case 18:
//                transition = new CubeTransition();
//                break;
//            case 19:
//                transition = new DirectionalTransition();
//                break;
//            case 20:
//                transition = new DirectionalWarpTransition();
//                break;
//            case 21:
//                transition = new DirectionalWipeTransition();
//                break;
//            case 22:
//                transition = new DoomScreenTransition();
//                break;
//            case 23:
//                transition = new DoorWayTransition();
//                break;
//            case 24:
//                transition = new DreamyTransition();
//                break;
//            case 25:
//                transition = new DreamyZoomTransition();
//                break;
//            case 26:
//                transition = new FadeTransition();
//                break;
//            case 27:
//                transition = new FadeColorTransition();
//                break;
//            case 28:
//                transition = new FadeGrayScaleTransition();
//                break;
//            case 29:
//                transition = new FlyEyeTransition();
//                break;
//            case 30:
//                transition = new GlitchDisplaceTransition();
//                break;
//            case 31:
//                transition = new GlitchMemoriesTransition();
//                break;
//            case 32:
//                transition = new GridFlipTransition();
//                break;
//            case 33:
//                transition = new HeartTransition();
//                break;
//            case 34:
//                transition = new HexagonalTransition();
//                break;
//            case 35:
//                transition = new KaleidoScopeTransition();
//                break;
//            case 36:
//                transition = new LinearBlurTransition();
//                break;
//            case 37:
//                transition = new LuminanceMeltTransition();
//                break;
//            case 38:
//                transition = new MorphTransition();
//                break;
//            case 39:
//                transition = new MosaicTransition();
//                break;
//            case 40:
//                transition = new MultiplyBlendTransition();
//                break;
//            case 41:
//                transition = new PerlinTransition();
//                break;
//            case 42:
//                transition = new PinWheelTransition();
//                break;
//            case 43:
//                transition = new PixelizeTransition();
//                break;
//            case 44:
//                transition = new PolarFunctionTransition();
//                break;
//            case 45:
//                transition = new PolkaDotsCurtainTransition();
//                break;
//            case 46:
//                transition = new RadialTransition();
//                break;
//            case 47:
//                transition = new RandomSquaresTransition();
//                break;
//            case 48:
//                transition = new RippleTransition();
//                break;
//            case 49:
//                transition = new RotateScaleFadeTransition();
//                break;
//            case 50:
//                transition = new SimpleZoomTransition();
//                break;
//            case 51:
//                transition = new SquaresWireTransition();
//                break;
//            case 52:
//                transition = new AbstractTransition();
//                break;
//            case 53:
//                transition = new StereoViewerTransition();
//                break;
//            case 54:
//                transition = new SwapTransition();
//                break;
//            case 55:
//                transition = new SwirlTransition();
//                break;
//            case 56:
//                transition = new UndulatingBurnOutTransition();
//                break;
//            case 57:
//                transition = new WaterDropTransition();
//                break;
//            case 58:
//                transition = new WindTransition();
//                break;
//            case 59:
//                transition = new WindowBlindsTransition();
//                break;
//            case 60:
//                transition = new WipeDownTransition();
//                break;
//            case 61:
//                transition = new WipeUpTransition();
//                break;
//            case 62:
//                transition = new WipeLeftTransition();
//                break;
//            case 63:
//                transition = new WipeRightTransition();
//                break;
//            case 64:
//                transition = new ZoomInCirclesTransition();
//                break;
//            default:
//                break;
//        }
//
        return transition;
    }

    public static void start(Activity context, int requestCode, String imagePathList, Bitmap bitmap) {
        if (mIsStarted) {
            Logger.d(TAG, "VideoGenerateActivity started already, no need!");
            return;
        }

        mIsStarted = true;

       String copiedList = (imagePathList);
        Intent intent = new Intent(context, VideoGenerateActivity.class);
        intent.putExtra(EXTRA_IMAGE_PATH_LIST, copiedList);
        intent.putExtra(EXTRA_IMAGE_BITMAP, bitmap);
        context.startActivityForResult(intent, requestCode);
    }
}
