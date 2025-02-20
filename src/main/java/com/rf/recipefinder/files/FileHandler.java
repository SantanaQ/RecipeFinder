package com.rf.recipefinder.files;

import java.io.File;
import java.io.IOException;


public class FileHandler {

    private static final String imagesPath = "src/main/resources/static/images";

    public static String getImagePath(String imageName) throws IOException {
        File file = new File(imagesPath, imageName);
        return file.getPath();
    }

}
