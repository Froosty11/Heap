public class Main
{
    public static void main(String[] args) {
        long sum = 0;
        for(int i = 0; i < 100000; i++){
            Heap h = new Heap();
            h.addLinear(5);
            h.addLinear(4);
            h.addLinear(3);
            h.addLinear(2);
            h.addLinear(1);
            h.addLinear(6);
            h.addLinear(7);
            h.addLinear(8);
            Node temp = h.list.getNode(4);
            long t_start, t_Total;
            t_start = System.nanoTime();
            h.removeConstant(temp);
            t_Total = System.nanoTime()-t_start;
            sum += t_Total;
            System.out.println(h.list.toString());
        }


        System.out.println(sum/100000);





    }
}
