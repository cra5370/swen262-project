/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medicalimaging.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;
import medicalimaging.model.Study;
import medicalimaging.model.StudyElement;

/**
 *
 * @author ericlee
 */
public class MainFrame extends javax.swing.JFrame implements TreeSelectionListener, MouseWheelListener, KeyListener{

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
        //Configure study tree
        studyTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        studyTree.addTreeSelectionListener(this);
        
        //Configure image panel
        imagePanel.setLayout(new GridLayout(0,1));
        imagePanel.addMouseWheelListener(this);
        //this.addMouseWheelListener(this);
        JLabel placeHolder = new JLabel("");
        placeHolder.setPreferredSize(new Dimension(imagePanel.getWidth(), imagePanel.getWidth()));
        imagePanel.add(placeHolder);
        imagePanel.addKeyListener(this);
        studyTree.addKeyListener(this);
        
        //Set key pressed states
        keyPressedIndex = 0;
        keysPressed = new int[5];
    }
    
    /**
     * Sets the tree model of the JTree
     * @param model (TreeModel) mode to set
     */
    protected void setTreeModel(TreeModel model) {
        studyTree.setModel(model);
    }
    
    /**
     * Refresh the images of the MedicalImagePanel
     */
    protected void refreshImages() {
        this.valueChanged(null);
    }
    
    /**
     * Detects a mouse wheel even
     * @param e 
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        int panelX = imagePanel.getX();
        int panelY = imagePanel.getY();
        
        int hoverIndex = imagePanel.getGridIndexOfImageAt(mouseX, mouseY);
        int notches = e.getWheelRotation();
        delegate.mouseScrollOnImage(notches, hoverIndex);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        studyTreePanel = new javax.swing.JScrollPane();
        studyTree = new javax.swing.JTree();
        toolbar = new javax.swing.JToolBar();
        openButton = new javax.swing.JButton();
        copyButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        undoButton = new javax.swing.JButton();
        displayModeSelect = new javax.swing.JComboBox();
        imagePanel = new medicalimaging.gui.MedicalImageView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        studyTreePanel.setViewportView(studyTree);

        toolbar.setRollover(true);

        openButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalimaging/images/open.gif"))); // NOI18N
        openButton.setFocusable(false);
        openButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        openButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });
        toolbar.add(openButton);

        copyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalimaging/images/copy.gif"))); // NOI18N
        copyButton.setFocusable(false);
        copyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        copyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        copyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyButtonActionPerformed(evt);
            }
        });
        toolbar.add(copyButton);

        previousButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalimaging/images/previous.gif"))); // NOI18N
        previousButton.setFocusable(false);
        previousButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previousButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });
        toolbar.add(previousButton);

        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalimaging/images/next.gif"))); // NOI18N
        nextButton.setFocusable(false);
        nextButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nextButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        toolbar.add(nextButton);

        undoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalimaging/images/undo.gif"))); // NOI18N
        undoButton.setFocusable(false);
        undoButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        undoButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });
        toolbar.add(undoButton);

        displayModeSelect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1x1", "2x2", "Recon", "Window"}));
        displayModeSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayModeSelectActionPerformed(evt);
            }
        });
        toolbar.add(displayModeSelect);

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studyTreePanel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(studyTreePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        delegate.previousButtonPressed();
    }//GEN-LAST:event_previousButtonActionPerformed

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        delegate.loadStudyButtonPressed();
    }//GEN-LAST:event_openButtonActionPerformed

    private void copyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyButtonActionPerformed
        delegate.copyButtonPressed();
    }//GEN-LAST:event_copyButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        delegate.nextButtonPressed();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        delegate.undoButtonPressed();
    }//GEN-LAST:event_undoButtonActionPerformed

    private void displayModeSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayModeSelectActionPerformed
        String selectedItem = (String)displayModeSelect.getSelectedItem();
        int displayMode = Study.DISPLAY_MODE_1x1;
        if(selectedItem.equals("2x2"))
            displayMode = Study.DISPLAY_MODE_2x2;
        else if(selectedItem.equals("Recon"))
            displayMode = Study.DISPLAY_MODE_RECON;
        else if(selectedItem.equals("Window"))
            displayMode = Study.DISPLAY_MODE_INTEN;
        delegate.displayModeChanged(displayMode);
    }//GEN-LAST:event_displayModeSelectActionPerformed
    
    /**
     * Executes when the value of the JTree is changed
     * TODO: This method should be cleaned up and sized down.
     * @param e 
     */
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        delegate.selectedImageChanged((StudyElement)studyTree.getLastSelectedPathComponent());
    }
    
    public void updateGUIForState(int state) {
        if(state == Study.DISPLAY_MODE_1x1)
            displayModeSelect.setSelectedItem("1x1");
        else if(state == Study.DISPLAY_MODE_2x2)
            displayModeSelect.setSelectedItem("2x2");
        else if(state == Study.DISPLAY_MODE_RECON)
            displayModeSelect.setSelectedItem("Recon");
        else if(state == Study.DISPLAY_MODE_INTEN) {
            displayModeSelect.setSelectedItem("Window");
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyPressedIndex < keysPressed.length) {
            keysPressed[keyPressedIndex] = keyCode;
            keyPressedIndex++;
        }
        
        //Compare vs key bindings
        if(keysPressed[0] == KeyEvent.VK_CONTROL && keysPressed[1] == KeyEvent.VK_SHIFT && keysPressed[2] == KeyEvent.VK_W) {
            keysPressed = new int[5];
            keyPressedIndex = 0; 
            delegate.refreshKeyTyped();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keysPressed = new int[5];
        keyPressedIndex = 0;
    }
    
    protected MainFrameViewProtocol delegate;
    
    private int[] keysPressed;
    private int keyPressedIndex;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton copyButton;
    protected javax.swing.JComboBox displayModeSelect;
    protected medicalimaging.gui.MedicalImageView imagePanel;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton openButton;
    private javax.swing.JButton previousButton;
    protected javax.swing.JTree studyTree;
    private javax.swing.JScrollPane studyTreePanel;
    private javax.swing.JToolBar toolbar;
    private javax.swing.JButton undoButton;
    // End of variables declaration//GEN-END:variables

}
