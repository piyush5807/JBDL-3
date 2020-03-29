public class ThreadClass extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread name : " + currentThread().getName());

    }



    public static void main(String[]args){
        for(int i=0;i<10;i++){
            ThreadClass obj = new ThreadClass();
            obj.start();

        }
    }
}
