package ads.pkg2019.oop.estruturadedados;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ExQueue {

    private Queue<String> queue;

    public ExQueue(String obj) {
        queue = new LinkedList<String>();
        queue.add(obj);
    }
    
    public void setQueue(LinkedList<String> obj){
        this.queue = obj;
    }
    
    public Queue<String> getQueue(){
        return this.queue;
    }

    public int getSizeQueue(){
        return queue.size();
    }
    
    public void insertQueue(String obj) {
        queue.add(obj);
    }

    public void removeQueue() {
        queue.remove();
    }
    
    public String peekQueue(){
        String toReturn;
        if (queue.peek() != null){
            toReturn = queue.peek();
        } else { 
            toReturn = "vazio";
        }
        return toReturn;
    }
    
    public boolean isEmptyQueue(){
        boolean toReturn = false;
        if (queue.isEmpty()){
            toReturn = !toReturn;
        } 
        return toReturn;
    }
    
}
