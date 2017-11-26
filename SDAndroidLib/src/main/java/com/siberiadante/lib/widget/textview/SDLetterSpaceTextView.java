package com.siberiadante.lib.widget.textview;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;

/**
 * @Created SiberiaDante
 * @Describe： 可设置字体间距的TextView
 * @Time: 2017/9/7
 * @UpDate:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDLetterSpaceTextView extends AppCompatTextView {
    private float spacing = Spacing.NORMAL;
    private CharSequence originalText = "";

    public SDLetterSpaceTextView(Context context) {
        super(context);
    }

    public SDLetterSpaceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SDLetterSpaceTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public float getSpacing() {
        return this.spacing;
    }

    public void setSpacing(float spacing) {
        this.spacing = spacing;
        applySpacing();
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        originalText = text;
        applySpacing();
    }

    @Override
    public CharSequence getText() {
        return originalText;
    }

    private void applySpacing() {
        if (this == null || this.originalText == null) return;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < originalText.length(); i++) {
            builder.append(originalText.charAt(i));
            if (i + 1 < originalText.length()) {
                builder.append("\u00A0");
            }
        }
        SpannableString finalText = new SpannableString(builder.toString());
        if (builder.toString().length() > 1) {
            for (int i = 1; i < builder.toString().length(); i += 2) {
                finalText.setSpan(new ScaleXSpan((spacing + 1) / 10), i, i + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        super.setText(finalText, BufferType.SPANNABLE);
    }

    private class Spacing {
        final static float NORMAL = 0;
    }
}