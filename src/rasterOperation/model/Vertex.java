package rasterOperation.model;

import transforms.Point3D;
import util.Vectorizable;

public class Vertex implements Vectorizable<Vertex> {
    private Point3D point3D;

    public Point3D getPoint3D() {
        return point3D;
    }

    public void setPoint3D(Point3D point3D) {
        this.point3D = point3D;
    }


    @Override
    public Vertex mul(double t) {
        return null;
    }

    @Override
    public Vertex add(Vertex a) {
        return null;
    }
}
