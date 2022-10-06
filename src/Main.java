import java.util.Random;

public class Main
{
    public static void main(String[] args) {
        System.out.println("#n\tcSUM\tcMIN\tlSUM\tlMIN");
        int[] nList = {10, 32, 64, 128, 256, 512, 1024, 2048, 4096,8192, 8192*2, 8192*4};
        for (int n : nList) {
            long constantSum = 0;
            long constantMin = (int) Double.POSITIVE_INFINITY;
            long linearSum = 0;
            long linearMin = (int) Double.POSITIVE_INFINITY;
            long temp;


            for(int i = 0; i < 100; i++){
                Heap h = new Heap();
                for (int j = 0; j < n; j++){
                    h.addLinear(j);
                }
                long t_start, t_Total;
                Integer s = new Random().nextInt(1, n-2);
                t_start = System.nanoTime();
                h.removeLinear(s);
                temp= System.nanoTime()-t_start;
                linearSum += temp;
                if(temp < linearMin) linearMin = temp;


                h = new Heap();
                for (int j = 0; j < n; j++){
                    h.addLinear(j);
                }
                Node t = h.list.getNode(new Random().nextInt(n-2));
                t_start = System.nanoTime();
                h.removeConstant(t);
                temp = System.nanoTime()-t_start;
                constantSum += temp;
                if(temp < constantMin) constantMin = temp;

            }

            if(n != 10) System.out.printf("%d\t%d\t%d\t%d\t%d\n",n,constantSum/100, constantMin, linearSum/100, linearMin);
        }






    }
}
