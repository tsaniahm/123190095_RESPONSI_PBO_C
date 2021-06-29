
package view;
import controller.BarangController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class DetailBarangTotalView extends JFrame implements ActionListener{
        private JLabel lnama, lmassa, lharga, ltotal, nama, massa, harga, total;
        private JButton back;
        private String id;
        
    public void openDetail(String[] data){
       
        this.id = data[0];
        
        setLayout(null);
        setSize(370,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle(data[0]);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        lnama = new JLabel("Nama         : ");
        lmassa = new JLabel("Massa(g)     :");
        lharga = new JLabel("Harga Satuan :");
        ltotal = new JLabel("Total Harga :");
        nama = new JLabel(data[1]);
        massa = new JLabel(data[2]);
        harga = new JLabel(data[3]);
        total = new JLabel(data[4]);
        
        back = new JButton("Kembali");
        
        add(lnama);
        add(lmassa);
        add(lharga);
        add(ltotal);
        add(nama);
        add(massa);
        add(harga);
        add(total);
        add(back);
       
        lnama.setBounds(20, 10, 130, 25);
        nama.setBounds(130, 10, 130, 25);
        lmassa.setBounds(20, 35, 130, 25);
        massa.setBounds(130, 35, 130, 25);
        lharga.setBounds(20, 60, 130, 25);
        harga.setBounds(130, 60, 130, 25);
        ltotal.setBounds(20, 85, 130, 25);
        total.setBounds(130, 85, 130, 25);
        
        back.setBounds(20, 140, 130,25);
        back.addActionListener(this);

     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            dispose();
            BarangController barang = new BarangController();
            barang.readDataBarang(id);
        }
    }
    
}
