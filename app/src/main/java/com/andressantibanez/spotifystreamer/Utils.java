package com.andressantibanez.spotifystreamer;

import android.util.Log;

import java.util.List;

import kaaes.spotify.webapi.android.models.Image;

public class Utils {

    public static final String TAG = Utils.class.getSimpleName();

    public static String getThumbnailUrl(List<Image> imagesList, int requiredSize) {
        String thumbnailUrl = null;

        Image image;
        int imageSize;

        //Image sizes come bigger first, small last
        for(int i = imagesList.size() - 1; i >= 0; i--) {
            image = imagesList.get(i);
            imageSize = Math.max(image.height, image.width);
            if(imageSize >= requiredSize) {
                thumbnailUrl = image.url;
                break;
            }
        }

        return thumbnailUrl;
    }

}
