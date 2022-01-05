package ss6_ke_thua.bai_tap.lop_point_va_moveablepoint;

import java.util.Arrays;

public class Point {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY(){
        float[] xy = {x,y};
        return xy;
    }

    @Override
    public String toString() {
        return Arrays.toString(getXY());
    }
}
