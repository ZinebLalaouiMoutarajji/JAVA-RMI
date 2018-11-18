package Metier;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Model.Message;

public interface IChat extends Remote{
	
    public void sendMessage(Message message) throws RemoteException;
    public ArrayList<Message> readMessage() throws RemoteException;
    public void clear() throws RemoteException;

}
