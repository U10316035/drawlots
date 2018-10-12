package lins.drawlots.Util;
import lins.drawlots.BuildConfig;
import android.util.Log;


/**
 * Created by utaipei on 2018/2/1.
 */

public class LogHelper {
    private static final boolean DEBUG = BuildConfig.DEBUG ? true: false;
    private String title;
    private String content;

    public LogHelper(){

    }

    public LogHelper(String title, String content){
        this.title = title;
        this.content = content;
    }

    public static void i(String title, String content){
        if(DEBUG) {
            Log.i(title, content);
        }
    }

    public static void e(String title, String content){
        if(DEBUG) {
            Log.e(title, content);
        }
    }

    public static void d(String title, String content){
        if(DEBUG) {
            Log.d(title, content);
        }
    }

//    public static void i(String title, String content) {
//        Log.i(title, content);
//    }
}