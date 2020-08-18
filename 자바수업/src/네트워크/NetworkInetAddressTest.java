package 네트워크;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkInetAddressTest {

	public static void main(String[] args) {
		try {
			InetAddress[] google = InetAddress.getAllByName("a3536aa369ce.ngrok.io");
			for (InetAddress addr : google)
			    System.out.println(addr.getHostAddress());
			
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println(localhost);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}