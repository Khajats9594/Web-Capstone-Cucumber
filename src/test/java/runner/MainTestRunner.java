package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserRegistrationTestRunner.class,
        UserLoginTestRunner.class
})
public class MainTestRunner {
}
