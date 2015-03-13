/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.gems.tipmerge.gui;

import br.uff.ic.gems.tipmerge.dao.CommitterDao;
import br.uff.ic.gems.tipmerge.dao.EditedFilesDao;
import br.uff.ic.gems.tipmerge.dao.MergeCommitsDao;
import br.uff.ic.gems.tipmerge.dao.MergeFilesDao;
import br.uff.ic.gems.tipmerge.model.Committer;
import br.uff.ic.gems.tipmerge.model.EditedFile;
import br.uff.ic.gems.tipmerge.model.MergeCommits;
import br.uff.ic.gems.tipmerge.model.MergeFiles;
import br.uff.ic.gems.tipmerge.model.RepoFiles;
import br.uff.ic.gems.tipmerge.model.Repository;
import br.uff.ic.gems.tipmerge.util.Export;
import br.uff.ic.gems.tipmerge.util.RunGit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * This class is in charge of showing all results about the files analysis
 * @author j2cf, Catarina
 */
public class JFrameFilesAnalysis extends javax.swing.JFrame {
        
	private final RepoFiles repoFiles;
	/**
	 * Creates new form JFrameCommitsAnalysis
	 * @param repository
	 */
	public JFrameFilesAnalysis(Repository repository) {
            this.repoFiles = new RepoFiles(repository);
            initComponents();
            setParameters();
	}
	
	//1- Shows the project branches that the user can select to merge - 2- shows all the existing merges - 3 - and put the name of the project
	private void setParameters() {
		jcBranch1.setModel(new JComboBox(repoFiles.getRepository().getBranches().toArray()).getModel());
		jcBranch2.setModel(new JComboBox(repoFiles.getRepository().getBranches().toArray()).getModel());
		jcMerge.setModel(
			new JComboBox(
					repoFiles.getRepository().getListOfMerges().toArray())
					.getModel()
		);
		jPanel1.setBorder(
			BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(""), "Project " +  repoFiles.getRepository().getName())
		);
	}
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hash1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        hashBranch1 = new javax.swing.JLabel();
        jcBranch1 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcBranch2 = new javax.swing.JComboBox();
        hashBranch2 = new javax.swing.JLabel();
        radioBranches = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jcMerge = new javax.swing.JComboBox();
        radioHistorical = new javax.swing.JRadioButton();
        barRunning = new javax.swing.JProgressBar();
        btRun = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        btAllMerges = new javax.swing.JButton();

        hash1.setText("<hash>");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Files Analysis");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setEnabled(false);

        hashBranch1.setText("<hash>");

        jcBranch1.setEnabled(false);
        jcBranch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcBranch1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Branch one's hash: ");

        jLabel8.setText("Branch two's hash: ");

        jcBranch2.setEnabled(false);
        jcBranch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcBranch2ActionPerformed(evt);
            }
        });

        hashBranch2.setText("<hash>");

        buttonGroup1.add(radioBranches);
        radioBranches.setText("Select Branches to Merge");
        radioBranches.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioBranchesStateChanged(evt);
            }
        });
        radioBranches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBranchesActionPerformed(evt);
            }
        });

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
                                .addComponent(hashBranch1))
                            .addComponent(radioBranches))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(radioBranches)
                .addGap(5, 5, 5)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Select Merge");

        jcMerge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcMergeActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioHistorical);
        radioHistorical.setSelected(true);
        radioHistorical.setText("Select Previous Merges");
        radioHistorical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioHistoricalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcMerge, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(radioHistorical)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioHistorical)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcMerge, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        barRunning.setStringPainted(true);

        btRun.setText("Run");
        btRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(barRunning, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRun, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btRun)
                    .addComponent(barRunning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Export");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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

        btAllMerges.setText("Run All Merges");
        btAllMerges.setEnabled(false);
        btAllMerges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAllMergesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btAllMerges)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btAllMerges))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRunActionPerformed

		startProgressBar(this.repoFiles.getRepository().getListOfMerges().size());
		
		/**
		 * At this time a merge will be created or
		 * - the selection of branches
		 * - by selecting one merge from the history
		 */
		MergeFiles mergeSelected;
		MergeCommits mCommits;
		MergeFilesDao mergeFilesDao = new MergeFilesDao();
		MergeCommitsDao mergeCommittsDao = new MergeCommitsDao(repoFiles.getRepository().getProject());

		if (radioHistorical.isSelected()){
			mergeSelected = mergeFilesDao.getMerge(jcMerge.getSelectedItem().toString(), repoFiles.getRepository().getProject());
			mCommits = new MergeCommits(jcMerge.getSelectedItem().toString(), repoFiles.getRepository().getProject());
			
		}else{
			mergeSelected = new MergeFiles("", repoFiles.getRepository().getProject());
			mergeSelected.setParents(hashBranch1.getText(), hashBranch2.getText());
			mergeSelected.setHashBase(mergeFilesDao.getMergeBase(mergeSelected.getParents()[0], mergeSelected.getParents()[1], mergeSelected.getPath()));

			mCommits = new MergeCommits("", repoFiles.getRepository().getProject());
		}
		mergeCommittsDao.update(mCommits);
		mergeCommittsDao.setCommittersOnBranch(mCommits);
		/** 
		 * From now the merge already exists with parents and merge base, next steps are:
		 * Set the files of that merge and committers that changed that files.
		 */

		EditedFilesDao filesDao = new EditedFilesDao();
		mergeSelected.setFilesOnBranchOne(filesDao.getFiles(mergeSelected.getHashBase(), mergeSelected.getParents()[0], mergeSelected.getPath()));
		mergeSelected.setFilesOnBranchTwo(filesDao.getFiles(mergeSelected.getHashBase(), mergeSelected.getParents()[1], mergeSelected.getPath()));
		
		CommitterDao cmterDao = new CommitterDao();
		
		for(EditedFile editedFile : mergeSelected.getFilesOnBranchOne()){
			editedFile.setWhoEditTheFile(cmterDao.getWhoEditedFile(mergeSelected.getHashBase(), 
										mergeSelected.getParents()[0], 
										editedFile.getFileName(), 
										mergeSelected.getPath())
			);
		}

		for(EditedFile editedFile : mergeSelected.getFilesOnBranchTwo()){
			editedFile.setWhoEditTheFile(cmterDao.getWhoEditedFile(mergeSelected.getHashBase(), 
										mergeSelected.getParents()[1], 
										editedFile.getFileName(), 
										mergeSelected.getPath())
			);
		}
		
		for(EditedFile editedFile : mergeSelected.getFilesOnPreviousHistory()){
			editedFile.setWhoEditTheFile(cmterDao.getWhoEditedFile(repoFiles.getRepository().getFirstCommit(), 
										mergeSelected.getHashBase(), 
										editedFile.getFileName(), 
										mergeSelected.getPath())
			);
		}
		
		//prints on the command line
		//showCommitters(mergeSelected);
		repoFiles.getMergeFiles().add(mergeSelected);
		
		//organizes the data in the table
		showResBranch1(mergeSelected);
		showResBranch2(mergeSelected);
		showResPreviousHistory(mergeSelected);
		showResIntersection(mCommits.getCommittersInCommon());

        jButton2.setEnabled(true);
    }//GEN-LAST:event_btRunActionPerformed

    private void jcMergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcMergeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcMergeActionPerformed
	
	//select and show all merges from branch 1
    private void jcBranch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcBranch1ActionPerformed
		hashBranch1.setText(RunGit.getResult("git log -n 1 --pretty=format:%H " + jcBranch1.getSelectedItem().toString(), repoFiles.getRepository().getProject()));
    }//GEN-LAST:event_jcBranch1ActionPerformed

    private void radioHistoricalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioHistoricalActionPerformed
    }//GEN-LAST:event_radioHistoricalActionPerformed

    private void radioBranchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBranchesActionPerformed
    }//GEN-LAST:event_radioBranchesActionPerformed
	//select and show all merges from branch 2
    private void jcBranch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcBranch2ActionPerformed
		hashBranch2.setText(RunGit.getResult("git log -n 1 --pretty=format:%H " + jcBranch2.getSelectedItem().toString(), repoFiles.getRepository().getProject()));
    }//GEN-LAST:event_jcBranch2ActionPerformed
	
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
		Map<String, TableModel> sheet = new LinkedHashMap<>();
		sheet.put("Branch1", jTable1.getModel());
		sheet.put("Branch2", jTable2.getModel());
		sheet.put("Both Branches", jTable3.getModel());
		sheet.put("Previous History", jTable4.getModel());
		
		Export.toExcel(sheet);	
		JOptionPane.showMessageDialog(this, "File was sucessfully saved", null, JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void radioBranchesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioBranchesStateChanged
		invertEnabledGroup();
		
    }//GEN-LAST:event_radioBranchesStateChanged

	//It's not working yet
    private void btAllMergesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAllMergesActionPerformed
        int i = this.repoFiles.getRepository().getListOfMerges().size();
        float j = (float) (i/100.0);
        int count = 0;
        barRunning.setValue(0);
        barRunning.setMaximum(100);
        // It should show all merges in some other way

        for (String hashMerge : repoFiles.getRepository().getListOfMerges()){

            if(hashMerge.equals(jcMerge.getSelectedItem().toString())){
                MergeFilesDao mergeDao = new MergeFilesDao();
                MergeFiles mergeFiles = mergeDao.getMerge(hashMerge, repoFiles.getRepository().getProject());

                EditedFilesDao filesDao = new EditedFilesDao();
                mergeFiles.setFilesOnBranchOne(filesDao.getFiles(mergeFiles.getHashBase(), mergeFiles.getParents()[0], mergeFiles.getPath()));
                /*
                model.insertRow(model.getValueToRow(), new Object[]{"Branch One","",""});
                for (EditedFile  file : mergeSelected.getFilesOnBranchOne()){
                    model.insertRow(
                        model.getValueToRow(),
                        new Object[]{file,"",""}
                    );
                    CommitterDao cmterDao = new CommitterDao();
                    file.setWhoEditTheFile(
                        cmterDao.getWhoEditedFile(
                            mergeSelected.getHashBase(), mergeSelected.getParents()[0], file.getFileName(), mergeSelected.getPath()));

                    for(Committer cmter : file.getWhoEditTheFile()){
                        model.insertRow(
                            model.getValueToRow(),
                            new Object[]{"",cmter.getEmail(),cmter.getCommits()}
                        );
                    }

                }
                model.insertRow(model.getValueToRow(), new Object[]{"Branch Two"});
                mergeSelected.setFilesOnBranchTwo(filesDao.getFiles(mergeSelected.getHashBase(), mergeSelected.getParents()[1], mergeSelected.getPath()));
                for (EditedFile  file : mergeSelected.getFilesOnBranchTwo()){
                    model.insertRow(
                        model.getValueToRow(),
                        new Object[]{file,"",""}
                    );
                    CommitterDao cmterDao = new CommitterDao();
                    file.setWhoEditTheFile(
                        cmterDao.getWhoEditedFile(
                            mergeSelected.getHashBase(), mergeSelected.getParents()[1], file.getFileName(), mergeSelected.getPath()));

                    for(Committer cmter : file.getWhoEditTheFile()){
                        model.insertRow(
                            model.getValueToRow(),
                            new Object[]{"",cmter.getEmail(),cmter.getCommits()}
                        );
                    }

                }
                //prints on the command line
                showCommitters(mergeSelected);
                repoFiles.getMergeFiles().add(mergeSelected);
                */
            }
            count++;
            if(count%j < 1.0){
                updateBar(count);
            }
        }

        //organizes the data in the table
        DefaultTableModel dftModel = new DefaultTableModel(new Object[]{"File name","Who edited it","Number of changes"}, count);
        jTable1.setModel(dftModel);

        DefaultTableModel model =  (DefaultTableModel)jTable1.getModel();

        jTable1.update(jTable1.getGraphics());
    }//GEN-LAST:event_btAllMergesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barRunning;
    private javax.swing.JButton btAllMerges;
    private javax.swing.JButton btRun;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel hash1;
    private javax.swing.JLabel hashBranch1;
    private javax.swing.JLabel hashBranch2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    private javax.swing.JComboBox jcMerge;
    private javax.swing.JRadioButton radioBranches;
    private javax.swing.JRadioButton radioHistorical;
    // End of variables declaration//GEN-END:variables

	private void startProgressBar(Integer max){
		barRunning.setValue(0);
		//barRunning.setMaximum(100);
		barRunning.setMaximum(max);
	}
	
	private void updateBar(Integer value) {
		int max = barRunning.getMaximum();
		float j = (float) max / 100;
		if(value % j < 1.0){
			barRunning.setValue(value);
			barRunning.setString("processing...");
			barRunning.update(barRunning.getGraphics());
		}
		if(value == max){
			barRunning.setValue(value);
			barRunning.setString("100% Done");
			barRunning.update(barRunning.getGraphics());
		}
	}

	private void showCommitters(MergeFiles mergeFiles) {
		System.out.println("Merge: " + mergeFiles.getHash());
		System.out.println("Branch One");
		mergeFiles.getFilesOnBranchOne().stream().forEach((file) ->{
			System.out.println(file.getFileName());
			file.getWhoEditTheFile().stream().forEach((cmter) -> {
				System.out.println("\t" + cmter.toString());
			});
		});
		System.out.println("Branch Two");
		mergeFiles.getFilesOnBranchTwo().stream().forEach((file) ->{
			System.out.println(file.getFileName());
			file.getWhoEditTheFile().stream().forEach((cmter) -> {
				System.out.println("\t" + cmter.toString());
			});
		});
		/*
		mergeFiles.getCommittersOnMege().stream().forEach((cmt) -> {
			System.out.println(cmt.toString());
		});
		*/
	}

	private void invertEnabledGroup() {
		jcBranch1.setEnabled(!jcBranch1.isEnabled());
		jcBranch2.setEnabled(!jcBranch2.isEnabled());
		jcMerge.setEnabled(!jcMerge.isEnabled());
		jPanel2.setEnabled(!jPanel2.isEnabled());
		jPanel3.setEnabled(!jPanel3.isEnabled());
		jButton2.setEnabled(false);

	}
	
	//shows the number of commits by committers in each file on Branch 1
	private void showResBranch1(MergeFiles mergeSelected) {
		DefaultTableModel dftModel = new DefaultTableModel(new Object[]{"File name"}, 0);

		Set<Committer> committers = mergeSelected.getCommittersOnBranchOne();
		
		//Includes columns with the names of all developers (branches 1 and 2)
		committers.stream().forEach((committer) -> {
			dftModel.addColumn(committer.getName());
		});
		
		//dftModel.addRow(new Object[]{"BRANCH ONE"});
		mergeSelected.getFilesOnBranchOne().stream().forEach((editedfile) -> {
			dftModel.addRow(getValueToRow(editedfile, committers));
			//dftModel.addRow(new Object[]{file.getFileName()});
			
		});

		jTable1.setModel(dftModel);
	}
	
	//shows the number of commits by committers in each file on Branch 2
	private void showResBranch2(MergeFiles mergeSelected) {
		DefaultTableModel dftModel = new DefaultTableModel(new Object[]{"File name"}, 0);

		Set<Committer> committers = mergeSelected.getCommittersOnBranchTwo();
		
		//Includes columns with the names of all developers (branches 1 and 2)
		committers.stream().forEach((committer) -> {
			dftModel.addColumn(committer.getName());
		});
		
		//dftModel.addRow(new Object[]{"BRANCH TWO"});
		mergeSelected.getFilesOnBranchTwo().stream().forEach((file) -> {
			dftModel.addRow(getValueToRow(file, committers));

		});

		jTable2.setModel(dftModel);
        //tbResultsBranch1.update(tbResultsBranch1.getGraphics());	
	}
	
//shows the number of commits in both branches, this information considers only commits
	private void showResIntersection(List<Committer> committers) {
		
		DefaultTableModel model = new DefaultTableModel( new Object[] {"Author ", "Number of Commits in Both Branches"}, 0);
		//model.addRow(new Object[]{"BOTH BRANCHES"});
		for (Committer cmter : committers){
			model.insertRow(model.getRowCount(), 
							new Object[] {cmter.getName() , cmter.getCommits()
							}
			);
		}
		//return model;
		jTable3.setModel(model);
	}
	
	//shows the number of commits by committers in each file (changed on any branch) that was changed in the history before the branch
	private void showResPreviousHistory(MergeFiles mergeSelected) {
		
		DefaultTableModel dftModel = new DefaultTableModel(new Object[]{"File name"}, 0);

		Set<Committer> committers = mergeSelected.getCommittersOnPreviousHistory();
		 
	//	Arrays.sort(committers);
		//Includes columns with the names of all developers (branches 1 and 2)
		committers.stream().forEach((committer) -> {
			dftModel.addColumn(committer.getName());
		//	System.out.println(committer.toString());
		});
		
		//dftModel.addRow(new Object[]{"PREVIOUS HISTORY"});
		mergeSelected.getFilesOnPreviousHistory().stream().forEach((file) -> {
			if(file.getWhoEditTheFile().size() > 0)
				dftModel.addRow(getValueToRow(file, committers));

		});

		jTable4.setModel(dftModel);
	}
	
	private String[] getValueToRow(EditedFile editedFile, Set<Committer> committers) {
		String valuesVector[] = new String[committers.size() + 1];
		valuesVector[0] = editedFile.getFileName();
		editedFile.getWhoEditTheFile().stream().forEach((cmtrFile) -> {
			int index = 1;
			for(Committer cmter : committers){
				
				if(cmtrFile.equals(cmter)){
					valuesVector[index] = cmtrFile.getCommits().toString();
				}
				index++;
			}

		});
		return valuesVector;
	}

	
}
