/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangles;
import static java.lang.Math.*;
/**
 *
 * @author 1
 */
class Point
{
    double rad;
    double corner;
    double x,y;
}

enum Direction {RIGHT,LEFT,UP,DOWN};

public class Triangle {
    private Point[] points;
    public Triangle(Point[] _points)
    {
       points = new Point[3];
       for(int i=0;i<3;i++)
       {
           points[i] = new Point();
           points[i] = _points[i];
           points[i].x = points[i].rad*cos((PI/180)*points[i].corner);
           points[i].y = points[i].rad*sin((PI/180)*points[i].corner);
       }
    }
    
    public double side(Point p1, Point p2)//длина отрезка по двум точкам
    {
        return sqrt(pow(p1.rad,2)+pow(p2.rad,2)-2*p1.rad*p2.rad*cos((PI/180)*(p1.corner-p2.corner))); 
    }
    
    public void sides()//вывод длин сторон
    {
        for(int i=0;i<3;i++)
        {
            System.out.print("Length of side number "+i+": ");
            System.out.println(side(points[i],points[(i+1)%3]));
        } 
    }
    
    public void corners()//вывод углов
    {
        double corner,rad1,cor1,rad2,cor2,rad3,cor3,m1,m2,n1,n2,x1,x2,x3,y1,y2,y3;
        double sumOfCorners=0;
        for(int i=0;i<3;i++)
        {
            rad1 = points[i].rad;
            cor1 = points[i].corner;
            rad2 = points[(i+1)%3].rad;
            cor2 = points[(i+1)%3].corner;
            rad3 = points[(i+2)%3].rad;
            cor3 = points[(i+2)%3].corner;
            x1 = rad1*cos(toRadians(cor1));
            y1 = rad1*sin(toRadians(cor1));
            x2 = rad2*cos(toRadians(cor2));
            y2 = rad2*sin(toRadians(cor2));
            x3 = rad3*cos(toRadians(cor3));
            y3 = rad3*sin(toRadians(cor3));
            m1 = x2 - x1; n1 = y2 - y1; m2 = x3 - x2; n2 = y3 - y2;
            corner = toDegrees(acos(abs(m1*m2+n1*n2)/(sqrt(m1*m1+n1*n1)*sqrt(m2*m2+n2*n2))));
            System.out.println("Corner number "+i+": "+corner);
            sumOfCorners+=corner;
        }
        System.out.println("Sum of corners: "+sumOfCorners);
    }
    
    public void area()//вывод площади
    {
        double[] s = new double[3];
        double p;
        for(int i=0;i<3;i++)
        {
            s[i] = side(points[i],points[(i+1)%3]);
        }
        //Формула Герона
        p = (s[0]+s[1]+s[2])/2;
        System.out.println("Area: "+sqrt(p*(p-s[0])*(p-s[1])*(p-s[2])));
    }
    
    public void turn(double corner)//поворот вокруг нуля
    {
        for(int i=0;i<3;i++)
        {
            points[i].corner+=corner;
            points[i].x = points[i].rad*cos(toRadians(points[i].corner));
            points[i].y = points[i].rad*sin(toRadians(points[i].corner));
        }
    }
    
    public void shift(Direction dir, double val)//сдвиг
    {
        double x,y;
        switch(dir)
        {
            case RIGHT:
                for(int i=0;i<3;i++)
                {
                    x = points[i].x;
                    y = points[i].y;
                    points[i].rad = sqrt(pow(x+val,2)+y*y);
                    points[i].corner = toDegrees(asin(y/points[i].rad));
                    points[i].x = points[i].rad*cos((PI/180)*points[i].corner);
                    points[i].y = points[i].rad*sin((PI/180)*points[i].corner);
                } break;            
            case LEFT:
                for(int i=0;i<3;i++)
                {
                    x = points[i].x;
                    y = points[i].y;
                    points[i].rad = sqrt(pow(x-val,2)+y*y);
                    points[i].corner = toDegrees(asin(y/points[i].rad));
                    points[i].x = points[i].rad*cos((PI/180)*points[i].corner);
                    points[i].y = points[i].rad*sin((PI/180)*points[i].corner);
                } break;         
            case UP:
                for(int i=0;i<3;i++)
                {
                    x = points[i].x;
                    y = points[i].y;
                    points[i].rad = sqrt(x*x+pow(y+val,2));
                    points[i].corner = toDegrees(acos(x/points[i].rad));
                    points[i].x = points[i].rad*cos((PI/180)*points[i].corner);
                    points[i].y = points[i].rad*sin((PI/180)*points[i].corner);
                }break;
            case DOWN:
                for(int i=0;i<3;i++)
                {
                    x = points[i].x;
                    y = points[i].y;
                    points[i].rad = sqrt(x*x+pow(y-val,2));
                    points[i].corner = toDegrees(acos(x/points[i].rad));
                    points[i].x = points[i].rad*cos((PI/180)*points[i].corner);
                    points[i].y = points[i].rad*sin((PI/180)*points[i].corner);
                }break;
        }
    }
    
    
}
