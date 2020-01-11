import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InterfaceH1H4Imp extends UnicastRemoteObject implements interfaceH1H4{
	
	private static final long serialVersionUID = 1L;
	protected InterfaceH1H4Imp() throws RemoteException {
		super();
	}

	@Override
	public void affiche(double d) throws RemoteException {
		System.out.println("Le Résultat Réçu De La Part De Server HOST-4 = "+d);
		
	}

}