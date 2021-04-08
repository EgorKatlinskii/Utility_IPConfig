import java.net.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

public class IpConfig {


    public static void nameHost() {
        try {
            System.out.println(InetAddress.getLocalHost().getHostName());
            System.out.println(InetAddress.getLocalHost().getHostAddress() + "\n");
        } catch (Exception UnknownHostException) {
            UnknownHostException.printStackTrace();
        }

    }

    public static void gettingNetworkInterfaces() {
        try {
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();

            for (NetworkInterface networkInterface : Collections.list(nets)) {
                dropInfo(networkInterface);
                System.out.println("State interface: " + networkInterface.isUp());
                printMac(networkInterface.getHardwareAddress());
                System.out.println("Network prefix size: " + networkInterface.getInterfaceAddresses().get(1).getNetworkPrefixLength());
                System.out.println("\n");

            }

        } catch (Exception SocketException) {
            SocketException.printStackTrace();
        }
    }

    public static void dropInfo(NetworkInterface netint) {
        try {
            System.out.println("Display name: " + netint.getDisplayName());
            System.out.println("Name: " + netint.getName());

            Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
            for (InetAddress inetAddress : Collections.list(inetAddresses)) {
                System.out.println("InetAddress: " + inetAddress + "\nSize: " + inetAddress.toString().length());
            }

        } catch (Exception SocketException) {
            SocketException.printStackTrace();
        }

    }


    private static void printMac(byte[] mac) {
        StringBuilder sb = new StringBuilder();
        if (mac != null) {
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "" : ""));
            }
        }

        System.out.println("MAC: " + sb.toString().toLowerCase());

    }

}
