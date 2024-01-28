import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
public class AddNumbers {

private int totalValue;
private int acceptInput;
private String[] MultData;



    private String Negativedata = "" ;

    public String getNegativedata() {
        return Negativedata;
    }

    public void setNegativedata(String negativedata) {
        Negativedata = negativedata;
    }

    public String[] getMultData() {
        return MultData;
    }

    public String getRawinput() {
        return Rawinput;
    }

    public void setRawinput(String rawinput) {
        Rawinput = rawinput;
    }

    private String Rawinput;

    public int getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }

    public int getAcceptInput() {
        return acceptInput;
    }

    public void setAcceptInput(int acceptInput) {
        this.acceptInput = acceptInput;
    }

public void AddValue() {
        int intermidvalue  ;
        intermidvalue = this.getTotalValue() + this.getAcceptInput();
        setTotalValue(intermidvalue);

}
public void CheckNegative() {
        if (this.getAcceptInput() < 0) {
          String tempA = this.getNegativedata() +"," + this.getAcceptInput();
          this.setNegativedata(tempA);
          this.setAcceptInput(0);
       }
    }
    public void CheckAboveThousand() {
        if (this.getAcceptInput() > 1000) {
             this.setAcceptInput(0);
        }
    }
public void Checknulldata() {
    if (AreyouaNumber(Rawinput) ) {
        this.setAcceptInput(Integer.valueOf(Rawinput));
    }else
    {
        this.setAcceptInput(0);
    }
}
//Function to check if the number is integer , double or floating
public static boolean AreyouaNumber(String StrNumber) {

    if (StrNumber == null) {
        System.out.println("Not a number");
        return false;
    }

    try {
        int intnum = Integer.parseInt(StrNumber);
    } catch (NumberFormatException nerr) {
        return false;
    }

      return true;

}

public void CheckMultData() {

/*
Check for Non-Numeric Characters and eliminate . This part
    will check for any numbers of delimiters and remove them from the input string
*/
    for (int i= 0 ;i<Rawinput.length(); i++) {
        int cp = Rawinput.codePointAt(i);

        if ( (cp>=48 && cp <=57)) {
            String Alpha = Rawinput.substring(i,i+1);

        } else
        {
            String NonAlpha = Rawinput.substring(i,i+1);
            int lp = i+1;
            if (lp == Rawinput.length()-2 ) {lp = i;}
            int nextcp = Rawinput.codePointAt(lp);

            if (( cp == 43 || cp == 45) && (nextcp >= 48 && nextcp <= 57)) {
                int skip = 1;


            } else {Rawinput = Rawinput.replace(NonAlpha," ");

            }

        }

    }



     Rawinput =  Rawinput.replace("\\n," , " ");
    this.MultData = Rawinput.split(" ");
   // System.out.println("Final Data " + Rawinput);

        }

    public static void main(String[] args) throws IOException {

        int j  ;
        AddNumbers addNumbers = new AddNumbers();

        for (int  ktr = 0 ; ktr<10 ; ktr++) {
            System.out.println("Enter Number");
            InputStreamReader inp = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(inp);
            String inputValue = br.readLine();

            addNumbers.setRawinput(inputValue);
            addNumbers.CheckMultData();
            int lenArray = addNumbers.getMultData().length;
            if (lenArray > 0 ) {
                for ( j = 0 ; j<lenArray ; j++) {
                    String indivElements = addNumbers.getMultData()[j];
                    addNumbers.setRawinput(indivElements);
                    addNumbers.Checknulldata();
                    addNumbers.CheckNegative();
                    addNumbers.CheckAboveThousand();
                    addNumbers.AddValue();
                }
            } else {
              //  System.out.println("checking the need of blank");
                addNumbers.setRawinput(inputValue);
                addNumbers.Checknulldata();
                addNumbers.AddValue();
             }

            System.out.println(addNumbers.getTotalValue());
            if (addNumbers.getNegativedata() != "" ) {
                System.out.println("Negative Numbers Not allowed " + addNumbers.getNegativedata());
                addNumbers.setNegativedata("");
            }
        }
    }
}