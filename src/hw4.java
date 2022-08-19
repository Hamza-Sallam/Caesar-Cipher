import java.io.*;
import java.util.*;

public class hw4 {
//***********************PART I******************************************	
      public static void missing() {
		List<Double> lst = new ArrayList<Double>();
       // a reference to file that contains matrix
       File file = new File("part1.txt");
       // int N stores total rows, M stores total column
       double N = 0, M=0, temp;
       // i_error and j_error store row and column of missing information
       double i_error=0,j_error=0;
       BufferedReader r = null;
       try{
           r = new BufferedReader(new FileReader(file));
          String text= "";          
           // read the file line by line in variable text
           while((text = r.readLine()) != null){
               // split the text by spaces
                String[] s=text.split(" ");
                // columns = total length after split
                M = s.length;
                double i = 0;              
                for(i=0;i<s.length;i++){
                    try{
                        // if the current string is an integer add to the list
                        temp = Double.parseDouble(s[(int) i]);
                       lst.add(temp);
                    }
                    catch(Exception e){
                        // if current string is not integer
                        // store current index of error
                        i_error = N;

                        j_error = i;
                    }                 
                }
                // increase count of rows
                N++;
            }
        }
        catch(Exception e){
            System.out.println("File Not Found");
        }
        // create a multidimensional array to store retrieved matrix
        double matrix[][] = new double[(int) N][(int) M];     
        System.out.println("Matrix read from file:");
        for(double i=0;i<N;i++){
            for(double j=0;j<M;j++){
                // if error index is reached then make current element = 0
                if(i==i_error && j==j_error){
                    matrix[(int) i][(int) j] = 0;
                    System.out.print("* ");
                }
               // else keep adding element to matrix
                else{
                    matrix[(int) i][(int) j]=lst.get(0);
                    lst.remove(0);
                    System.out.print(matrix[(int) i][(int) j]+" ");
                }
            }
            System.out.print("\n");// print in new lin          
        }     
        // sum up the values in the column of error element
        double sumOfCol=0;
        for(double i=0 ;i<N;i++){
            sumOfCol+=matrix[(int) i][(int) j_error];
        }
        
        // strore average value of column in the error index
        matrix[(int) i_error][(int) j_error] = sumOfCol/(N-1);
        
        // print the final matrix
        System.out.println("\nMatrix after averaging column to get missing number:");
        for(double i=0; i<N ;i++){
            for(double j=0;j<M;j++){
                System.out.print(matrix[(int) i][(int) j]+" ");
            }
            System.out.print("\n");
        }
    }
//**********************PART II*******************************************
      public static String reead() throws IOException { 
    		File file=new File("part2.txt");    //creates a new file instance  
    		FileReader fr=new FileReader(file);   //reads the file  
    		BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
    		StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
    		String line;  
    		while((line=br.readLine())!=null) {   
    		sb.append(line);      //appends line to string buffer  
    		sb.append("\n");     //line feed   
    		}  
    		fr.close();    //closes the stream and release the resources  
    		String ss=sb.toString();
    		return ss; //returns a string that textually represents the object  
    		}
    		//*******************************************************		       
    		      public static void sipher() throws IOException {
    		      		String message, decryptedMessage = "";
    		      		int key;
    		      		char ch;
    		      		Scanner sc = new Scanner(System.in);   		      		
    		      		System.out.println("encrypted messages are:");
    	                  System.out.println(reead());
    		      		 message = reead();    		      		
    		      		System.out.println("\nEnter shift: ");
    		      		key = sc.nextInt();    		       
    		      		for(int i = 0; i < message.length(); ++i){
    		      			ch = message.charAt(i);      			
    		      			if(ch >= 'a' && ch <= 'z'){
    		      	            ch = (char)(ch - key);		      	            
    		      	            if(ch < 'a'){
    		      	                ch = (char)(ch + 'z' - 'a' + 1);
    		      	            }		      	            
    		      	            decryptedMessage += ch;
    		      	        }
    		      	        else if(ch >= 'A' && ch <= 'Z'){
    		      	            ch = (char)(ch - key); 		      	           
    		      	            if(ch < 'A'){
    		      	                ch = (char)(ch + 'Z' - 'A' + 1);
    		      	            }  		      	            
    		      	            decryptedMessage += ch;
    		      	        }
    		      	        else {
    		      	        	decryptedMessage += ch;
    		      	        }
    		      		}    		      		
    		      		System.out.println("Decrypted Messages = \n" + decryptedMessage);
    		      	}      
      //-**************************************************************
      
 //******************MAIN***********************************************     
      
      public static void main(String[] args) throws IOException {
		System.out.println("part I\n");
    	 missing();
		System.out.println("\npart II\n");
		sipher();
	}
}



