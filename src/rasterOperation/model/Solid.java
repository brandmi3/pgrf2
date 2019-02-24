package rasterOperation.model;

import java.util.List;

public abstract class Solid {
    protected List<Part> parts;
    protected List<Vertex> verticies;
    protected List<Integer> indicies;

    public Solid(List<Part> parts, List<Vertex> verticies, List<Integer> indicies) {
        this.parts = parts;
        this.verticies = verticies;
        this.indicies = indicies;
    }

    public Solid() {
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public List<Vertex> getVerticies() {
        return verticies;
    }

    public void setVerticies(List<Vertex> verticies) {
        this.verticies = verticies;
    }

    public List<Integer> getIndicies() {
        return indicies;
    }

    public void setIndicies(List<Integer> indicies) {
        this.indicies = indicies;
    }
}
