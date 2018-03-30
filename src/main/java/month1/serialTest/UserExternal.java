package month1.serialTest;

import java.io.*;

/**
 * @author aidar
 * @desc
 * @date 18-3-21
 */
public class UserExternal implements Externalizable {
    @Override public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }

    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "User{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
