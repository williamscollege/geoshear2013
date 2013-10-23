/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.williams.geoshear2013;

import java.awt.Color;

/**
 *
 * @author cwarren
 */
public class MainWindow extends javax.swing.JFrame {
//    private double cx;
//    private double cy;
    private GSComplexUI gscUI;
    private HelpWindow helpWindow;
    private AboutWindow aboutWindow;
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        
        this.helpWindow = new HelpWindow();
        this.helpWindow.setLocationByPlatform(true);
        this.helpWindow.setSize(this.jPanelContainerDisplay.getWidth() + 50,this.jPanelContainerDisplay.getHeight() + 50);
        
        this.aboutWindow = new AboutWindow();
        this.aboutWindow.setLocationByPlatform(true);
        
        this.gscUI = new GSComplexUI(new GSComplex(),this);

        int w = this.jPanelContainerDisplay.getWidth();
        int h = this.jPanelContainerDisplay.getHeight();
        this.gscUI.setPreferredSize (new java.awt.Dimension (w,h));
        this.gscUI.setBounds(0, 0, w, h);
        this.gscUI.setDoubleBuffered (true);
        this.gscUI.setCenter(this.jPanelContainerDisplay.getWidth()/2, this.jPanelContainerDisplay.getHeight()/2);
        this.jPanelContainerDisplay.add(this.gscUI);

        // dev data
//        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(-150,-200,150,100,Math.PI/2 + Math.PI / 5));
//        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(-150,200,100,100,Math.PI/2 + Math.PI / 5));
        
//        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(150,200,150,100,0));
//        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(-150,200,150,100,.5));
//        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(-150,-200,150,100,1));
//        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(150,-200,150,100,1.5));
       
        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(100,100,30,20,0, Color.CYAN));
        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(200,100,45,30,.5, Color.GREEN));
        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(100,200,60,40,-1, Color.BLUE));
        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(200,200,75,50,2, Color.MAGENTA));

        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(-100,100,30,20,0, Color.CYAN));
        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(-200,100,45,30,.5, Color.GREEN));
        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(-100,200,60,40,-1, Color.BLUE));
        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(-200,200,75,50,2, Color.MAGENTA));
        
        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(100,-100,30,20,0, Color.CYAN));
        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(200,-100,45,30,.5, Color.GREEN));
        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(100,-200,60,40,-1, Color.BLUE));
        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(200,-200,75,50,2, Color.MAGENTA));

        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(-100,-100,30,20,0, Color.CYAN));
        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(-200,-100,45,30,.5, Color.GREEN));
        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(-100,-200,60,40,-1, Color.BLUE));
        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(-200,-200,75,50,2, Color.MAGENTA));
        
//        this.gscUI.gsc.pebbleSets.getLast().add(new GSPebble(0,0,150,150,0));

//        this.gscUI.setCenter(this.displayPanel.getWidth()/2, this.displayPanel.getHeight()/2);
//        this.gscUI.repaint();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContainerDisplay = new javax.swing.JPanel();
        jPanelContainerControls = new javax.swing.JPanel();
        jPanelDisplayControls = new javax.swing.JPanel();
        jPanelZoomControl = new javax.swing.JPanel();
        jLabelZoom = new javax.swing.JLabel();
        jSliderZoom = new javax.swing.JSlider();
        jPanelResetButtons = new javax.swing.JPanel();
        jButtonUnzoom = new javax.swing.JButton();
        jButtonCenter = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jPanelDeformControls = new javax.swing.JPanel();
        jPanelDeformShearControls = new javax.swing.JPanel();
        jLabelShearControl = new javax.swing.JLabel();
        jTextFieldShearX = new javax.swing.JTextField();
        jLabelShearX = new javax.swing.JLabel();
        jLabelShearY = new javax.swing.JLabel();
        jTextFieldShearY = new javax.swing.JTextField();
        jPanelDeformCompressControls = new javax.swing.JPanel();
        jLabelCompressControl = new javax.swing.JLabel();
        jTextFieldCompressX = new javax.swing.JTextField();
        jLabelCompressX = new javax.swing.JLabel();
        jLabelCompressrY = new javax.swing.JLabel();
        jTextFieldCompressY = new javax.swing.JTextField();
        jPanelDeformRotateControls = new javax.swing.JPanel();
        jPanelDeformNavControls = new javax.swing.JPanel();
        jPanelDeformMatrixLeft = new javax.swing.JPanel();
        jPanelDeformMatrixRight = new javax.swing.JPanel();
        jPanelStrainControls = new javax.swing.JPanel();
        jPanelEditPebbleControls = new javax.swing.JPanel();
        jPanelSnapshotControls = new javax.swing.JPanel();
        MainWindowMenuBar = new javax.swing.JMenuBar();
        GeoshearMenu = new javax.swing.JMenu();
        HelpMenuItem = new javax.swing.JMenuItem();
        AboutMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        ExitMenuItem = new javax.swing.JMenuItem();
        FileMenu = new javax.swing.JMenu();
        DisplayMenu = new javax.swing.JMenu();
        ChartsMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelContainerDisplay.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContainerDisplay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelContainerDisplay.setPreferredSize(new java.awt.Dimension(700, 700));
        jPanelContainerDisplay.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jPanelContainerDisplayMouseWheelMoved(evt);
            }
        });
        jPanelContainerDisplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelContainerDisplayMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelContainerDisplayMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanelContainerDisplayMouseReleased(evt);
            }
        });
        jPanelContainerDisplay.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanelContainerDisplayComponentResized(evt);
            }
        });
        jPanelContainerDisplay.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelContainerDisplayMouseDragged(evt);
            }
        });
        jPanelContainerDisplay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanelContainerDisplayKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanelContainerDisplayKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanelContainerDisplayLayout = new javax.swing.GroupLayout(jPanelContainerDisplay);
        jPanelContainerDisplay.setLayout(jPanelContainerDisplayLayout);
        jPanelContainerDisplayLayout.setHorizontalGroup(
            jPanelContainerDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 705, Short.MAX_VALUE)
        );
        jPanelContainerDisplayLayout.setVerticalGroup(
            jPanelContainerDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelContainerControls.setMaximumSize(new java.awt.Dimension(220, 131123));
        jPanelContainerControls.setMinimumSize(new java.awt.Dimension(220, 700));
        jPanelContainerControls.setPreferredSize(new java.awt.Dimension(220, 700));
        jPanelContainerControls.setLayout(new javax.swing.BoxLayout(jPanelContainerControls, javax.swing.BoxLayout.Y_AXIS));

        jPanelDisplayControls.setAlignmentY(0.0F);
        jPanelDisplayControls.setMaximumSize(new java.awt.Dimension(32787, 70));
        jPanelDisplayControls.setMinimumSize(new java.awt.Dimension(219, 70));
        jPanelDisplayControls.setPreferredSize(new java.awt.Dimension(219, 70));
        jPanelDisplayControls.setLayout(new javax.swing.BoxLayout(jPanelDisplayControls, javax.swing.BoxLayout.Y_AXIS));

        jPanelZoomControl.setLayout(new javax.swing.BoxLayout(jPanelZoomControl, javax.swing.BoxLayout.X_AXIS));

        jLabelZoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/williams/geoshear2013/img/magnifier.gif"))); // NOI18N
        jPanelZoomControl.add(jLabelZoom);

        jSliderZoom.setMajorTickSpacing(50);
        jSliderZoom.setMinorTickSpacing(5);
        jSliderZoom.setPaintTicks(true);
        jSliderZoom.setToolTipText("left to zoom out, right to zoom in");
        jSliderZoom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderZoomStateChanged(evt);
            }
        });
        jPanelZoomControl.add(jSliderZoom);
        jSliderZoom.getAccessibleContext().setAccessibleName("zoom control");

        jPanelDisplayControls.add(jPanelZoomControl);

        jPanelResetButtons.setLayout(new javax.swing.BoxLayout(jPanelResetButtons, javax.swing.BoxLayout.X_AXIS));

        jButtonUnzoom.setText("Unzoom");
        jButtonUnzoom.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jButtonUnzoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUnzoomActionPerformed(evt);
            }
        });
        jPanelResetButtons.add(jButtonUnzoom);

        jButtonCenter.setText("Center");
        jButtonCenter.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jButtonCenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCenterActionPerformed(evt);
            }
        });
        jPanelResetButtons.add(jButtonCenter);

        jButtonReset.setText("Reset");
        jButtonReset.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });
        jPanelResetButtons.add(jButtonReset);

        jPanelDisplayControls.add(jPanelResetButtons);

        jPanelContainerControls.add(jPanelDisplayControls);

        jPanelDeformControls.setMaximumSize(new java.awt.Dimension(220, 250));
        jPanelDeformControls.setMinimumSize(new java.awt.Dimension(220, 250));
        jPanelDeformControls.setPreferredSize(new java.awt.Dimension(220, 250));
        jPanelDeformControls.setRequestFocusEnabled(false);
        jPanelDeformControls.setLayout(new java.awt.GridLayout(3, 2));

        jPanelDeformShearControls.setMaximumSize(new java.awt.Dimension(93, 75));
        jPanelDeformShearControls.setMinimumSize(new java.awt.Dimension(93, 75));
        jPanelDeformShearControls.setPreferredSize(new java.awt.Dimension(93, 75));

        jLabelShearControl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelShearControl.setText("shear");
        jLabelShearControl.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jTextFieldShearX.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldShearX.setText("0.000");
        jTextFieldShearX.setBorder(null);

        jLabelShearX.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelShearX.setText("X");

        jLabelShearY.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelShearY.setText("Y");

        jTextFieldShearY.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldShearY.setText("0.000");
        jTextFieldShearY.setBorder(null);

        javax.swing.GroupLayout jPanelDeformShearControlsLayout = new javax.swing.GroupLayout(jPanelDeformShearControls);
        jPanelDeformShearControls.setLayout(jPanelDeformShearControlsLayout);
        jPanelDeformShearControlsLayout.setHorizontalGroup(
            jPanelDeformShearControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeformShearControlsLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanelDeformShearControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelShearControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelDeformShearControlsLayout.createSequentialGroup()
                        .addGroup(jPanelDeformShearControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelShearY, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelShearX, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanelDeformShearControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldShearY, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(jTextFieldShearX, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanelDeformShearControlsLayout.setVerticalGroup(
            jPanelDeformShearControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeformShearControlsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelShearControl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDeformShearControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldShearX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShearX))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDeformShearControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldShearY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShearY))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanelDeformControls.add(jPanelDeformShearControls);

        jPanelDeformCompressControls.setMaximumSize(new java.awt.Dimension(93, 75));
        jPanelDeformCompressControls.setMinimumSize(new java.awt.Dimension(93, 75));
        jPanelDeformCompressControls.setPreferredSize(new java.awt.Dimension(93, 75));

        jLabelCompressControl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCompressControl.setText("compress");
        jLabelCompressControl.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jTextFieldCompressX.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldCompressX.setText("0.000");
        jTextFieldCompressX.setBorder(null);

        jLabelCompressX.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCompressX.setText("X");

        jLabelCompressrY.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCompressrY.setText("Y");

        jTextFieldCompressY.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldCompressY.setText("0.000");
        jTextFieldCompressY.setBorder(null);

        javax.swing.GroupLayout jPanelDeformCompressControlsLayout = new javax.swing.GroupLayout(jPanelDeformCompressControls);
        jPanelDeformCompressControls.setLayout(jPanelDeformCompressControlsLayout);
        jPanelDeformCompressControlsLayout.setHorizontalGroup(
            jPanelDeformCompressControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeformCompressControlsLayout.createSequentialGroup()
                .addGroup(jPanelDeformCompressControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelCompressControl, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDeformCompressControlsLayout.createSequentialGroup()
                        .addGroup(jPanelDeformCompressControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelCompressrY, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCompressX, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanelDeformCompressControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldCompressY, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(jTextFieldCompressX, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanelDeformCompressControlsLayout.setVerticalGroup(
            jPanelDeformCompressControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeformCompressControlsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCompressControl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDeformCompressControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCompressX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCompressX))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDeformCompressControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCompressY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCompressrY))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanelDeformControls.add(jPanelDeformCompressControls);

        jPanelDeformRotateControls.setPreferredSize(new java.awt.Dimension(93, 75));

        javax.swing.GroupLayout jPanelDeformRotateControlsLayout = new javax.swing.GroupLayout(jPanelDeformRotateControls);
        jPanelDeformRotateControls.setLayout(jPanelDeformRotateControlsLayout);
        jPanelDeformRotateControlsLayout.setHorizontalGroup(
            jPanelDeformRotateControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );
        jPanelDeformRotateControlsLayout.setVerticalGroup(
            jPanelDeformRotateControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );

        jPanelDeformControls.add(jPanelDeformRotateControls);

        jPanelDeformNavControls.setPreferredSize(new java.awt.Dimension(93, 75));

        javax.swing.GroupLayout jPanelDeformNavControlsLayout = new javax.swing.GroupLayout(jPanelDeformNavControls);
        jPanelDeformNavControls.setLayout(jPanelDeformNavControlsLayout);
        jPanelDeformNavControlsLayout.setHorizontalGroup(
            jPanelDeformNavControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );
        jPanelDeformNavControlsLayout.setVerticalGroup(
            jPanelDeformNavControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );

        jPanelDeformControls.add(jPanelDeformNavControls);

        jPanelDeformMatrixLeft.setPreferredSize(new java.awt.Dimension(93, 75));

        javax.swing.GroupLayout jPanelDeformMatrixLeftLayout = new javax.swing.GroupLayout(jPanelDeformMatrixLeft);
        jPanelDeformMatrixLeft.setLayout(jPanelDeformMatrixLeftLayout);
        jPanelDeformMatrixLeftLayout.setHorizontalGroup(
            jPanelDeformMatrixLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );
        jPanelDeformMatrixLeftLayout.setVerticalGroup(
            jPanelDeformMatrixLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );

        jPanelDeformControls.add(jPanelDeformMatrixLeft);

        jPanelDeformMatrixRight.setPreferredSize(new java.awt.Dimension(93, 75));

        javax.swing.GroupLayout jPanelDeformMatrixRightLayout = new javax.swing.GroupLayout(jPanelDeformMatrixRight);
        jPanelDeformMatrixRight.setLayout(jPanelDeformMatrixRightLayout);
        jPanelDeformMatrixRightLayout.setHorizontalGroup(
            jPanelDeformMatrixRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );
        jPanelDeformMatrixRightLayout.setVerticalGroup(
            jPanelDeformMatrixRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );

        jPanelDeformControls.add(jPanelDeformMatrixRight);

        jPanelContainerControls.add(jPanelDeformControls);

        jPanelStrainControls.setMaximumSize(new java.awt.Dimension(220, 100));
        jPanelStrainControls.setMinimumSize(new java.awt.Dimension(220, 100));
        jPanelStrainControls.setPreferredSize(new java.awt.Dimension(220, 100));

        javax.swing.GroupLayout jPanelStrainControlsLayout = new javax.swing.GroupLayout(jPanelStrainControls);
        jPanelStrainControls.setLayout(jPanelStrainControlsLayout);
        jPanelStrainControlsLayout.setHorizontalGroup(
            jPanelStrainControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanelStrainControlsLayout.setVerticalGroup(
            jPanelStrainControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanelContainerControls.add(jPanelStrainControls);

        jPanelEditPebbleControls.setMaximumSize(new java.awt.Dimension(220, 100));
        jPanelEditPebbleControls.setMinimumSize(new java.awt.Dimension(220, 100));
        jPanelEditPebbleControls.setPreferredSize(new java.awt.Dimension(220, 100));

        javax.swing.GroupLayout jPanelEditPebbleControlsLayout = new javax.swing.GroupLayout(jPanelEditPebbleControls);
        jPanelEditPebbleControls.setLayout(jPanelEditPebbleControlsLayout);
        jPanelEditPebbleControlsLayout.setHorizontalGroup(
            jPanelEditPebbleControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanelEditPebbleControlsLayout.setVerticalGroup(
            jPanelEditPebbleControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanelContainerControls.add(jPanelEditPebbleControls);

        jPanelSnapshotControls.setMaximumSize(new java.awt.Dimension(220, 100));
        jPanelSnapshotControls.setMinimumSize(new java.awt.Dimension(220, 100));
        jPanelSnapshotControls.setPreferredSize(new java.awt.Dimension(220, 100));

        javax.swing.GroupLayout jPanelSnapshotControlsLayout = new javax.swing.GroupLayout(jPanelSnapshotControls);
        jPanelSnapshotControls.setLayout(jPanelSnapshotControlsLayout);
        jPanelSnapshotControlsLayout.setHorizontalGroup(
            jPanelSnapshotControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanelSnapshotControlsLayout.setVerticalGroup(
            jPanelSnapshotControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanelContainerControls.add(jPanelSnapshotControls);

        GeoshearMenu.setText("GeoShear");
        GeoshearMenu.setToolTipText("Control the application");

        HelpMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        HelpMenuItem.setText("Help");
        HelpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpMenuItemActionPerformed(evt);
            }
        });
        GeoshearMenu.add(HelpMenuItem);

        AboutMenuItem.setText("About");
        AboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutMenuItemActionPerformed(evt);
            }
        });
        GeoshearMenu.add(AboutMenuItem);
        GeoshearMenu.add(jSeparator1);

        ExitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        ExitMenuItem.setText("Quit");
        ExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuItemActionPerformed(evt);
            }
        });
        GeoshearMenu.add(ExitMenuItem);

        MainWindowMenuBar.add(GeoshearMenu);

        FileMenu.setText("File");
        FileMenu.setToolTipText("Save, Open, Export");
        MainWindowMenuBar.add(FileMenu);

        DisplayMenu.setText("Display");
        DisplayMenu.setToolTipText("Options for the main display area");
        MainWindowMenuBar.add(DisplayMenu);

        ChartsMenu.setText("Charts");
        ChartsMenu.setToolTipText("Open new windows to display charts");
        MainWindowMenuBar.add(ChartsMenu);

        setJMenuBar(MainWindowMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelContainerControls, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelContainerDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContainerControls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelContainerDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelContainerDisplayComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelContainerDisplayComponentResized
        int w = this.jPanelContainerDisplay.getWidth();
        int h = this.jPanelContainerDisplay.getHeight();
        if (this.gscUI != null) {
            this.gscUI.setPreferredSize (new java.awt.Dimension (w,h));
            this.gscUI.setBounds(0, 0, w, h);
            this.gscUI.repaint();
        }
    }//GEN-LAST:event_jPanelContainerDisplayComponentResized

    private void jPanelContainerDisplayMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelContainerDisplayMouseDragged
        this.gscUI.handleMouseDrag(evt);
    }//GEN-LAST:event_jPanelContainerDisplayMouseDragged

    private void jPanelContainerDisplayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelContainerDisplayMousePressed
        this.gscUI.handleMousePressed(evt);
    }//GEN-LAST:event_jPanelContainerDisplayMousePressed

    private void jPanelContainerDisplayMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jPanelContainerDisplayMouseWheelMoved
        this.gscUI.handleMouseWheelMoved(evt);
    }//GEN-LAST:event_jPanelContainerDisplayMouseWheelMoved

    private void jPanelContainerDisplayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelContainerDisplayMouseReleased
        this.gscUI.handleMouseReleased(evt);
    }//GEN-LAST:event_jPanelContainerDisplayMouseReleased

    private void jPanelContainerDisplayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanelContainerDisplayKeyPressed
        this.gscUI.handleKeyPressed(evt);
    }//GEN-LAST:event_jPanelContainerDisplayKeyPressed

    private void jPanelContainerDisplayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanelContainerDisplayKeyReleased
        this.gscUI.handleKeyReleased(evt);
    }//GEN-LAST:event_jPanelContainerDisplayKeyReleased

    private void AboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutMenuItemActionPerformed
        this.aboutWindow.setVisible(true);
    }//GEN-LAST:event_AboutMenuItemActionPerformed

    private void ExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitMenuItemActionPerformed

    private void HelpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpMenuItemActionPerformed
        this.helpWindow.setVisible(true);
    }//GEN-LAST:event_HelpMenuItemActionPerformed

    private void jSliderZoomStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderZoomStateChanged
        double amt = this.jSliderZoom.getModel().getValue();
        double scaling = 1.0;
        double outIncr = (1-GSComplexUI.ZOOM_MIN) / 50;
        double inIncr = (GSComplexUI.ZOOM_MAX - 1) / 50;
        
        if (amt < 50)
        {
            this.gscUI.setDisplayZoom(GSComplexUI.ZOOM_MIN + outIncr*amt, true, this.gscUI.gsc.getCenter().asPoint2D());
        }
        else if (amt > 50)
        {
            this.gscUI.setDisplayZoom(1 + inIncr*(amt-50), true, this.gscUI.gsc.getCenter().asPoint2D());
        } else {
            this.gscUI.setDisplayZoom(1, true, this.gscUI.gsc.getCenter().asPoint2D());
        }
        
        this.repaint();
    }//GEN-LAST:event_jSliderZoomStateChanged

    public void updateZoomSlider(double zoomValue) {
        double outIncr = (1-GSComplexUI.ZOOM_MIN) / 50;
        double inIncr = (GSComplexUI.ZOOM_MAX - 1) / 50;
        int sliderVal = 50;
        if (zoomValue < 1) {
            zoomValue -= GSComplexUI.ZOOM_MIN;
            sliderVal = (int) (zoomValue/outIncr);
        } else if (zoomValue > 1) {
            zoomValue -= 1;
            sliderVal = (int) (zoomValue/inIncr)+50;
        }
        this.jSliderZoom.getModel().setValue(sliderVal);
        this.repaint ();
    }
    
    private void jButtonUnzoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUnzoomActionPerformed
        this.gscUI.setDisplayZoom(1, true, this.gscUI.gsc.getCenter().asPoint2D());
        this.jSliderZoom.getModel().setValue(50);
        this.repaint ();
    }//GEN-LAST:event_jButtonUnzoomActionPerformed

    private void jButtonCenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCenterActionPerformed
        this.gscUI.centerDisplay();
    }//GEN-LAST:event_jButtonCenterActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        this.jSliderZoom.getModel().setValue(50);
        this.gscUI.resetDisplayTransform();
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jPanelContainerDisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelContainerDisplayMouseClicked
        this.gscUI.handleMouseClicked(evt);
    }//GEN-LAST:event_jPanelContainerDisplayMouseClicked

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutMenuItem;
    private javax.swing.JMenu ChartsMenu;
    private javax.swing.JMenu DisplayMenu;
    private javax.swing.JMenuItem ExitMenuItem;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu GeoshearMenu;
    private javax.swing.JMenuItem HelpMenuItem;
    private javax.swing.JMenuBar MainWindowMenuBar;
    private javax.swing.JButton jButtonCenter;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonUnzoom;
    private javax.swing.JLabel jLabelCompressControl;
    private javax.swing.JLabel jLabelCompressX;
    private javax.swing.JLabel jLabelCompressrY;
    private javax.swing.JLabel jLabelShearControl;
    private javax.swing.JLabel jLabelShearX;
    private javax.swing.JLabel jLabelShearY;
    private javax.swing.JLabel jLabelZoom;
    private javax.swing.JPanel jPanelContainerControls;
    private javax.swing.JPanel jPanelContainerDisplay;
    private javax.swing.JPanel jPanelDeformCompressControls;
    private javax.swing.JPanel jPanelDeformControls;
    private javax.swing.JPanel jPanelDeformMatrixLeft;
    private javax.swing.JPanel jPanelDeformMatrixRight;
    private javax.swing.JPanel jPanelDeformNavControls;
    private javax.swing.JPanel jPanelDeformRotateControls;
    private javax.swing.JPanel jPanelDeformShearControls;
    private javax.swing.JPanel jPanelDisplayControls;
    private javax.swing.JPanel jPanelEditPebbleControls;
    private javax.swing.JPanel jPanelResetButtons;
    private javax.swing.JPanel jPanelSnapshotControls;
    private javax.swing.JPanel jPanelStrainControls;
    private javax.swing.JPanel jPanelZoomControl;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSlider jSliderZoom;
    private javax.swing.JTextField jTextFieldCompressX;
    private javax.swing.JTextField jTextFieldCompressY;
    private javax.swing.JTextField jTextFieldShearX;
    private javax.swing.JTextField jTextFieldShearY;
    // End of variables declaration//GEN-END:variables
}
