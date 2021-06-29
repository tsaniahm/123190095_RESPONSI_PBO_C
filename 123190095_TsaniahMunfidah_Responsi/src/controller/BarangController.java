
package controller;

import model.BarangModel;
import view.BarangInputView;
import view.BarangUpdateView;
import view.BarangView;
import view.DetailBarangTotalView;
import view.DetailBarangView;
import view.MenuView;

public class BarangController {
    
    public void createBarang(){
        BarangInputView input = new BarangInputView();
        input.openForm();
    }
    
    public void createBarang(String [] data){
        BarangModel model = new BarangModel();
        model.createBarang(data);
    }
    
    public void readDataBarang(){
        
        BarangModel model = new BarangModel();
        String[][] data = model.readData();
        if(data == null)
            new MenuView();
        else
           new BarangView(data);
    }
    
    public void readDataBarang(String id){
        BarangModel model = new BarangModel();
        DetailBarangView detail = new DetailBarangView();
        detail.openDetail(model.readData(id));
    }
    
    public void createTotalBarang(String[] data){
        BarangModel model = new BarangModel();
        DetailBarangTotalView view = new DetailBarangTotalView();
        view.openDetail(model.createTotalBarang(data));
    
    }
    
    public void updatePanel(String[] data){
        BarangUpdateView view = new BarangUpdateView();
        view.openForm(data);
    }
    public void updateBarang(String[] data){
        BarangModel model = new BarangModel();
        model.updateBarang(data);
    }
    
    public void deleteBarang(String id){
        BarangModel model = new BarangModel();
        model.deleteBarang(id);
    
    }
    
}
