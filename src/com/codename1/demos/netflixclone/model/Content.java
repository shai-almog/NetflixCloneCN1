package com.codename1.demos.netflixclone.model;

import com.codename1.properties.MapProperty;
import com.codename1.properties.Property;
import com.codename1.properties.PropertyBusinessObject;
import com.codename1.properties.PropertyIndex;
import com.codename1.ui.EncodedImage;

public class Content implements PropertyBusinessObject {
    public final Property<String, Content> id = new Property<>("id");
    public final Property<EncodedImage, Content> heroImage = new Property<>("heroImage", EncodedImage.class);
    public final Property<EncodedImage, Content> icon = new Property<>("icon", EncodedImage.class);
    public final Property<EncodedImage, Content> logo = new Property<>("logo", EncodedImage.class);
    public final Property<String, Content> name = new Property<>("name");
    public final Property<String, Content> description = new Property<>("description");
    public final MapProperty<String, String, Content> videoUrls = new MapProperty<>("videoUrls", String.class, String.class);

    private final PropertyIndex idx = new PropertyIndex(this, "Content", id, heroImage, icon, logo, name, description, videoUrls);

    @Override
    public PropertyIndex getPropertyIndex() {
        return idx;
    }
}
