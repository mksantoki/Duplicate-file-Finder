
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

public class Demo extends javax.swing.JFrame {

    public static int count = 1;
    public static int countu = 1;
    public static int countupdate = 1;
    public static int countdelete = 0;
    boolean  status=false;
    public static int fdc=0;
    public static int smatch=0;
    public static int nmatch=0;
    private boolean flg = false;

    public Demo() {
        initComponents();
        status=false;
        jbdelete.show(status);

        File[] paths;
        FileSystemView fsv = FileSystemView.getFileSystemView();
        paths = File.listRoots();
        int cr = paths.length;
        String str[] = null;
        int i = 0;

        for (File path : paths) {
            String strData = path.toString();
            strData = strData.substring(0, strData.lastIndexOf("\\"));
            // prints file and directory paths
            System.out.println("Drive Name: " + strData);
            jComboBox1.addItem("" + strData);
            System.out.println("Description: " + fsv.getSystemTypeDescription(path));
            str = path.list();
            i++;
            if (i > cr) {
                break;
            }
        }

        flg = true;
    }

    public void dir(String path, int j) {
        try {
            DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel();
            String dir = path;

            File f3 = new File(dir);
            String[] arr = f3.list();
            String[] farr = {""};
            int farrlangth;


            for (int i = 0; arr != null && i < arr.length; i++) {
                File f2 = new File(path + "\\" + arr[i]);


                if (f2.isFile()) {
                    if (f2.isFile() && !f2.isHidden() && f2.canRead()) {
                        String fname = f2.getName();
                        fname = fname.substring(0, fname.lastIndexOf("."));

                        dtm.addRow(new Object[]{count, fname, f2.toPath(), f2.length() + " Byte"});
                        count++;
                        jltotlefile.setText("Total Files :" + Integer.toString(count));
                    }
                } else if (f2.isDirectory() && !f2.isHidden() && f2.canRead()) {
                    farr = f2.list();
                    farrlangth = farr.length;
                    dir = f2.toPath().toString();
                    dir(dir, j);
                }

            }
        } catch (StringIndexOutOfBoundsException ex) {
            int idasf;
            idasf = 34;
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jbdelete = new javax.swing.JButton();
        jbsize = new javax.swing.JButton();
        jbname = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jts = new javax.swing.JTextField();
        jbs = new javax.swing.JButton();
        jltotlefile = new javax.swing.JLabel();
        jlnfileupdate = new javax.swing.JLabel();
        jlnfiledelete = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Duplicate FIle Finder");
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "File Name ", "Path", "Size", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setRowHeight(20);
        jTable1.setRowMargin(2);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(50);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(1).setMinWidth(200);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setMinWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setMinWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select File");
        jLabel1.setToolTipText("");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Drive" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jbdelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbdelete.setText("Delete");
        jbdelete.setToolTipText("Delete Selected File");
        jbdelete.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jbdeleteMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jbdeleteMouseMoved(evt);
            }
        });
        jbdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbdeleteActionPerformed(evt);
            }
        });
        jbdelete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbdeleteKeyPressed(evt);
            }
        });

        jbsize.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbsize.setText("Size");
        jbsize.setToolTipText("Find Duplicate File By Size");
        jbsize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsizeActionPerformed(evt);
            }
        });

        jbname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbname.setText("Name");
        jbname.setToolTipText("Find Duplicate File By the Name");
        jbname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnameActionPerformed(evt);
            }
        });
        jbname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbnameKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jbsize, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbname, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jbdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jbdelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbsize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Search Name");

        jts.setText("Enter the First Character of File......");
        jts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtsActionPerformed(evt);
            }
        });
        jts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtsKeyPressed(evt);
            }
        });

        jbs.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbs.setText("Search");
        jbs.setToolTipText("Enter the First Character of File......");
        jbs.setMaximumSize(new java.awt.Dimension(51, 23));
        jbs.setMinimumSize(new java.awt.Dimension(51, 23));
        jbs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jts, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jbs, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jltotlefile, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlnfileupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlnfiledelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlnfileupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jts)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))
                    .addComponent(jbs, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jltotlefile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlnfiledelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(48, 48, 48))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jbdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbdeleteActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel();
        int jtr=jTable1.getRowCount();
        int jtl = jTable1.getRowCount();
        String[] fdname = new String[jtl];
        String[] fdpath = new String[jtl];
        String[] fdsize = new String[jtl];

        int arr = dtm.getRowCount();
        for (int k = 0; k < arr; k++)
        {
            String check = "";
            try {
                check = dtm.getValueAt(k, 4).toString();
            } catch (NullPointerException ex) {
            }
            if ("true".equals(check.toLowerCase())) 
            {
                String fpath;
                fpath = dtm.getValueAt(k, 2).toString();
                File f = new File(fpath);
                f.delete();
               
                fdc++;
                countdelete++;
            }
            else
            {
                
                 fdname[k] = jTable1.getValueAt(k, 1).toString();
                 fdpath[k] = jTable1.getValueAt(k, 2).toString();
                 fdsize[k] = jTable1.getValueAt(k, 3).toString();
                
               
                 
            }
        }
        dtm.setRowCount(0);
        int size=fdname.length;
        int n=1;
        for(int m=0;m<size;m++)
        {
            
            if(fdname[m] != null)
            {
            dtm.addRow(new Object[]{n, fdname[m], fdpath[m],fdsize[m]+ " Byte"});  
             n++;
            }
           
            
        }
               
        
        if(fdc!=0)
            {
                Icon icon = new ImageIcon("D:\\Duplicate File FInder\\My Project\\src\\delete dilogbox.png");
                String aboutGreeting = "File Deleted";
                JOptionPane.showMessageDialog(null, aboutGreeting, "Delete Message", JOptionPane.INFORMATION_MESSAGE,icon);
                jlnfiledelete.setText("File delete:-"+Integer.toString(countdelete));
            }
        
    }//GEN-LAST:event_jbdeleteActionPerformed


    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if (!flg) {
            return;
        }
         status=false;
        jbdelete.show(status);
        countupdate=0;
        jlnfileupdate.setText("");
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel();
        dtm.getDataVector().removeAllElements();
        revalidate();
        count = 1;

        String data = jComboBox1.getItemAt(jComboBox1.getSelectedIndex()) + "";
   
        File f = new File(data);
        String[] arr = f.list();

        System.out.print(arr.length);
        for (int i = 0; arr != null && i < arr.length; i++) {
            File f2 = new File(data + "\\" + arr[i]);

            if (f2.isFile()) 
            {
                String fname = f2.getName();
                fname = fname.substring(0, fname.lastIndexOf("."));
                dtm.addRow(new Object[]{count, fname, f2.toPath(), f2.length() + " Byte"});
                count++;

            } else if (f2.isDirectory() && !f2.isHidden() && f2.canRead()) {
                //jTable1.setValueAt(i, i, 1);
                String path = data + "\\" + arr[i];
                dir(path, i);
                jltotlefile.setText("Total Files :" + Integer.toString(count));
            }
        }


    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jbdeleteMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbdeleteMouseDragged
        // TODO add your handling code here:


    }//GEN-LAST:event_jbdeleteMouseDragged

    private void jbdeleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbdeleteKeyPressed
        // TODO add your handling code here:4


    }//GEN-LAST:event_jbdeleteKeyPressed

    private void jbdeleteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbdeleteMouseMoved
        // TODO add your handling code here:


    }//GEN-LAST:event_jbdeleteMouseMoved

    private void jbnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnameActionPerformed
        // TODO add your handling code here:
        if (!flg) {
            return;
        }
        DefaultTableModel dt = (DefaultTableModel) this.jTable1.getModel();
        countupdate=0;
        int jtl = jTable1.getRowCount();
        String[] fname = new String[jtl];
        String[] fpath = new String[jtl];
        String[] fsize = new String[jtl];

        String[] fname1 = new String[jtl];
        String[] fpath1 = new String[jtl];
        String[] fsize1 = new String[jtl];

        for (int i = 0; i < jtl; i++) {
            for (int j = i + 1; j < jtl; j++) {
                String jtn1 = jTable1.getValueAt(i, 1).toString();
                String jtn2 = jTable1.getValueAt(j, 1).toString();

                if (jtn1.equals(jtn2)) //                if(1==jtn1.compareTo(jtn2))
                {
                    int fnl=fname.length;
                    nmatch=0;
                    for(int f=0;f<fnl;f++)
                    {
                     if(jtn1.equals(fname[f]))   
                     {
                         nmatch++;
                     }                  
                    }
                    if(nmatch==0)
                    {
                         fname[i] = jTable1.getValueAt(i, 1).toString();
                         fpath[i] = jTable1.getValueAt(i, 2).toString();
                         fsize[i] = jTable1.getValueAt(i, 3).toString();

                        fname1[i] = jTable1.getValueAt(j, 1).toString();
                        fpath1[i] = jTable1.getValueAt(j, 2).toString();
                        fsize1[i] = jTable1.getValueAt(j, 3).toString();
                      //  countupdate++;
                        
                        
                    }                   
                
                }
            }
        }

        dt.setRowCount(0);
        revalidate();
        for (int k = 0; k < fname.length; k++) {
            if (fname[k] != null) {
                dt.addRow(new Object[]{countupdate, fname[k], fpath[k], fsize[k]});
                countupdate++;
            }

            if (fname1[k] != null) {
                dt.addRow(new Object[]{countupdate, fname1[k], fpath1[k], fsize1[k]});
                countupdate++;
            }
            jlnfileupdate.setText("File Duplicate:-"+Integer.toString(countupdate));
        }
       
        status=true;
        jbdelete.setVisible(status);

    }//GEN-LAST:event_jbnameActionPerformed

    private void jbnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbnameKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_jbnameKeyPressed

    private void jbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsActionPerformed
        DefaultTableModel dt = (DefaultTableModel) this.jTable1.getModel();

        int jtl = jTable1.getRowCount();
        String[] fname = new String[jtl];
        String[] fpath = new String[jtl];
        String[] fsize = new String[jtl];
        
        

        for (int i = 0; i < jtl; i++) 
        {
            String jtn1 = "";
            jtn1 = jTable1.getValueAt(i, 1).toString();
            char cjtn1 = jtn1.charAt(0);
            jtn1 = Character.toString(cjtn1);
            String jt = jts.getText();

            if (jtn1.equals(jt)) {
                fname[i] = jTable1.getValueAt(i, 1).toString();
                fpath[i] = jTable1.getValueAt(i, 2).toString();
                fsize[i] = jTable1.getValueAt(i, 3).toString();
            }
        }
        dt.setRowCount(0);
        revalidate();
        for (int k = 0; k < fname.length; k++) {
            if (fname[k] != null) {
                dt.addRow(new Object[]{k, fname[k], fpath[k], fsize[k]});
            }
        }


    }//GEN-LAST:event_jbsActionPerformed

    private void jbsizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsizeActionPerformed
 DefaultTableModel dt = (DefaultTableModel) this.jTable1.getModel();

        int jtl = jTable1.getRowCount();
        String[] fname = new String[jtl];
        String[] fpath = new String[jtl];
        String[] fsize = new String[jtl];
        
        
        String[] fname1 = new String[jtl];
        String[] fpath1 = new String[jtl];
        String[] fsize1 = new String[jtl];

        for (int i = 0; i < jtl; i++) {
            for (int j = i + 1; j < jtl; j++) 
            {
                String jtn1 = jTable1.getValueAt(i, 3).toString();
                String jtn2 = jTable1.getValueAt(j, 3).toString();

                if (jtn1.equals(jtn2)) //                if(1==jtn1.compareTo(jtn2))
                {
                    int fnl=fname.length;
                    smatch=0;
                    for(int f=0;f<fnl;f++)
                    {
                     if(jtn1.equals(fsize[f]))   
                     {
                         smatch++;
                     }                  
                    }
                    if(smatch==0)
                    {
                         fname[i] = jTable1.getValueAt(i, 1).toString();
                         fpath[i] = jTable1.getValueAt(i, 2).toString();
                         fsize[i] = jTable1.getValueAt(i, 3).toString();

                        fname1[i] = jTable1.getValueAt(j, 1).toString();
                        fpath1[i] = jTable1.getValueAt(j, 2).toString();
                        fsize1[i] = jTable1.getValueAt(j, 3).toString();
                       // countupdate++;
                        
                        
                    }                   
                }
            }
        }

        dt.setRowCount(0);
        revalidate();
        for (int k = 0; k < fname.length; k++)
        {
            if (fname[k] != null) {
                dt.addRow(new Object[]{countupdate, fname[k], fpath[k], fsize[k]});
                countupdate++;
            }

            if (fname1[k] != null) {
                dt.addRow(new Object[]{countupdate, fname1[k], fpath1[k], fsize1[k]});
                countupdate++;
            }
            
            jlnfileupdate.setText("File Duplicate:-"+Integer.toString(countupdate));
        }
        status=true;
        jbdelete.setVisible(status);


    }//GEN-LAST:event_jbsizeActionPerformed

    private void jtsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtsActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jtsActionPerformed

    private void jtsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtsKeyPressed
        // TODO add your handling code here:
         jts.setText("");
    }//GEN-LAST:event_jtsKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Demo().setVisible(true);
            
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbdelete;
    private javax.swing.JButton jbname;
    private javax.swing.JButton jbs;
    private javax.swing.JButton jbsize;
    private javax.swing.JLabel jlnfiledelete;
    private javax.swing.JLabel jlnfileupdate;
    private javax.swing.JLabel jltotlefile;
    private javax.swing.JTextField jts;
    // End of variables declaration//GEN-END:variables
}
