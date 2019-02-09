package com.classLoader.test;

import com.classLoader.util.MyURLClassLoader;
import com.classLoader.util.ReadStrFromFileTest;
import com.dyc.pub.model.User;

import java.io.File;
import java.net.URL;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/24 16:43
 * @Description:测试jdk的classLoad
 */
public class ClassLoadTest4 extends ClassLoader{

    public static final String PATH_REPLACEED = "D:\\projectManage\\pubWar\\basePub\\target\\classes\\com\\dyc\\pub\\model\\";

    public static final String FILE_TYPE = ".class";
    private String name = "load1";



    public ClassLoadTest4() {
        super();
    }

    public ClassLoadTest4(ClassLoader parent) {
        super(parent);
    }

    public static void main(String[] args) throws Exception {
       new ClassLoadTest4().startMain();
    }


    @Override
    public String toString() {
        return this.name;
    }

    public void startMain() throws Exception {
            ClassLoader parentLoader = ClassLoadTest4.class.getClassLoader();
            for (;;){
                User user = new User();
                System.out.println("代码中的："+user + ",class" + user.getClass().hashCode());
                ClassLoadTest4 classLoadTest3 = new ClassLoadTest4(parentLoader);
                this.reloadUser(classLoadTest3);
           //     this.reloadUser2( new ClassLoadTest4(null));
                System.out.println("");
                Thread.sleep(2000);
            }
    }

    private void reloadUser( ClassLoadTest4 classLoadTest4 ) throws Exception {
        Class<?> aClass = classLoadTest4.loadClass("com.dyc.pub.model.User");
        System.out.println("当前的aClass" + aClass.hashCode() + ",它的class名称"+aClass.getName()  +",它的classLoad为" + aClass.getClassLoader());
        Object object = aClass.newInstance();
        User user = (User) object;
        System.out.println("user-"+user);
    }

    private void reloadUser2( ClassLoadTest4 classLoadTest4 ) throws Exception {
        Class<?> aClass = null;
        try {
             aClass = classLoadTest4.loadClass("com.dyc.pub.model.User");
        }catch (Exception e){
            System.out.println("该文件已删除");
            return;
        }
        System.out.println("当前的aClass" + aClass.hashCode() + ",它的class名称"+aClass.getName()  +",它的classLoad为" + aClass.getClassLoader());
        Object object = aClass.newInstance();
    //    User user = (User) object;
        System.out.println("object-"+object);
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
