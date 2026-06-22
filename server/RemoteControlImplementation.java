import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteControlImplementation extends UnicastRemoteObject implements RemoteControl {

    private static final long serialVersionUID = 1L;

    /*
     * SERVICE_PORT: porta fixa em que o objeto remoto é exportado.
     * Sem isso, o RMI usaria uma porta aleatória e o firewall precisaria liberar uma faixa imprevisível.
     */
    private static final int SERVICE_PORT = 1100;

    private static final int MAX_VOLUME = 100;
    private static final int MAX_CHANNEL = 50;

    private boolean on;
    private int volume;
    private int channel;

    public RemoteControlImplementation() throws RemoteException {
        super(SERVICE_PORT);
        this.on = false;
        this.volume = 10;
        this.channel = 1;
    }

    @Override
    public synchronized String turnOn() throws RemoteException {
        if (!on) {
            on = true;
            System.out.println("[Server] TV turned on by the client.");
            return "TV turned on!";
        }

        System.out.println("[Server] Client tried to turn on the TV, but it was already on.");
        return "The TV is already on.";
    }

    @Override
    public synchronized String turnOff() throws RemoteException {
        if (on) {
            on = false;
            System.out.println("[Server] TV turned off by the client.");
            return "TV turned off!";
        }

        System.out.println("[Server] Client tried to turn off the TV, but it was already off.");
        return "The TV is already off.";
    }

    @Override
    public synchronized String increaseVolume(int value) throws RemoteException {
        if (!on) {
            System.out.println("[Server] Client tried to increase volume, but the TV is off.");
            return "The TV is off!";
        }

        if (value <= 0) {
            System.out.println("[Server] Client sent an invalid value to increase volume: " + value + ".");
            return "Invalid value! Use a positive number.";
        }

        volume += value;
        if (volume > MAX_VOLUME)
            volume = MAX_VOLUME;
        System.out.println("[Server] Volume increased to " + volume + " by the client.");
        return "Volume increased to " + volume;
    }

    @Override
    public synchronized String decreaseVolume(int value) throws RemoteException {
        if (!on) {
            System.out.println("[Server] Client tried to decrease volume, but the TV is off.");
            return "The TV is off!";
        }

        if (value <= 0) {
            System.out.println("[Server] Client sent an invalid value to decrease volume: " + value + ".");
            return "Invalid value! Use a positive number.";
        }

        volume -= value;
        if (volume < 0)
            volume = 0;
        System.out.println("[Server] Volume decreased to " + volume + " by the client.");
        return "Volume decreased to " + volume;
    }

    @Override
    public synchronized String changeChannel(int channel) throws RemoteException {
        if (!on) {
            System.out.println("[Server] Client tried to change the channel, but the TV is off.");
            return "The TV is off!";
        }

        if (channel < 1 || channel > MAX_CHANNEL) {
            System.out.println("[Server] Client tried to change to an invalid channel: " + channel + ".");
            return "Invalid channel! Use a number between 1 and " + MAX_CHANNEL + ".";
        }

        this.channel = channel;
        System.out.println("[Server] Channel changed to " + this.channel + " by the client.");
        return "Channel changed to " + this.channel;
    }
}
