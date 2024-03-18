package list;

public class Main {

	public static void main(String args[])
	{
		SendEmailImpl auth = new SendEmailImpl();
		
		while(true)
		{
			auth.AuthApp();
		}
		
	}
}
