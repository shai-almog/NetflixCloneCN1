package com.codename1.demos.netflixclone.model;

import com.codename1.io.rest.Rest;
import com.codename1.util.OnComplete;

public class Server {
    private static final String SERVER_URL = "http://localhost:8080/";
    public static void fetchContent(OnComplete<ContentCollection> fetch) {
        Rest.get(SERVER_URL + "video/list").
                jsonContent().fetchAsProperties(callback -> {
                    fetch.completed((ContentCollection)callback.getResponseData());
        }, ContentCollection.class);
    }
}
