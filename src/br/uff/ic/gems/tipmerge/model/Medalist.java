package br.uff.ic.gems.tipmerge.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * This class has information about Committers who have medals.
 *
 * @author Eduardo
 */
public class Medalist {

    private Committer committer;
    private List<String> goldListBranch1 = new ArrayList();
    private List<String> goldListBranch2 = new ArrayList();
    private List<String> silverList = new ArrayList();
    private Set<String> bronzeList = new HashSet<>();

    public Medalist(Committer committer) {
        this.committer = committer;
    }

    public Committer getCommitter() {
        return committer;
    }

    /*
    public void setCommitter(Committer committer) {
        this.committer = committer;
    }
     */

    public int getGoldMedals() {
        //TODO como contar as medalhas de ouro
        return getGoldListBranch1().size() + getGoldListBranch2().size();

    }

    public List<String> getGoldListBranch1() {
        return goldListBranch1;
    }

    public List<String> getGoldListBranch2() {
        return goldListBranch2;
    }

    public void setgoldListBranch1(List<String> files) {
        this.goldListBranch1 = files;
    }

    public void setgoldListBranch2(List<String> files) {
        this.goldListBranch2 = files;
    }

    public int getSilverMedals() {
        return silverList.size();
    }

    public void setsilverList(List<String> files) {
        this.silverList = files;
    }

    public List<String> getSilverList() {
        return this.silverList;
    }

    public int getBronzeMedals() {
        return bronzeList.size();
    }

    public void setBronzeList(Set<String> files) {
        this.bronzeList = files;
    }

    public Set<String> getBronzeList() {
        return this.bronzeList;
    }

    public void addGoldMedalBranch1(String fileName) {
        this.getGoldListBranch1().add(fileName);
    }

    public void addGoldMedalBranch2(String fileName) {
        this.getGoldListBranch2().add(fileName);
    }

    public void addSilverMedal(String fileName) {
        this.silverList.add(fileName);
    }

    public void addBronzeMedal(String fileName) {
        this.bronzeList.add(fileName);
    }

    @Override
    public String toString() {
        return this.getCommitter().getName().substring(0, Math.min(20, this.getCommitter().getName().length())) + "\t"
                + this.getGoldMedals() + "\t"
                + this.getSilverMedals() + "\t"
                + this.getBronzeMedals();

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.committer);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medalist other = (Medalist) obj;
        if (!Objects.equals(this.committer, other.committer)) {
            return false;
        }
        return true;
    }

    public Map<String, Integer[]> getFilesList() {
        //Integer[] medals = new Integer[3];

        Map<String, Integer[]> res = new HashMap<>();
        for (String file : this.bronzeList) {
            if (res.containsKey(file)) {
                res.put(file, new Integer[]{res.get(file)[0], res.get(file)[1], res.get(file)[2] + 1});
            } else {
                res.put(file, new Integer[]{0, 0, 1});
            }
        }
        for (String file : this.silverList) {
            if (res.containsKey(file)) {
                res.put(file, new Integer[]{res.get(file)[0], res.get(file)[1] + 1, res.get(file)[2]});
            } else {
                res.put(file, new Integer[]{0, 1, 0});
            }
        }
        for (String file : this.goldListBranch1) {
            if (res.containsKey(file)) {
                res.put(file, new Integer[]{res.get(file)[0] + 1, res.get(file)[1], res.get(file)[2]});
            } else {
                res.put(file, new Integer[]{1, 0, 0});
            }
        }
        for (String file : this.goldListBranch2) {
            if (res.containsKey(file)) {
                res.put(file, new Integer[]{res.get(file)[0] + 1, res.get(file)[1], res.get(file)[2]});
            } else {
                res.put(file, new Integer[]{1, 0, 0});
            }
        }

        /*        
        Set<String> result = new HashSet<>();
        result.addAll(this.bronzeList);
        result.addAll(this.silverList);
        result.addAll(this.goldListBranch1);
        result.addAll(this.goldListBranch2);
         */
        return res;
    }

}
