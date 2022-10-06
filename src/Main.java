import java.util.Random;

public class Main
{
    public static void main(String[] args) {
        System.out.println("#n\tcon sum \t lin sum");
        int[] nList = {10, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192 };
        for (int n : nList) {
            long constantSum = 0;
            long linearSum = 0;

            for(int i = 0; i < 1000; i++){
                Heap h = new Heap();
                for (int j = 0; j < n; j++){
                    h.addLinear(j);
                }
                long t_start, t_Total;
                t_start = System.nanoTime();
                h.removeLinear(5);
                linearSum += System.nanoTime()-t_start;

                h = new Heap();
                for (int j = 0; j < n; j++){
                    h.addLinear(j);
                }
                Node temp = h.list.getNode(new Random().nextInt(n-2));
                t_start = System.nanoTime();
                h.removeConstant(temp);
                constantSum += System.nanoTime()-t_start;

            }

            if(n != 10) System.out.printf("%d\t%d\t%d\n",n,constantSum/1000, linearSum/1000);
        }






    }
}
