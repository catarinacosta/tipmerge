/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.gems.tipmerge.gui;

import br.uff.ic.gems.tipmerge.dao.RepositoryDao;
import br.uff.ic.gems.tipmerge.model.Committer;
import br.uff.ic.gems.tipmerge.model.Repository;
import java.io.File;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * This class is in charge of showing all basic information about the repository project selected and direct to other possible analyzes
 * @author j2cf, Catarina
 */
public class JFrameMainWindow extends javax.swing.JFrame {
	
	Repository repository;

	/**
	 * Creates new form JFrameMainWindows
	 */
	public JFrameMainWindow() {
		initComponents();
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

        jPanel2 = new javax.swing.JPanel();
        btSelectProject = new javax.swing.JButton();
        jtProjectName = new javax.swing.JTextField();
        jtPathToProjects = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txCommits = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txLast = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txTotalMerges = new javax.swing.JTextField();
        btShow = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txTotalAuthors = new javax.swing.JTextField();
        txTotalBranches = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txResult = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuCommit = new javax.swing.JMenuItem();
        menuDependence = new javax.swing.JMenuItem();
        menuFile = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuAssign = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TIPMerge - Tool to assIgn develoPers to Merge on Git");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(500, 500));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Project Info"));

        btSelectProject.setText("Select Project");
        btSelectProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelectProjectActionPerformed(evt);
            }
        });

        jtProjectName.setEditable(false);

        jtPathToProjects.setEditable(false);

        jLabel1.setText("Path to Projects");

        jLabel2.setText("Selected Project");

        jLabel3.setText("Commits");

        txCommits.setEditable(false);

        jLabel4.setText("Last Commit");

        txLast.setEditable(false);

        jLabel5.setText("Merges");

        txTotalMerges.setEditable(false);

        btShow.setText("Show Basic Data");
        btShow.setEnabled(false);
        btShow.setMaximumSize(new java.awt.Dimension(140, 29));
        btShow.setMinimumSize(new java.awt.Dimension(140, 29));
        btShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btShowActionPerformed(evt);
            }
        });

        jLabel6.setText("Committers");

        txTotalAuthors.setEditable(false);

        txTotalBranches.setEditable(false);

        jLabel7.setText("Branches");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jtProjectName)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSelectProject, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtPathToProjects)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txCommits)
                                    .addComponent(txLast)
                                    .addComponent(txTotalAuthors)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txTotalMerges, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txTotalBranches, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtPathToProjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSelectProject))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txCommits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txTotalBranches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txTotalMerges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txTotalAuthors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(jTree1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
        );

        jButton1.setText("Export");
        jButton1.setEnabled(false);

        txResult.setEditable(false);
        txResult.setColumns(20);
        txResult.setFont(new java.awt.Font("Menlo", 0, 12)); // NOI18N
        txResult.setRows(5);
        txResult.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Committers", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Menlo", 0, 12))); // NOI18N
        jScrollPane3.setViewportView(txResult);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Properties");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Analyze");

        menuCommit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        menuCommit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uff/ic/gems/tipmerge/icons/commits.png"))); // NOI18N
        menuCommit.setText("Commits");
        menuCommit.setEnabled(false);
        menuCommit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCommitActionPerformed(evt);
            }
        });
        jMenu2.add(menuCommit);

        menuDependence.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_MASK));
        menuDependence.setText("Dependencies");
        menuDependence.setEnabled(false);
        menuDependence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDependenceActionPerformed(evt);
            }
        });
        jMenu2.add(menuDependence);

        menuFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK));
        menuFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/uff/ic/gems/tipmerge/icons/search99.png"))); // NOI18N
        menuFile.setText("Files");
        menuFile.setEnabled(false);
        menuFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileActionPerformed(evt);
            }
        });
        jMenu2.add(menuFile);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Assign");

        menuAssign.setText("Ranking");
        menuAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssignActionPerformed(evt);
            }
        });
        jMenu4.add(menuAssign);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Help");

        jMenuItem4.setText("About");
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
	//Allows user to select a project in a directory and show basics information (total merges, total branches, last commit, ...)
    private void btSelectProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelectProjectActionPerformed
		JFileChooser projetctFile = new JFileChooser(new File(jtPathToProjects.getText()));
		projetctFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = projetctFile.showDialog(this.getParent(),"Select");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String path = projetctFile.getSelectedFile().getParentFile().toString();
			jtPathToProjects.setText(path);
			jtProjectName.setText(projetctFile.getSelectedFile().getName());
					
			try {
				
				repository = new RepositoryDao(projetctFile.getSelectedFile()).getRepository();
							
				txCommits.setText(repository.getCommits().toString());
                                txLast.setText(repository.getLastCommit().format(
                                    DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.US)));
                                
				txTotalMerges.setText(String.valueOf(repository.getListOfMerges().size()));
				txTotalAuthors.setText(String.valueOf(repository.getCommitters().size()));
				txTotalBranches.setText(String.valueOf(repository.getBranches().size()));
				btShow.setEnabled(true);
				menuCommit.setEnabled(true);
				menuFile.setEnabled(true);
				menuDependence.setEnabled(true);
				clearAllFields();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, 
					"Please, select a git project folder.",
					"Inane error",
					JOptionPane.ERROR_MESSAGE);
			}

		}

    }//GEN-LAST:event_btSelectProjectActionPerformed

	
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
/*		JFileChooser fcPath = new JFileChooser();
		fcPath.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fcPath.showSaveDialog(this.getParent());
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			jtPathToProjects.setText(fcPath.getSelectedFile().toString());
			jtProjectName.setText(null);
		}
*/
    }//GEN-LAST:event_jMenuItem1ActionPerformed
	//shows the committers name information and the Jtree with the merge branch information 
    private void btShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btShowActionPerformed
		clearAllFields();
		
		//show committers (basic information)in order - Get an array list and transforms an array and orders
		Committer[] committers = new Committer[repository.getCommitters().size()];
		for (int i =0 ; i< repository.getCommitters().size() ; i++)
			committers[i]= repository.getCommitters().get(i);
		Arrays.sort(committers);
		for (Committer cmtr : committers){
			txResult.append(formatted(cmtr.getName(),30) + "\t" + cmtr.getEmail() + "\n");
		}
		

		//txResult.setText(this.repository.getAuthors().toString());
		updateJTree();

    }//GEN-LAST:event_btShowActionPerformed
	//Directs for the commits analysis
    private void menuCommitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCommitActionPerformed
        JFrameCommitsAnalysis commits = new JFrameCommitsAnalysis(this.repository);
		commits.setLocationRelativeTo(this.getFocusOwner());
		commits.setVisible(true);
    }//GEN-LAST:event_menuCommitActionPerformed
	//Directs for the files analysis
    private void menuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileActionPerformed
        JFrameFilesAnalysis files = new JFrameFilesAnalysis(repository);
		files.setLocationRelativeTo(this.getFocusOwner());
		files.setVisible(true);
    }//GEN-LAST:event_menuFileActionPerformed

    private void menuDependenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDependenceActionPerformed
        JFrameDependencies filesDependence = new JFrameDependencies(repository);
		filesDependence.setLocationRelativeTo(this.getFocusOwner());
		filesDependence.setVisible(true);
    }//GEN-LAST:event_menuDependenceActionPerformed

    private void menuAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAssignActionPerformed
        JFrameAssignMerge jfAssignMerge = new JFrameAssignMerge(repository);
		jfAssignMerge.setLocationRelativeTo(this.getFocusOwner());
		jfAssignMerge.setVisible(true);
    }//GEN-LAST:event_menuAssignActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSelectProject;
    private javax.swing.JButton btShow;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTree jTree1;
    private javax.swing.JTextField jtPathToProjects;
    private javax.swing.JTextField jtProjectName;
    private javax.swing.JMenuItem menuAssign;
    private javax.swing.JMenuItem menuCommit;
    private javax.swing.JMenuItem menuDependence;
    private javax.swing.JMenuItem menuFile;
    private javax.swing.JTextField txCommits;
    private javax.swing.JTextField txLast;
    private javax.swing.JTextArea txResult;
    private javax.swing.JTextField txTotalAuthors;
    private javax.swing.JTextField txTotalBranches;
    private javax.swing.JTextField txTotalMerges;
    // End of variables declaration//GEN-END:variables

	
	private void clearAllFields() {
		txResult.setText("");
		txResult.update(txResult.getGraphics());

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
		jTree1.setModel(new javax.swing.tree.DefaultTreeModel(root));
        jScrollPane1.setViewportView(jTree1);

	}

	private void updateJTree() {
		jTree1 = new JTreeRepository(this.repository);
		jScrollPane1.setViewportView(jTree1);		
	}
	
	//Sets a size for one string - It is used to display the names of developers in 30 characters
	private String formatted(String string, int tam){
		if (string.length() >= tam)
			return string.substring(0,tam);
		else
			return string.concat("                                                      ").substring(0,tam);
	}
 
}
