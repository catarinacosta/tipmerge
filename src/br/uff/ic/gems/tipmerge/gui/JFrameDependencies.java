/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.gems.tipmerge.gui;

import arch.Cell;
import arch.IMatrix2D;
import br.uff.ic.gems.tipmerge.dao.CommitterDao;
import br.uff.ic.gems.tipmerge.dao.EditedFilesDao;
import br.uff.ic.gems.tipmerge.dao.MergeCommitsDao;
import br.uff.ic.gems.tipmerge.dao.MergeFilesDao;
import br.uff.ic.gems.tipmerge.dominoes.DominoesFiles;
import br.uff.ic.gems.tipmerge.model.Committer;
import br.uff.ic.gems.tipmerge.model.Dependencies;
import br.uff.ic.gems.tipmerge.model.EditedFile;
import br.uff.ic.gems.tipmerge.model.MergeCommits;
import br.uff.ic.gems.tipmerge.model.MergeFiles;
import br.uff.ic.gems.tipmerge.model.Repository;
import dao.DominoesSQLDao2;
import domain.Dominoes;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author j2cf
 */
public class JFrameDependencies extends javax.swing.JFrame {

    private static Repository repo;
    private static String databaseName = "data/gitdataminer.sqlite";
    private MergeFiles mergeFiles;
    private Map<EditedFile, Set<EditedFile>> dependenciesBranchOne;
    private Map<EditedFile, Set<EditedFile>> dependenciesBranchTwo;
    private Map<EditedFile, Set<EditedFile>> dependenciesMap;

    public JFrameDependencies(Repository repository, MergeFiles mergeFiles) {
        initComponents();
        repo = repository;
        this.mergeFiles = mergeFiles;
        this.txRepositoryName.setText(repo.getName());

        comboMergesList.setModel(new JComboBox(new String[]{mergeFiles.getHash()}).getModel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRanking = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableRanking = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        labelRepository = new javax.swing.JLabel();
        btRun = new javax.swing.JButton();
        txRepositoryName = new javax.swing.JTextField();
        labelMerge = new javax.swing.JLabel();
        comboMergesList = new javax.swing.JComboBox();
        spinnerThreshold = new javax.swing.JSpinner();
        labelThreshold = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDependencies = new javax.swing.JTextArea();
        labelLoading = new javax.swing.JLabel();
        btGenRanking = new javax.swing.JButton();
        btKeyFiles = new javax.swing.JButton();

        jRanking.setTitle("Ranking");
        jRanking.setBounds(50,50,500, 500);

        jTableRanking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableRanking.setSize(500,500);
        jScrollPane2.setViewportView(jTableRanking);

        javax.swing.GroupLayout jRankingLayout = new javax.swing.GroupLayout(jRanking.getContentPane());
        jRanking.getContentPane().setLayout(jRankingLayout);
        jRankingLayout.setHorizontalGroup(
            jRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jRankingLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jRankingLayout.setVerticalGroup(
            jRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jRankingLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dependencies Analysis");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelRepository.setText("Repository Name");

        btRun.setText("Run Dependencies");
        btRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRunActionPerformed(evt);
            }
        });

        txRepositoryName.setEnabled(false);

        labelMerge.setText("Hashes");

        comboMergesList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMergesListActionPerformed(evt);
            }
        });

        spinnerThreshold.setModel(new javax.swing.SpinnerNumberModel(0.5d, 0.0d, 1.0d, 0.1d));
        spinnerThreshold.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerThresholdStateChanged(evt);
            }
        });

        labelThreshold.setText("Threshold:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRepository)
                            .addComponent(labelMerge))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboMergesList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txRepositoryName))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                        .addComponent(labelThreshold)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRun, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRepository)
                    .addComponent(txRepositoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMerge)
                    .addComponent(comboMergesList, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelThreshold)
                    .addComponent(spinnerThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRun))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtDependencies.setColumns(20);
        txtDependencies.setRows(5);
        jScrollPane1.setViewportView(txtDependencies);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );

        labelLoading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uff/ic/gems/tipmerge/icons/loading1.gif"))); // NOI18N
        labelLoading.setText("Loading ...");
        labelLoading.setVisible(false);

        btGenRanking.setText("Get Ranking");
        btGenRanking.setEnabled(false);
        btGenRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGenRankingActionPerformed(evt);
            }
        });

        btKeyFiles.setText("Get Key Files");
        btKeyFiles.setEnabled(false);
        btKeyFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKeyFilesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btKeyFiles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btGenRanking)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelLoading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGenRanking)
                    .addComponent(btKeyFiles))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRunActionPerformed

        Runnable r = () -> {
            btGenRanking.setEnabled(false);
            btRun.setEnabled(false);
            labelLoading.setVisible(true);
            MergeCommitsDao mCommitsDao = new MergeCommitsDao(repo.getProject());
            //MergeCommits merge = new MergeCommits(comboMergesList.getSelectedItem().toString().split(" ")[0], repo.getProject());
            MergeCommits merge = new MergeCommits(mergeFiles.getParents()[0], mergeFiles.getParents()[1], repo.getProject());
            mCommitsDao.update(merge);

            //Previous History
            List<String> hashsOnPreviousHistory = mCommitsDao.getHashs(repo.getFirstCommit(), merge.getHashBase());
            
            //System.out.println("\n" +hashsOnPreviousHistory+ "\n");
            
            Set<String> editedFiles = new HashSet<>();
            mergeFiles.getFilesOnBranchOne().stream().forEach((editedFile) -> {
                editedFiles.add("'" + editedFile.getFileName() + "'");
            });
            mergeFiles.getFilesOnBranchTwo().stream().forEach((editedFile) -> {
                editedFiles.add("'"+editedFile.getFileName()+"'");
            });

            //System.out.println("\n"+editedFiles+"\n");

            try {

                List<Integer> matrices = new ArrayList<>(Arrays.asList(7));
                System.out.println("\nCreating the dominoes of History");
                
                List<Dominoes> dominoesHistory
                        = DominoesFiles.loadMatrices(databaseName, txRepositoryName.getText(),
                                "CPU", hashsOnPreviousHistory, editedFiles, matrices);

                System.out.println("atual");
                for (Dominoes dominoe : dominoesHistory) {
                    System.out.println(dominoe.getHistoric() + ": " + dominoe.getMat().getMemUsed());
                }
                
                List<Dominoes> dominoesTrad
                        = DominoesSQLDao2.loadAllMatrices(databaseName, txRepositoryName.getText(),
                                "CPU", hashsOnPreviousHistory, matrices);

                System.out.println("antigo");
                for (Dominoes dominoe : dominoesTrad) {
                    System.out.println(dominoe.getHistoric() + ": " + dominoe.getMat().getMemUsed());
                }
                        
                Dominoes domCF = null;
                for (Dominoes dominoe : dominoesHistory) {
                    //System.out.println(dominoe.getHistoric());
                    if (dominoe.getHistoric().toString().equals("CF")) {
                        domCF = dominoe;
                    }
                }

                //multiplicando as matrizes e gerando a confidence
                //domCF = dominoesHistory.get(6);
                Dominoes domCFt = domCF.cloneNoMatrix();
                domCFt.transpose();
                Dominoes domFF = domCFt.multiply(domCF);
                domFF.confidence();

                if (mergeFiles == null) {
                    setValuesToMerge();
                }

                Dependencies dependencies = new Dependencies(domFF);
                double threshold = (double) spinnerThreshold.getValue();

                //System.out.println("Dependencies Branch One");
                this.dependenciesBranchOne
                        = dependencies.getDependenciesAcrossBranches(
                                mergeFiles.getFilesOnBranchOne(),
                                mergeFiles.getFilesOnBranchTwo(),
                                threshold);

                //System.out.println("Dependencies Branch Two");
                this.dependenciesBranchTwo
                        = dependencies.getDependenciesAcrossBranches(
                                mergeFiles.getFilesOnBranchTwo(),
                                mergeFiles.getFilesOnBranchOne(),
                                threshold);

                Set<EditedFile> allFiles = new HashSet<>(mergeFiles.getFilesOnBranchOne());
                allFiles.addAll(mergeFiles.getFilesOnBranchTwo());
                this.dependenciesMap = dependencies.getFilesDependencies(allFiles, threshold);

                //gera o texto para mostrar na tela
                txtDependencies.setText("Dependencies Branch One\n");
                addListDependences(this.dependenciesBranchOne);
                txtDependencies.append("\nDependencies Branch Two\n");
                addListDependences(this.dependenciesBranchTwo);
                txtDependencies.append("\n\nAll Files Dependencies\n");
                addListDependences(this.dependenciesMap);

            } catch (SQLException ex) {
                Logger.getLogger(JFrameDependencies.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(JFrameDependencies.class.getName()).log(Level.SEVERE, null, ex);
            }
            labelLoading.setVisible(false);
            btGenRanking.setEnabled(true);
            btRun.setEnabled(true);
            btKeyFiles.setEnabled(true);
        };
        Thread t = new Thread(r);
        t.start();
    }//GEN-LAST:event_btRunActionPerformed

    private void setValuesToMerge() {
        MergeFilesDao mergeFilesDao = new MergeFilesDao();
        mergeFiles = mergeFilesDao.getMerge(comboMergesList.getSelectedItem().toString().split(" ")[0], repo.getProject());

        EditedFilesDao filesDao = new EditedFilesDao();
        mergeFiles.setFilesOnBranchOne(filesDao.getFiles(mergeFiles.getHashBase(),
                mergeFiles.getParents()[0],
                mergeFiles.getPath(),
                "All Files"));
        mergeFiles.setFilesOnBranchTwo(filesDao.getFiles(mergeFiles.getHashBase(),
                mergeFiles.getParents()[1],
                mergeFiles.getPath(),
                "All Files"));

        CommitterDao cmterDao = new CommitterDao();
        List<EditedFile> files = new LinkedList<>();
        for (EditedFile editedFile : mergeFiles.getFilesOnBranchOne()) {
            List<Committer> whoEdited = cmterDao.getWhoEditedFile(mergeFiles.getHashBase(),
                    mergeFiles.getParents()[0],
                    editedFile.getFileName(),
                    mergeFiles.getPath());
            if (whoEdited.size() > 0) {
                editedFile.setWhoEditTheFile(whoEdited);
                files.add(editedFile);
            }
        }
        mergeFiles.setFilesOnBranchOne(files);

        files = new LinkedList<>();
        for (EditedFile editedFile : mergeFiles.getFilesOnBranchTwo()) {
            List<Committer> whoEdited = cmterDao.getWhoEditedFile(mergeFiles.getHashBase(),
                    mergeFiles.getParents()[1],
                    editedFile.getFileName(),
                    mergeFiles.getPath());
            if (whoEdited.size() > 0) {
                editedFile.setWhoEditTheFile(whoEdited);
                files.add(editedFile);
            }
        }
        mergeFiles.setFilesOnBranchTwo(files);

        files = new LinkedList<>();
        for (EditedFile editedFile : mergeFiles.getFilesOnPreviousHistory()) {
            List<Committer> whoEdited = cmterDao.getWhoEditedFile(repo.getFirstCommit(),
                    mergeFiles.getHashBase(),
                    editedFile.getFileName(),
                    mergeFiles.getPath());
            if (whoEdited.size() > 0) {
                editedFile.setWhoEditTheFile(whoEdited);
                files.add(editedFile);
            }
        }
        mergeFiles.setFilesOnPreviousHistory(new HashSet<>(files));
    }

    private void addListDependences(Map<EditedFile, Set<EditedFile>> dependencies) {

        dependencies.entrySet().stream().forEach((dependency) -> {
            EditedFile key = dependency.getKey();
            Set<EditedFile> value = dependency.getValue();
            txtDependencies.append(key.toString() + "\n" + "\t" + value.toString() + "\n");
        });
    }

    private void comboMergesListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMergesListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMergesListActionPerformed

    private void btGenRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGenRankingActionPerformed
        File dir = new File("lib/icons/");
        if (!dir.exists()) {
            try {
                dir.mkdir();
                System.out.println("Diretorio criado com sucesso!");                  
            } catch (Exception e) {
                System.out.println("Erro ao criar diretório!");
            }

        }  
        JFrameRankingCoverageFile jfAssignMerge = new JFrameRankingCoverageFile(repo, mergeFiles, dependenciesBranchOne, dependenciesBranchTwo);
        jfAssignMerge.setLocationRelativeTo(this.getFocusOwner());
        jfAssignMerge.setVisible(true);
            
    }//GEN-LAST:event_btGenRankingActionPerformed

    private void spinnerThresholdStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerThresholdStateChanged
        btGenRanking.setEnabled(false);
    }//GEN-LAST:event_spinnerThresholdStateChanged

    private void btKeyFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKeyFilesActionPerformed
        
        JFrameKeyFiles files = new JFrameKeyFiles(mergeFiles, dependenciesBranchOne, dependenciesBranchTwo);
        files.setLocationRelativeTo(this.getFocusOwner());
        files.setVisible(true);
        
    }//GEN-LAST:event_btKeyFilesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGenRanking;
    private javax.swing.JButton btKeyFiles;
    private javax.swing.JButton btRun;
    private javax.swing.JComboBox comboMergesList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JFrame jRanking;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableRanking;
    private javax.swing.JLabel labelLoading;
    private javax.swing.JLabel labelMerge;
    private javax.swing.JLabel labelRepository;
    private javax.swing.JLabel labelThreshold;
    private javax.swing.JSpinner spinnerThreshold;
    private javax.swing.JTextField txRepositoryName;
    private javax.swing.JTextArea txtDependencies;
    // End of variables declaration//GEN-END:variables

    private StringBuilder printDominoes(Dominoes dominoes, double threshold, Collection<EditedFile> filesEdited) {

        StringBuilder strBuilder = new StringBuilder();

        IMatrix2D matrix = dominoes.getMat();

        System.out.println("getDevice\t" + dominoes.getDevice());
        System.out.println("getHistoric\t" + dominoes.getHistoric().toString());

        System.out.println("getColType\t" + matrix.getMatrixDescriptor().getColType());
        System.out.println("getRowType\t" + matrix.getMatrixDescriptor().getRowType());
        System.out.println("getNumRows\t" + matrix.getMatrixDescriptor().getNumRows());
        System.out.println("getNumCols\t" + matrix.getMatrixDescriptor().getNumCols());

        strBuilder.append("File Dependencies.\n\n");

        List<Cell> cells = matrix.getNonZeroData();
        int rows = matrix.getMatrixDescriptor().getNumRows();
        int cols = matrix.getMatrixDescriptor().getNumCols();

        for (int i = 0; i < rows; i++) {

            EditedFile efTemp = new EditedFile(matrix.getMatrixDescriptor().getRowAt(i));

            if (filesEdited.contains(efTemp)) {

                System.out.println(efTemp);
                strBuilder.append(efTemp).append("\n");
                boolean hasDepencies = false;

                for (int j = 0; j < cols; j++) {

                    if ((i != j) && (filesEdited.contains(new EditedFile(matrix.getMatrixDescriptor().getColumnAt(j))))) {

                        for (Cell c : cells) {
                            if ((c.value >= threshold) && (c.row == i) && (c.col == j)) {
                                System.out.println("\t" + c.value + "\t" + matrix.getMatrixDescriptor().getColumnAt(j));
                                strBuilder.append("\t").append(c.value)
                                        .append("\t").append(matrix.getMatrixDescriptor().getColumnAt(j))
                                        .append("\n");
                                hasDepencies = true;
                            }
                        }
                    }
                }
                if (!hasDepencies) {
                    int lastIndex = strBuilder.lastIndexOf(efTemp.getFileName());
                    strBuilder.replace(lastIndex, lastIndex + efTemp.getFileName().length(), "");
                }
                System.out.println();
            }
        }
        return strBuilder;
    }

}
