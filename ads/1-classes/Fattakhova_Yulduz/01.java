
package javaapplication6;
class triangle
{
    private double h;
    private double alfa;//grad
    private double s;
    
    public triangle(double h, double alfa, double s)
    {
        this.alfa = alfa;
        this.h = h;
        this.s = s;
    }
    public double get_h()
    {
        return h;
    }
     public double get_s()
    {
        return s;
    }
      public double get_alfa()
    {
        return alfa;
    }
    public double[] sides()
    {
        double[] a = new double[3];
        a[0] = 2*s/h;
        a[1] = h/Math.sin(alfa*Math.PI/180);
        a[2] = Math.sqrt(a[0]*a[0] + a[1]*a[1] - 2*a[0]*a[1]*Math.cos(alfa*Math.PI/180));
        return a;
    }
    public double[] corners()
    {
        double[] a = new double[3];
        double[] b = new double[3];
        System.arraycopy(this.sides(), 0, b, 0, 3);
        a[0] = alfa;          
        a[1] = Math.asin((b[0]*Math.sin(alfa*Math.PI/180))/b[2])*180/Math.PI;
        a[2] = 180 - a[1] - a[0];
        return a;
    }
    public triangle similar_triangle(double k, triangle t)
    {
      triangle t1 = new triangle(h*k,t.get_alfa(),k*k*t.get_s());
      return t1;
    }
}

