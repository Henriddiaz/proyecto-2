/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hanoi;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



public class VentanaPrincipal extends javax.swing.JFrame {
    
    
    int ContNumMov = 0;
    Pila PilaTorreA;
    Pila PilaTorreB;
    Pila PilaTorreC;
    
    DefaultTableModel ModeloTablaTorreA, ModeloTablaTorreB, ModeloTablaTorreC;
    
    int Objetivo = 0;
    
    double NumMinMov = 0;
    
    boolean Stop = false;

    /** Creates new form VentanaPrincipal */
    public VentanaPrincipal() {
        initComponents();
        
        ModeloTablaTorreA = (DefaultTableModel) TorreA.getModel();
        ModeloTablaTorreA.setRowCount(10);
        
        ModeloTablaTorreB = (DefaultTableModel) TorreB.getModel();
        ModeloTablaTorreB.setRowCount(10);
        
        ModeloTablaTorreC = (DefaultTableModel) TorreC.getModel();
        ModeloTablaTorreC.setRowCount(10);
        
        DefaultTableCellRenderer renderA = new DefaultTableCellRenderer();
        renderA.setHorizontalAlignment(SwingConstants.CENTER);
        TorreA.getColumnModel().getColumn(0).setCellRenderer(renderA);
        
        DefaultTableCellRenderer renderB = new DefaultTableCellRenderer();
        renderB.setHorizontalAlignment(SwingConstants.CENTER);
        TorreB.getColumnModel().getColumn(0).setCellRenderer(renderB);
        
        DefaultTableCellRenderer renderC = new DefaultTableCellRenderer();
        renderC.setHorizontalAlignment(SwingConstants.CENTER);
        TorreC.getColumnModel().getColumn(0).setCellRenderer(renderC);
    }
    
    private void Limpiar(){
        
        ContNumMov = 0;
        NumMinMov = 0;
        
        CbNumDiscos.setSelectedItem(String.valueOf(Objetivo));
        
    }
    
    private void PresentarCantMov(){
        
        ContNumMov ++;
        LblNumMov.setText(String.valueOf(ContNumMov));
        
    }
    
    private void Reiniciar(){
        
        try{
            
            if(!LblMinMov.getText().equals("")){
                
                Limpiar();
                Iniciar();
            }
            
        }catch(Exception E){
            System.out.println("Error: "+E.getMessage());
        }        
        
    }
    
    private void Iniciar(){
        
        try{
            
            PilaTorreA = new Pila();
        PilaTorreB = new Pila();
        PilaTorreC = new Pila();
        
        Objetivo = Integer.parseInt(CbNumDiscos.getSelectedItem().toString());
        
        NumMinMov = Math.pow(2, Objetivo) -1;
        
        LblNumMov.setText(String.valueOf(ContNumMov));
        LblMinMov.setText(String.valueOf(String.format("%.0f", NumMinMov)));
        
        for(int x = Objetivo; x >= 1; x--){
            
            Nodo Plataforma = new Nodo();
            
            String Disco = "";
            
            for(int y = x; y > 0 ; y--){
                
                Disco+= "#";
            }
            
            Plataforma.setDato(Disco);
            
            PilaTorreA.Push(Plataforma);
        }
        
        PresentarTorreA();
        PresentarTorreB();
        PresentarTorreC();
            
        }catch(Exception E){
            System.out.println("Error: "+E.getMessage());
        }
        
        
    }
    
    
    private void PresentarTorreA(){
        
        ((DefaultTableModel)TorreA.getModel()).setRowCount(0);
        
        ModeloTablaTorreA.setRowCount(10);
        
        Nodo K;
        
        int RowDisco = (10 - PilaTorreA.getContNodo());
        
        if(PilaTorreA.getContNodo() > 0){
            
            for(K = PilaTorreA.getCabeza(); K.getAbajo() != null; K = K.getAbajo()){
                
                String[] VectorNormal = {K.getDato()};
                
                ModeloTablaTorreA.insertRow(RowDisco, VectorNormal);
                RowDisco++;
            }
            
            if(K.getAbajo() == null){
                String[] VectorNormal = {K.getDato()};
                ModeloTablaTorreA.insertRow(RowDisco, VectorNormal);
            }
        }
        
        
        TorreA.setModel(ModeloTablaTorreA);
        ModeloTablaTorreA.setRowCount(10);
    }
    
    private void PresentarTorreB(){
        
        ((DefaultTableModel)TorreB.getModel()).setRowCount(0);
        
        ModeloTablaTorreB.setRowCount(10);
        
        Nodo K;
        
        int RowDisco = (10 - PilaTorreB.getContNodo());
        
        if(PilaTorreB.getContNodo() > 0){
            
            for(K = PilaTorreB.getCabeza(); K.getAbajo() != null; K = K.getAbajo()){
                
                String[] VectorNormal = {K.getDato()};
                
                ModeloTablaTorreB.insertRow(RowDisco, VectorNormal);
                RowDisco++;
            }
            
            if(K.getAbajo() == null){
                String[] VectorNormal = {K.getDato()};
                ModeloTablaTorreB.insertRow(RowDisco, VectorNormal);
            }
        }
        
        
        TorreB.setModel(ModeloTablaTorreB);
        ModeloTablaTorreB.setRowCount(10);
    }
    
    private void PresentarTorreC(){
        
        ((DefaultTableModel)TorreC.getModel()).setRowCount(0);
        
        ModeloTablaTorreC.setRowCount(10);
        
        Nodo K;
        
        int RowDisco = (10 - PilaTorreC.getContNodo());
        
        if(PilaTorreC.getContNodo() > 0){
            
            for(K = PilaTorreC.getCabeza(); K.getAbajo() != null; K = K.getAbajo()){
                
                String[] VectorNormal = {K.getDato()};
                
                ModeloTablaTorreC.insertRow(RowDisco, VectorNormal);
                RowDisco++;
            }
            
            if(K.getAbajo() == null){
                String[] VectorNormal = {K.getDato()};
                ModeloTablaTorreC.insertRow(RowDisco, VectorNormal);
            }
        }
        
        
        TorreC.setModel(ModeloTablaTorreC);
        ModeloTablaTorreC.setRowCount(10);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TorreA = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TorreB = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TorreC = new javax.swing.JTable();
        BtnA_B = new javax.swing.JButton();
        BtnA_C = new javax.swing.JButton();
        BtnB_C = new javax.swing.JButton();
        BtnB_A = new javax.swing.JButton();
        BtnC_B = new javax.swing.JButton();
        BtnC_A = new javax.swing.JButton();
        CbNumDiscos = new javax.swing.JComboBox<>();
        LblMinMov = new javax.swing.JLabel();
        LblNumMov = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BtnIniciar = new javax.swing.JButton();
        BtnReiniciar = new javax.swing.JButton();
        BtnResolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TorreA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TorreA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TorreA.setAutoscrolls(false);
        TorreA.setFocusable(false);
        TorreA.setRowSelectionAllowed(false);
        TorreA.setShowHorizontalLines(false);
        TorreA.setShowVerticalLines(false);
        jScrollPane1.setViewportView(TorreA);
        if (TorreA.getColumnModel().getColumnCount() > 0) {
            TorreA.getColumnModel().getColumn(0).setResizable(false);
        }

        TorreB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TorreB"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TorreB.setAutoscrolls(false);
        TorreB.setFocusable(false);
        TorreB.setRowSelectionAllowed(false);
        TorreB.setShowHorizontalLines(false);
        TorreB.setShowVerticalLines(false);
        jScrollPane2.setViewportView(TorreB);
        if (TorreB.getColumnModel().getColumnCount() > 0) {
            TorreB.getColumnModel().getColumn(0).setResizable(false);
        }

        TorreC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TorreC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TorreC.setAutoscrolls(false);
        TorreC.setFocusable(false);
        TorreC.setRowSelectionAllowed(false);
        TorreC.setShowHorizontalLines(false);
        TorreC.setShowVerticalLines(false);
        jScrollPane3.setViewportView(TorreC);
        if (TorreC.getColumnModel().getColumnCount() > 0) {
            TorreC.getColumnModel().getColumn(0).setResizable(false);
        }

        BtnA_B.setText("B");
        BtnA_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnA_BActionPerformed(evt);
            }
        });

        BtnA_C.setText("C");
        BtnA_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnA_CActionPerformed(evt);
            }
        });

        BtnB_C.setText("C");
        BtnB_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnB_CActionPerformed(evt);
            }
        });

        BtnB_A.setText("A");
        BtnB_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnB_AActionPerformed(evt);
            }
        });

        BtnC_B.setText("B");
        BtnC_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnC_BActionPerformed(evt);
            }
        });

        BtnC_A.setText("A");
        BtnC_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnC_AActionPerformed(evt);
            }
        });

        CbNumDiscos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5", "6", "7", "8", "9", "10" }));

        LblMinMov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblMinMov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        LblNumMov.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LblNumMov.setForeground(new java.awt.Color(255, 51, 0));
        LblNumMov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblNumMov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel3.setText("Número de Discos:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel4.setText("Número min de mov:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel5.setText("Número de Movimientos:");

        BtnIniciar.setText("Iniciar");
        BtnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIniciarActionPerformed(evt);
            }
        });

        BtnReiniciar.setText("Reiniciar");
        BtnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReiniciarActionPerformed(evt);
            }
        });

        BtnResolver.setText("Resolver");
        BtnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResolverActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(layout.createSequentialGroup()
                            .add(BtnA_B, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(26, 26, 26)
                            .add(BtnA_C, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 146, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, BtnIniciar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(95, 95, 95)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 146, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(layout.createSequentialGroup()
                                        .add(BtnB_A, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(26, 26, 26)
                                        .add(BtnB_C, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(CbNumDiscos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 146, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, LblMinMov, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 146, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, LblNumMov, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 146, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 95, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(BtnReiniciar)
                        .add(132, 132, 132)))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 146, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(BtnC_A, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(26, 26, 26)
                        .add(BtnC_B, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(BtnResolver))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .add(68, 68, 68)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(BtnA_B)
                    .add(BtnA_C)
                    .add(BtnB_A)
                    .add(BtnB_C)
                    .add(BtnC_A)
                    .add(BtnC_B))
                .add(59, 59, 59)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(CbNumDiscos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(21, 21, 21)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(LblMinMov, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(LblNumMov, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 33, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(BtnIniciar)
                    .add(BtnReiniciar)
                    .add(BtnResolver))
                .add(31, 31, 31))
        );

        pack();
    }// </editor-fold>                        

    
    private void MoverDeA_B(){
        try{
            
            if(PilaTorreA.getContNodo() > 0){
                
                Nodo Plataforma = new Nodo();
                
                Plataforma.setDato(PilaTorreA.Peek());
                
                if(PilaTorreB.getContNodo() > 0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreB.Peek()) > 0){
                        
                        return;
                    }
                }
            
            
            PilaTorreA.Pop();
            PilaTorreB.Push(Plataforma);
            
            PresentarTorreA();
            PresentarTorreB();
            PresentarCantMov();
            
            }
            
        }catch(Exception E){
            System.out.println("Error:"+E.getMessage());
        }
    }
    private void BtnA_BActionPerformed(java.awt.event.ActionEvent evt) {                                       
        
    }                                      

    
    private void MoverDeA_C(){
        try{
            
            if(PilaTorreA.getContNodo() > 0){
                
                Nodo Plataforma = new Nodo();
                
                Plataforma.setDato(PilaTorreA.Peek());
                
                if(PilaTorreC.getContNodo() > 0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreC.Peek()) > 0){
                        
                        return;
                }
            }
            
            PilaTorreA.Pop();
            PilaTorreC.Push(Plataforma);
            
            PresentarTorreA();
            PresentarTorreC();
            PresentarCantMov();
            
            if(PilaTorreC.getContNodo() == Objetivo && ContNumMov == NumMinMov){
                
                JOptionPane.showMessageDialog(null,"Felicidades Has alcanzado el objetivo de minimo de movimientos\n\nIntenta con otro nivel de dificultad", "Felicitaciones", JOptionPane.WARNING_MESSAGE);
            }else if(PilaTorreC.getContNodo() == Objetivo && ContNumMov != NumMinMov){
                JOptionPane.showMessageDialog(null,"Felicidades lo has resuelto\\nIntenta superar el objetivo minimo de movimientos", "Felicitaciones", JOptionPane.INFORMATION_MESSAGE );
            }
            
            }
        }catch(Exception E){
            System.out.println("Error:"+E.getMessage());
        }
    }
    private void BtnA_CActionPerformed(java.awt.event.ActionEvent evt) {                                       
        MoverDeA_C();
    }                                      

    
    private void MoverDeB_C(){
        
        try{
            
            if(PilaTorreB.getContNodo() > 0){
                
                Nodo Plataforma = new Nodo();
                
                Plataforma.setDato(PilaTorreB.Peek());
                
                if(PilaTorreC.getContNodo() > 0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreC.Peek()) > 0){
                        
                        return;
                }
            }
            
            PilaTorreB.Pop();
            PilaTorreC.Push(Plataforma);
            
            PresentarTorreB();
            PresentarTorreC();
            PresentarCantMov();
            
            if(PilaTorreC.getContNodo() == Objetivo && ContNumMov == NumMinMov){
                
                JOptionPane.showMessageDialog(null,"Felicidades Has alcanzado el objetivo de minimo de movimientos\n\nIntenta con otro nivel de dificultad", "Felicitaciones", JOptionPane.WARNING_MESSAGE);
            }else if(PilaTorreC.getContNodo() == Objetivo && ContNumMov != NumMinMov){
                JOptionPane.showMessageDialog(null,"Felicidades lo has resuelto\\nIntenta superar el objetivo minimo de movimientos", "Felicitaciones", JOptionPane.INFORMATION_MESSAGE );
            }
            
            }
        }catch(Exception E){
            System.out.println("Error:"+E.getMessage());
        }
    }
    
    private void BtnB_CActionPerformed(java.awt.event.ActionEvent evt) {                                       
        MoverDeB_C();
    }                                      

    private void MoverDeB_A(){
        try{
            
            if(PilaTorreB.getContNodo() > 0){
                
                Nodo Plataforma = new Nodo();
                
                Plataforma.setDato(PilaTorreB.Peek());
                
                if(PilaTorreA.getContNodo() > 0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreA.Peek()) > 0){
                        
                        return;
                }
            }
            
            PilaTorreB.Pop();
            PilaTorreA.Push(Plataforma);
            
            PresentarTorreA();
            PresentarTorreC();
            PresentarCantMov();
            
            if(PilaTorreC.getContNodo() == Objetivo && ContNumMov == NumMinMov){
                
                JOptionPane.showMessageDialog(null,"Felicidades Has alcanzado el objetivo de minimo de movimientos\n\nIntenta con otro nivel de dificultad", "Felicitaciones", JOptionPane.WARNING_MESSAGE);
            }else if(PilaTorreC.getContNodo() == Objetivo && ContNumMov != NumMinMov){
                JOptionPane.showMessageDialog(null,"Felicidades lo has resuelto\\nIntenta superar el objetivo minimo de movimientos", "Felicitaciones", JOptionPane.INFORMATION_MESSAGE );
            }
            
            }
        }catch(Exception E){
            System.out.println("Error:"+E.getMessage());
        }
        
        
    }
    
    
    private void BtnB_AActionPerformed(java.awt.event.ActionEvent evt) {                                       
        MoverDeB_A();
    }                                      

    
    
    private void MoverDeC_B(){
        
        try{
            
            if(PilaTorreC.getContNodo() > 0){
                
                Nodo Plataforma = new Nodo();
                
                Plataforma.setDato(PilaTorreC.Peek());
                
                if(PilaTorreB.getContNodo() > 0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreB.Peek()) > 0){
                        
                        return;
                    }
                }
            
            
            PilaTorreC.Pop();
            PilaTorreB.Push(Plataforma);
            
            PresentarTorreB();
            PresentarTorreC();
            PresentarCantMov();
            
            }
            
        }catch(Exception E){
            System.out.println("Error:"+E.getMessage());
        }
        
    }
    private void BtnC_BActionPerformed(java.awt.event.ActionEvent evt) {                                       
        MoverDeC_B();
    }                                      

    private void MoverDeC_A(){
        
        try{
            
            if(PilaTorreC.getContNodo() > 0){
                
                Nodo Plataforma = new Nodo();
                
                Plataforma.setDato(PilaTorreC.Peek());
                
                if(PilaTorreB.getContNodo() > 0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreB.Peek()) > 0){
                        
                        return;
                    }
                }
            
            
            PilaTorreC.Pop();
            PilaTorreB.Push(Plataforma);
            
            PresentarTorreA();
            PresentarTorreC();
            PresentarCantMov();
            
            }
            
        }catch(Exception E){
            System.out.println("Error:"+E.getMessage());
        }
        
    }
    
    
    private void BtnC_AActionPerformed(java.awt.event.ActionEvent evt) {                                       
        MoverDeC_A();
    }                                      

    boolean stop = false;
    
    private void MoverPlataforma(Pila Origen, Pila Destino){
        
        if(stop == false){
            
            Nodo Plataforma = new Nodo();
            
            Plataforma.setDato(Origen.Peek());
            
            Origen.Pop();
            
            Destino.Push(Plataforma);
            
            PresentarTorreA();
            PresentarTorreB();
            PresentarTorreC();
            PresentarCantMov();
            
            JOptionPane pane = new JOptionPane("Paso # "+LblNumMov.getText()+"\n\n¿Continuar?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
            
            JDialog dialog = pane.createDialog("Número de pasos");
            
            dialog.setLocation(600, 400);
            
            dialog.setVisible(true);
            
            int opt = (int) pane.getValue();
            
            if(opt == JOptionPane.NO_OPTION){
                Stop = true;
            }
            
        }
    }
    
    private void ResolverHanoiRecursivo(int n, Pila Origen, Pila Auxiliar, Pila Destino){
        
        if(n == 1){
            
            MoverPlataforma(Origen, Destino);
            
        }else{
            
            ResolverHanoiRecursivo(n -1, Origen, Destino, Auxiliar);
            
            MoverPlataforma(Origen, Destino);
            
            ResolverHanoiRecursivo(n -1, Auxiliar, Origen, Destino);
        }
    }
    
    
    
    private void BtnResolverActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(!LblMinMov.getText().equals("") && PilaTorreC.getContNodo() != Objetivo){
            
            Reiniciar();
            Stop=false;
            
            ResolverHanoiRecursivo(Objetivo, PilaTorreA, PilaTorreB, PilaTorreC);
            
        }
    }                                           

    private void BtnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        Reiniciar();
    }                                            

    private void BtnIniciarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        Iniciar();
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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton BtnA_B;
    private javax.swing.JButton BtnA_C;
    private javax.swing.JButton BtnB_A;
    private javax.swing.JButton BtnB_C;
    private javax.swing.JButton BtnC_A;
    private javax.swing.JButton BtnC_B;
    private javax.swing.JButton BtnIniciar;
    private javax.swing.JButton BtnReiniciar;
    private javax.swing.JButton BtnResolver;
    private javax.swing.JComboBox<String> CbNumDiscos;
    private javax.swing.JLabel LblMinMov;
    private javax.swing.JLabel LblNumMov;
    private javax.swing.JTable TorreA;
    private javax.swing.JTable TorreB;
    private javax.swing.JTable TorreC;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration                   

}
