
public class one {

    public static void main (String [] args) {

        int n = 9;
        boolean arra[][] = new boolean[2][n];
        for (int j=0; j<n+1; j++) System.out.print(j);
        System.out.println();
        for (int i=0; i<2; ++i) {
            System.out.print((i+1));
            for (int j=0; j<n; j++) {
                arra[i][j] = (j>=i)?true:false;
                char a;
                a = (arra[i][j])?'*':' ';
                System.out.print(a);
            }
            System.out.println(' ');
        }


    }


}

