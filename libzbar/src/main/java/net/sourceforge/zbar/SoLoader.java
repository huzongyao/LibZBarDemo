package net.sourceforge.zbar;

/**
 * Created by huzongyao on 2018/4/4.
 */

public class SoLoader {

    private static volatile boolean isLoaded = false;

    public static void ensureLoad() {
        if (!isLoaded) {
            System.loadLibrary("zbarjni");
            System.loadLibrary("iconv");
            isLoaded = true;
        }
    }
}
