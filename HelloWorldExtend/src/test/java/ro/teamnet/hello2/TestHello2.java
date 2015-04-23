package ro.teamnet.hello2;

import org.junit.Test;

/**
 * Created by Andrei on 4/22/2015.
 */
public class TestHello2 {

    @Test
    public void testExtendSayHello(){
        HelloWorldExtend extendHello = new HelloWorldExtend();
        extendHello.extendSayHello();
    }
}
