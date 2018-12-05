package com.dyc.demo3.controller;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/19 09:26
 * @Description:
 */

import com.lmax.disruptor.ExceptionHandler;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/19 09:26
 * @Description:
 */
public class PlayerEventExceptionHandler implements ExceptionHandler {
    @Override
    public void handleEventException(Throwable throwable, long l, Object o) {

    }

    @Override
    public void handleOnStartException(Throwable throwable) {

    }

    @Override
    public void handleOnShutdownException(Throwable throwable) {

    }
}
