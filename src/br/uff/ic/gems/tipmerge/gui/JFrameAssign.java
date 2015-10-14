/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.gems.tipmerge.gui;

import br.uff.ic.gems.tipmerge.dao.CommitterDao;
import br.uff.ic.gems.tipmerge.dao.EditedFilesDao;
import br.uff.ic.gems.tipmerge.dao.MergeFilesDao;
import br.uff.ic.gems.tipmerge.dao.RepositoryDao;
import br.uff.ic.gems.tipmerge.model.Committer;
import br.uff.ic.gems.tipmerge.model.EditedFile;
import br.uff.ic.gems.tipmerge.model.MergeFiles;
import br.uff.ic.gems.tipmerge.model.RepoFiles;
import br.uff.ic.gems.tipmerge.model.Repository;
import br.uff.ic.gems.tipmerge.util.Export;
import br.uff.ic.gems.tipmerge.util.RunGit;
import br.uff.ic.gems.tipmerge.util.Statistics;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Catarina
 */
public class JFrameAssign extends javax.swing.JFrame {

    private final RepoFiles repoFiles;
    private MergeFiles mergeFiles;
    private String branchName;

    /**
     * Creates new form JFrameAssign
     */
    public JFrameAssign(Repository repository) {
        RepositoryDao rdao = new RepositoryDao(repository.getProject());
        rdao.setDetails(repository);
        this.repoFiles = new RepoFiles(repository);

        initComponents();
        txRepositoryName.setText(repository.getName());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        hashBranch1 = new javax.swing.JLabel();
        jcBranch1 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcBranch2 = new javax.swing.JComboBox();
        hashBranch2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btRun = new javax.swing.JButton();
        jLSelecByExt = new javax.swing.JLabel();
        comboFileExtension = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        labelRepository = new javax.swing.JLabel();
        txRepositoryName = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        btnChart1 = new javax.swing.JButton();
        btnChart2 = new javax.swing.JButton();
        jButtonDependencies = new javax.swing.JButton();
        btExport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Merge of Branches");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setEnabled(false);

        hashBranch1.setText("<hash>");

        jcBranch1.setModel(new DefaultComboBoxModel(this.repoFiles.getRepository().getBranches().toArray()));
        jcBranch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcBranch1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Branch one's hash: ");

        jLabel8.setText("Branch two's hash: ");

        jcBranch2.setModel(new DefaultComboBoxModel(this.repoFiles.getRepository().getBranches().toArray()));
        jcBranch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcBranch2ActionPerformed(evt);
            }
        });

        hashBranch2.setText("<hash>");

        btRun.setText("Run");
        btRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRunActionPerformed(evt);
            }
        });

        jLSelecByExt.setText("File Extensions");

        comboFileExtension.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All Files", ".java", ".c", ".html", ".js", ".py", ".php", ".rb", ".xml", " " }));
        comboFileExtension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFileExtensionActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uff/ic/gems/tipmerge/icons/loading1.gif"))); // NOI18N
        jLabel1.setText("Loading ...");
        jLabel1.setVisible(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLSelecByExt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboFileExtension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRun)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSelecByExt)
                    .addComponent(comboFileExtension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRun)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        labelRepository.setText("Repository Name");

        txRepositoryName.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcBranch2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcBranch1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hashBranch2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hashBranch1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelRepository)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txRepositoryName)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRepository)
                    .addComponent(txRepositoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(hashBranch1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcBranch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(hashBranch2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcBranch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(jTable1);

        jTabbedPane1.addTab("Branch1", jScrollPane5);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(jTable2);

        jTabbedPane1.addTab("Branch2", jScrollPane6);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(jTable3);

        jTabbedPane1.addTab("Both Branches", jScrollPane7);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(jTable4);

        jTabbedPane1.addTab("Previous History", jScrollPane8);

        btnChart1.setText("Chart1");
        btnChart1.setEnabled(false);
        btnChart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChart1ActionPerformed(evt);
            }
        });

        btnChart2.setText("Chart2");
        btnChart2.setEnabled(false);
        btnChart2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChart2ActionPerformed(evt);
            }
        });

        jButtonDependencies.setText("See Logical Dependencies");
        jButtonDependencies.setEnabled(false);
        jButtonDependencies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDependenciesActionPerformed(evt);
            }
        });

        btExport.setText("Export");
        btExport.setEnabled(false);
        btExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnChart1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChart2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDependencies)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExport))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExport)
                    .addComponent(jButtonDependencies)
                    .addComponent(btnChart2)
                    .addComponent(btnChart1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcBranch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcBranch1ActionPerformed
        hashBranch1.setText(RunGit.getResult("git log -n 1 --pretty=format:%H " + jcBranch1.getSelectedItem().toString(), repoFiles.getRepository().getProject()));
    }//GEN-LAST:event_jcBranch1ActionPerformed

    private void jcBranch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcBranch2ActionPerformed
        hashBranch2.setText(RunGit.getResult("git log -n 1 --pretty=format:%H " + jcBranch2.getSelectedItem().toString(), repoFiles.getRepository().getProject()));
    }//GEN-LAST:event_jcBranch2ActionPerformed

    private void btRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRunActionPerformed
        Runnable r = () -> {
            jLabel1.setVisible(true);
            btRun.setEnabled(false);

            /**
             * At this time a merge will be created or - the selection of
             * branches - by selecting one merge from the history
             */
            MergeFilesDao mergeFilesDao = new MergeFilesDao();

            MergeFiles mergeSelected = new MergeFiles("", repoFiles.getRepository().getProject());
            mergeSelected.setParents(hashBranch1.getText(), hashBranch2.getText());
            mergeSelected.setHashBase(mergeFilesDao.getMergeBase(mergeSelected.getParents()[0], mergeSelected.getParents()[1], mergeSelected.getPath()));

            /**
             * From now the merge already exists with parents and merge base,
             * next steps are: Set the files of that merge and committers that
             * changed that files.
             */
            //System.out.println(mergeSelected.getHash() + "\n" + mergeSelected.getHashBase() + "\n" + Arrays.toString(mergeSelected.getParents()));
            EditedFilesDao filesDao = new EditedFilesDao();
            mergeSelected.setFilesOnBranchOne(filesDao.getFiles(mergeSelected.getHashBase(),
                    mergeSelected.getParents()[0],
                    mergeSelected.getPath(),
                    comboFileExtension.getSelectedItem().toString()));
            mergeSelected.setFilesOnBranchTwo(filesDao.getFiles(mergeSelected.getHashBase(),
                    mergeSelected.getParents()[1],
                    mergeSelected.getPath(),
                    comboFileExtension.getSelectedItem().toString()));

            CommitterDao cmterDao = new CommitterDao();
            List<EditedFile> files = new LinkedList<>();

            for (EditedFile editedFile : mergeSelected.getFilesOnBranchOne()) {
                List<Committer> whoEdited = cmterDao.getWhoEditedFile(mergeSelected.getHashBase(),
                        mergeSelected.getParents()[0],
                        editedFile.getFileName(),
                        mergeSelected.getPath());
                if (whoEdited.size() > 0) {
                    editedFile.setWhoEditTheFile(whoEdited);
                    files.add(editedFile);
                }
            }
            mergeSelected.setFilesOnBranchOne(files);

            files = new LinkedList<>();
            for (EditedFile editedFile : mergeSelected.getFilesOnBranchTwo()) {
                List<Committer> whoEdited = cmterDao.getWhoEditedFile(mergeSelected.getHashBase(),
                        mergeSelected.getParents()[1],
                        editedFile.getFileName(),
                        mergeSelected.getPath());
                if (whoEdited.size() > 0) {
                    editedFile.setWhoEditTheFile(whoEdited);
                    files.add(editedFile);
                }
            }
            mergeSelected.setFilesOnBranchTwo(files);

            files = new LinkedList<>();
            for (EditedFile editedFile : mergeSelected.getFilesOnPreviousHistory()) {
                List<Committer> whoEdited = cmterDao.getWhoEditedFile(repoFiles.getRepository().getFirstCommit(),
                        mergeSelected.getHashBase(),
                        editedFile.getFileName(),
                        mergeSelected.getPath());
                if (whoEdited.size() > 0) {
                    editedFile.setWhoEditTheFile(whoEdited);
                    files.add(editedFile);
                }
            }
            mergeSelected.setFilesOnPreviousHistory(new HashSet<>(files));

            //prints on the command line
            //showCommitters(mergeSelected);
            repoFiles.getMergeFiles().add(mergeSelected);

            this.setMergeFiles(mergeSelected);

            showResultsTable(this.getMergeFiles());
            //showResultsTable(this.getMergeFiles(),true);
            //showResIntersection(mCommits.getCommittersBothBranches());

            btExport.setEnabled(true);
            btnChart1.setEnabled(true);
            btnChart2.setEnabled(true);
            jButtonDependencies.setEnabled(true);
            jLabel1.setVisible(false);
            btRun.setEnabled(true);
        };
        Thread t = new Thread(r);
        t.start();
    }//GEN-LAST:event_btRunActionPerformed

    private void btnChart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChart1ActionPerformed
        // Botão do Chart 1:
        newGraphic(this.getMergeFiles(), 1);
    }//GEN-LAST:event_btnChart1ActionPerformed

    private void btnChart2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChart2ActionPerformed
        //Botão do Chart 2:
        newGraphic(this.getMergeFiles(), 2);
    }//GEN-LAST:event_btnChart2ActionPerformed

    private void jButtonDependenciesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDependenciesActionPerformed

        this.getMergeFiles().setHash(jcBranch1.getSelectedItem().toString() + " + " + jcBranch2.getSelectedItem().toString());
        JFrameDependencies filesDependence = new JFrameDependencies(this.repoFiles.getRepository(), this.getMergeFiles());
        filesDependence.setLocationRelativeTo(this.getFocusOwner());
        filesDependence.setVisible(true);

    }//GEN-LAST:event_jButtonDependenciesActionPerformed

    private void btExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExportActionPerformed
        Map<String, TableModel> sheet = new LinkedHashMap<>();
        sheet.put("Branch1", jTable1.getModel());
        sheet.put("Branch2", jTable2.getModel());
        sheet.put("Both Branches", jTable3.getModel());
        sheet.put("Previous History", jTable4.getModel());

        Export.toExcel(sheet);
        JOptionPane.showMessageDialog(this, "File was sucessfully saved", null, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btExportActionPerformed

    private void comboFileExtensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFileExtensionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboFileExtensionActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameAssign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAssign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAssign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAssign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new JFrameAssign().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExport;
    private javax.swing.JButton btRun;
    private javax.swing.JButton btnChart1;
    private javax.swing.JButton btnChart2;
    private javax.swing.JComboBox comboFileExtension;
    private javax.swing.JLabel hashBranch1;
    private javax.swing.JLabel hashBranch2;
    private javax.swing.JButton jButtonDependencies;
    private javax.swing.JLabel jLSelecByExt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JComboBox jcBranch1;
    private javax.swing.JComboBox jcBranch2;
    private javax.swing.JLabel labelRepository;
    private javax.swing.JTextField txRepositoryName;
    // End of variables declaration//GEN-END:variables
private void invertEnabledGroup() {
        jcBranch1.setEnabled(!jcBranch1.isEnabled());
        jcBranch2.setEnabled(!jcBranch2.isEnabled());
        jPanel2.setEnabled(!jPanel2.isEnabled());
        btExport.setEnabled(false);
    }

    //shows the number of commits by committers in each file on Branch 1
    private void showResBranch1(MergeFiles mergeSelected, Boolean showScoreZ) {
        DefaultTableModel dftModel = new DefaultTableModel(new Object[]{"File name"}, 0);

        List<Committer> committers = mergeSelected.getCommittersOnBranchOne();

        //Includes columns with the names of all developers (branches 1 and 2)
        committers.stream().forEach((committer) -> {
            dftModel.addColumn(committer.getName());
        });

        //dftModel.addRow(new Object[]{"BRANCH ONE"});
        mergeSelected.getFilesOnBranchOne().stream().forEach((editedfile) -> {
            dftModel.addRow(getValueToRow(editedfile, committers, showScoreZ));
            //dftModel.addRow(new Object[]{file.getFileName()});

        });

        jTable1.setModel(dftModel);
    }

    //shows the number of commits by committers in each file on Branch 2
    private void showResBranch2(MergeFiles mergeSelected, Boolean showScoreZ) {
        DefaultTableModel dftModel = new DefaultTableModel(new Object[]{"File name"}, 0);

        List<Committer> committers = mergeSelected.getCommittersOnBranchTwo();

        //Includes columns with the names of all developers (branches 1 and 2)
        committers.stream().forEach((committer) -> {
            dftModel.addColumn(committer.getName());
        });

        //dftModel.addRow(new Object[]{"BRANCH TWO"});
        mergeSelected.getFilesOnBranchTwo().stream().forEach((file) -> {
            dftModel.addRow(getValueToRow(file, committers, showScoreZ));

        });

        jTable2.setModel(dftModel);
        //tbResultsBranch1.update(tbResultsBranch1.getGraphics());	
    }

    private void showResIntersection(Set<EditedFile> filesOnBothBranch) {
        DefaultTableModel dftModel = new DefaultTableModel(new Object[]{"File name"}, 0);

        filesOnBothBranch.stream().forEach((file) -> {
            dftModel.addRow(new String[]{file.getFileName(), ""});
        });

        jTable3.setModel(dftModel);
    }

    //shows the number of commits by committers in each file (changed on any branch) that was changed in the history before the branch
    private void showResPreviousHistory(MergeFiles mergeSelected, Boolean showScoreZ) {

        DefaultTableModel dftModel = new DefaultTableModel(new Object[]{"File name"}, 0);

        List<Committer> committers = mergeSelected.getCommittersOnPreviousHistory();

        //	Arrays.sort(committers);
        //Includes columns with the names of all developers (branches 1 and 2)
        committers.stream().forEach((committer) -> {
            dftModel.addColumn(committer.getName());
            //	System.out.println(committer.toString());
        });

        //dftModel.addRow(new Object[]{"PREVIOUS HISTORY"});
        mergeSelected.getFilesOnPreviousHistory().stream().forEach((file) -> {
            if (file.getWhoEditTheFile().size() > 0) {
                dftModel.addRow(getValueToRow(file, committers, showScoreZ));
            }

        });

        jTable4.setModel(dftModel);
    }

    private String[] getValueToRow(EditedFile editedFile, List<Committer> committers, Boolean showScoreZ) {

        String fileName = editedFile.getFileName();
        Integer[] values = new Integer[committers.size()];
        editedFile.getWhoEditTheFile().stream().forEach((cmtrFile) -> {
            int index = 0;
            for (Committer cmter : committers) {
                if (cmtrFile.equals(cmter)) {
                    values[index] = cmtrFile.getCommits();
                    break;
                }
                index++;
            }

        });
        String[] result = getArrayResult(fileName, values, showScoreZ);

        return result;
    }

    private void cleanResults() {
        btExport.setEnabled(false);
        jTable1.setModel(new DefaultTableModel());
        jTable2.setModel(new DefaultTableModel());
        jTable3.setModel(new DefaultTableModel());
        jTable4.setModel(new DefaultTableModel());
    }

    /**
     * @return the mergeFiles
     */
    public MergeFiles getMergeFiles() {
        return mergeFiles;
    }

    /**
     * @param mergeFiles the mergeFiles to set
     */
    public void setMergeFiles(MergeFiles mergeFiles) {
        this.mergeFiles = mergeFiles;
    }

    private String[] getArrayResult(String fileName, Integer[] values, Boolean showScoreZ) {
        String[] result = new String[values.length + 1];
        result[0] = fileName;

        for (int i = 1; i < result.length; i++) {
            result[i] = values[i - 1] == null ? (values[i - 1] = 0).toString() : values[i - 1].toString();
        }

        if (showScoreZ) {
            List<Double> scores = Statistics.getMZScore(values);
            for (int i = 0; i < scores.size(); i++) {
                result[i + 1] = scores.get(i).toString();
            }
            return result;
        }

        return result;
    }

    private String codHash(String hash) {
        String temp = hash;
        hash = "";
        String temp2;
        boolean valid = true;
        for (int i = 0; i < temp.length(); i++) {
            temp2 = String.valueOf(temp.charAt(i));
            if (temp2.equals(" ")) {
                valid = false;
            } else {
                if (valid == true) {
                    hash = hash + temp2;
                }
            }
        }
        return hash;
    }

    private String limit(String fileName) {
        int length = fileName.length();
        if (length > 30) {
            String[] parts = fileName.split("/");
//                          System.out.println(parts[parts.length - 1]);
            return parts[parts.length - 1];
        }
        return fileName;
    }

    private CategoryDataset createBranch(MergeFiles merge, int botao) {
        DefaultCategoryDataset dataBranch1 = new DefaultCategoryDataset();
        JTable tabela = new JTable();
        tabela = jTable4;
        JTable table12 = new JTable();
        table12 = jTable1;
        if (jTable1.isShowing() || jTable2.isShowing()) {
            String fileName = " ";
            if (jTable1.isShowing()) {
                table12 = jTable1;
            } else {
                if (jTable2.isShowing()) {
                    table12 = jTable2;
                }
            }
            if (botao == 1) {
                double num;
                for (int i = 1; i < table12.getColumnCount(); i++) {
                    for (int j = 0; j < table12.getRowCount(); j++) {
                        num = Integer.parseInt((String) table12.getValueAt(j, i));
                        if (num != 0) {
                            fileName = limit((String) table12.getValueAt(j, 0));
                            dataBranch1.addValue(num, fileName, table12.getColumnName(i));
                        }
                    }
                }
            }

        }
        if (jTable4.isShowing()) {
            if (botao == 1) {
                double cont = 0;
                for (int i = 1; i < jTable4.getColumnCount(); i++) {
                    for (int j = 0; j < jTable4.getRowCount(); j++) {
                        if (Integer.parseInt((String) jTable4.getValueAt(j, i)) == 0) {

                        } else {
                            cont++;
                        }
                    }
                    dataBranch1.addValue(cont, jTable4.getColumnName(i), "Number of Files");
                    cont = 0;
                }
            }
        }
        if (botao == 2) {
            String fileName = " ";
            for (int k = 0; k < jTable3.getRowCount(); k++) {
                for (EditedFile file : mergeFiles.getFilesOnBranchOne()) {
                    for (Committer comitter : file.getWhoEditTheFile()) {
                        if (file.getFileName().equals(jTable3.getValueAt(k, 0))) {
                            if (comitter.getCommits() != 0) {
                                fileName = limit(file.getFileName());
                                dataBranch1.addValue(comitter.getCommits(), comitter.getName(), "B1 " + fileName);
                            }
                        }
                    }
                }
            }
            for (int k = 0; k < jTable3.getRowCount(); k++) {
                for (EditedFile file : mergeFiles.getFilesOnBranchTwo()) {
                    for (Committer comitter : file.getWhoEditTheFile()) {
                        if (file.getFileName().equals(jTable3.getValueAt(k, 0))) {
                            if (comitter.getCommits() != 0) {
                                fileName = limit(file.getFileName());
                                dataBranch1.addValue(comitter.getCommits(), comitter.getName(), "B2 " + fileName);
                            }
                        }
                    }
                }
            }
            double num;
            for (int i = 0; i < jTable3.getRowCount(); i++) {
                for (int j = 0; j < jTable4.getRowCount(); j++) {
                    if (jTable4.getValueAt(j, 0).equals(jTable3.getValueAt(i, 0))) {
                        for (int k = 1; k < jTable4.getColumnCount(); k++) {
                            num = Integer.parseInt((String) jTable4.getValueAt(j, k));
                            if (num != 0) {
                                fileName = limit((String) jTable4.getValueAt(j, 0));
                                dataBranch1.addValue(num, jTable4.getColumnName(k), "H " + fileName);
                            }
                        }
                    }
                }
            }

        }
        return dataBranch1;
    }

    public void newGraphic(MergeFiles merge, int botao) {
        //jFrame1.setVisible(true);
        CategoryDataset cdsBranch1 = createBranch(merge, botao);
        String title = "";
        if (jTable1.isShowing()) {
            title = "Branch 1";
        }
        if (jTable2.isShowing()) {
            title = "Branch 2";
        }
        if (jTable3.isShowing()) {
            title = "Both Branches";
        }
        if (jTable4.isShowing()) {
            title = "Previous History";
        }
        JFreeChart graphic;
        if (botao == 1) {
            graphic = ChartFactory.createBarChart3D(title, "Names", "Commit", cdsBranch1, PlotOrientation.VERTICAL, true, true, true);
        } else {
            graphic = ChartFactory.createStackedBarChart("Modified Files in Both Branches", "History/Branch2/Branch1", "Commiters Name", cdsBranch1, PlotOrientation.HORIZONTAL, true, true, true);
        }
        CategoryPlot plot = graphic.getCategoryPlot();
        CategoryItemRenderer itemRerender = plot.getRenderer();
        itemRerender.setItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("0")));
        itemRerender.setItemLabelsVisible(true);
        ChartPanel chartPanel = new ChartPanel(graphic);
        chartPanel.setPreferredSize(new java.awt.Dimension(590, 350));
//        jFrame1.setContentPane(chartPanel);
//        jFrame1.pack();
//        RefineryUtilities.centerFrameOnScreen(jFrame1);
//        jFrame1.setVisible(true);

    }

    public void showResultsTable(MergeFiles merge) {
        //organizes the data in the table
        showResBranch1(merge, false);
        showResBranch2(merge, false);
        showResIntersection(merge.getFilesOnBothBranch());
        showResPreviousHistory(merge, false);
    }

    public void showResultsTable(MergeFiles merge, Boolean showScoreZ) {
        //organizes the data in the table
        showResBranch1(merge, showScoreZ);
        showResBranch2(merge, showScoreZ);
        showResPreviousHistory(merge, showScoreZ);
    }

}