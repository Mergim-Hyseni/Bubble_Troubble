package Bubble_Trouble;

public class Main {
    static void towerOfHanoi(int n, char from_rod, char to_rod, char helper_rod)
    {
        if (n == 1)
        {
            System.out.println("Take disk 1 from rod " +  from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n-1, from_rod, helper_rod, to_rod);
        System.out.println("Take disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        towerOfHanoi(n-1, helper_rod, to_rod, from_rod);
    }
    public static int find3n(int n)
    {
        if (n==1)return 3;
        return find3n(n-1)+find3n(n-1)+find3n(n-1);
    }
    public static int find3nn(int n){
        int rez=1;
        for (int i = 1; i <=n ; i++) {
            rez*=3;
        }
        return rez;
    }

    public static void main(String args[])
    {
        int n = 3;
        System.out.println(find3nn(3));

    }

}
