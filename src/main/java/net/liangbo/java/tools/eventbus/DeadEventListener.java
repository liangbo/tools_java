package net.liangbo.java.tools.eventbus;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * Created with IntelliJ IDEA.
 * User: LiangBo mailto:liangbo1180@gmail.com
 * Date: 15/2/12
 * Time: 下午5:50
 */
public class DeadEventListener {


    @Subscribe
    public void handle(DeadEvent event){

        System.out.println("dead event");

        System.out.println(event.getSource());
        System.out.println(event.getEvent());
    }

}
