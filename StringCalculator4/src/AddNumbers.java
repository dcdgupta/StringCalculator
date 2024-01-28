import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddNumbers {

private int totalValue;
private int acceptInput;
private String[] MultData;

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
    Rawinput =  Rawinput.replace("\\" , ",");
    Rawinput =  Rawinput.replace("n" , ",");
    Rawinput =  Rawinput.replace("\n" , ",");
    Rawinput =  Rawinput.replace("/" , ",");
    Rawinput =  Rawinput.replace(";" , ",");
    Rawinput =  Rawinput.replace("," , " ");

    Rawinput =  Rawinput.replace("\\n," , " ");

    this.MultData = Rawinput.split(" ");
        }

    public static void main(String[] args) throws IOException {

        int i = 0 ;
        AddNumbers addNumbers = new AddNumbers();
        int totfn = 0;
        for (int j = 0 ; j<10 ; j++) {
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
                    addNumbers.AddValue();
                }
            } else {
                addNumbers.setRawinput(inputValue);
                addNumbers.Checknulldata();
                addNumbers.AddValue();
             }

            System.out.println(addNumbers.getTotalValue());
        }
    }
}