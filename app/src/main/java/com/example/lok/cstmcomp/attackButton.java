package com.example.lok.cstmcomp;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.util.AttributeSet;

public class attackButton extends androidx.appcompat.widget.AppCompatImageButton {

    private Icon icon;

    public attackButton(Context context) {
        super(context);
    }

    public attackButton(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    public attackButton(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
    }

    public Icon getIcon() { return this.icon; }

    public void setIcon(Icon icon) { this.icon = icon; }

}
