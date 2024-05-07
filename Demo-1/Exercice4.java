class Exercice4 {

    public static void main(String[] args) {

        int[] x = new int[3];

        for(int i=0; i<x.length; i++) {
            x[i] = i;
        }

        int y = 2;

        int[] z = foo(x, x, y);                                 // 1.5

        System.out.println( y );                                // 2
        System.out.println(x[0] + "," + x[1] + "," + x[2]);     // "2,3,4"
        System.out.println(z[0] + "," + z[1] + "," + z[2]);     // "2,3,4"
    }

    public static int[] foo(int[] a, int[] b, double c) {

        c++;
        
        System.out.println(c / 2);

        for(int i=0; i<a.length; i++) {
            a[i] += (int) (c / 2);
            b[i] += (int) (c / 2);
        }

        return b;
    }
}
