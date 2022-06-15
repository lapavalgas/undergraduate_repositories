
package ads.pkg2019.oop.estruturadedados;

import java.util.Stack;

public class ExStack {
    
    private Stack<String> pilha;
    
    public ExStack (String obj){
        pilha = new Stack<String>();
        pilha.push(obj);
    }
    
    public String peekPilha(){
        return pilha.peek();
    }
    
    public void pushPilha(String obj){
        pilha.push(obj);
    }
    
    public void popPilha(){
        pilha.pop();
    }
    
    public Stack<String> getPilha(){
        return this.pilha;
    }
    
}
