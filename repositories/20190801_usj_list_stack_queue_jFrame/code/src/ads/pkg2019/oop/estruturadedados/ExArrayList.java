
package ads.pkg2019.oop.estruturadedados;

import java.util.ArrayList;
import java.util.List;

public class ExArrayList {
    
    private List<String> arrayList; 
    
    public ExArrayList(String obj){
        this.arrayList = new ArrayList<>();
        arrayList.add(obj);
    }
    
    public int getSize(){
        return arrayList.size();
    }
    
    public void addObj(String obj){
        this.arrayList.add(obj);
    }
    
    public void setArrayList(List<String> arrayList){
        this.arrayList = arrayList;
    }
    
    public List<String>getVetor(){
        return arrayList;
    }
    
}