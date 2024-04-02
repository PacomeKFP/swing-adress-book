package ui.creation;

import com.formdev.flatlaf.FlatDarkLaf;
import core.Repertoire;
import java.awt.CardLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class MainCreation extends javax.swing.JFrame {

    public MainCreation(Repertoire repertoire) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
        }        
        
        this.agentPane = new AgentPane(repertoire);
        this.enseignantPane = new EnseignantPane(repertoire);
        this.etudiantPane = new EtudiantPane(repertoire);
        
        initComponents();
        
        this.cardLayout = new CardLayout();
        this.container.setLayout(this.cardLayout);
        this.container.add(this.creationMenuPanel, this.MENU_PANEL);
        this.container.add(this.agentPane, this.AGENT_PANEL);
        this.container.add(this.etudiantPane, this.ETUDIANT_PANEL);
        this.container.add(this.enseignantPane, this.ENSEIGNANT_PANEL);
        
        this.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        creationMenuPanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        creerAgentButton = new javax.swing.JButton();
        creerEtudiantButton = new javax.swing.JButton();
        creerEnseignantButton = new javax.swing.JButton();
        retourBoutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Eras Bd BT", 0, 18)); // NOI18N
        title.setText("CREER CONTACT");

        creerAgentButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        creerAgentButton.setText("AGENT");
        creerAgentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creerAgentButtonActionPerformed(evt);
            }
        });

        creerEtudiantButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        creerEtudiantButton.setText("ETUDIANT");
        creerEtudiantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creerEtudiantButtonActionPerformed(evt);
            }
        });

        creerEnseignantButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        creerEnseignantButton.setText("ENSEIGNANT");
        creerEnseignantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creerEnseignantButtonActionPerformed(evt);
            }
        });

        retourBoutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        retourBoutton.setText("RETOUR");
        retourBoutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourBouttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout creationMenuPanelLayout = new javax.swing.GroupLayout(creationMenuPanel);
        creationMenuPanel.setLayout(creationMenuPanelLayout);
        creationMenuPanelLayout.setHorizontalGroup(
            creationMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creationMenuPanelLayout.createSequentialGroup()
                .addGroup(creationMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(creationMenuPanelLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(title))
                    .addGroup(creationMenuPanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(creationMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(creerEtudiantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(creerEnseignantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(creerAgentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(retourBoutton, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        creationMenuPanelLayout.setVerticalGroup(
            creationMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creationMenuPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(title)
                .addGap(50, 50, 50)
                .addComponent(creerEtudiantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(creerEnseignantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(creerAgentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(retourBoutton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(creationMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(creationMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void creerEtudiantButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creerEtudiantButtonActionPerformed
        this.cardLayout.show(this.container, this.ETUDIANT_PANEL);
    }//GEN-LAST:event_creerEtudiantButtonActionPerformed

    private void creerEnseignantButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creerEnseignantButtonActionPerformed
        this.cardLayout.show(this.container, this.ENSEIGNANT_PANEL);
    }//GEN-LAST:event_creerEnseignantButtonActionPerformed

    private void creerAgentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creerAgentButtonActionPerformed
        this.cardLayout.show(this.container, this.AGENT_PANEL);
    }//GEN-LAST:event_creerAgentButtonActionPerformed

    private void retourBouttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourBouttonActionPerformed
        this.dispose();
    }//GEN-LAST:event_retourBouttonActionPerformed

    // personnal Panels declarations
    private final CardLayout cardLayout;
    private final AgentPane agentPane;
    private final EnseignantPane enseignantPane;
    private final EtudiantPane etudiantPane;
    
    private final String MENU_PANEL = "menu panel";
    private final String AGENT_PANEL = "agent panel";
    private final String ETUDIANT_PANEL = "etudiant panel";
    private final String ENSEIGNANT_PANEL = "enseignant panel";
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JPanel creationMenuPanel;
    private javax.swing.JButton creerAgentButton;
    private javax.swing.JButton creerEnseignantButton;
    private javax.swing.JButton creerEtudiantButton;
    private javax.swing.JButton retourBoutton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}