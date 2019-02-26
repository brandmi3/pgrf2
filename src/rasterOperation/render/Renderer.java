package rasterOperation.render;

import rasterOperation.model.Part;
import rasterOperation.model.Solid;
import rasterOperation.model.Vertex;
import transforms.Mat4;
import util.Lerp;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Renderer {
    private Mat4 viewMatrix;
    private RestariserTriangle rt;
    private RestariserLine rl;
    private RestariserPoint rp;
    private BufferedImage img;
    private Lerp<Vertex> lerp = new Lerp();

    public Renderer(BufferedImage img) {
        this.img = img;
    }

    //TODO zabalit do aplikace randerer, umístění , matice, RIP

    public void render(Solid solid) {
        for (Part part : solid.getParts()) {
            switch (part.getType()) {
                case POINT:

                    break;
                case LINE:

                    break;
                case TRIANGLE:
                    for (int i = 0; i < part.getCount(); i++) {
                        Vertex a, b, c;
                        int index = 3 * i + part.getStart();
                        a = solid.getVerticies().get(solid.getIndicies().get(index));
                        b = solid.getVerticies().get(solid.getIndicies().get(index + 1));
                        c = solid.getVerticies().get(solid.getIndicies().get(index + 2));


                        renderTriangle(a, b, c);
                    }
                    break;
                default:

                    break;
            }
            ;
        }

    }

    private void renderTriangle(Vertex a, Vertex b, Vertex c) {
        //todo transformace, orez -rychle, zadne 'z' nebude zaporne,



        if (a.getPoint3D().getZ() > b.getPoint3D().getZ()) {
            Vertex p = a;
            a = b;
            b = p;
        } else if (b.getPoint3D().getZ() > c.getPoint3D().getZ()) {
            Vertex p = b;
            b = c;
            c = p;
        } else if (a.getPoint3D().getZ() > b.getPoint3D().getZ()) {
            Vertex p = a;
            a = b;
            b = p;
        }
        // detekovat 4 varianty
        //za pozorovatele
        if(a.getPoint3D().getZ()<0) {
            return;
        }

        if(b.getPoint3D().getZ()<0) {
            //dopocitat
            double t1 = -b.getPoint3D().getZ()/(a.getPoint3D().getZ()-b.getPoint3D().getZ());
            Vertex ab = lerp.lerp(b,a,t1);
            Vertex ac = lerp.lerp();
            rt.rasterizace(a,ab,ac);
            return;
        }



    }

    public void lineDDA(int x1, int y1, int x2, int y2, int color) {

        float k, g, h; //G = PŘÍRŮSTEK X, H = PŘÍRŮSTEK Y
        int dy = y2 - y1;
        int dx = x2 - x1;
        k = dy / (float) dx;

        //určení řídící osy
        if (Math.abs(dx) > Math.abs(dy)) {
            g = 1;
            h = k;
            if (x1 > x2) { // prohození
                int temp = x1;
                x1 = x2;
                x2 = temp;
                temp = y1;
                y1 = y2;
                y2 = temp;
            }
        } else {
            g = 1 / k;
            h = 1;
            if (y1 > y2) { //otočení
                int temp = x1;
                x1 = x2;
                x2 = temp;
                temp = y1;
                y1 = y2;
                y2 = temp;
            }
        }

        float x = x1;
        float y = y1;
        int max = Math.max(Math.abs(dx), Math.abs(dy));

        for (int i = 0; i <= max; i++) {
            drawPixel(Math.round(x), Math.round(y), color);
            x += g;
            y += h;
        }
    }

    private void drawPixel(int x, int y, int color) {
        if (x < 0 || x >= img.getWidth()) return;
        if (y < 0 || y >= img.getHeight()) return;
        img.setRGB(x, y, color);
    }

}
