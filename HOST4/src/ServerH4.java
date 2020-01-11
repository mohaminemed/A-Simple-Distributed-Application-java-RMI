import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class ServerH4 {
	public static void main(String[] args) throws MalformedURLException {    
	try {
    	LocateRegistry.createRegistry(5555);
    	InterfaceH2H4H3Imp od=new InterfaceH2H4H3Imp();
    	Naming.rebind("rmi://192.168.8.100:5555/calculNorme",od) ;
		System.out.println( " Je Suis Le Server de HOST 4 Lie à l’URL : rmi :// "
    	+ getHostName()+ " / Calcul Norme \n je suis à l'écoute...  "); 
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
