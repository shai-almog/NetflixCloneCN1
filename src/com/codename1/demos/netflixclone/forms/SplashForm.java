package com.codename1.demos.netflixclone.forms;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;

public class SplashForm extends Form {
    private SplashForm() {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER));
    }

    private void init() {
        Resources r = Resources.getGlobalResources();
        add(CENTER, new Label(r.getImage("netflix-logo.png")));
    }

    public static SplashForm create() {
        SplashForm h = new SplashForm();
        h.init();
        return h;
    }
}
