package com.codename1.demos.netflixclone.forms;

import com.codename1.components.ScaleImageButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.demos.netflixclone.model.Content;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;

import java.util.List;

import static com.codename1.ui.FontImage.MATERIAL_AIRPLANEMODE_ON;
import static com.codename1.ui.FontImage.MATERIAL_HOME;
import static com.codename1.ui.FontImage.MATERIAL_MENU;
import static com.codename1.ui.FontImage.MATERIAL_ONDEMAND_VIDEO;
import static com.codename1.ui.FontImage.MATERIAL_PLAY_ARROW;
import static com.codename1.ui.FontImage.MATERIAL_SEARCH;

public class HomeForm extends BaseForm {
    private HomeForm() {
        super(new BorderLayout());
    }

    private void init(Content lead, List<Content> popularTitles,
                      List<Content> myTitles,
                      List<Content> recommended) {
        Resources r = Resources.getGlobalResources();
        Toolbar tb = getToolbar();
        ((Label)tb.getTitleComponent()).setIcon(r.getImage("netflix-logo.png"));

        // adding this just so the sidemenu and search icon appear
        tb.addMaterialCommandToLeftSideMenu("Placeholder", MATERIAL_AIRPLANEMODE_ON, e ->{});
        tb.addSearchCommand(e -> {});

        ScaleImageLabel logo = new ScaleImageLabel(lead.logo.get());
        logo.setUIID("HeroImageLogo");
        Button play = new Button("PLAY", MATERIAL_PLAY_ARROW, "HeroImagePlayButton");

        Container heroTitle = BoxLayout.encloseY(logo,
                FlowLayout.encloseCenter(play),
                new Label("Popular on Netflix", "Lead"));
        Style stl = heroTitle.getAllStyles();
        stl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        stl.setBgImage(lead.heroImage.get());

        Tabs tabs = new Tabs();
        tabs.setTabPlacement(BOTTOM);

        Container content = BoxLayout.encloseY(heroTitle,
                movieList(popularTitles),
                new Label("My List", "Lead"),
                movieList(myTitles),
                new Label("Recommended", "Lead"),
                movieList(recommended));
        content.setScrollableY(true);

        tabs.addTab("Home", MATERIAL_HOME, 4, content);
        tabs.addTab("Search", MATERIAL_SEARCH, 4, new Label("TODO"));
        tabs.addTab("Coming Soon", MATERIAL_ONDEMAND_VIDEO, 4, new Label("TODO"));
        tabs.addTab("More", MATERIAL_MENU, 4, new Label("TODO"));

        add(CENTER, tabs);
    }

    private Container movieList(List<Content> lst) {
        Container p = new Container(BoxLayout.x());
        for(Content c : lst) {
            ScaleImageButton b = new ScaleImageButton(c.icon.get());
            b.setUIID("ThumbIcon");
            p.add(b);
            b.addActionListener(e -> {
                DetailsForm.create(c).show();
            });
        }
        p.setScrollableX(true);
        return p;
    }

    public static HomeForm create(Content lead, List<Content> popularTitles,
                                  List<Content> myTitles,
                                  List<Content> recommended) {
        HomeForm h = new HomeForm();
        h.init(lead, popularTitles, myTitles, recommended);
        return h;
    }
}
