
package business;
import java.util.ArrayList;

/*
 * @author Katelyn Waddell 
 */
public class Bin2Dec {
    private String decresult, errmsg, startval;
    private ArrayList<String> steps;
    
    
    public Bin2Dec(String sval)
    {
        this.startval = sval;
        this.errmsg = "";
        if (isValid())
        {
            convert();
        }
        else
        {
            this.errmsg = "Start value not a valid binary number.";        }
    }
    private boolean isValid()
    {
        //check that startval is only 1s and 0s
        for (int i=0; i < this.startval.length(); i++)
        {
            if(this.startval.charAt(i) != '1' && this.startval.charAt(i) != '0')
                    return false;    
        }
        return true;
    }
    
    public String getErrorMsg()
    {
        return this.errmsg;
    }
    
    private void convert()
    {
        steps = new ArrayList<String>();
        
        // positions: 0123
        // exmple: "1101" = (1 * 2^0)+
        //                  (0 * 2^0)+
        //                  (1 * 2^0)+
        //                  (1 * 2^0)
        
        int pos = 0;
        long result = 0;
        for (int i=this.startval.length()-1; i >= 0; i--)
        {
            if (this.startval.charAt(i) == '1')
            {
                steps.add("There is a " + i + " In the value:  2 ^  " + pos);
            }
            this.decresult = String.valueOf(result);
        }
    }
    
    public String getResult()
    {
        return this.decresult;
    }
    
    public ArrayList <String> getSteps()
    {
        return this.steps;
    }
    
}
