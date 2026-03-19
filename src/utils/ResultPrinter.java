package utils;

public class ResultPrinter extends Thread {

    private int single;
    private int multi;
    private int pool;

    public ResultPrinter(int single, int multi, int pool) {
        this.single = single;
        this.multi = multi;
        this.pool = pool;
    }

    @Override
    public void run() {

        System.out.println("\n========= FINAL RESULTS =========");
        System.out.println("Single Thread Count: " + single);
        System.out.println("4 Threads Count: " + multi);
        System.out.println("Thread Pool Count: " + pool);
        System.out.println("=================================");
    }
}