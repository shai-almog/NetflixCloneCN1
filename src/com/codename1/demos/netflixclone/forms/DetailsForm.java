package com.codename1.demos.netflixclone.forms;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.demos.netflixclone.model.Content;
import com.codename1.demos.netflixclone.model.VideoQuality;
import com.codename1.io.Log;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;

import java.io.IOException;

import static com.codename1.ui.CN.*;

import static com.codename1.ui.FontImage.*;

public class DetailsForm extends BaseForm {
    private DetailsForm() {
        super(BoxLayout.y());
    }

    private void init(Content ct) {
        Toolbar tb = getToolbar();
        Form previous = getCurrentForm();
        tb.setBackCommand("", Toolbar.BackCommandPolicy.AS_ARROW, e -> previous.showBack());

        Button play = new Button("", MATERIAL_PLAY_ARROW, "PlayNowButton");
        Container heroTitle = BorderLayout.centerAbsolute(play);
        Style stl = heroTitle.getAllStyles();
        stl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        stl.setBgImage(ct.heroImage.get());
        heroTitle.add(SOUTH, new Label(ct.name.get(), "ShowTitleOverlay"));
        add(heroTitle);

        play.addActionListener(e -> {
            try {
                Media m = MediaManager.createMedia(ct.videoUrls.get(VideoQuality.MEDIUM.name()), true);
                m.setFullScreen(true);
                m.setNativePlayerMode(true);
                m.play();
            } catch (IOException ex) {
                Log.e(ex);
            }
        });

        add(new Label("97% Match", "MatchPercentage"));

        add(new SpanLabel(ct.description.get(), "ShowDescription"));

        Button addToList = new Button("My List", MATERIAL_ADD, "DescriptionFormButton");
        Button rate = new Button("Rate", MATERIAL_THUMB_UP_ALT, "DescriptionFormButton");
        Button share = new Button("Share", MATERIAL_SHARE, "DescriptionFormButton");
        addToList.setTextPosition(BOTTOM);
        rate.setTextPosition(BOTTOM);
        share.setTextPosition(BOTTOM);

        add(FlowLayout.encloseIn(
                GridLayout.encloseIn(3, addToList, rate, share)
        ));
    }

    public static DetailsForm create(Content ct) {
        DetailsForm f = new DetailsForm();
        f.init(ct);
        return f;
    }
}
