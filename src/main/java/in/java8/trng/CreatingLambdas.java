package in.java8.trng;

import java.util.concurrent.Callable;

public class CreatingLambdas {

	
	public void testGreeting(String a, Greeting g)
	{
		String result = g.sayHello(a);
		System.out.println(result);
	}
	
	public void methodAcceptingRunnable(Runnable r)
	{
		r.run();
	}
	
	public void methodAcceptingCallable(Callable<String> c)
	{
		try {
			System.out.println(c.call());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		new CreatingLambdas().testGreeting("kiran", (s) -> "Hello "+s);
		new CreatingLambdas().testGreeting("", s -> !s.isEmpty()?"Howdy "+s:"Did you miss somethng");
		Runnable runn = () -> System.out.println("got inside runnable run method");
		new CreatingLambdas().methodAcceptingRunnable(() -> System.out.println("testing method accepting runnable") );
		new CreatingLambdas().methodAcceptingRunnable(runn);
		new CreatingLambdas().methodAcceptingRunnable(() -> 
		{
			System.out.println("complex lambdas");
		}
				);
		new CreatingLambdas().methodAcceptingCallable(() -> "Inside callable call" );
	}
}
