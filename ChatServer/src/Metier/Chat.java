package Metier;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Model.Message;

public class Chat extends UnicastRemoteObject implements IChat, Serializable {

    ArrayList<Message> messages = new ArrayList<>();

    public Chat() throws RemoteException {
        super();    
    }
    
    public void createMessage(String msg,String idS) throws RemoteException {
    	Message message = new Message(msg,idS);
    }

    @Override
    public synchronized void sendMessage(Message msg) throws RemoteException {
        messages.add(msg);
    }

    @Override
    public synchronized ArrayList<Message> readMessage() throws RemoteException {
        for(Message m : messages){
            System.out.println(m.getID_sender()+ " : " + m.getMessage());
        }
        return messages;
    }
    
    @Override
    public void clear() throws RemoteException{
        for(Message m : messages){
            messages.remove(m);
        }
        
    }
    

}
