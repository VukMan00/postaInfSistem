/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handler;


import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import controller.Controller;
import domain.UserLogin;
import java.net.Socket;

/**
 *
 * @author Vuk
 */
public class ProcessClientRequest extends Thread{

    Socket socket;
    Sender sender;
    Receiver receiver;
    Request request = null;
    Response response = null;
    
    public ProcessClientRequest(Socket socket) {
        this.socket = socket;
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    @Override
    public void run() {
        while(true){
            try {
                request = (Request) receiver.receive();
                response = new Response();
                switch(request.getOperation()){
                    case LOGIN -> {
                        UserLogin user = (UserLogin)request.getArgument();
                        response.setResult(Controller.getInstance().login(user));
                    }
                    case ADD -> Controller.getInstance().add(request.getArgument());
                    case UPDATE -> Controller.getInstance().update(request.getArgument());
                    case DELETE -> Controller.getInstance().delete(request.getArgument());
                    case GET -> response.setResult(Controller.getInstance().get(request.getArgument()));
                    case GET_ALL -> response.setResult(Controller.getInstance().getAll(request.getArgument()));
                    case GET_ALL_CONDITION -> response.setResult(Controller.getInstance().getAllWithCondition(request.getArgument()));
                    case GET_ALL_PARTITION -> response.setResult(Controller.getInstance().getAllWithPartition(request.getArgument()));
                }
                
            } catch (Exception ex) {
                if(response==null){
                    System.out.println("Nema odgovora!");
                }
                else{
                    response.setException(ex);
                    response.setMessageException(ex.getMessage());
                }
            }
           sender.send(response);
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
