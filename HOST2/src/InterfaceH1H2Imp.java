import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
public class InterfaceH1H2Imp extends UnicastRemoteObject implements interfaceH1H2 {
	private static final long serialVersionUID = 1L;
	protected InterfaceH1H2Imp() throws RemoteException {
		super();
	}
	@Override
	public void calculNorme1(double [] v) {
		System.out.println( "\nLe Vecteur Réçu De La Part De Client="+Arrays.toString(v)); 
		double som=0;
		for(double n :v) {
			som=som+n*n;
		}
		System.out.println( "NORME_1 = "+Math.sqrt(som));
		System.setProperty("java.security.policy","/etc/java-8-openjdk/security/java.policy");          
        try {
		
		interfaceH2H4H3 h2h4;
		try {
			h2h4 = (interfaceH2H4H3) Naming.lookup("rmi://192.168.8.100:5555/calculNorme");
			h2h4.setCalculNorme1(Math.sqrt(som));
			h2h4.Calcul();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
        } catch (NotBoundException e) {
			e.printStackTrace();
		}
        catch (RemoteException e) {
        	e.printStackTrace();
		}
	}  
}