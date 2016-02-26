import java.net.*;
import java.io.*;

/**
 *
 * @author njm24
 */
public class DateClient {
    
    private static final String SERVER = "127.0.0.1";
    private static final int PORT = 6017;
    
    public static void main(String[] args)
    {
        try{
            try (Socket sock = new Socket(SERVER, PORT)) {
                InputStream in = sock.getInputStream();
                BufferedReader bin = new BufferedReader(new InputStreamReader(in));
                
                //read the date back from the socket
                String line;
                while((line = bin.readLine()) != null)
                    System.out.println(line);
            }
            
            
        }
        catch(IOException ioe){
            System.err.println(ioe);
        }
                      
                   
              
    }
    
}
