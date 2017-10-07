
package business;
import java.util.ArrayList;

/*
 * @author Katelyn Waddell
 */
public class Dec2Bin {
    private long decval; // converted string input (value we'll be operating on)
    private String binresult;
    private String errmsg; // carries indicator that we cannot convert the value
    private ArrayList<String> steps;
    
    public Dec2Bin(String decval)//needs to validate the string value
    {
        this.errmsg = "";
        
        try
        {
            this.decval = Long.parseLong(decval);
            if (this.decval < 0)
            {
                this.errmsg = "Values cannot be negative";
            }
            else
            {
                //convert by recursion
                this.binresult = "";
                steps = new ArrayList<>();
                convertByRecursion(this.decval);
            }
        }
        
        catch (Exception e)
        {
            this.errmsg = "Illegal value: non-integer start value";
            this.decval = 0;
        }
    }
    
    public String getErrorMsg()
    {
        return this.errmsg;
    }
    
    public String getResult()
    {
        return this.binresult;
    }
    
    private void convertByRecursion(long n)
    {
        int remainder;
        long newval;
        
        remainder = (int) (n % 2);
        newval = n/2; // integer division base 2
        steps.add(n + " divided by 2 = " + newval + " w/remainder of: " + remainder);
        if (newval > 0)
        {
            convertByRecursion(newval);
        }
        this.binresult += String.valueOf(remainder);
    }
    
    public ArrayList<String> getSteps()
    {
        return this.steps;
    }
    
}
