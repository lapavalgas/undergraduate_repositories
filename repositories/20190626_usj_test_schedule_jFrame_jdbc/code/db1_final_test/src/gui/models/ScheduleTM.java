
package ads.pkg2019.agenda2.gui.models;

import ads.pkg2019.agenda2.entity.Schedule;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ScheduleTM extends AbstractTableModel {
    
    private List<Schedule> rows;
    private String[] column = new String[]{"name"};
    
    public ScheduleTM(){
        rows = new ArrayList<>();
    }
    
    public ScheduleTM(List<Schedule> rows){
        rows = new ArrayList<>(rows);
    }
    
    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return column.length;
    }

    public String getColumnName(int columnIndex){
        return column[columnIndex];
    }
    
    public Class<?> getColumnClass(int columnIndex){
        switch(columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            default:
                return String.class;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Schedule schedule = rows.get(rowIndex);
        switch(columnIndex){
            case 0:
                return schedule.getName();
            case 1:          
                return null; 
            case 2:          //just a example to the future
                return null; //don't exist this columns;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        Schedule schedule = rows.get(rowIndex);
        switch(columnIndex){
            case 0:
                schedule.setName(aValue.toString());
            case 1:    //just a example to the future
                break; //don't exist this columns;
            case 2:    
                break; 
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
//    public void setValueAt(Schedule aValue, int rowIndex){
//        Schedule schedule = rows.get(rowIndex);
//        schedule.setName(aValue.getName());
//        //schedule.setTasks(aValue.getSomeThing());
//        fireTableCellUpdate(rowIndex, 0);
//        // ?
//        //to edit the complete object;
//    }
    
//        public boolean isCellEditable(int rowIndex, int columnIndex){
//            return false;
//        }
    
    public Schedule getSchedule(int rowIndex){
        return rows.get(rowIndex);
    }
    
    public void addSchedule(Schedule schedule){
        rows.add(schedule);
        int lastIndex = getRowCount() -1;
        fireTableRowsInserted(lastIndex, lastIndex);        
    }
    
    public void removeSchedule(int rowIndex){
        rows.remove(rowIndex);
        fireTableRowsInserted(rowIndex, rowIndex);
    }
    
    public void addList(List<Schedule> rows){
        int lastRowCount = getRowCount();
        rows.addAll(rows);
        fireTableRowsInserted(lastRowCount, getRowCount() - 1);
    }
    
    public void Clean(){
        rows.clear();
        fireTableDataChanged();
    }
    
    public boolean isEmpty(){
        return rows.isEmpty();
    }
    
    
    
    
}
