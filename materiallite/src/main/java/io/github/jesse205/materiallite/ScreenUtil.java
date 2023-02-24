package io.github.jesse205.materiallite;

import android.content.Context;
import android.util.TypedValue;

public class ScreenUtil {
    public static int dp2px(Context context, int value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());

    }
}
