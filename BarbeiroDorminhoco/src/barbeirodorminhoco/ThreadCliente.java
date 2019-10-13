/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbeirodorminhoco;

/**
 *
 * @author jessica
 */
public class ThreadCliente extends Thread{
    BarbeiroDorminhoco bd;
    
    public ThreadCliente(BarbeiroDorminhoco bd){
        this.bd = bd;
    }
    
    @Override
    public void run(){
        while(true){
            this.bd.agendaCliente(5000);
        }
    }
    
    public void sleep(int var){
        try{
            System.out.println("Cliente dormiu");
            Thread.sleep(var);
            System.out.println("Cliente acordou");
        }catch(InterruptedException ex){
            System.out.println("Erro: "+ex);
        }
    }
}