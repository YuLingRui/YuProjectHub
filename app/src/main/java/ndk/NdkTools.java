package ndk;

public class NdkTools {
    static {
        System.loadLibrary("native-lib");
    }
    //eg: 简单的例子“获取一个字符串”
    public static native String getStringFromNDK();
}
