package model;

/**
 * Created by Gabriel on 19/11/2015.
 */
public class OpenResult {
    private final int x;
    private final int y;
    private final int minesAround;

    public OpenResult(int x, int y, int minesAround) {
        this.x = x;
        this.y = y;
        this.minesAround = minesAround;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMinesAround() {
        return minesAround;
    }
}
