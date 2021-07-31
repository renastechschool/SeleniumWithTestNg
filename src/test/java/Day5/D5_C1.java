package Day5;

import org.testng.annotations.*;

public class D5_C1 {

    /*
    TestNG is testing framework for Java project
   - It comes with 15 annotations to help us to organize our project
   - It has assertions which helps us to validate test results
   -It TestNg.xml which runs the tests
   -It also has multi browser support which
    runs the test on different browsers in the same time
     */

    @BeforeClass // will run before every calls
    public void classSetup(){
        System.out.println("Before class is executed");
    }

    @AfterClass
    public void classCleanUp(){
        System.out.println("After class");
    }

    @BeforeMethod // this will run before every @Test method
    public void setup(){
        System.out.println("runs before every @Test method");
    }

    @AfterMethod// executed after every @Test
    public void tearDown(){
        System.out.println(" runs after every @Test");
    }
    @Test //execute a test
    public void test(){
        System.out.println("test");
    }

}
