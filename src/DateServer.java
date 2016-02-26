import java.net.*;
import java.io.*;

/**
 *
 * @author njm24
 */
public class DateServer {
    
    private static final int PORT = 6017;
    
    public static void main(String[] args)
    {
        String qotd = " ";
        
        try{
            ServerSocket sock = new ServerSocket(PORT);
            qotd = getQOTD();
            
            
            
            //Listen for connection
            while(true){
                try (Socket client = sock.accept()) {
                    PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                    System.out.println("Client Connected");
                    
                    //Write the quote of the day
                    //Change from date to QOTD
                    pout.println(qotd);
                }
            }
        }
        catch(IOException ioe)
        {
            System.err.println(ioe);
        }
    }
    
    public static String getQOTD()  
    {
        String qotd;
        
        try{
            Socket sock = new Socket("127.0.0.1", 17);
            
            InputStream in = sock.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));
            
            while((qotd = bin.readLine()) != null)
                    return qotd;
        }
        catch(IOException ioe){
            System.err.println(ioe);
            System.err.println("Error is here");
        }
        
        
        qotd = "Quote not found";
        
        return qotd;
    }
    
}

