package rasterOperation.render;

import rasterOperation.model.Part;
import rasterOperation.model.Solid;
import rasterOperation.model.Type;
import transforms.Mat4;

public class Renderer {
    private Mat4 viewMatrix;
    private RestariserTriangle rt;
    private RestariserLine rl;
    private RestariserPoint rp;

    //TODO zabalit do aplikace randerer, umístění , matice, RIP

    public void render(Solid solid){
        for(Part part:solid.getParts()){
            switch (part.getType()){
                case POINT:

                    break;
                case LINE:

                    break;
                case TRIANGLE:

                    break;
                default:

                    break;
            };
        }

    }
}
