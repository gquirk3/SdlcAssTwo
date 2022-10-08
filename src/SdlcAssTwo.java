
public class SdlcAssTwo {
	/**
	 * This is the main method.  It creates two threads that will be used by the recursion method and the iterative method.
	 * @param args  Strings passed into the main.
	 */
	public static void main(String[] args) 
	{
		Thread t1 = new Thread(new Recursion(40));  // creating thread for Recursion calculation
		Thread t2 = new Thread(new Iterative(40));  // creating thread for Iterative calculation
		
		// starting threads
		t1.start();
		t2.start();
	}

}
	/**
	 * This class contains the recursion method for calculating the fibonacci number.
	 * 
	 *
	 */
class Recursion extends Thread
{
	long startTime;
	long endTime;
	long time;
	int fibNumber;
	int n;
	

	public Recursion (int n)
	{
		this.n = n;
	}
	/**
	 * Returns the fibonacci number via the recursion method.
	 * @param n   any integer
	 * @return  the fibonacci number based on input integer
	 */
	// Recursion method
	public int fib(int n)
	{
		if((n == 0) || (n == 1))
			return n;
		else
			return fib(n - 1) + fib(n - 2);
	}
	
	public void run()
	{
		startTime = System.nanoTime();  // getting the time before the thread starts
		fibNumber = fib(n);  // calling the method and setting n
		endTime = System.nanoTime();  // getting the time after the thread ends
		time = (endTime - startTime);  // calculating the time to complete the thread
		System.out.println("Recursion Thread found the answer: " + fibNumber + " in " + time + "ns" );  // required output for Recursion calculation
	}
}
	/**
	 * This class contains the iterative method for calculating the fibonacci number.
	 * 
	 *
	 */
class Iterative extends Thread
{
	long startTime;
	long endTime;
	long time;
	int fibNumber;
	int n;
	
	public Iterative (int n)
	{
		this.n = n;
	}
	/**
	 * Returns the fibonacci number via the iterative method.
	 * @param n   any integer
	 * @return  the fibonacci number based on input integer
	 */
	// Iterative method
	public int fib(int n)
	{
		if(n == 0 || n == 1) return n;
		int v1 = 0;
		int v2 = 1;
		int v3 = 0;
		for(int i = 2; i <= n; i++)
		{
			v3 = v2 + v1;
			v1 = v2;
			v2 = v3;
		}
		return v3;
	}
	
	public void run()
	{
		startTime = System.nanoTime();  // getting the time before the thread starts
		fibNumber = fib(n);  // calling the method 
		endTime = System.nanoTime();  // getting the time after the thread ends
		time = (endTime - startTime);  // calculating the time to complete the thread
		System.out.println("Iterative Thread found the answer: " + fibNumber + " in " + time + "ns" );  // required output for Iterative calculation
	}
}