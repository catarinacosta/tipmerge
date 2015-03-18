/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.gems.tipmerge.dao;

import br.uff.ic.gems.tipmerge.model.Repository;
import br.uff.ic.gems.tipmerge.util.RunGit;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class is in charge of setting the repository information from a repository using Gits commands
 * @author j2cf, Catarina
 */
public class RepositoryDao {
	
	private File path = null;
	
	public RepositoryDao(File path){
		this.path = path;
	}
	
	public Repository getRepository(){
		
		//sets the directory and the project name
		Repository repo = new Repository(path);
				
		//set the last commit information
		String[] result = RunGit.getResult("git show -s --format=%ci%x09%H", path).split("\t");
		String data = result[0].substring(0, 19);
		String lastHash = result[1];

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		repo.setLastCommit(LocalDateTime.parse(data, formatter));

		//set the first commit information
		repo.setFirstCommit(RunGit.getResult("git rev-list --max-parents=0 HEAD", path));

		//set the total number of commits information
		repo.setCommits(Long.valueOf(RunGit.getResult("git rev-list HEAD --count", path)));
		
		//set the merges information - only hash information
		repo.setListOfMerges(RunGit.getListOfResult("git log --merges --pretty=%H", path));

		//set the total number of branches information
		repo.setBranches(RunGit.getListOfResult("git branch -a",path));
		//repo.getBranches().remove(1);
		//repo.getBranches().remove(0);
		//repo.getBranches().add(0, " origin/master");
				
		//set the list of authors with the total of commits each author
		repo.setAuthors(RunGit.getListOfResult("git shortlog -sne --no-merges " + repo.getFirstCommit() + ".." + lastHash, path));
		return repo;
	}
	

}
