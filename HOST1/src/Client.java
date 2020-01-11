import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client{
    public static double[] tab;
    public static int N;
    @SuppressWarnings("resource")
	public static void setTab() {
    	 Scanner scanner;
         System.out.println("Entrer Votre N:");
         scanner = new Scanner(System.in);
         N = Integer.parseInt(scanner.nextLine());
         tab = new double[N];
         System.out.println("\nEnter Les Eléments Du Vecteur :");
         for (int i = 0; i < N; i++) {
             tab[i] = Integer.parseInt(scanner.nextLine());
         }
	}
	public double[] GetTab() {
        return tab;
    }
	public static void main(String[] args) throws InterruptedException, MalformedURLException  {
//-------------------------------------------------------------------------------------------------------	  
                                              //Serveur+
//---------------------------------------------------------------------------------------------------------
	        try {
	        	LocateRegistry.createRegistry(6666);
	        	InterfaceH1H4Imp h1h4=new InterfaceH1H4Imp();
	        	Naming.rebind("rmi://192.168.8.100:6666/afficheNorme",h1h4) ;
				System.out.println( " Je Suis Client Lie à l’URL : rmi :// " + getHostName() ); 
			} catch (RemoteException e) {
				e.printStackTrace();
				return;
			}
//-------------------------------------------------------------------------------------------------------	  
	                                           //Client
//---------------------------------------------------------------------------------------------------------
	       System.setProperty("java.security.policy","/etc/java-8-openjdk/security/java.policy");          
	      try {	
	            
	    	    interfaceH1H2 s1 = (interfaceH1H2) Naming.lookup("rmi://192.168.8.100:3333/Norme1");
	            interfaceH1H3 s2 = (interfaceH1H3) Naming.lookup("rmi://192.168.8.100:4444/Norme2");
	            interfaceH2H4H3 s3 = (interfaceH2H4H3)  Naming.lookup("rmi://192.168.8.100:5555/calculNorme");
	                while(true) {
	                	System.out.println("\n!!  Nouveau Calcul !!"); 
	                    setTab();
					    System.out.println("Attendre Le Résultat De Calcul... ");
					   s3.genereFibo(N);
		               Thread.sleep(5000);
	                   s1.calculNorme1(tab);
	                   Thread.sleep(5000);
	                   s2.calculNorme2(tab);
	                   Thread.sleep(5000);
	                   s3.Calcul();        
	         }
			} catch (NotBoundException e) {
					e.printStackTrace();
			}
	          catch (RemoteException e) {
	            	e.printStackTrace();
			}
//------------------------------------------------------------------------------------------------------        
}

	private static String getHostName() {
		try {
			return  java.net.InetAddress.getLocalHost()+"";
		} catch (UnknownHostException e) {		
			return "";
		}
	}

}
