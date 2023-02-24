package io.github.jesse205.materiallite;

import android.content.res.ColorStateList;
import android.graphics.Color;

public class MaterialApplication {
    private static MaterialApplication _theOne;
    // 按钮
    private ColorStateList defaultButtonTextColor;
    private ColorStateList defaultButtonColor;
    private ColorStateList defaultButtonStrokeColor;
    private ColorStateList defaultButtonRippleColor;
    private int defaultButtonStrokeDp = 1;
    private int defaultButtonRadiusDp = 4;

    public static MaterialApplication getInstance() {
        if (_theOne == null) _theOne = new MaterialApplication();
        return _theOne;
    }

    private MaterialApplication() {

    }

    // 按钮
    public ColorStateList getDefaultButtonTextColor() {
        return defaultButtonTextColor;
    }

    public void setDefaultButtonTextColor(ColorStateList defaultButtonTextColor) {
        this.defaultButtonTextColor = defaultButtonTextColor;
    }

    public ColorStateList getDefaultButtonColor() {
        if (defaultButtonColor == null) {
            defaultButtonColor = ColorStateList.valueOf(Color.TRANSPARENT);
        }
        return defaultButtonColor;
    }

    public void setDefaultButtonColor(ColorStateList defaultButtonColor) {
        this.defaultButtonColor = defaultButtonColor;
    }

    public ColorStateList getDefaultButtonStrokeColor() {
        if (defaultButtonStrokeColor == null) {
            defaultButtonStrokeColor = ColorStateList.valueOf(MaterialColor.GERY_300);
        }
        return defaultButtonStrokeColor;
    }

    public void setDefaultButtonStrokeColor(ColorStateList defaultButtonStrokeColor) {
        this.defaultButtonStrokeColor = defaultButtonStrokeColor;
    }

    public ColorStateList getDefaultButtonRippleColor() {
        if (defaultButtonRippleColor == null) {
            defaultButtonRippleColor = ColorStateList.valueOf(MaterialColor.RIPPLE_DARK);
        }
        return defaultButtonRippleColor;
    }

    public void setDefaultButtonRippleColor(ColorStateList defaultButtonRippleColor) {
        this.defaultButtonRippleColor = defaultButtonRippleColor;
    }

    public int getDefaultButtonStrokeDp() {
        return defaultButtonStrokeDp;
    }

    public void setDefaultButtonStrokeDp(int defaultButtonStrokeDp) {
        this.defaultButtonStrokeDp = defaultButtonStrokeDp;
    }

    public int getDefaultButtonRadiusDp() {
        return defaultButtonRadiusDp;
    }

    public void setDefaultButtonRadiusDp(int defaultButtonRadiusDp) {
        this.defaultButtonRadiusDp = defaultButtonRadiusDp;
    }
}
