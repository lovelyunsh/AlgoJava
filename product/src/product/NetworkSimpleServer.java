package product;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class NetworkSimpleServer {

	public static void main(String[] args) throws InterruptedException {
		int port = 5100;

		try (ServerSocket serverSocket = new ServerSocket(port)) {

			System.out.println("NetworkSimpleServer Started");

			while (true) {
				Socket socket = serverSocket.accept();
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ArrayList<Product> pArr = (ArrayList<Product>) ois.readObject();
				for (Product p : pArr)
					System.out.println(p);
			}

		} catch (IOException e) {
			System.out.println("NetworkSimpleServer exception: " + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("NetworkSimpleServer Ended");
	}
}