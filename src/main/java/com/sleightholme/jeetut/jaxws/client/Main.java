package com.sleightholme.jeetut.jaxws.client;

import com.sleightholme.jeetut.jaxws.endpoint.*;
import javax.xml.ws.WebServiceRef;

/**
 * Enterprise Application Client main class.
 *
 */
public class Main {
    
    @WebServiceRef(wsdlLocation = "http://localhost:8080/jee-tut/BookService?wsdl")
    private static BookService service;
    
    public static void main( String[] args ) {
        Main main = new Main();
        main.run(args);
    }
    
    public Main(){
        service = new BookService();
    }
    
    public void run(String[] args){
        if (args.length > 0){
            System.out.println("");
            for (int i = 0; i < args.length; i++){
                System.out.println(sayHello(args[i]));
            }
            
        } else {
            System.out.println(sayHello("Jonathan"));
        }
    }
    
    private String sayHello(String arg){
        Book port = service.getBookPort();
        if (port == null){
            return "FAILED";
        }
        if (arg == null){
            return "no args!";
        }
        return port.sayHello(arg);
    }
}
