public class Perms {
    private int[] p; //массив перестановки
    private int[] res; //массив для вычислений
    private int n; // степень перестанови

    public Perms(int[] s) { //конструктор
        n = s.length;
        p=new int[n];
        for(int i=0;i<n;i++)
            p[i]=s[i];
    }

    public int getElem(int i){ //Элемент по индексу
        return this.p[i];
    }

    public void reversePerms() { //Обратная перестановка
        res=new int[n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++){
                if(i+1==this.p[j])
                {
                    res[i]=j+1;
                }
            }
        }
        for(int i=0;i<n;i++)
            this.p[i]=res[i];
    }

    public boolean isEqual(Perms a){ //Сравнение перестановок
        for(int i=0;i<n;i++){
            if(a.getElem(i) != this.getElem(i)){
                return false;
            }
        }
        return true;
    }

    public void multPerms(Perms a){ //Умножение перестановок
        res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=a.getElem(this.p[i]-1);
        }
        for(int i=0;i<n;i++)
            this.p[i]=res[i];
    }

    public void reverse() { //Перестановка в обратном порядке
        int temp;
        for(int i=0;i<n/2;i++) {
            temp=this.p[i];
            this.p[i] = this.p[n-i-1];
            this.p[n-i-1]=temp;
        }
    }

    public void printPerms(){ //Вывод перестаноки
            for(int i=0;i<n;i++)
                System.out.print(p[i]+" ");
            System.out.print("\n");
    }

}