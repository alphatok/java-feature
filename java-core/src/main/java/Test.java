import org.openjdk.jol.info.ClassLayout;

public class Test {
    private int x = 0;
    private String str;
    
    public class Fruit {
        
        //占一个字节大小
        private boolean flag;
    }
    
    
    private int add(int x){
        int c = x*2;
        System.out.println("abc" + c);
        return c + 1;
    }
    
    public static void main(String[] args) {
      
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    new Test().add(1);
                }
            });
        }
        System.gc();
        System.out.print(ClassLayout.parseInstance(Fruit.class).toPrintable());
    }
}


