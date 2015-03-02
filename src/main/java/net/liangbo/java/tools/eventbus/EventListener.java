package net.liangbo.java.tools.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * Created with IntelliJ IDEA.
 * User: LiangBo mailto:liangbo1180@gmail.com
 * Date: 15/2/12
 * Time: 下午3:57
 */
public class EventListener {


    @Subscribe
    public void handle(PolicyIssuedEvent event){

        System.out.println("receive an event");
        System.out.println(event);

    }



}
