package rasterOperation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ZBuffer<T> implements Raster<T> {

    private List<T> pixels;
    private int height;
    private int width;

    public ZBuffer(int height, int width) {
//        this.pixels = (T[][]) Array.newInstance(null, height, width);
        this.pixels = new ArrayList<>(width * height);
        this.height = height;
        this.width = width;
    }

    @Override
    public T getPixel(int x, int y) {
        return pixels.get(y * width + x);
    }

    @Override
    public void setPixel(int x, int y, T value) {
        pixels.set(y * width + x, value);
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
}
