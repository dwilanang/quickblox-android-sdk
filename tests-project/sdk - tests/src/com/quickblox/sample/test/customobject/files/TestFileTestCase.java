package com.quickblox.sample.test.customobject.files;

import android.content.res.AssetManager;
import com.quickblox.internal.core.helper.FileHelper;
import com.quickblox.module.content.model.QBFile;
import com.quickblox.sample.test.customobject.CustomObjectsTestCase;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by vfite on 11.12.13.
 */
public class TestFileTestCase extends CustomObjectsTestCase {
    public static final String TEST_ASSETS_ROOT = "test_files";
    AssetManager assetManager;
    File fileObject;
    QBFile file;


    @Override
    public void setUp() throws Exception {
        super.setUp();
        assetManager = getInstrumentation().getContext().getResources().getAssets();
    }


    public File getRandomFile() {
        File file = null;
        try {
            String[] assetsFileNames = assetManager.list(TEST_ASSETS_ROOT);
            int n = new Random().nextInt(assetsFileNames.length);
            String fileName = assetsFileNames[n];
            InputStream is = assetManager.open(TEST_ASSETS_ROOT + "/" + fileName);
            file = FileHelper.getFileFromAsset(is, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;

    }


    public ArrayList<File> getRandomFiles() {
        ArrayList<File> files = new ArrayList<File>();
        try {
            for (String fileName : assetManager.list(TEST_ASSETS_ROOT)) {
                InputStream is = assetManager.open(TEST_ASSETS_ROOT + "/" + fileName);
                File file = FileHelper.getFileFromAsset(is, fileName);
                files.add(file);
            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return files;

    }
}
