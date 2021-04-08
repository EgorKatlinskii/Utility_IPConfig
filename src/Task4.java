
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;


public class Task4 {

    public static void nsLookUp() throws UnknownHostException {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        try{
            InetAddress inetAddress=InetAddress.getByName(str);
            System.out.println("Canonical hostname: "+inetAddress.getCanonicalHostName());
            System.out.println("Hostname: "+inetAddress.getHostName());
            System.out.println("Hostname and IPv4,IPv6: "+Arrays.toString(Inet4Address.getAllByName(str)));
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}

