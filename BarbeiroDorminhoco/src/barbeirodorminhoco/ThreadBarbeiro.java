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
public class ThreadBarbeiro extends Thread{
    BarbeiroDorminhoco bd;
    
    public ThreadBarbeiro(BarbeiroDorminhoco bd){
        this.bd = bd;
    }
    
    @Override
    public void run(){
        while(true){
            this.bd.removeCliente();
        }
    }
    
    public void cortaCabelo(int corte){
        try{
            System.out.println("Barbeiro cortando");
            Thread.sleep(corte);
            System.out.println("Barbeiro terminou");
        }catch(InterruptedException ex){
            System.out.println("Erro: "+ex);
        }
    }
    
    public void sleep(int var){
        try{
            System.out.println("Barbeiro dormiu");
            Thread.sleep(var);
            System.out.println("Barbeiro acordou");
        }catch(InterruptedException ex){
            System.out.println("Erro: "+ex);
        }
    }
}