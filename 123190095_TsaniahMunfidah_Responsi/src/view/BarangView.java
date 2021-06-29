
package view;

import controller.BarangController;
import controller.MenuController;
import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarangView extends JFrame implements ActionListener{
    
    private JTable table;
    private JButton back;
    
    private String id;
    private String[] tableTitle = {"Id", "Nama", "Masa", "Harga Satuan"};
    
    public BarangView(String [][] data){
        try{
            id = data[0][0];
           
            setTitle("DATA BARANG");
            setSize(700,375);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);

            back = new JButton(" Kembali ");
            table = new JTable(data,tableTitle);

            table.setBounds(30,40,400,600);
            JScrollPane scroll = new JScrollPane(table);
            scroll.setPreferredSize(new Dimension(500,80));
            
            this.getContentPane().add(BorderLayout.CENTER, scroll);
            this.getContentPane().add(BorderLayout.SOUTH, back);
            
           
            
            table.setCursor((Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)));
            table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
               
                public void valueChanged(ListSelectionEvent event) {
                    dispose();
                    id = table.getValueAt(table.getSelectedRow(), 0).toString();
                    BarangController barang = new BarangController();
                    barang.readDataBarang(id);
                    
                }
            });
            
             back.addActionListener(this);
        }
        catch (Exception e){
            System.out.println("Error : " + e);
        }      
    }

    public BarangView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            MenuController menu = new MenuController();
            menu.openMenu();
            dispose();
        }
    }
    
}
