package month1.serialTest;

import java.io.*;

/**
 * @author aidar
 * @desc
 * @date 18-3-21
 */
public class ExternalTest2 {
    public static void main(String[] args) throws Exception{
        UserExternal2 user = new UserExternal2();
        user.setAge(25);
        user.setName("aidar");
        System.out.println(user);

        //write object to File
        FileOutputStream fos = new FileOutputStream("/home/upsmart/IdeaProjects/learning20180315/src/main/java/month1/serialTest/tempFile");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(user);

        //read object from file
        File file = new File("/home/upsmart/IdeaProjects/learning20180315/src/main/java/month1/serialTest/tempFile");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        UserExternal2 newUser = (UserExternal2)ois.readObject();
        System.out.println(newUser);

    }
}
