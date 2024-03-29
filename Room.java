
package hotel_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Room extends javax.swing.JFrame {

    public Room() {
       initComponents();
       Connect();
       autoID();
       Show_Room();
    }

     Connection con;
    PreparedStatement pst;// prepare statement object
    DefaultTableModel d;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/HotelDB?useTimezone=true&serverTimezone=UTC","root","");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void autoID(){
        try {
            java.sql.Statement s=con.createStatement();
            ResultSet rs=s.executeQuery("select MAX(RoomID) from Room");
            rs.next();
            rs.getString("Max(RoomID)");
            
            if(rs.getString ("Max(RoomID)")== null)
            {
                roomNo.setText("R0001");
               
            }
            else{
                long id = Long.parseLong(rs.getString("Max(RoomID)").substring(2,rs.getString("Max(RoomID"
                        + ")").length()));
                id++;
                roomNo.setText("R0"+String.format("%03d", id));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void Show_Room()
    {
    int c;
        try {
            pst=con.prepareStatement("select*from Room");
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsd =rs.getMetaData();
            c = rsd.getColumnCount();
            
            d=(DefaultTableModel)RoomTable.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2=new Vector();
                
                for (int i=1; i<=c; i++){
                    v2.add(rs.getString("RoomID"));
                    v2.add(rs.getString("RoomName"));
                    v2.add(rs.getString("Category"));
                    v2.add(rs.getString("Type"));
                    v2.add(rs.getString("Status"));
                    v2.add(rs.getString("Price"));
                    
                }
                d.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        roomLbl = new javax.swing.JLabel();
        bookingLbl = new javax.swing.JLabel();
        customerLbl = new javax.swing.JLabel();
        HomeBtn = new javax.swing.JLabel();
        dashboardlbl = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        AddBtn = new javax.swing.JButton();
        roomName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        roomNo = new javax.swing.JLabel();
        ClearBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        roomCat = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        roomStatus = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        roomPrice = new javax.swing.JTextField();
        EditBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        roomType = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RoomTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 51, 6));

        roomLbl.setBackground(new java.awt.Color(204, 255, 255));
        roomLbl.setFont(new java.awt.Font("Times New Roman", 2, 28)); // NOI18N
        roomLbl.setForeground(new java.awt.Color(255, 255, 255));
        roomLbl.setText("Room");
        roomLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomLblMouseClicked(evt);
            }
        });

        bookingLbl.setBackground(new java.awt.Color(204, 255, 255));
        bookingLbl.setFont(new java.awt.Font("Times New Roman", 2, 28)); // NOI18N
        bookingLbl.setForeground(new java.awt.Color(255, 255, 255));
        bookingLbl.setText("CheckOut");
        bookingLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookingLblMouseClicked(evt);
            }
        });

        customerLbl.setBackground(new java.awt.Color(204, 255, 255));
        customerLbl.setFont(new java.awt.Font("Times New Roman", 2, 28)); // NOI18N
        customerLbl.setForeground(new java.awt.Color(255, 255, 255));
        customerLbl.setText("CheckIn");
        customerLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerLblMouseClicked(evt);
            }
        });

        HomeBtn.setBackground(new java.awt.Color(204, 255, 255));
        HomeBtn.setFont(new java.awt.Font("Times New Roman", 2, 28)); // NOI18N
        HomeBtn.setForeground(new java.awt.Color(255, 255, 255));
        HomeBtn.setText("Home");
        HomeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeBtnMouseClicked(evt);
            }
        });

        dashboardlbl.setBackground(new java.awt.Color(204, 255, 255));
        dashboardlbl.setFont(new java.awt.Font("Times New Roman", 2, 28)); // NOI18N
        dashboardlbl.setForeground(new java.awt.Color(255, 255, 255));
        dashboardlbl.setText("Dashboard");
        dashboardlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardlblMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(roomLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(customerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(bookingLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(dashboardlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomLbl)
                    .addComponent(customerLbl)
                    .addComponent(bookingLbl)
                    .addComponent(dashboardlbl)
                    .addComponent(HomeBtn))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 0));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Vivaldi", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(216, 216, 83));
        jLabel1.setText("TongueTaster");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(385, 385, 385))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(44, 51, 47));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setForeground(new java.awt.Color(12, 43, 48));

        jLabel4.setBackground(new java.awt.Color(204, 255, 255));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Room No.");

        AddBtn.setBackground(new java.awt.Color(102, 102, 0));
        AddBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AddBtn.setText("Enter");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        roomName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNameActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(204, 255, 255));
        jLabel12.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Name");

        roomNo.setBackground(new java.awt.Color(255, 204, 102));
        roomNo.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        roomNo.setForeground(new java.awt.Color(204, 153, 0));
        roomNo.setText("R0001");

        ClearBtn.setBackground(new java.awt.Color(102, 102, 0));
        ClearBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ClearBtn.setText("Clear");
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(204, 255, 255));
        jLabel3.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Category");

        roomCat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        roomCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single Bed", "Double Bed", "Triple Bed", "Family", "VIP" }));

        jLabel5.setBackground(new java.awt.Color(204, 255, 255));
        jLabel5.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Status");

        roomStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        roomStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Booked", "Available", " " }));
        roomStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomStatusActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(204, 255, 255));
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Price");

        roomPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomPriceActionPerformed(evt);
            }
        });

        EditBtn.setBackground(new java.awt.Color(102, 102, 0));
        EditBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        EditBtn.setText("Edit");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setBackground(new java.awt.Color(102, 102, 0));
        DeleteBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(204, 255, 255));
        jLabel7.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Type");

        roomType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        roomType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A/C", "Non A/C" }));
        roomType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AddBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditBtn)
                        .addGap(6, 6, 6)
                        .addComponent(DeleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roomNo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(roomName, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(roomType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roomPrice, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(roomCat, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roomStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, 247, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(roomNo))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roomName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roomCat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roomType, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roomStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roomPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jLabel2.setBackground(new java.awt.Color(51, 51, 0));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 0));
        jLabel2.setText("Rooms");
        jLabel2.setToolTipText("");

        jScrollPane1.setBorder(new javax.swing.border.MatteBorder(null));

        RoomTable.setBackground(new java.awt.Color(204, 204, 204));
        RoomTable.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RoomTable.setForeground(new java.awt.Color(0, 102, 102));
        RoomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room No", "Name", "Category", "Type", "Status", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        RoomTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        RoomTable.setGridColor(new java.awt.Color(0, 102, 102));
        RoomTable.setRowMargin(3);
        RoomTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RoomTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(RoomTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeBtnMouseClicked
        
        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeBtnMouseClicked

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        String rNo= roomNo.getText().toString();
        String rName= roomName.getText().toString();
        String rCat= roomCat.getSelectedItem().toString();
        String rType= roomType.getSelectedItem().toString();
        String rSt=roomStatus.getSelectedItem().toString();
        String rPrice= roomPrice.getText().toString();
         
        if(roomName.getText().isEmpty() || roomCat.getSelectedIndex()== -1 || roomStatus.getSelectedIndex()==-1 ||roomPrice.getText().isEmpty()||roomType.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(this, "Missing Data !!!");
        }else{
            try {
                    pst=con.prepareStatement("insert into Room(RoomID,RoomName,Category,Type,Status,Price) values(?,?,?,?,?,?)");
            pst.setString(1, rNo);
            pst.setString(2, rName);
            pst.setString(3, rCat);
            pst.setString(4, rType);
            pst.setString(5,rSt);
            pst.setString(6,rPrice);
           
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Room added Succsessfully !!! ");
            
            roomName.setText("");
            roomCat.setSelectedIndex(-1);
            roomType.setSelectedIndex(-1);
            roomStatus.setSelectedIndex(-1);
            roomPrice.setText("");
            autoID();
            Show_Room();
            AddBtn.setEnabled(true);
            
            } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_AddBtnActionPerformed
    }
    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
         roomName.setText("");
            roomCat.setSelectedIndex(-1);
            roomType.setSelectedIndex(-1);
            roomStatus.setSelectedIndex(-1);
            roomPrice.setText("");
   
            autoID();
            Show_Room();
            AddBtn.setEnabled(true);
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void RoomTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RoomTableMouseClicked
        d=(DefaultTableModel)RoomTable.getModel();
        int selectIndex=RoomTable.getSelectedRow();
        
        roomNo.setText(d.getValueAt(selectIndex, 0).toString());
        roomName.setText(d.getValueAt(selectIndex, 1).toString());
        roomCat.setSelectedItem(d.getValueAt(selectIndex, 2).toString());        
        roomType.setSelectedItem(d.getValueAt(selectIndex,3).toString());
        roomStatus.setSelectedItem(d.getValueAt(selectIndex, 4).toString());
        roomPrice.setText(d.getValueAt(selectIndex, 5).toString());
        AddBtn.setEnabled(false);

    }//GEN-LAST:event_RoomTableMouseClicked

    private void roomStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomStatusActionPerformed

    private void roomPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomPriceActionPerformed

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
          String rNo= roomNo.getText().toString();
          String rName= roomName.getText().toString();
          String rCat= roomCat.getSelectedItem().toString();       
          String rType= roomType.getSelectedItem().toString();
          String rSt=roomStatus.getSelectedItem().toString();
          String rPrice= roomPrice.getText().toString();

        try {
            pst=con.prepareStatement("update Room set RoomName= ?,Category= ?,Type=?,Status = ?,Price = ? where RoomID= ?");
           
            
            pst.setString(1, rName);
            pst.setString(2, rCat);
            pst.setString(3, rType);
            pst.setString(4,rSt);
            pst.setString(5,rPrice);
            pst.setString(6,rNo);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Room Details Updated Succsessfully !!! ");
            
            roomName.setText("");
            roomCat.setSelectedIndex(-1);
            roomType.setSelectedIndex(-1);
            roomStatus.setSelectedIndex(-1);
            roomPrice.setText("");
            autoID();
            Show_Room();
                   AddBtn.setEnabled(true);

           

        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }                           

    }//GEN-LAST:event_EditBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
          String rNo= roomNo.getText().toString();
          String rName= roomName.getText().toString();
          String rCat= roomCat.getSelectedItem().toString();
           String rType= roomType.getSelectedItem().toString();
          String rSt=roomStatus.getSelectedItem().toString();
          String rPrice= roomPrice.getText().toString();
        
        try {
            pst=con.prepareStatement("delete from Room where RoomID = ?");
           
            pst.setString(1, rNo);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Room Details Deleted Succsessfully !!! ");
            
            roomName.setText("");
            roomCat.setSelectedIndex(-1);
            roomType.setSelectedIndex(-1);
            roomStatus.setSelectedIndex(-1);
            roomPrice.setText("");
            autoID();
            Show_Room();
            DeleteBtn.setEnabled(true);
            AddBtn.setEnabled(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void roomLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomLblMouseClicked
        new Room().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_roomLblMouseClicked

    private void customerLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerLblMouseClicked
        new Customers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_customerLblMouseClicked

    private void bookingLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingLblMouseClicked
        new Checkout().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bookingLblMouseClicked

    private void dashboardlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardlblMouseClicked
         new Dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashboardlblMouseClicked

    private void roomTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomTypeActionPerformed

    private void roomNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNameActionPerformed

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
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Room().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JLabel HomeBtn;
    private javax.swing.JTable RoomTable;
    private javax.swing.JLabel bookingLbl;
    private javax.swing.JLabel customerLbl;
    private javax.swing.JLabel dashboardlbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> roomCat;
    private javax.swing.JLabel roomLbl;
    private javax.swing.JTextField roomName;
    private javax.swing.JLabel roomNo;
    private javax.swing.JTextField roomPrice;
    private javax.swing.JComboBox<String> roomStatus;
    private javax.swing.JComboBox<String> roomType;
    // End of variables declaration//GEN-END:variables
}
