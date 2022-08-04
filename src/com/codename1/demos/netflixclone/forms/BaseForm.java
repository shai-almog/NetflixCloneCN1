package com.codename1.demos.netflixclone.forms;

import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.Layout;

public class BaseForm extends Form {
    public BaseForm(Layout l) {
        super(l);
    }

    @Override
    protected void initGlobalToolbar() {
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("ToolbarGradient");
    }
}
