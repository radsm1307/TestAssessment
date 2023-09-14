package env;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends DriverUtil{
    @Before
    public void init(){
//        getDefaultDriver();
//        WaitFor();
    }
    @After
    public void teardown() {
        System.out.println("Close browser");
        driver.quit();
    }
}
