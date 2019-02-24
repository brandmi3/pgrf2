package rasterOperation.model;

public class Part {

    private final int start;
    private final int count;
    private final Type type;

    public Part(int start, int count, Type type) {
        this.start = start;
        this.count = count;
        this.type = type;
    }

    public int getStart() {
        return start;
    }

    public int getCount() {
        return count;
    }

    public Type getType() {
        return type;
    }
}
