package rasterOperation;

import transforms.Col;

import java.awt.image.BufferedImage;

public class VisibilityZBuffer {
    private ImageBuffer imageBuffer;
    private ZBuffer<Float> zBuffer;

    public VisibilityZBuffer(int width, int height) {
        this.imageBuffer = new ImageBuffer(width, height);

    }

    public void put(int x, int y, float z, Col color) {
        if (zBuffer.getPixel(x, y) > z) {
            imageBuffer.setPixel(x, y, color.getRGB());
            zBuffer.setPixel(x, y, z);
        }
    }

    public void init(int color) {

        for (int x = 0; x < imageBuffer.getWidth(); x++) {
            for (int y = 0; y < imageBuffer.getHeight(); y++) {
                zBuffer.setPixel(x, y, 1f);
            }
        }
        imageBuffer.clear(color);
    }

    public BufferedImage getBufferedImage(){
        return null;//todo
    }
}
