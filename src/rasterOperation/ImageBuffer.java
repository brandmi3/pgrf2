package rasterOperation;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.management.BufferPoolMXBean;

public class ImageBuffer implements Raster<Integer> {

    private int width;
    private int height;
    private BufferedImage bufferedImage;

    public ImageBuffer(int width, int height) {
        this.width = width;
        this.height = height;
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    @Override
    public Integer getPixel(int x, int y) {
        return bufferedImage.getRGB(x, y);
    }

    @Override
    public void setPixel(int x, int y, Integer value) {
        bufferedImage.setRGB(x,y,value);
    }

    @Override
    public int getWidth() {
        return bufferedImage.getWidth();
    }

    @Override
    public int getHeight() {
        return bufferedImage.getHeight();
    }

    public void clear(int color) {
        Graphics gr = bufferedImage.getGraphics();
        gr.setColor(new Color(color));
        gr.fillRect(0, 0,
                bufferedImage.getWidth(), bufferedImage.getHeight());
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
}
