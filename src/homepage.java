
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PrinterException;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author User
 */
public class homepage extends javax.swing.JFrame {

    /**
     * Creates new form homepage
     */
    
    private final Vector<String> v = new Vector<String>();
    private JTextField tf;
    private boolean hide_flag = false;
    int total=0;
    int subtotal,price,quantity,discount,amount,returnAmount;
    String name="";
    String contactNo="0";
    int billno;
    
    public homepage() {
        initComponents();
        
        nameField.setEditable(false);
        priceField.setEditable(false);
        subtotalField.setEditable(false);
        totalField.setEditable(false);
        returnField.setEditable(false);
        billField.setEditable(false);
        
        
        showDate();
        showTime();
        
        loadProduct();
        autoSuggest();
    }
    
    void showDate(){
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        Date d = new Date();
        date.setText(s.format(d));
        
    }
    
    void showTime(){
        new Timer(0, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
                Date d = new Date();
                time.setText(s.format(d));
            }
        }).start();
    }
    
    void loadProduct(){
        try{
            Connection con = dbconnect.connect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from product");
            
            while(rs.next()){
                v.addElement(rs.getString(2));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void setModel(DefaultComboBoxModel mdl, String str){
        searchField.setModel(mdl);
        searchField.setSelectedIndex(-1);
        tf.setText(str);
    }
    
    private static DefaultComboBoxModel getSuggestedModel(List<String> list, String text){
        
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        
        for(String s : list){
            if(s.startsWith(text)){
                m.addElement((s));
            }
        }
        
        return m;
    }
    
    void autoSuggest(){
        searchField.setEditable(true);
        tf = (JTextField)searchField.getEditor().getEditorComponent();
        tf.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e){
                EventQueue.invokeLater(new Runnable(){
                    @Override
                    public void run(){
                        String text = tf.getText();
                        if(text.length()==0){
                            searchField.hidePopup();
                            setModel(new DefaultComboBoxModel(v), text);
                        }
                        else{
                            DefaultComboBoxModel m = getSuggestedModel(v, text);
                            if(m.getSize() == 0 || hide_flag){
                                searchField.hidePopup();
                                hide_flag = false;
                            }
                        else{
                                setModel(m, text);
                                searchField.showPopup();
                            }
                        }
                    }
                });
            }

            @Override
            public void keyPressed(KeyEvent e){
                String text = tf.getText();
                int code = e.getKeyCode();
                
                if(code == KeyEvent.VK_ENTER){
                    if(v.contains(text)){
                        v.addElement(text);
                        Collections.sort(v);
                        setModel(getSuggestedModel(v,text), text);
                        hide_flag = true;
                    }
                    else if(code == KeyEvent.VK_ESCAPE){
                        hide_flag = true;
                    }
                    else if(code == KeyEvent.VK_RIGHT){
                        for(int i=0; i<v.size(); i++){
                            String str = v.elementAt(i);
                            if(str.startsWith(text)){
                                searchField.setSelectedIndex(-1);
                                tf.setText(str);
                                return;
                            }
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e){
                
            }
 
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        buttonPrint = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        billField = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        customerName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        searchField = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        labelBillNo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        subtotalField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        totalField = new javax.swing.JTextField();
        buttonAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();
        buttonConfirm = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        discountField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        returnField = new javax.swing.JTextField();
        buttonReset = new javax.swing.JButton();
        buttonClose = new javax.swing.JButton();
        buttonMinimize = new javax.swing.JButton();
        buttonInfo = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout.png"))); // NOI18N
        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 6, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 103, 1152, 10));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonPrint.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/print.png"))); // NOI18N
        buttonPrint.setText("Print");
        buttonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrintActionPerformed(evt);
            }
        });
        jPanel1.add(buttonPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 518, -1, -1));

        billField.setColumns(20);
        billField.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        billField.setRows(5);
        jScrollPane2.setViewportView(billField);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 8, 454, 492));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/textArea.jpg"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 570));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 119, -1, 570));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Customer Name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 119, -1, -1));

        customerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameActionPerformed(evt);
            }
        });
        customerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customerNameKeyPressed(evt);
            }
        });
        getContentPane().add(customerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 119, 220, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Contact:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 119, -1, -1));

        contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contactKeyPressed(evt);
            }
        });
        getContentPane().add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 119, 190, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 153, 670, 10));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Date:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 169, -1, -1));

        date.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 169, 136, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Time:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 169, -1, -1));

        time.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 169, 108, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        jLabel5.setText("Search Item:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 204, -1, -1));

        searchField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
        });
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 201, 250, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Product Name:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 239, -1, -1));

        nameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 239, 200, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Price:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 242, -1, -1));

        priceField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(priceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 239, 179, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Bill No:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 169, -1, -1));

        labelBillNo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(labelBillNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 169, 100, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Quantity:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 286, -1, -1));

        quantityField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityFieldActionPerformed(evt);
            }
        });
        quantityField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityFieldKeyPressed(evt);
            }
        });
        getContentPane().add(quantityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 283, 87, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Sub Total:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 286, -1, -1));

        subtotalField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(subtotalField, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 283, 110, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Total:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 396, -1, -1));

        totalField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(totalField, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 393, 130, -1));

        buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addSmall.png"))); // NOI18N
        buttonAdd.setText("Add");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 353, -1, -1));

        billTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Quantity", "Sub Total"
            }
        )

        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }
    );
    jScrollPane1.setViewportView(billTable);

    getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 425, -1, 126));

    buttonConfirm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    buttonConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/confirm.png"))); // NOI18N
    buttonConfirm.setText("Confirm");
    buttonConfirm.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonConfirmActionPerformed(evt);
        }
    });
    getContentPane().add(buttonConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 640, -1, -1));

    jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel13.setText("Discount(%):");
    getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 324, -1, -1));

    discountField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    discountField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            discountFieldKeyPressed(evt);
        }
    });
    getContentPane().add(discountField, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 321, 87, -1));

    jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel14.setText("Enter Amount:");
    getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 584, -1, -1));

    amountField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    amountField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            amountFieldKeyPressed(evt);
        }
    });
    getContentPane().add(amountField, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 581, 100, -1));

    jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel15.setText("Return:");
    getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 584, -1, -1));

    returnField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    getContentPane().add(returnField, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 581, 100, -1));

    buttonReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    buttonReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reset.png"))); // NOI18N
    buttonReset.setText("Reset");
    buttonReset.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonResetActionPerformed(evt);
        }
    });
    getContentPane().add(buttonReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 640, -1, -1));

    buttonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/closeSmall.png"))); // NOI18N
    buttonClose.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonCloseActionPerformed(evt);
        }
    });
    getContentPane().add(buttonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, -1, -1));

    buttonMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minimize.png"))); // NOI18N
    buttonMinimize.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonMinimizeActionPerformed(evt);
        }
    });
    getContentPane().add(buttonMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, -1, -1));

    buttonInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info.png"))); // NOI18N
    buttonInfo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonInfoActionPerformed(evt);
        }
    });
    getContentPane().add(buttonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 40, 40));

    jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_medium.jpg"))); // NOI18N
    getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int check = JOptionPane.showConfirmDialog(null,"Confirm logout?", "Select", JOptionPane.YES_NO_OPTION);
        if(check == 0){
            setVisible(false);
            new login().setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void customerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameActionPerformed

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed

    }//GEN-LAST:event_searchFieldKeyPressed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        String pname = (String)searchField.getSelectedItem();        
        try{
            Connection con = dbconnect.connect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from product where name = '"+pname+"'");
            if(rs.next()){
                nameField.setText(rs.getString(2));
                priceField.setText(rs.getString(3));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_searchFieldActionPerformed

    private void quantityFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityFieldKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            price = Integer.parseInt(priceField.getText());
            quantity = Integer.parseInt(quantityField.getText());
            subtotal = price*quantity;
            String s = Integer.toString(subtotal);
            subtotalField.setText(s);
            
        }
    }//GEN-LAST:event_quantityFieldKeyPressed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        
        returnAmount = 0;
        amountField.setText("");
        returnField.setText("");
        
        if(subtotalField.getText() == "" || subtotal==0){
            JOptionPane.showMessageDialog(null, "Please add item and quantity.");
        }
        else{
            total += subtotal;
            String tt = Integer.toString(total);
            totalField.setText(tt);

            String itemName = nameField.getText();
            String itemQuantity = quantityField.getText();
            String itemSubtotal = subtotalField.getText();

            String s[] = {itemName,itemQuantity,itemSubtotal};

            DefaultTableModel tbl = (DefaultTableModel)billTable.getModel();
            tbl.addRow(s);
        }     
        
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmActionPerformed
        
        checkName();
        checkContact();
        
        if(name == "" || contactNo == "0"){
            JOptionPane.showMessageDialog(null, "Customer name and contact shouldn't be empty.");
        }
        else if(total==0){
            JOptionPane.showMessageDialog(null, "Please add some item first.");
        }
        else if(amountField.getText()=="" || amount<total || returnAmount == 0){
            JOptionPane.showMessageDialog(null, "Please pay first.");
        }
        else{
            
            billField.setText("");
            
            billField.setText(billField.getText() +"*********************************************************\n");
            billField.setText(billField.getText() + "                         MyShop                  \n");
            billField.setText(billField.getText() + "                    XYZ, Bangladesh.                  \n");
            billField.setText(billField.getText() + "                    +880-1234567890                  \n");
            billField.setText(billField.getText() + "*********************************************************\n");
            billField.setText(billField.getText() + "Bill No: " + billno + "\n");
            billField.setText(billField.getText() + "Customer Name: " + customerName.getText() + "\n");
            billField.setText(billField.getText() + "Contact:       " + contact.getText() + "\n");
            billField.setText(billField.getText() + "---------------------------------------------------------\n");
            billField.setText(billField.getText() + "Item\t\t\t\tQuantity\tSubtotal\n");
            
            for(int i=0; i<billTable.getRowCount(); i++){
                billField.append("\n" + billTable.getValueAt(i, 0) + "\t\t\t" + billTable.getValueAt(i, 1) + "\t\t" + billTable.getValueAt(i, 2));
            }
            billField.setText(billField.getText() + "\n\n---------------------------------------------------------");
            billField.setText(billField.getText() + "\nTotal Bill\t\t\t\t\t" + total);
            billField.setText(billField.getText() + "\nPaid Amount\t\t\t\t\t" + amount);
            billField.setText(billField.getText() + "\nReturn Amount\t\t\t\t\t" + returnAmount);
            
            billField.setText(billField.getText() + "\n\nDate: " + date.getText() + "\t\t\t" + "Time: " + time.getText());
            
            billField.setText(billField.getText() + "\n\n******************* Thanks for shopping *****************\n\n");
            billField.setText(billField.getText() + "Prepared by : JK Software Ltd." + "\n");
            
        }
        
        
    }//GEN-LAST:event_buttonConfirmActionPerformed

    private void quantityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityFieldActionPerformed

    private void discountFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountFieldKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            price = Integer.parseInt(priceField.getText());
            quantity = Integer.parseInt(quantityField.getText());
            discount = Integer.parseInt(discountField.getText());
            subtotal = (int) ((price*quantity) - ((price*quantity) * (discount/100.0)));
            String s = Integer.toString(subtotal);
            subtotalField.setText(s);
            
        }
    }//GEN-LAST:event_discountFieldKeyPressed

    private void amountFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountFieldKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            amount = Integer.parseInt(amountField.getText());
            if(amount < total){
                returnAmount = 0;
                returnField.setText(Integer.toString(returnAmount));
                JOptionPane.showMessageDialog(null, "Insufficient amount.");
            }
            else{
                returnAmount = amount-total;
                returnField.setText(Integer.toString(returnAmount));
            }
        }
    }//GEN-LAST:event_amountFieldKeyPressed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        setVisible(false);
        new homepage().setVisible(true);
    }//GEN-LAST:event_buttonResetActionPerformed

    private void customerNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerNameKeyPressed

    }//GEN-LAST:event_customerNameKeyPressed

    private void contactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactKeyPressed

    }//GEN-LAST:event_contactKeyPressed

    private void buttonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrintActionPerformed
        
        String d = date.getText();
        String t = time.getText();
        
        try{
            Connection con = dbconnect.connect();
            Statement st = con.createStatement();
            st.executeUpdate("insert into record values('"+billno+"', '"+d+"', '"+t+"', '"+name+"', '"+contactNo+"', '"+total+"', '"+amount+"', '"+returnAmount+"')");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            billField.print();
        } catch (PrinterException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonPrintActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try{
            Connection con = dbconnect.connect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select max(billNo) from record");            
            while(rs.next()){
                billno = rs.getInt(1);
            }
        }
        catch(Exception e){
        }
        
        billno++;
                
        labelBillNo.setText(Integer.toString(billno));
    }//GEN-LAST:event_formComponentShown

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void buttonMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMinimizeActionPerformed
        this.setExtendedState(homepage.ICONIFIED);
    }//GEN-LAST:event_buttonMinimizeActionPerformed

    private void buttonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInfoActionPerformed
        new info().setVisible(true);
    }//GEN-LAST:event_buttonInfoActionPerformed

       void checkName(){
           name = customerName.getText();
            boolean check = true;
            for(int i=0; i<name.length(); i++){
                if((name.charAt(i)>='a' && name.charAt(i)<='z') || (name.charAt(i)>='A' && name.charAt(i)<='Z') || name.charAt(i) == ' '){
                    continue;
                }
                else{
                    check = false;
                }
            }
            if(check == false){
                JOptionPane.showMessageDialog(null, "Name can't contain digits or special characters.");
                customerName.setText("");
                name="";
            }
            else{
                name = customerName.getText();
            }
       }
       
       void checkContact(){
           String cNo = contact.getText();
            
            boolean check = true;
            for(int i=0; i<cNo.length(); i++){
                if(cNo.charAt(i)>='0' && cNo.charAt(i)<='9'){
                    continue;
                }
                else{
                    check = false;
                }
            }
            
            if(check == false || cNo.length() != 11){
                JOptionPane.showMessageDialog(null, "Contact should contain only digits and must contain 11 digits.");
                contact.setText("");
                contactNo = "0";
            }
            else{
                //contactNo = Integer.parseInt(contact.getText());
                contactNo = contact.getText();
            }
       }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountField;
    private javax.swing.JTextArea billField;
    private javax.swing.JTable billTable;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonConfirm;
    private javax.swing.JButton buttonInfo;
    private javax.swing.JButton buttonMinimize;
    private javax.swing.JButton buttonPrint;
    private javax.swing.JButton buttonReset;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField customerName;
    private javax.swing.JLabel date;
    private javax.swing.JTextField discountField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelBillNo;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField priceField;
    private javax.swing.JTextField quantityField;
    private javax.swing.JTextField returnField;
    private javax.swing.JComboBox<String> searchField;
    private javax.swing.JTextField subtotalField;
    private javax.swing.JLabel time;
    private javax.swing.JTextField totalField;
    // End of variables declaration//GEN-END:variables
}
