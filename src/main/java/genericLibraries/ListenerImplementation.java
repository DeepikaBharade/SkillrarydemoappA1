package genericLibraries;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener
{
	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println(result.getMethod().getMethodName()+ "execution starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println(result.getMethod().getMethodName()+"Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println(result.getMethod().getMethodName()+"Failed");
		System.out.println("Failure occured due to:" + result.getThrowable());
		//it will handle Exception with getThrowable() method
		
		WebDriverUtility web= new WebDriverUtility();
		//Static method we are calling here (sdriver)
		web.takeScreenshot(BaseClass.sdriver, result.getMethod().getMethodName(),BaseClass.sjutil);
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println(result.getMethod().getMethodName()+"skipped");
		System.out.println("Skipped due to:" +result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println("Suite execution Starts");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("Suite execution ends");
	}
}
