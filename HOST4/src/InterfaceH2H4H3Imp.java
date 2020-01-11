import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InterfaceH2H4H3Imp extends UnicastRemoteObject implements interfaceH2H4H3{
	private double n1,n2;
	private static int nbO=0,nbE=0,N=-1;
	private static final long serialVersionUID = 1L;
	protected InterfaceH2H4H3Imp() throws RemoteException {
		super();
	}
	public static long fibo(long x) {
		if(x==0) return 0;
		if(x==1 || x==2)return 1;
		else {
			long x1=0,x2=1,x3=0;
	    	for(int i=2;i<=x;i++) {
    		x3=x1+x2;
    		x1=x2;x2=x3;}
	    	return x3;}   		
	}
	public void genereFibo (int n)throws RemoteException {
		N=n;
        nbO=0;
        nbE=0;
		System.out.println("Valeur reçu de la part de Client = "+n);
		long fibo;
		for (int i = 0; i <= N; i++) {
			fibo=fibo(i);
			System.out.println("fibo["+i+"]="+fibo);
			if(fibo%2==0) nbE++;
			else nbO++;
		}
		System.out.println("Nombre de nombres pairs = "+nbE);
		System.out.println("Nombre de nombres impairs = "+nbO+"\n");
	}
	@Override
	
 public void Calcul() throws RemoteException{
	if((getCalculNorme1()==0 || getCalculNorme2()==0) || N==-1 )
	return ;
	else {
	try {
	 System.setProperty("java.security.policy","/etc/java-8-openjdk/security/java.policy"); 
     interfaceH1H4 h1h4;			
	 Thread.sleep(1000);
	 System.out.println("Résultat_Global ="+(nbE*getCalculNorme1())/(nbO*getCalculNorme2())+"\n");
     h1h4 = (interfaceH1H4)Naming.lookup("rmi://127.0.0.1:6666/afficheNorme");
     h1h4.affiche((nbE*getCalculNorme1())/(nbO*getCalculNorme2()));
	 } catch (Exception e) {
	 e.printStackTrace();
	 }
     n1=0.0;n2=0.0;	       
	 }
	}
	@Override
	public void setCalculNorme1(double norme1) throws RemoteException {
		System.out.println( "la NORME_1 reçue de la part de serveur HOST2 == "+norme1);
	    n1=norme1;
	}

	@Override
	public void setCalculNorme2(double norme2) throws RemoteException {
		System.out.println( "la NORME_2 reçue de la part de serveur HOST3 == "+norme2);
		 n2=norme2;
	}
	public double getCalculNorme1() {return n1;}
	public double getCalculNorme2() {return n2;}
}
