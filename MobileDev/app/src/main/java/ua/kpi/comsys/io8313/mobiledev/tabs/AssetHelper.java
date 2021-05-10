package ua.kpi.comsys.io8313.mobiledev.tabs;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

import ua.kpi.comsys.io8313.mobiledev.R;

public class AssetHelper {
    static final String TAG = "Asset Helper";
    private AssetHelper() {}

    public static InputStream getInputStreamFromFile(Context context, String filename) throws IOException {
        return context.getAssets().open(filename);
    }

    public static boolean isPortraitOrientation(Activity activity) {
        return activity.getResources()
                .getConfiguration()
                .orientation == Configuration.ORIENTATION_PORTRAIT;
    }

    public static int getResourceByString(String resourceName) {
        try {
            Field field = R.id.class.getDeclaredField(resourceName);
            return field.getInt(field);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "error at "+e.getMessage());
            return -1;
        } catch (IllegalAccessException e) {
            Log.e(TAG, "error at "+e.getMessage());
            return -1;
        }
    }
}
