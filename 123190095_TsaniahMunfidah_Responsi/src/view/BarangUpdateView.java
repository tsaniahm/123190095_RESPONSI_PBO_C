
package view;

import controller.BarangController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BarangUpdateView  extends JFrame implements ActionListener {
    
    private JLabel lmain, lnama, lmassa, lharga;
    private JTextField nama, massa, harga;
    private JButton submit, reset, back;
    private String id;
    
    public void openForm(String[] data){
       
        this.id = data[0];
        
        setLayout(null);
        setSize(350,250);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle(data[1]);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        lmain = new JLabel("Update Barang");
        lnama = new JLabel("Nama ");
        lmassa = new JLabel("Massa(g) ");
        lharga = new JLabel("Harga Satuan ");
    
        nama = new JTextField(data[1]);
        massa = new JTextField(data[2]);
        harga = new JTextField(data[3]);
    
        submit = new JButton("Submit");
        reset = new JButton("Reset");
        back = new JButton("Kembali");
        
        add(lmain);
        add(lnama);
        add(lmassa);
        add(lharga);
        add(nama);
        add(massa);
        add(harga);
        add(submit);
        add(reset);
        add(back);
        
        lmain.setBounds(20, 10, 130, 25);
        lnama.setBounds(20, 40, 145, 25);
        nama.setBounds(150, 40, 170, 25);
        lmassa.setBounds(20, 70, 145, 25);
        massa.setBounds(150, 70, 170, 25);
        lharga.setBounds(20, 100, 145, 25);
        harga.setBounds(150, 100, 170, 25);
        submit.setBounds(20, 135, 140, 25);
        reset.setBounds(180, 135, 140, 25);
        back.setBounds(10, 170, 320, 25);
        
        submit.setBackground(Color.blue);
        reset.setBackground(Color.red);
        submit.setForeground(Color.white);
        reset.setForeground(Color.white);
        
        submit.addActionListener(this);
        reset.addActionListener(this);
        back.addActionListener(this);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== submit){
           if (nama.getText().equals("")) {
                setMessage("Nama harus diisi");
            }
            if (massa.getText().equals("")) {
                setMessage("massa harus diisi");
            }
            if (harga.getText().equals("")) {
                setMessage("harga  harus diisi");
            }
            if(harga.getText().matches("^[a-zA-Z]*$") || massa.getText().matches("^[a-zA-Z]*$")){
                     setMessage("Massa dan Harga harus bilangan");
            }
            else {
                if(Float.valueOf(massa.getText()) < 0 || Float.valueOf(harga.getText()) <0){
                     setMessage("massa dam harga harus positif");
                }
                
                else if(Float.valueOf(harga.getText()) == 0 || Float.valueOf(massa.getText()) == 0){
                    setMessage("massa dan harga tidak boleh 0");
                }
                else{
                String[] data = {
                   id, nama.getText(), massa.getText(), harga.getText()
                };
                BarangController barang = new BarangController();
                barang.updateBarang(data);
                }
            }
        }
        else if(e.getSource()== reset){
            nama.setText("");
            massa.setText("");
            harga.setText("");
        }
        else if(e.getSource() == back){
            dispose();
            BarangController barang = new BarangController();
            barang.readDataBarang(id);
        }
    }

    private void setMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
}
