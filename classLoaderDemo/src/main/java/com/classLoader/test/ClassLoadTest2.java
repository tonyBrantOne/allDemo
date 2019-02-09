package com.classLoader.test;

import com.classLoader.util.ReadStrFromFileTest;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/24 16:43
 * @Description:测试jdk的classLoad
 */
public class ClassLoadTest2 extends ClassLoader{

 //   public static final String PATH_REPLACEED = "D:\\folder\\b\\";
    public static final String PATH_REPLACEED = "D:\\projectManage\\demo\\AllDemo\\redisConnection\\target\\classes\\com\\dyc\\model\\";

    public static final String FILE_TYPE = ".class";
    private String name = "load1";


    public static void main(String[] args) throws Exception {
       new ClassLoadTest2().startMain();
    }


    @Override
    public String toString() {
        return this.name;
    }

    public void startMain() throws Exception {
        ClassLoadTest2 classLoader = new ClassLoadTest2();
        Class<?> aClass = classLoader.loadClass("com.dyc.model.User");
            System.out.println("当前的aClass" + aClass.hashCode());
            Object object = aClass.newInstance();
            System.out.println("object-"+object);
            System.out.println("");
            aClass = null;
            for (;;){
                aClass = classLoader.loadClass("com.dyc.model.User");
                resolveClass(aClass);
                System.out.println("object-"+aClass.hashCode());
                object = aClass.newInstance();
                System.out.println("object-"+object);
                Thread.sleep(2000);
            }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
          byte[] bytes =  this.loadFileToHeap("User");
          return this.defineClass(name,bytes,0,bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException(e.getMessage());
        }
    }

    public byte[] loadFileToHeap( String name ) throws Exception {
        String path =  PATH_REPLACEED + name + FILE_TYPE;
        byte[] bytes = ReadStrFromFileTest.readInputStreamToByteArray(path);
        return bytes;
    }
}
