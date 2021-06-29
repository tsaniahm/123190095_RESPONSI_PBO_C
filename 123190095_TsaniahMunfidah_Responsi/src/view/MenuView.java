
package view;

import controller.BarangController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuView extends JFrame implements ActionListener{
    
    private JLabel lmain;
    private JButton add, show;
    
    public MenuView(){
    
        setLayout(null);
        setSize(250,160);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("DAFTAR BARANG");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        lmain = new JLabel("MAIN MENU");
        add = new JButton("Tambah Barang");
        show = new JButton("Lihat Barang");
        
        add(lmain);
        add(add);
        add(show);
        
        lmain.setBounds(85, 10, 130, 25);
        add.setBounds(40, 35, 150, 25);
        show.setBounds(40, 65, 150, 25);
        
        add.addActionListener(this);
        show.addActionListener(this);
      
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== add){
            BarangController barang = new BarangController();
            barang.createBarang();
            dispose();
        }
        else if(e.getSource()== show){
            BarangController barang = new BarangController();
            barang.readDataBarang();
            dispose();
        }
       
    }
    
}
