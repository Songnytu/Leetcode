public class testinterface{
    public static void main(String[] args) {

    }
    
}
class Test{
    private static Test test = new Test();
    Test(){}
    public static Test getTest(){
        return test;
    }
}
class Test1{
    private  static Test1 test1;
    private Test1(){}
    private static synchronized Test1 getTest1(){
        if (test1 == null){
            test1 = new Test1();
        }
        return test1;
    }
}
