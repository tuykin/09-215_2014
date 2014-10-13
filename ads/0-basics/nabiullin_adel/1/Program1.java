class Program1 {
    public static void main(String[] args){
        boolean[][] mass = new boolean[5][15];
        int i, j;
        mass[0][0]=mass[0][2]=mass[0][4]=mass[0][5]=mass[0][6]=mass[0][8]=mass[0][12]=true;
        mass[1][0]=mass[1][2]=mass[1][4]=mass[1][8]=mass[1][12]=true;
        mass[2][0]=mass[2][1]=mass[2][2]=mass[2][4]=mass[2][5]=mass[2][6]=mass[2][8]=mass[2][12]=true;
        mass[3][0]=mass[3][2]=mass[3][4]=mass[3][8]=mass[3][12]=true;
        mass[4][0]=mass[4][2]=mass[4][4]=mass[4][5]=mass[4][6]=mass[4][8]=mass[4][9]=mass[4][10]=mass[4][12]=true;
        mass[4][13]=mass[4][14]=true;
        System.out.print(' ');
        for (j = 0; j < 9; j++)
            System.out.print(j + 1);
        for (j = 0; j < 6; j++) {
            System.out.print((char)(j+(int)'A'));
        }
        System.out.print('\n');
        for (i = 0; i < 5; i++) {
            System.out.print(i+1);
            for (j = 0; j < 15; j++) {
                if (mass[i][j])
                    System.out.print('*');
                if (!mass[i][j])
                    System.out.print(' ');
                }
            System.out.print('\n');
        }
    }
}
