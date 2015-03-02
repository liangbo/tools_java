package net.liangbo.java.tools.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * Created with IntelliJ IDEA.
 * User: LiangBo mailto:liangbo1180@gmail.com
 * Date: 15/2/12
 * Time: 下午5:26
 */
public class EventHandler {

    @Subscribe
    public void handle(PolicyIssuedEvent event){
        System.out.println("this handler'name is EventHandler");
        System.out.println(event);
    }
}
