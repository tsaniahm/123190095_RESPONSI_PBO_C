/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BarangController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author ASUS
 */
public class DetailBarangView extends JFrame implements ActionListener{

    private JLabel lnama, lmassa, lharga, lbanyak, nama, massa, harga;
    private JTextField fbanyak;
    private JButton back, edit, delete, total;
    private String id;
    private String[] dataa;
        
    public void openDetail(String[] data){
        
        this.id = data[0];
        this.dataa = data;
        
        setLayout(null);
        setSize(370,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle(data[1]);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        lnama = new JLabel("Nama         : ");
        lmassa = new JLabel("Massa(g)     :");
        lharga = new JLabel("Harga Satuan :");
        nama = new JLabel(data[1]);
        massa = new JLabel(data[2]);
        harga = new JLabel(data[3]);
        lbanyak = new JLabel("Banyak :");

        fbanyak = new JTextField();
        
        total = new JButton("Total Harga");
        back = new JButton("kembali");
        edit = new JButton("Edit");
        delete = new JButton("Hapus");
        
        add(lnama);
        add(lmassa);
        add(lharga);
        add(nama);
        add(massa);
        add(harga);
        add(lbanyak);
        add(fbanyak);
        add(total);
        add(back);
        add(edit);
        add(delete);
        
        
        lnama.setBounds(20, 10, 130, 25);
        nama.setBounds(130, 10, 130, 25);
        lmassa.setBounds(20, 35, 130, 25);
        massa.setBounds(130, 35, 130, 25);
        lharga.setBounds(20, 60, 130, 25);
        harga.setBounds(130, 60, 130, 25);
        lbanyak.setBounds(20, 85, 130, 25);
        fbanyak.setBounds(130, 85, 200, 25);
        total.setBounds(110, 150, 130, 25);
        back.setBounds(10, 200, 100, 25);
        edit.setBounds(120, 200, 100, 25);
        delete.setBounds(230, 200, 100, 25);
        
        edit.setBackground(Color.blue);
        delete.setBackground(Color.red);
        edit.setForeground(Color.white);
        delete.setForeground(Color.white);
        
        total.addActionListener(this);
        edit.addActionListener(this);
        delete.addActionListener(this);
        back.addActionListener(this);
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== total){

           if (fbanyak.getText().equals("")) {
                setMessage("Banyak barang harus diisi");
           }
            if(fbanyak.getText().matches("^[a-zA-Z]*$")){
                     setMessage("Input Banyak harus bilangan");
            }
           else {
               if(Float.valueOf(fbanyak.getText()) < 0){
                   setMessage("Bilangan harus positif");
               }else if(Float.valueOf(fbanyak.getText()) == 0){
                   setMessage("Jumlah tidak boleh 0");
               }else{
                    String[] data = {
                        id, nama.getText(), massa.getText(), harga.getText(), fbanyak.getText()
                    };
                    dispose();
                    BarangController barang = new BarangController();
                    barang.createTotalBarang(data);
               }
           }
        }
        else if(e.getSource()== edit){
                dispose();
                 BarangController barang = new BarangController();
                 barang.updatePanel(dataa);
        }
        else if(e.getSource() == delete){
            
        int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus data ini ?");
        switch(opsi){
            case JOptionPane.YES_OPTION:
                 dispose();
                 BarangController barang = new BarangController();
                 barang.deleteBarang(id);
                break;
            case JOptionPane.NO_OPTION:
                break;
            default:
                break;
        }    
        }
        else if(e.getSource() == back){
            dispose();
            BarangController barang = new BarangController();
            barang.readDataBarang();
        }
    }

    private void setMessage(String message) {
      JOptionPane.showMessageDialog(this, message);
    }
}
