import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

public class Task3 {

    public static void getLoopBack(){
        System.out.println("IPv4 Loopback address: "+Inet4Address.getLoopbackAddress()+"\nIPv6 Loopback address: "+Inet6Address.getLoopbackAddress().getHostAddress());
    }

    public static void listAllBroadcastAddresses() throws SocketException, UnknownHostException {
        List<InetAddress> broadcastList = new ArrayList<>();
        Enumeration<NetworkInterface> interfaces
                = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface networkInterface = interfaces.nextElement();

            if (networkInterface.isLoopback() || !networkInterface.isUp()) {
                continue;
            }

            networkInterface.getInterfaceAddresses().stream()
                    .map(a -> a.getBroadcast())
                    .filter(Objects::nonNull)
                    .forEach(broadcastList::add);
        }
        System.out.println("Broadcast IP address: "+broadcastList+"\n");
    }

}
