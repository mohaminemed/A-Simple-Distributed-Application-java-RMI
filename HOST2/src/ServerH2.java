import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerH2 {
	public static void main(String[] args) throws MalformedURLException {
        try {
        	
        	LocateRegistry.createRegistry(3333);
        	InterfaceH1H2Imp h1h2=new InterfaceH1H2Imp();// instanciation
        	Naming.rebind("rmi://192.168.8.100:3333/Norme1",h1h2) ;//enregistrement
        	
			System.out.println( " Je Suis le Server de HOST 2 Lie à l’URL : rmi :// " + 
					getHostName()  + " / Norme_1 \n Je suis à l'écoute...  "); 
		} catch (RemoteException e) {
			e.printStackTrace();
			return;
		}
}
	private static String getHostName() {
		try {
			return  java.net.InetAddress.getLocalHost()+"";
		} catch (UnknownHostException e) {		
			return "";
		}
	}	
}