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
public class BarbeiroDorminhoco {
    
    int[] filaCedairas;
    int cadeiraOcupada;
    
    int cadeiras;
    ThreadBarbeiro barbeiro;
    ThreadCliente cliente;
    
    public BarbeiroDorminhoco(int tam){
        this.filaCedairas = new int[tam];
        this.cadeiraOcupada = 0;
        this.cadeiras = tam;
        this.barbeiro = new ThreadBarbeiro(this);
        this.cliente = new ThreadCliente(this);

    }
    
    public synchronized void agendaCliente(int corte){
        while(this.cadeiraOcupada >= (this.cadeiras)){
            System.out.println("Salao cheio");
            this.cliente.sleep(1000);
            try{
                this.wait();
            }catch(InterruptedException ex){
                System.out.println("Erro: "+ex);
            }
        }
        
        this.notify();
        System.out.println("Cliente Agendado");
        this.filaCedairas[this.cadeiraOcupada] = corte;
        this.cadeiraOcupada++;
    }
    
    public synchronized void removeCliente(){
        while(cadeiraOcupada == 0){
            System.out.println("Salão Vazio.");
            this.barbeiro.sleep(1000);
            try{
                this.wait();
            }catch(InterruptedException ex){
                System.out.println("Erro: "+ex);
            }
        }
        
        this.notify();
        int corte = this.filaCedairas[this.cadeiraOcupada-1];
        this.filaCedairas[this.cadeiraOcupada-1] = -1;
        this.cadeiraOcupada --;
        this.barbeiro.cortaCabelo(corte);
        
    }
    
    public void init(){
        this.barbeiro.start();
        this.cliente.start();
    }
    
    public static void main(String[] args) {
        BarbeiroDorminhoco bd = new BarbeiroDorminhoco(10);
        bd.init();
        
    }
}