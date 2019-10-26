/*
* 多线程的两种实现方式
* */
public class testThread{
    public static void main(String[] args) {
        //第一种线程启动方式(接口实现)
        Thread thread1 = new Thread(new ThreadRunableTest());
        thread1.start();
        //第二种线程启动方式(继承实现)
        ThreadExtendsTest thread2 = new ThreadExtendsTest();
        thread2.start();
    }
}
class ThreadRunableTest implements Runnable{
    public void run(){
        for (int i = 0;i<10;i++)
            System.out.println(Thread.currentThread().getName()+"运行中");
    }
}
class ThreadExtendsTest extends Thread{
    public void run(){
        for (int i =0;i<10;i++)
            System.out.println(Thread.currentThread().getName()+"运行中儿");
    }
}
