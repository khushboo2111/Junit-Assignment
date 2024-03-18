package list;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SendEmailImpl {

	HashMap<String, String> list = new HashMap<>();
	public String email="";
	public String password="";

	public SendEmailImpl()
	{ 
		
		
	}
	
	public boolean Register(String email, String password) {
		if(!isValidEmail(email))
		{
			System.out.println("Invalid email");
			return false;
		}
		
		else if(!isValidPassword(password))
		{
			System.out.println("Invalid password");
			return false;
		}
		
		else {
			list.put(email, password);
			System.out.println("Valid registeration");
		}
		return true;
	}
	
    public boolean isValidEmail(String email) {
    	String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                  
		Pattern pat = Pattern.compile(emailRegex); 
		if (email == null) 
		return false; 
		return pat.matcher(email).matches(); 	
    	
    }
    
    public boolean  isValidPassword(String password)
    {
 
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])"
                       + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);

        if (password == null) {
            return false;
        }

		return p.matcher(password).matches(); 	
    }
 
    public boolean userExist(String email) {
    	if(list.containsKey(email))
    	{
    		return true;
    	}
    	return false;
    }

    public boolean newPassword(String email, String password)
    {
    	System.out.println("Email sent" + email);
    	if(email == "")
    	{
    		return false;
    	}
    	else if(!isValidPassword(password))
    	{
    		System.out.println("Enter valid password");
    		return false;
    	}
    	else
    	{
    		list.replace(email, password);
    		System.out.println("Password changed");
    		return true;
    	}
    }
    
    public boolean Login(String email, String password)
    {
    	if(!list.containsKey(email))
    	{
    		return false;
    	}
    	
    	else if(!list.get(email).equals(password))
    	{
    		return false;
    	}
    	else {
    		System.out.println("Login successful");
    		return true;
    	}
    }
    
    
public  void AuthApp() {
		
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter an email: ");
		email = sc.nextLine();
		if(!isValidEmail(email))
		{
			System.out.println("Invalid Email");
			return;
		}

		System.out.println("Enter a password: ");
		password = sc.nextLine();
		
		if(!Register(email, password))
			return;
		
		
		
		System.out.println("Registeration Successful\t");
		System.out.println("Choose an option\t");
		System.out.println("1. Forgot Password 2. Login");

		int option = 1;
		option = sc.nextInt();
		switch (option) {
		  case 1:
			  System.out.println("Forgot Password");

				System.out.println("Enter your email: ");
				Scanner s = new Scanner(System.in);
				email = s.nextLine();
				
				if (userExist(email)) {
					System.out.println("Email Sent");

					System.out.println("Enter your new password: ");
					Scanner c = new Scanner(System.in);
					email = c.nextLine();

					if(!newPassword(email, password))
						return;

				} else {
					System.out.println("Invalid Email");
				}
		    break;
		  case 2:
			  System.out.println("Log Into Your Account");

				System.out.println("Enter your email: ");
				Scanner t = new Scanner(System.in);
				email = t.nextLine();

				System.out.println("Enter your password: ");
				Scanner q = new Scanner(System.in);
				password = q.nextLine();
				
				boolean res = Login(email, password);

				if (res) {
					System.out.println("Login Successful");
				} else{
					System.out.println("Invalid login");
				}
				

		    break;
		}
		
		
		sc.close();
	}

}
