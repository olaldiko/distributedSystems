
public class Casio extends utils._CalculatorDisp 
{
  private int numOps;

  private void incNumOps()
  {
    numOps++;
    System.out.println("Numer of onvocations till now: "+numOps); 
  }

  public int numOps (Ice.Current current) 
  {
    return numOps;
  }
  public int gcd (int a, int b, Ice.Current current)
  {
    int tmp;
    
    incNumOps();
    while((tmp=a%b)!=0)
    {
      a=b;
      b=tmp;
    }
    return b;
  }
  public int factorial (int n, Ice.Current current)
  {
    int i,f=1;
    
    for(i=2;i<=n;i++) f*=i;
    incNumOps();
    return f;
  }
}
