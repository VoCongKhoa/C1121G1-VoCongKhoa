package ss6_ke_thua.bai_tap.lop_point_2D_va_lop_point_3D;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D(float x, float y, float z){
        super(x,y);
        this.z = z;
    }
    public Point3D(){
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ(){
        float[] xyz = {super.getX(),super.getY(),z};
        return xyz;
    }

    @Override
    public String toString(){
        return "("+super.getX()+","+super.getY()+","+z+")";
    }
}
