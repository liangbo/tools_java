package net.liangbo.eventbus;

import com.google.common.eventbus.EventBus;
import net.liangbo.java.tools.eventbus.DeadEventListener;
import net.liangbo.java.tools.eventbus.EventHandler;
import net.liangbo.java.tools.eventbus.EventListener;
import net.liangbo.java.tools.eventbus.PolicyIssuedEvent;
import org.junit.Test;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: LiangBo mailto:liangbo1180@gmail.com
 * Date: 15/3/2
 * Time: ÏÂÎç8:54
 */
public class EventBusTest {
    
    @Test
    public void testEventBus(){
        EventBus eventBus = new EventBus();

        eventBus.register(new EventListener());
        eventBus.register(new EventHandler());

        eventBus.register(new DeadEventListener());


        eventBus.post(createPolicyEvent());

        eventBus.post(new Date());
    }

    private PolicyIssuedEvent createPolicyEvent() {
        PolicyIssuedEvent pie = new PolicyIssuedEvent();
        pie.setIssueTime(new Date());
        pie.setName("health policy");
        pie.setStatus(999);

        return pie;
    }
}
