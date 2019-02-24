package rasterOperation.model;

import java.util.List;

public class Arrow extends Solid {

    public Arrow() {
        verticies.add(new Vertex());
        verticies.add(new Vertex());
        verticies.add(new Vertex());
        verticies.add(new Vertex());
        verticies.add(new Vertex());

        indicies.add(0);
        indicies.add(1);
        indicies.add(2);
        indicies.add(3);
        indicies.add(4);

        parts.add(new Part(0,1,Type.LINE));
        parts.add(new Part(2,1,Type.TRIANGLE));


    }
}
