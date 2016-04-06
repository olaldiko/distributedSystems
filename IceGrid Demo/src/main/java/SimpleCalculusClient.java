public class SimpleCalculusClient
{
  public static void main(String args[])
  {
	  int n1,n2;
	  Ice.Communicator ic = null;
	
    //if(args.length!=1) System.out.println("Command line must contain --Ice.config=\"someConfigFile\"");
	  try 
	  {
	    ic = Ice.Util.initialize(args);
	    Ice.ObjectPrx base = ic.stringToProxy("SimpleCalculator@SimpleCalculatorAdapterIdentity");
	    utils.CalculatorPrx calculator= utils.CalculatorPrxHelper.checkedCast(base);
	    if (calculator == null) throw new Error("Invalid proxy");
      n1=calculator.gcd(2048,384);
      n2=calculator.gcd(n1,704);
      System.out.println("mcd(384,704,2048)="+n2);
      ic.destroy();
    }
    catch (Exception e) 
    {
      System.out.println("ERROR : " + e) ;
      e.printStackTrace(System.out);
    }
  }
}
