package month1.classTest.refelectTest.constructorTest;

/**
 * @author aidar
 * @desc
 * @date 18-3-21
 */
public class StudentConstructor {
    public StudentConstructor(String str){
        System.out.println("(默认)的构造方法 s = " + str);
    }

    //无参构造方法
    public StudentConstructor(){
        System.out.println("调用了公有、无参构造方法执行了。。。");
    }

    //有一个参数的构造方法
    public StudentConstructor(char name){
        System.out.println("姓名：" + name);
    }

    //有多个参数的构造方法
    public StudentConstructor(String name ,int age){
        System.out.println("姓名："+name+"年龄："+ age);//这的执行效率有问题，以后解决。
    }

    //受保护的构造方法
    protected StudentConstructor(boolean n){
        System.out.println("受保护的构造方法 n = " + n);
    }

    //私有构造方法
    private StudentConstructor(int age){
        System.out.println("私有的构造方法   年龄："+ age);
    }

}
