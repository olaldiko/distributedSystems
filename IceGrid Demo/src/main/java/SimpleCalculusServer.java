import java.io.*;

public class SimpleCalculusServer
{
  public static void main(String args[]) 
  {
	BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	int status = 0;
	Ice.Communicator ic = null;
	Ice.ObjectAdapter adapter;
	 
	//if(args.length!=1) System.out.println("Command line must contain --Ice.config=\"someConfigFile\"");
	try 
	{
	  ic = Ice.Util.initialize(args);
	  adapter=ic.createObjectAdapter("SimpleCalculatorAdapter");
	  Ice.Object object = new Casio();
	  adapter.add(object,ic.stringToIdentity("SimpleCalculator"));
	  adapter.activate();
	  System.out.println("SimpleCalulator server ready .... ");
	  System.out.println("To Stop server pulse \"Return\" .... ");
	  stdIn.readLine();
	  ic.destroy();
	} 
	catch (Ice.LocalException e) 
	{
	  e.printStackTrace();
	  status = 1;
	}
	catch (Exception e) 
	{
	  System.err.println(e.getMessage());
	  status = 1;
	}
	if (ic != null) 
	{
	  // Clean up
	  try 
	  {
	    ic.destroy();
	  } 
	  catch (Exception e) 
	  {
	    System.err.println(e.getMessage());
	    status = 1;
	  }
	}
	System.exit(status);
  }
}
