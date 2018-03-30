package month1.classTest.refelectTest.fieldTest;

/**
 * @author aidar
 * @desc
 * @date 18-3-21
 */
public class StudentField {
    public String name;
    protected int age;
    char sex;
    private String phoneNum;

    @Override public String toString() {
        return "Student [name=" + name + ",age=" + age + ",sex=" + sex + ", phoneNum=" + phoneNum +"]";
    }
}
