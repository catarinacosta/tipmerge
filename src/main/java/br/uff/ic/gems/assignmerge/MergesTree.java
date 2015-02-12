/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.gems.assignmerge;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

/**
 *
 * @author j2cf
 */
public class MergesTree extends JTree{
	
	GitProject project;

	public MergesTree(GitProject project) {
		this.project = project;
		update();
	}
	
	public void update(){
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(project.getProjectDirectory().getName());
		
		DefaultMutableTreeNode mergeBranchesNode = new DefaultMutableTreeNode("Merges of Branches");
		DefaultMutableTreeNode allMergesNode = new DefaultMutableTreeNode("All Merges");
		int mergeSeq = 1;
		for(MergeBranches merge : project.getMerges()){
			DefaultMutableTreeNode nodeMerge = new DefaultMutableTreeNode(merge.getCommitHash());
			
			DefaultMutableTreeNode bOne = (new DefaultMutableTreeNode("Branch One"));
			DefaultMutableTreeNode bTwo = (new DefaultMutableTreeNode("Branch Two"));
			DefaultMutableTreeNode both = (new DefaultMutableTreeNode("Both branches"));

			if (merge.isMergeOfBranches()){
				
				nodeMerge = new DefaultMutableTreeNode("Merge " + mergeSeq++ + " "  + merge.getCommitHash());
				
				for(CommitAuthor author : merge.getAuthorsBranchOne()){
					bOne.add(new DefaultMutableTreeNode(author.toString()));

				}
				for(CommitAuthor author : merge.getAuthorsBranchTwo()){
					bTwo.add(new DefaultMutableTreeNode(author.toString()));
				}

				if (merge.getAuthorsInCommon() != null){
					for(CommitAuthor author : merge.getAuthorsInCommon()){
						both.add(new DefaultMutableTreeNode(author.toString()));
					}
					nodeMerge.add(both);
				}
				nodeMerge.add(bOne);
				nodeMerge.add(bTwo);
				mergeBranchesNode.add(nodeMerge);
				allMergesNode.add((MutableTreeNode) nodeMerge.clone());
			}else
				allMergesNode.add(nodeMerge);

		}
		root.add(mergeBranchesNode);
		root.add(allMergesNode);
		this.setModel(new DefaultTreeModel(root));
	}
	
	
}
