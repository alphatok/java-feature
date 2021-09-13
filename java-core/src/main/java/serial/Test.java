package serial;

import java.io.*;

public class Test {
    
    public static class User implements Serializable {
        private static final long serialVersionUID = 123456L;
        private transient String age;
        private String name;
    
        public String getAge() {
            return age;
        }
    
        public void setAge(String age) {
            this.age = age;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    
    public static void main(String[] args) throws Exception, IOException {
        SerializeUser();
        DeSerializeUser();
    }
    //序列化
    private static void SerializeUser() throws FileNotFoundException, IOException, ClassNotFoundException {
        User user = new User();
        user.setName("Java的架构师技术栈");
        user.setAge("xx");
        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("F://template"));
        oos.writeObject(user);
        oos.close();
        System.out.println("添加了transient关键字序列化：age=  "+user.getAge());
    }
    //反序列化
    private static void DeSerializeUser() throws IOException, ClassNotFoundException {
        File file = new File("F://template");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User newUser = (User)ois.readObject();
        System.out.println("添加了transient关键字反序列化：age=  "+newUser.getAge());
    }
}
