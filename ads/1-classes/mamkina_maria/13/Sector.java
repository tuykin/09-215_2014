


public class Sector {

            public double x; // абсцисса центра
            public double y; // ордината центра
            public double x1;
            public double y1;
            public double x2;
            public double y2;

            public boolean proverka() {

                if((x==x1)&&(y==y1)||(x==x2)&&(y==y2)||(x1==x2)&&(y1==y2))
                {System.out.println("False,the same point");
                    return false;
                }
                if( Math.sqrt(Math.pow(2,(x2-x)) + Math.pow(2,(y2- y)))!=(Math.sqrt(Math.pow(2,(x1- x)) + (Math.pow(2,(y1- y))))))
                {System.out.println("False,different");


                    return false;
                }
                System.out.println("Allright!");
                return true;
            }


            public double ugol() {
                return (Math.acos((((x1*x2)+(y1*y2))/radius())));
            }


            public double S() {
                return ((ugol()/2)*(Math.pow(2,radius())));
            }



            public double l() {
                return (ugol()*radius());
            }

            public double radius(){
                return (Math.sqrt(Math.pow(2,(x2-x)) + Math.pow(2,(y2- y))));
            }



            public void entermatrix(double a[][],double s,double c){
                for(int i=0;i<2;i++)
                    for(int j=0;j<2;j++)
                    {if((i==0)&&(j==1))
                        a[i][j]=-s;
                    if((i==1)&&(j==0))
                         a[i][j]=s;
                    if((i==0)&&(j==0)||(i==1)&&(j==1))
                         a[i][j]=c;
                     }
            }

            public void mult(double[]a,double[][]b,double[]c){

                for(int i = 0; i < 2; i++)
                {c[i]=0;
                    for(int j = 0; j < 2; j++)
                     c[i]=c[i]+b[i][j]*a[j];


                }

            }
            public void povorot(int degrees,boolean flag){
                double radians = Math.toRadians(degrees);
                 //a=Math.sqrt(2*Math.pow(2,radius)-2*radius*Math.cos(radians));
                double []vector= {(x1-x),(y1-y)};
                double []vector1={(x2 - x), (y2 - y)};
                double [] newvector=new double[2];
                double []newvector1=new double[2];
                double [][] turn= new double[2][2];
                double c=Math.cos(radians);
                double s=Math.sin(radians);

                System.out.println(s);
                System.out.printf("%3f", (Math.cos(radians)));
                if(flag)
                    entermatrix(turn,s,c);
                else
                entermatrix(turn,(-s), c);
                mult(vector,turn,newvector);
                mult(vector1,turn,newvector1);
                x1=newvector[0];
                y1=newvector[1];
                x2=newvector1[0];
                y2=newvector1[1];
            }

            public void move(double a, double b) {
                x = x + a;
                y = y + b;
                x1 = x1 + a;
                y1 = y1 + b;
                x2 = x2 + a;
                y2 = y2 + b;

            }
            void setPoints(double a,double b,double c,double d,double e,double f) {
                x = a;
                y = b;
                x1 = c;
                y1 = d;
                x2 = e;
                y2 = f;
            }

        }