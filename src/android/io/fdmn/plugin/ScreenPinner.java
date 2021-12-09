package io.fdmn.plugin;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import java.io.StringWriter;
import java.io.PrintWriter;

public class ScreenPinner extends CordovaPlugin {

    private static final String ACTION_START_PINNED_MODE = "start";
    private static final String ACTION_END_PINNED_MODE = "end";
    private static final String ACTION_ISPINNED_PINNED_MODE = "isPinned";

    private CallbackContext callback = null;
    private Activity activity = null;
    private ActivityManager activityManager = null;
    private ComponentName dac = null;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        activity = cordova.getActivity();
        activityManager = (ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE);
    }

    @Override
    public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) throws JSONException
    {  
        callback = callbackContext;

        try {
            if (ACTION_START_PINNED_MODE.equals(action)) {
                return startPinning();
            }
            else if (ACTION_END_PINNED_MODE.equals(action)) {
                return endPinning();
            }
            else if (ACTION_ISPINNED_PINNED_MODE.equals(action)) {
                return endPinning();
            }
        }

        catch (Exception e) {
            callback.error( "1:" + e.getMessage());
        }

        return false;
    }

    private boolean isPinned()
    {
        try {
            if (activityManager.isInLockTaskMode()) {
                callback.success();
                return true;
            }
            else
            {
                callback.error("Not pinned");
                return false;
            }
        } catch(Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            callback.error("2:" + sw.toString());
            return false;
        }
    }

    private boolean startPinning()
    {
        try {

            if (!activityManager.isInLockTaskMode()) {
                activity.startLockTask();
                callback.success();
                return true;
            } else {
                callback.success();
                return true;  
            }

        }
        catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            callback.error("3:" + sw.toString());
            return false;
        }    
    }

    private boolean endPinning()
    {
        try {
            if (activityManager.isInLockTaskMode()) {
                activity.stopLockTask();
                callback.success();
                return true;
            } else {
                callback.success();
                return true;  
            }
        }
        catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            callback.error("4:" + sw.toString());
            return false;
        }    
    }

}