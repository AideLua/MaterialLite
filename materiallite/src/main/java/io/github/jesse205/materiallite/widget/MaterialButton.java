package io.github.jesse205.materiallite.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.Button;

import io.github.jesse205.materiallite.MaterialApplication;
import io.github.jesse205.materiallite.MaterialColor;
import io.github.jesse205.materiallite.R;
import io.github.jesse205.materiallite.ScreenUtil;


public class MaterialButton extends Button {
    private final Context mContext;
    private GradientDrawable mGradientDrawable;
    private RippleDrawable mRippleDrawable;
    private ShapeDrawable mMaskDrawable;
    private int strokeWidth;
    private ColorStateList strokeColor;

    public MaterialButton(Context context) {
        super(context);
        mContext = context;
        init(null, 0);
    }

    public MaterialButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init(attrs, 0);
    }

    public MaterialButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        MaterialApplication materialApplication = MaterialApplication.getInstance();
        // 边框
        mGradientDrawable = new GradientDrawable();
        mMaskDrawable = new ShapeDrawable();
        mRippleDrawable = new RippleDrawable(materialApplication.getDefaultButtonRippleColor(), mGradientDrawable, mMaskDrawable);
        LayerDrawable layerDrawable = new LayerDrawable(new RippleDrawable[]{mRippleDrawable});

        mGradientDrawable.setShape(GradientDrawable.RECTANGLE);

        // drawable的外边距
        int insertY = ScreenUtil.dp2px(mContext, 4);
        int insertX = ScreenUtil.dp2px(mContext, 2);
        layerDrawable.setLayerInset(0, insertX, insertY, insertX, insertY);

        //drawable的内边距
        int paddingX = ScreenUtil.dp2px(mContext, 8);
        int paddingY = ScreenUtil.dp2px(mContext, 4);
        mMaskDrawable.setPadding(paddingX, paddingY, paddingX, paddingY);

        setStroke(ScreenUtil.dp2px(mContext, materialApplication.getDefaultButtonStrokeDp()), materialApplication.getDefaultButtonStrokeColor());
        setColor(materialApplication.getDefaultButtonColor());

        setRadius(ScreenUtil.dp2px(mContext, materialApplication.getDefaultButtonRadiusDp()));

        setBackground(layerDrawable);
        if (attrs != null) {
            final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MaterialButton, defStyle, 0);
            if (a.hasValue(R.styleable.MaterialButton_color)) {
                setColor(a.getColorStateList(R.styleable.MaterialButton_color));
            }
            if (a.hasValue(R.styleable.MaterialButton_strokeColor)) {
                setStrokeColor(a.getColorStateList(R.styleable.MaterialButton_strokeColor));
            }
            setStrokeWidth((int) a.getDimension(R.styleable.MaterialButton_strokeWidth, strokeWidth));
            a.recycle();
        }
    }

    public void setStroke(int width, ColorStateList color) {
        mGradientDrawable.setStroke(width, color);
        strokeWidth = width;
        strokeColor = color;
    }

    public void setStrokeColor(ColorStateList color) {
        setStroke(strokeWidth, color);
    }

    public void setStrokeWidth(int width) {
        setStroke(width, strokeColor);
    }

    public void setColor(ColorStateList color) {
        mGradientDrawable.setColor(color);
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public ColorStateList getStrokeColor() {
        return strokeColor;
    }

    public void setRadius(int radius) {
        mMaskDrawable.setShape(
                new RoundRectShape(
                        new float[]{radius, radius, radius, radius, radius, radius, radius, radius},
                        null, null));
        mGradientDrawable.setCornerRadius(radius);
    }
}