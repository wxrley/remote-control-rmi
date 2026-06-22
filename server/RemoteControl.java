import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteControl extends Remote {
    
    String turnOn() throws RemoteException;
    String turnOff() throws RemoteException;
    String increaseVolume(int value) throws RemoteException;
    String decreaseVolume(int value) throws RemoteException;
    String changeChannel(int channel) throws RemoteException;
}
