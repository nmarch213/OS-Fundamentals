import java.net.*;
import java.io.*;

/**
 *
 * @author njm24
 */
public class MessageServer {
    
    private static final int PORT = 8080;
    
    public static void main(String[] args)
    {

        
        try{
            ServerSocket sock = new ServerSocket(PORT);

            
            
            
            //Listen for connection
            while(true){
                try (Socket client = sock.accept()) {
                    PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                    System.out.println("Client Connected");
                    
                    //Write the quote of the day
                    //Change from date to QOTD
                    pout.println();
                }
            }
        }
        catch(IOException ioe)
        {
            System.err.println(ioe);
        }
    }
    
   
    
}
