package com.codename1.demos.netflixclone.model;

import com.codename1.properties.ListProperty;
import com.codename1.properties.Property;
import com.codename1.properties.PropertyBusinessObject;
import com.codename1.properties.PropertyIndex;

public class ContentCollection implements PropertyBusinessObject {
    public final Property<Content, ContentCollection> lead =
            new Property<>("lead", Content.class);

    public final ListProperty<Content, ContentCollection> popular =
            new ListProperty<>("popular", Content.class);

    public final ListProperty<Content, ContentCollection> myList =
            new ListProperty<>("myList", Content.class);

    public final ListProperty<Content, ContentCollection> recommended =
            new ListProperty<>("recommended", Content.class);

    private PropertyIndex idx = new PropertyIndex(this,
            "ContentCollection", lead, popular, myList, recommended);

    @Override
    public PropertyIndex getPropertyIndex() {
        return idx;
    }
}
