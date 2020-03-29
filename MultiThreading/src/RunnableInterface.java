public class RunnableInterface extends TestClass implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread name : " + Thread.currentThread().getName());

        System.out.println(TestClass.add(1, 3));


    }



    public static void main(String[]args){
        for(int i=0;i<10;i++){
            Thread obj = new Thread(new RunnableInterface());
            obj.start();
        }
    }
}
