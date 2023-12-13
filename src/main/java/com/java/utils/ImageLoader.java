package com.java.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class ImageLoader {
    private ClassLoader classLoader;

    public ImageLoader() {
        this.classLoader = getClass().getClassLoader();
    }

    public BufferedImage getImage(String url) {
        BufferedImage bufferedImage = null;
        InputStream inputStream = classLoader.getResourceAsStream(url);
        try {
            bufferedImage = ImageIO.read(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bufferedImage;
    }
}
