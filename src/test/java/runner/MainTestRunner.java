package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserRegistrationTest.class,
        UserLoginTest.class
})
public class MainTestRunner {
}
