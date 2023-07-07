package MergeIntervals;

public class Interval {
    int start;
    int end;
    boolean closed;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
        this.closed = true;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
