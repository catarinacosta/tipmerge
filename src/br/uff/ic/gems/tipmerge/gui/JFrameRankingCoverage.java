/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.gems.tipmerge.gui;

import arch.Cell;
import arch.IMatrix2D;
import arch.MatrixDescriptor;
import br.uff.ic.gems.tipmerge.dao.MergeCommitsDao;
import br.uff.ic.gems.tipmerge.model.Coverage;
import br.uff.ic.gems.tipmerge.model.EditedFile;
import br.uff.ic.gems.tipmerge.model.Medalist;
import br.uff.ic.gems.tipmerge.model.MergeCommits;
import br.uff.ic.gems.tipmerge.model.MergeFiles;
import br.uff.ic.gems.tipmerge.model.RankingGenerator;
import br.uff.ic.gems.tipmerge.model.Repository;
import dao.DominoesSQLDao2;
import domain.Dominoes;
import java.awt.Color;
import java.awt.GradientPaint;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LayeredBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author j2cf
 */
public class JFrameRankingCoverage extends javax.swing.JFrame {

    private JTable jTableRanking = new JTable();
    private String databaseName = "data/gitdataminer.sqlite";
    private Repository repository;
    public Set<EditedFile> filesOfInterest = new HashSet<>();
    private List<Coverage> coverageList1;
    private Map<String, Integer[]> fileNames1;

    public JFrameRankingCoverage(Repository repository) {
        initComponents();
        initVariables(repository);
    }

    public JFrameRankingCoverage(Repository repository, MergeFiles mergeFiles, Map<EditedFile, Set<EditedFile>> dependenciesBranchOne, Map<EditedFile, Set<EditedFile>> dependenciesBranchTwo) {
        initComponents();
        this.repository = repository;
        initVariables(repository);
        mergesList.setModel(new JComboBox(new String[]{mergeFiles.getHash()}).getModel());

//		if(dependenciesBranchOne.size() > 0)
        for (EditedFile file : dependenciesBranchOne.keySet()) {
            this.filesOfInterest.add(file);
            this.filesOfInterest.addAll(dependenciesBranchOne.get(file));
        }
//		if(dependenciesBranchTwo.size() > 0)
        for (EditedFile file : dependenciesBranchTwo.keySet()) {
            this.filesOfInterest.add(file);
            this.filesOfInterest.addAll(dependenciesBranchTwo.get(file));
        }
        this.filesOfInterest.addAll(mergeFiles.getFilesOnBothBranch());

		//System.out.println("Files Of Interest\t" + filesOfInterest);
        System.out.println("Medals for common files");
        RankingGenerator rGenerator = new RankingGenerator();
        Set<EditedFile> excepiontFiles = rGenerator.setMedalsFilesEditedBothBranches(mergeFiles);
        System.out.println("Medals for dependencies in branch 1");
        excepiontFiles = rGenerator.setMedalFromDependencies(dependenciesBranchOne, mergeFiles, excepiontFiles);
        System.out.println("Medals for dependencies in branch 2");
        excepiontFiles = rGenerator.setMedalFromDependencies(dependenciesBranchTwo, mergeFiles, excepiontFiles);
        excepiontFiles.removeAll(excepiontFiles);
        List<Medalist> ranking = rGenerator.getRanking();
        showRanking(ranking);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btRunCoverage = new javax.swing.JButton();
        txProjectName = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        mergesList = new javax.swing.JComboBox();
        labelLoading = new javax.swing.JLabel();
        btnCoverageChart = new javax.swing.JButton();
        paneResult = new javax.swing.JSplitPane();
        panelRanking = new javax.swing.JScrollPane();
        panelCoverage = new javax.swing.JScrollPane();
        txtCoverage = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Developer Assignments");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("Repository Name");

        btRunCoverage.setText("Coverage");
        btRunCoverage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRunCoverageActionPerformed(evt);
            }
        });

        txProjectName.setEnabled(false);

        jLabel14.setText("Selected Merge");

        mergesList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mergesListActionPerformed(evt);
            }
        });

        labelLoading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uff/ic/gems/tipmerge/icons/loading1.gif"))); // NOI18N
        labelLoading.setText("Loading ...");
        labelLoading.setVisible(false);

        btnCoverageChart.setText("Coverage-Chart");
        btnCoverageChart.setEnabled(false);
        btnCoverageChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoverageChartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(labelLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCoverageChart)
                        .addGap(50, 50, 50)
                        .addComponent(btRunCoverage, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mergesList, 0, 517, Short.MAX_VALUE)
                            .addComponent(txProjectName))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(mergesList, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRunCoverage)
                    .addComponent(labelLoading)
                    .addComponent(btnCoverageChart))
                .addContainerGap())
        );

        paneResult.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        paneResult.setDividerSize(10);
        paneResult.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        paneResult.setResizeWeight(0.4);
        paneResult.setToolTipText("");
        paneResult.setMinimumSize(new java.awt.Dimension(115, 143));
        paneResult.setPreferredSize(new java.awt.Dimension(154, 152));

        panelRanking.setBorder(javax.swing.BorderFactory.createTitledBorder("Ranking"));
        paneResult.setLeftComponent(panelRanking);

        panelCoverage.setBorder(javax.swing.BorderFactory.createTitledBorder("Coverage"));

        txtCoverage.setColumns(20);
        txtCoverage.setRows(5);
        txtCoverage.setText("Coverage datas");
        panelCoverage.setViewportView(txtCoverage);

        paneResult.setRightComponent(panelCoverage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(paneResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneResult, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRunCoverageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRunCoverageActionPerformed

        Runnable r;
        r = new Runnable() {

            public void run() {
                labelLoading.setVisible(true);

                MergeCommitsDao mCommitsDao = new MergeCommitsDao(repository.getProject());
                MergeCommits merge = new MergeCommits(mergesList.getSelectedItem().toString().split(" ")[0], repository.getProject());
                mCommitsDao.update(merge);

                List<String> hashsList = mCommitsDao.getHashs(merge.getHashBase(), merge.getParents()[0]);
                hashsList.addAll(mCommitsDao.getHashs(merge.getHashBase(), merge.getParents()[1]));

                try {

                    List<Integer> matrices = new ArrayList<>(Arrays.asList(1, 2, 8));

                    List<Dominoes> dominoesList = DominoesSQLDao2.loadAllMatrices(databaseName, txProjectName.getText(), "CPU", hashsList, matrices);

                    Dominoes dominoesDC = null, dominoesCM = null, dominoesFM = null;
                    for (Dominoes dominoe : dominoesList) {
                        if (dominoe.getHistoric().toString().equals("DC")) {
                            dominoesDC = dominoe;
                        }
                        if (dominoe.getHistoric().toString().equals("CM")) {
                            dominoesCM = dominoe;
                        }
                        if (dominoe.getHistoric().toString().equals("FM")) {
                            dominoesFM = dominoe;
                        }
                    }

                    List<String[]> files = getFilesList(dominoesFM);

                    //get wich developers edited methods
                    Dominoes dominoesDM = dominoesDC.multiply(dominoesCM);

                    List<Coverage> coverageList = getCoverageList(dominoesDM, files);
                    coverageList1 = getCoverageList(dominoesDM, files);
                    Map<String, Integer[]> fileNames = countsEditedMethods(files);
                    fileNames1 = countsEditedMethods(files);

                    appendCoverageToGui(files, coverageList, fileNames);
                    btnCoverageChart.setEnabled(true);

                } catch (SQLException ex) {
                    Logger.getLogger(JFrameRankingCoverage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(JFrameRankingCoverage.class.getName()).log(Level.SEVERE, null, ex);
                }

                labelLoading.setVisible(false);
            }

        };
        Thread t = new Thread(r);
        t.start();

    }//GEN-LAST:event_btRunCoverageActionPerformed

    private List<String[]> getFilesList(Dominoes dominoesFM) {
        int cols;
        MatrixDescriptor matrixFM = dominoesFM.getMat().getMatrixDescriptor();
        cols = matrixFM.getNumCols();
        List<String[]> files = new ArrayList<>();
        for (int i = 0; i < cols; i++) {
            String[] file = matrixFM.getColumnAt(i).split("\\$", 2);
            if (filesOfInterest.contains(new EditedFile(file[0]))) {
                int j = 0;
                while ((j < files.size()) && (files.get(j)[0].compareTo(file[0]) < 0)) {
                    j++;
                }
                files.add(j, file);
            }
        }
        return files;
    }

    private List<Coverage> getCoverageList(Dominoes dominoesDM, List<String[]> files) {
        int rows;
        int cols;
        IMatrix2D matrixDM = dominoesDM.getMat();
        rows = matrixDM.getMatrixDescriptor().getNumRows();
        cols = matrixDM.getMatrixDescriptor().getNumCols();
        List<Cell> cells = matrixDM.getNonZeroData();
        List<Coverage> coverageList = new ArrayList<>();
        for (int i = 0; i < rows; i++) {

            Coverage coverage = new Coverage();
            coverage.setDeveloper(matrixDM.getMatrixDescriptor().getRowAt(i));

            for (int j = 0; j < cols; j++) {

                for (Cell c : cells) {
                    if ((c.row == i) && (c.col == j)) {

                        for (String[] fullName : files) {
                            if (fullName[1].equals(matrixDM.getMatrixDescriptor().getColumnAt(j))) {
                                coverage.addValue(fullName);
                            }
                        }

                    }
                }

            }
            coverageList.add(coverage);

        }
        return coverageList;
    }

    private void appendCoverageToGui(List<String[]> files, List<Coverage> coverageList, Map<String, Integer[]> fileNames) {
        txtCoverage.setText("+-------- Files and Methods ---------+");
        files.stream().forEach((file) -> {
            txtCoverage.append("\n\t" + Arrays.toString(file));
        });

        txtCoverage.append("\n\n+-------- Coverage Sumary ---------+");
        for (Coverage coverage : coverageList) {
            txtCoverage.append("\n" + coverage.getDeveloper());
            Map<String, Integer[]> cover = coverage.getCoverage(fileNames);
            for (String file : cover.keySet()) {
                txtCoverage.append("\n\t" + file + "\t" + Arrays.toString(cover.get(file)));
            }
        }

        txtCoverage.append("\n\n+-------- Coverage Files ---------+");
        for (Coverage coverage : coverageList) {
            txtCoverage.append(coverage.toString());
        }
    }

    private Map<String, Integer[]> countsEditedMethods(List<String[]> files) {
        Map<String, Integer[]> fileNames = new HashMap<>();
        int totalMethodsFile = 0;
        String fileName = "";
        for (String[] fullFileName : files) {
            if (!fileName.equals(fullFileName[0])) {
                if (!fileName.isEmpty()) {
                    fileNames.put(fileName, new Integer[]{totalMethodsFile});
                }
                fileName = fullFileName[0];
                totalMethodsFile = 1;
            } else {
                totalMethodsFile++;
            }
        }
        fileNames.put(fileName, new Integer[]{totalMethodsFile});
        return fileNames;
    }

    /*
     private List<String[]> getFilesOfInterest(List<String[]> files) {
     List<String[]> newFileList = new ArrayList<>();
     for(String[] file : files){
     if(filesOfInterest.contains(new EditedFile(file[0])))
     newFileList.add(file);
     }
     return newFileList;
     }
     */

    private void mergesListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mergesListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mergesListActionPerformed

    private void btnCoverageChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoverageChartActionPerformed
        // Code Covergae Chart
        DefaultCategoryDataset chartData = new DefaultCategoryDataset();
        Vector selectedCommitters = new Vector();
        Vector selectedIndex = new Vector();   //Start Coverage 
        Vector noSelected = new Vector();
        for (int i = 0; i < jTableRanking.getRowCount(); i++) {
            if ((boolean) jTableRanking.getValueAt(i, 0) == true) {
//                    System.out.println("\n"+jTableRanking.getValueAt(k,0)+(String)jTableRanking.getValueAt(k,2));
                selectedCommitters.add((String) jTableRanking.getValueAt(i, 2));
            } else {
//                    System.out.println("\nNão Selecionado"+(String)jTableRanking.getValueAt(k,2));
            }
        }
        System.out.print("\nCoverge Files");
        boolean selected = false;
        if (selectedCommitters.size() > 0 && selectedCommitters.size() < 4) {
            for (int i = 0; i < selectedCommitters.size(); i++) {
                String nome1 = (String) selectedCommitters.get(i);
                for (Coverage coverage : this.coverageList1) {
                    String nome2 = coverage.getDeveloper() + " ";
                    if (nome1.equalsIgnoreCase(nome2)) {
                        selectedIndex.add(this.coverageList1.indexOf(coverage));
                        selected = true;
                    }
                }
                if (selected == false) {
                    noSelected.add(nome1);
                }
                selected = false;

            }
            if (!noSelected.isEmpty()) {
                String nameDev = "";
                for (int s = 0; s < noSelected.size(); s++) {
                    System.out.println("\nNo following developers not have coveage" + noSelected.get(s));
                    nameDev = nameDev + noSelected.get(s) + "  ;";
                }
                JOptionPane.showMessageDialog(null, "The Developer does not have coverage: " + "\n" + nameDev);
            }
            if (selectedIndex.size() == 1) {
                for (Coverage coverage : this.coverageList1) {
                    for (int i = 0; i < selectedCommitters.size(); i++) {
                        String name1 = (String) selectedCommitters.get(i);
                        String name2 = coverage.getDeveloper() + " ";
                        if (name1.equalsIgnoreCase(name2)) {
                            //                              System.out.print("Sucess");
                            Map<String, Integer[]> cover = coverage.getCoverage(this.fileNames1);
                            for (String file : cover.keySet()) {
                                Integer[] editedMethods = cover.get(file);
                                chartData.addValue(editedMethods[0], "Total Modified Methods", file);
                                chartData.addValue(editedMethods[1], coverage.getDeveloper(), file);
                            }
                        }
                    }
                }

                coverageChart(chartData);
            }
            if (selectedIndex.size() == 2) {
                Coverage coverDev1 = this.coverageList1.get((int) selectedIndex.get(0));
                List<String[]> coverData1 = coverDev1.getValues();
                Coverage coverDev2 = this.coverageList1.get((int) selectedIndex.get(1));
                List<String[]> coverData2 = coverDev2.getValues();
                String[] fileData1;
                String[] fileData2;
                Vector listSameFiles = new Vector();
                for (int i = 0; i < coverData1.size(); i++) {
                    fileData1 = coverData1.get(i);
                    for (int j = 0; j < coverData2.size(); j++) {
                        fileData2 = coverData2.get(j);
                        if (fileData1[0].equalsIgnoreCase(fileData2[0]) && fileData1[1].equalsIgnoreCase(fileData2[1])) {
                            System.out.printf("\n" + coverDev1.getDeveloper() + coverDev2.getDeveloper() + fileData1[0] + fileData2[0]);
                            listSameFiles.add(fileData1[0]);
                        }
                    }
                }
                Vector listAmountMethods1 = new Vector();
                Vector listSameMethods = new Vector();
                Vector listFiles = new Vector();
                int totalSameMethods = 0;
                Map<String, Integer[]> covera1 = coverDev1.getCoverage(this.fileNames1);
                for (String file1 : covera1.keySet()) {
                    Integer[] editedMethods1 = covera1.get(file1);
                    listAmountMethods1.add(editedMethods1[1]);
                    for (int h = 0; h < listSameFiles.size(); h++) {
                        if (file1.equalsIgnoreCase((String) listSameFiles.get(h))) {
                            totalSameMethods++;
                        }
                    }
                    listSameMethods.add(totalSameMethods);
                    listFiles.add(file1);
                    totalSameMethods = 0;
                }
                Vector listAmountMethods2 = new Vector();
                Vector listTotalMethods = new Vector();
                Map<String, Integer[]> covera2 = coverDev2.getCoverage(this.fileNames1);
                for (String file1 : covera2.keySet()) {
                    Integer[] editedMethods2 = covera2.get(file1);
                    listAmountMethods2.add(editedMethods2[1]);
                    listTotalMethods.add(editedMethods2[0]);
                }
                DefaultCategoryDataset dataCoverage = new DefaultCategoryDataset();
                String modifiedFile = " ";
                int sumModifications = 0;
                int num0 = 0;
                int num1 = 0;
                int num2 = 0;
                System.out.println("\n Tamanho de cada Lista" + listSameMethods.size() + listAmountMethods1.size() + listAmountMethods2.size());
                for (int y = 0; y < listAmountMethods1.size(); y++) {
                    num1 = (int) listAmountMethods1.get(y);
                    num2 = (int) listAmountMethods2.get(y);
                    num0 = (int) listSameMethods.get(y);
                    modifiedFile = (String) listFiles.get(y);
                    sumModifications = num1 + num2 - num0;
                    System.out.print("\n" + sumModifications + coverDev1.getDeveloper() + " + " + coverDev2.getDeveloper() + modifiedFile);
                    dataCoverage.addValue((int) listTotalMethods.get(y), "Total Modified Methods", modifiedFile);
                    dataCoverage.addValue(sumModifications, coverDev1.getDeveloper() + " + " + coverDev2.getDeveloper(), modifiedFile);
                }
                coverageChart(dataCoverage);
            }
            if (selectedIndex.size() == 3) {
                Coverage coverDev1 = coverageList1.get((int) selectedIndex.get(0));
                Coverage coverDev2 = coverageList1.get((int) selectedIndex.get(1));
                Coverage coverDev3 = coverageList1.get((int) selectedIndex.get(2));
                List<String[]> coverData1 = coverDev1.getValues();
                List<String[]> coverData2 = coverDev2.getValues();
                List<String[]> coverData3 = coverDev3.getValues();
                String[] fileData1;
                String[] fileData2;
//                  String [] fileData3;
                Vector listSameFile = new Vector();
                for (int i = 0; i < coverData1.size(); i++) {
                    fileData1 = coverData1.get(i);
                    for (int j = 0; j < coverData2.size(); j++) {
                        fileData2 = coverData2.get(j);
                        if (fileData1[0].equalsIgnoreCase(fileData2[0]) && fileData1[1].equalsIgnoreCase(fileData2[1])) {
                            System.out.printf("\n" + coverDev1.getDeveloper() + coverDev2.getDeveloper() + fileData1[0] + fileData2[0]);
                            listSameFile.add(fileData1[0]);
                        }
                    }
                }
                for (int i = 0; i < coverData2.size(); i++) {
                    fileData1 = coverData2.get(i);
                    for (int j = 0; j < coverData3.size(); j++) {
                        fileData2 = coverData3.get(j);
                        if (fileData1[0].equalsIgnoreCase(fileData2[0]) && fileData1[1].equalsIgnoreCase(fileData2[1])) {
                            System.out.printf("\n" + coverDev1.getDeveloper() + coverDev2.getDeveloper() + fileData1[0] + fileData2[0]);
                            listSameFile.add(fileData1[0]);
                        }
                    }
                }
                for (int i = 0; i < coverData1.size(); i++) {
                    fileData1 = coverData1.get(i);
                    for (int j = 0; j < coverData3.size(); j++) {
                        fileData2 = coverData3.get(j);
                        if (fileData1[0].equalsIgnoreCase(fileData2[0]) && fileData1[1].equalsIgnoreCase(fileData2[1])) {
                            System.out.printf("\n" + coverDev1.getDeveloper() + coverDev2.getDeveloper() + fileData1[0] + fileData2[0]);
                            listSameFile.add(fileData1[0]);
                        }
                    }
                }
                Vector listAmountMethods1 = new Vector();
                Vector amountSameMethods1 = new Vector();
                Vector listModifiedFiles = new Vector();
                int totalSameMethods = 0;
                Map<String, Integer[]> covera1 = coverDev1.getCoverage(this.fileNames1);
                for (String file1 : covera1.keySet()) {
                    Integer[] editedMethods1 = covera1.get(file1);
                    listAmountMethods1.add(editedMethods1[1]);
                    for (int h = 0; h < listSameFile.size(); h++) {
                        if (file1.equalsIgnoreCase((String) listSameFile.get(h))) {
                            totalSameMethods++;
                        }
                    }
                    amountSameMethods1.add(totalSameMethods);
                    listModifiedFiles.add(file1);
                    totalSameMethods = 0;
                }
                Vector listAmountMethods2 = new Vector();
                Vector listTotalModified = new Vector();
                Map<String, Integer[]> covera2 = coverDev2.getCoverage(this.fileNames1);
                for (String file1 : covera2.keySet()) {
                    Integer[] editedMethods2 = covera2.get(file1);
                    listTotalModified.add(editedMethods2[0]);
                    listAmountMethods2.add(editedMethods2[1]);
                }
                Vector listAmountMethods3 = new Vector();
                Map<String, Integer[]> covera3 = coverDev3.getCoverage(this.fileNames1);
                for (String file1 : covera3.keySet()) {
                    Integer[] editedMethods3 = covera3.get(file1);
                    listAmountMethods3.add(editedMethods3[1]);
                }
                DefaultCategoryDataset dataCoverage = new DefaultCategoryDataset();
                String modifiedFile1 = " ";
                int totalMofications = 0;
                int num0 = 0;
                int num1 = 0;
                int num2 = 0;
                int num3 = 0;
                System.out.println("\n Tamanho de cada Lista" + amountSameMethods1.size() + listAmountMethods1.size() + listAmountMethods2.size());
                for (int y = 0; y < listAmountMethods1.size(); y++) {
                    num0 = (int) amountSameMethods1.get(y);
                    num1 = (int) listAmountMethods1.get(y);
                    num2 = (int) listAmountMethods2.get(y);
                    num3 = (int) listAmountMethods3.get(y);
                    modifiedFile1 = (String) listModifiedFiles.get(y);
                    totalMofications = num1 + num2 + num3 - num0;
                    System.out.print("\n" + totalMofications + coverDev1.getDeveloper() + " + " + coverDev2.getDeveloper() + " + " + coverDev3.getDeveloper() + modifiedFile1);
                    dataCoverage.addValue((int) listTotalModified.get(y), "Total Modified Methods", modifiedFile1);
                    dataCoverage.addValue(totalMofications, coverDev1.getDeveloper() + " + " + coverDev2.getDeveloper() + "  + " + coverDev3.getDeveloper(), modifiedFile1);
                }
                coverageChart(dataCoverage);
            }
            for (int k = 0; k < selectedIndex.size(); k++) {
                Coverage cover = coverageList1.get((int) selectedIndex.get(k));
                System.out.print("\n You select the following developer:" + cover.getDeveloper());
            }
        } else {
            JOptionPane.showMessageDialog(null, "You can select 1-3 developers for Coverage Chart");
        } //End Coverage  
    }//GEN-LAST:event_btnCoverageChartActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRunCoverage;
    private javax.swing.JButton btnCoverageChart;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labelLoading;
    private javax.swing.JComboBox mergesList;
    private javax.swing.JSplitPane paneResult;
    private javax.swing.JScrollPane panelCoverage;
    private javax.swing.JScrollPane panelRanking;
    private javax.swing.JTextField txProjectName;
    private javax.swing.JTextArea txtCoverage;
    // End of variables declaration//GEN-END:variables

    private void showRanking(List<Medalist> ranking) {
        DefaultTableModel model = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                if (column == 0) //Return the first column as checkbox  
                {
                    return Boolean.class;
                }
                return super.getColumnClass(column);
            }
        };
        Icon mGold = new ImageIcon(getClass().getResource("/br/uff/ic/gems/tipmerge/icons/gold1.png"));
        Icon mSilver = new ImageIcon(getClass().getResource("/br/uff/ic/gems/tipmerge/icons/silver1.png"));
        Icon mBronze = new ImageIcon(getClass().getResource("/br/uff/ic/gems/tipmerge/icons/bronze1.png"));
        JLabel lblGold = new JLabel("Gold");
        JLabel lblSilver = new JLabel("Silver");
        JLabel lblBronze = new JLabel("Bronze");
        lblGold.setIcon(mGold);
        lblSilver.setIcon(mSilver);
        lblBronze.setIcon(mBronze);
        String[] columnLabels = {"Select", "Ranking", "Committer", "Gold", "Silver", "Bronze", "Total"};
        model.setColumnIdentifiers(columnLabels);
        int rank = 1;
        for (Medalist m : ranking) {
            int gold = m.getGoldMedals();
            int silver = m.getSilverMedals();
            int bronze = m.getBronzeMedals();
            int total = gold + silver + bronze;
            String name = m.getCommitter().getName();
            model.addRow(new Object[]{Boolean.FALSE, rank++ + "º", name, gold, silver, bronze, total});
        }
        jTableRanking.setModel(model);
        JCheckBox boxer = new JCheckBox();
        JTableRenderer jTableRender = new JTableRenderer();
        jTableRanking.getColumnModel().getColumn(3).setHeaderValue(lblGold);
        jTableRanking.getColumnModel().getColumn(3).setHeaderRenderer(jTableRender);
        jTableRanking.getColumnModel().getColumn(4).setHeaderValue(lblSilver);
        jTableRanking.getColumnModel().getColumn(4).setHeaderRenderer(jTableRender);
        jTableRanking.getColumnModel().getColumn(5).setHeaderValue(lblBronze);
        jTableRanking.getColumnModel().getColumn(5).setHeaderRenderer(jTableRender);
//                jTableRanking.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox().));
        jTableRanking.getColumnModel().getColumn(3).setCellRenderer(jTableRender);
        jTableRanking.getColumnModel().getColumn(4).setCellRenderer(jTableRender);
        jTableRanking.getColumnModel().getColumn(5).setCellRenderer(jTableRender);
        panelRanking.setViewportView(jTableRanking);
    }

    private void initVariables(Repository repository) {
        this.txProjectName.setText(repository.getName());
        mergesList.setModel(new JComboBox(repository.getListOfMerges().toArray()).getModel());
    }

    public void coverageChart(CategoryDataset dados) {
        CategoryAxis categoryAxis = new CategoryAxis("Edited Files");
        ValueAxis valueAxis = new NumberAxis("Methods");
        CategoryPlot plot = new CategoryPlot(dados, categoryAxis, valueAxis, new LayeredBarRenderer());
        plot.setOrientation(PlotOrientation.HORIZONTAL);
        LayeredBarRenderer renderer = (LayeredBarRenderer) plot.getRenderer();
        renderer.setSeriesBarWidth(0, 1.5);
        renderer.setSeriesBarWidth(1, 0.6);
        renderer.setItemMargin(0.02);
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryMargin(0.25);
        domainAxis.setUpperMargin(0.05);
        domainAxis.setLowerMargin(0.05);
        BarRenderer rendered1 = (BarRenderer) plot.getRenderer();
        rendered1.setDrawBarOutline(false);
        GradientPaint gradientpaint1 = new GradientPaint(0.0F, 0.0F, Color.GRAY, 0.0F, 0.0F, new Color(0, 0, 0));
        GradientPaint gradientpaint2 = new GradientPaint(0.0F, 0.0F, Color.GREEN, 0.0F, 0.0F, new Color(0, 64, 0));
        rendered1.setSeriesPaint(0, gradientpaint1);
        rendered1.setSeriesPaint(1, gradientpaint2);
        JFreeChart graphic = new JFreeChart("Coverge Chart", JFreeChart.DEFAULT_TITLE_FONT, plot, true);
        ChartPanel chartPanel = new ChartPanel(graphic);
        chartPanel.setPreferredSize(new java.awt.Dimension(590, 350));
        JFrame chartFrame1 = new JFrame();
        chartFrame1.setContentPane(chartPanel);
        chartFrame1.setBounds(120, 20, 500, 500);
        chartFrame1.setVisible(true);
    }
}
