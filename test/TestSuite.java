import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@SuiteClasses(value = { CustomerTest.class, MovieTest.class, RentalTest.class })
@RunWith(Suite.class)
public class TestSuite {

}
