package com.dyc.genericDemo1.handle;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 13:35
 * @Description:
 */
public abstract class AbstractBaseController<T>{
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public AbstractBaseController() {
    }

    public AbstractBaseController(T t) {
        this.t = t;
    }


    public T registerUser( T t){
        System.out.println(t);
        return t;
    }

    protected abstract T getPOLoginSuccess(T t);

}
