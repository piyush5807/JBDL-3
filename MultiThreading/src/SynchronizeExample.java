public class SynchronizeExample extends Thread{

    @Override
    public void run() {
        printName();
    }

    public void printName(){

        // Operating on non shared resources
        System.out.println("In function: " + currentThread().getName());


        // Operating on shared resources
        synchronized (this){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("current thread in printName is " + currentThread().getName());
        }

    }

    public static void main(String[]args){
        for(int i=0;i<10;i++){
            SynchronizeExample obj = new SynchronizeExample();
            obj.start();
        }
    }
}
