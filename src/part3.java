import java.io.*;
import java.util.ArrayList;

public class part3 {
    protected ArrayList<String> A;

    public part3() {
        A = new ArrayList<String>();
    }
    public int GetCount() { 
    	return(A.size()); 
    	}

    public String IndexerGetAtIndex(int iIndexPos) {
      String strReturn = null;
       if (iIndexPos>=0 && iIndexPos<A.size()) {
          strReturn = (String)A.get(iIndexPos);
       }
       return(strReturn);
    }  
    public void read(String filename) {
         try
         {
              FileReader fileReader = new FileReader(filename);
              BufferedReader bufferedReader = new BufferedReader(fileReader);
              String inbuff = new String("?");
              while (inbuff != null) {          
                  inbuff = bufferedReader.readLine();
                  if (inbuff==null || inbuff.length()==0) { break; }
           
                  //tokens[0] contains the 1st number; tokens[2] contains the 2nd number
                  //tokens[1] contains the operations symbol; tokens[3] contains the equal sign
                  // tokens[4] contains the alleged answer
                  
                  String tokens[] = (inbuff.trim()).split(" ");               
                  double num1 = Double.parseDouble(tokens[0]);
                  double num2 = Double.parseDouble(tokens[2]);
                  double answer = Double.parseDouble(tokens[4]);
                  double Answer=0;
                  
                  switch (tokens[1].charAt(0)) {

                     case '+' : {  Answer = num1 + num2; break; }

                     case '-' : {  Answer = num1 - num2; break; }

                     case '*' : {  Answer = num1 * num2; break; }

                     case '/' : { 
                           if (num2==0) {
                               Answer = Double.POSITIVE_INFINITY;
                           }
                           else {
                               Answer = num1/num2;
                            }
                           break;
                      }
                      case '%' : {
                           if (num2==0) {
                              Answer = Double.POSITIVE_INFINITY;
                           }
                           else {
                                Answer = (long)num1%(long)num2;
                            }
                           break;
                      }
                  }  //switch                                                 
                    if (Answer!=answer) {                 	
                          A.add(inbuff);
                      }
               } //while
              bufferedReader.close();                   
              int n = A.size();
              for ( int iLoop=0; iLoop<n; iLoop++) {                 
            	  System.out.println((String)A.get(iLoop));
              }
         }
         catch (IOException ex) {      	 
   System.out.println(" IO Exception occurs opening/reading file ");
         }
    }
//*******************************************
     public static void main(String args[]) {
             part3 x = new part3();
        System.out.println("the wrong operations written in the file are : \n");
             x.read("part3.txt");
     }
}
