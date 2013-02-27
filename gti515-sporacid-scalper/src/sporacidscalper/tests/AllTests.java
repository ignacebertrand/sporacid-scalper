package sporacidscalper.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import sporacidscalper.tests.controller.modelcontroller.ModelControllerAllTests;
import sporacidscalper.tests.model.TransferObjectAllTests;


@RunWith(Suite.class)
@SuiteClasses({ModelControllerAllTests.class,
	           TransferObjectAllTests.class})
public class AllTests 
{

}
