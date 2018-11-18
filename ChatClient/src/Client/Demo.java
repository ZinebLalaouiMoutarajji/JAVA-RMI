package Client;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import Metier.IChat;
import Model.Message;

public class Demo {

	public static void main(String[] args)  throws Exception, RemoteException, NotBoundException{
		Scanner clavier = new Scanner(System.in);
		System.out.print("Veuillez Entrer votre nom : ");
		String user = clavier.nextLine();
		System.out.println(user+" a rejoint la conversation\n");
		IChat chat= (IChat)Naming.lookup("rmi://localhost:1090/chat");
		while(true){
			try {
				for(Message m : chat.readMessage()){
					System.out.println(m.getID_sender()+" : "+m.getMessage());
				}
				System.out.print("Entrer votre message : ");
				String m = clavier.nextLine();
				if(m.equals("exit")){
					for(Message msg : chat.readMessage()){
						chat.readMessage().remove(msg);
					}
					break;
				}
				else{
					chat.sendMessage(new Message(m,user));
				}
			} catch ( Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
