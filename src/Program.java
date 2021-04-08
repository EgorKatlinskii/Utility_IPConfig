import java.net.SocketException;
import java.net.UnknownHostException;

public class Program {
    public static void main(String[] args) throws UnknownHostException, SocketException {
        IpConfig.nameHost();
        IpConfig.gettingNetworkInterfaces();
        Task3.getLoopBack();
        Task3.listAllBroadcastAddresses();
        Task4.nsLookUp();
    }
}
