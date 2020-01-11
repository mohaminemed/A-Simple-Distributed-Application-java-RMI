
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class InterfaceH1H3Imp extends UnicastRemoteObject implements interfaceH1H3  {
	private static final long serialVersionUID = 1L;
	protected InterfaceH1H3Imp() throws RemoteException {
		super();
	}
	@Override
	public void calculNorme2(double[] v) {
		System.out.println( "\nLe Vecteur Réçu De La Part De Client="+Arrays.toString(v)); 
		double max=Math.abs(v[0]);
		for(double n :v) {
			if(Math.abs(n)>max) {
				max=Math.abs(n);
			}
		}
		System.out.println("NORME_2 ="+max);
		//--------------------------------------------------------------------
				System.setProperty("java.security.policy","/etc/java-8-openjdk/security/java.policy");          
		        try {
				
				interfaceH2H4H3 h3h4;
				try {
					h3h4 = (interfaceH2H4H3) Naming.lookup("rmi://192.168.8.100:5555/calculNorme");
				    h3h4.setCalculNorme2(max);
				    h3h4.Calcul();
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
