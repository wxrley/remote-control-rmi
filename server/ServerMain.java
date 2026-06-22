import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ServerMain {

    private static final int REGISTRY_PORT = 1099;
    private static final String SERVICE_NAME = "RemoteControlService";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter this machine's IP (the one the client will use):");
            String serverIP = scan.nextLine().trim();

            /*
             * java.rmi.server.hostname: endereço que o RMI embute no stub enviado ao cliente.
             * Sem definir isso, em Linux o RMI normalmente usa o loopback (127.0.0.1) e o cliente
             * não consegue chamar os métodos remotos a partir de outra máquina na rede.
             */
            System.setProperty("java.rmi.server.hostname", serverIP);

            try {
                //LocateRegistry.createRegistry(REGISTRY_PORT): inicia o registro RMI nesta porta.
                LocateRegistry.createRegistry(REGISTRY_PORT);
                System.out.println("RMI Registry started on port " + REGISTRY_PORT + ".");
            } catch (RemoteException e) {
                System.out.println("RMI Registry is already running on port " + REGISTRY_PORT + ".");
            }

            /*
             * RemoteControlImplementation control: instancia o serviço remoto baseado na interface que o cliente utiliza.
             * LocateRegistry.getRegistry(): acessa o Registry onde os serviços remotos são registrados e encontrados.
             * registry.rebind(SERVICE_NAME, control): registra o serviço no catálogo, permitindo que o cliente localize por esse nome.
             */
            RemoteControlImplementation control = new RemoteControlImplementation();
            Registry registry = LocateRegistry.getRegistry(REGISTRY_PORT);
            registry.rebind(SERVICE_NAME, control);

            System.out.println("Server ready to receive calls on " + serverIP + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }
        scan.close();
    }
}
