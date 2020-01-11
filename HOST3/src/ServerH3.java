
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerH3  {
	public static void main(String[] args) throws MalformedURLException {    
		try {
    	LocateRegistry.createRegistry(4444);
    	InterfaceH1H3Imp od=new InterfaceH1H3Imp();
    	Naming.rebind("rmi://192.168.8.100:4444/Norme2",od) ;
		System.out.println( " Je Suis Le Server de HOST 3 Lie à l’URL : rmi :// " + 
				getHostName()  + " / Norme_2 \n je suis à l'écoute...  "); 
	} catch (RemoteException e) {
		e.printStackTrace();
		return;
	}}
	private static String getHostName() {
		try {
			return  java.net.InetAddress.getLocalHost()+"";
		} catch (UnknownHostException e) {			
			return "";
		}
	}	
}