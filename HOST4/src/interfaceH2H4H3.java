import java.rmi.Remote;
import java.rmi.RemoteException;
public interface interfaceH2H4H3 extends Remote {
	public void setCalculNorme1(double d)throws RemoteException ;
	public void setCalculNorme2(double max)throws RemoteException ;
	public void genereFibo(int n)throws RemoteException;
	public void Calcul() throws RemoteException;
}
