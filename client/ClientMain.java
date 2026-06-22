import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientMain {

    private static final int REGISTRY_PORT = 1099;
    private static final String SERVICE_NAME = "RemoteControlService";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter the server IP:");
            String serverIP = scan.nextLine().trim();

            /*
             * Registry: catálogo onde os serviços RMI são registrados e encontrados.
             * LocateRegistry.getRegistry(serverIP, REGISTRY_PORT): conecta ao Registry rodando no servidor.
             * registry.lookup(SERVICE_NAME): procura o serviço publicado nesse nome (usando rebind no servidor).
             * Cast para RemoteControl: transforma o objeto retornado em uma referência do tipo da interface, permitindo usar os métodos definidos nela.
             */
            Registry registry = LocateRegistry.getRegistry(serverIP, REGISTRY_PORT);
            RemoteControl remoteControl = (RemoteControl)registry.lookup(SERVICE_NAME);

            int option;
            do {
                System.out.println("\n*** REMOTE CONTROL ***");
                System.out.println("1 - Turn on TV");
                System.out.println("2 - Turn off TV");
                System.out.println("3 - Increase volume");
                System.out.println("4 - Decrease volume");
                System.out.println("5 - Change channel");
                System.out.println("0 - Exit");
                System.out.print("Choose: ");

                while (!scan.hasNextInt()) {
                    System.out.println("Invalid option!");
                    scan.next();
                    System.out.print("Choose: ");
                }
                
                option = scan.nextInt();
                switch (option) {
                    case 1:
                        System.out.println(remoteControl.turnOn());
                        break;
                    case 2:
                        System.out.println(remoteControl.turnOff());
                        break;
                    case 3:
                        System.out.print("Value to increase: ");
                        while (!scan.hasNextInt()) {
                            System.out.println("Invalid input! Enter a number.");
                            scan.next();
                            System.out.print("Value to increase: ");
                        }
                        int increase = scan.nextInt();
                        System.out.println(remoteControl.increaseVolume(increase));
                        break;
                    case 4:
                        System.out.print("Value to decrease: ");
                        while (!scan.hasNextInt()) {
                            System.out.println("Invalid input! Enter a number.");
                            scan.next();
                            System.out.print("Value to decrease: ");
                        }
                        int decrease = scan.nextInt();
                        System.out.println(remoteControl.decreaseVolume(decrease));
                        break;
                    case 5:
                        System.out.print("Channel number: ");
                        while (!scan.hasNextInt()) {
                            System.out.println("Invalid input! Enter a number.");
                            scan.next();
                            System.out.print("Channel number: ");
                        }
                        int channel = scan.nextInt();
                        System.out.println(remoteControl.changeChannel(channel));
                        break;
                    case 0:
                        System.out.println("Closing client...");
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            } while (option != 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        scan.close();
    }
}
