import java.util.*;
import java.io.*;
import java.math.*;


/*
** THIS SOLUTION IS ONLY 90% CORRECT!!!
*/
class Solution {

    public static void main(String args[]) {
        Teads obj = new Teads();
        obj.execute();
    }
}

class TreeNode implements Serializable {
    private int value;
    private TreeNode parent;
    private List<TreeNode> children;
    private boolean leaf;
    
    public TreeNode(int value) {
        this.value = value;
        this.parent = null;
        this.children = null;
        this.leaf = true;
    }
    
    public TreeNode() {
        this.value = -1;
        this.parent = null;
        this.children = null;
        this.leaf = true;
    }   
    
    public int getValue() {
        return this.value;
    }
    public TreeNode getParent() {
        return this.parent;
    }
    public List<TreeNode> getChildren() {
        return this.children;
    }

    public void addChild(TreeNode child) {
        if (children == null) {
            children = new LinkedList<TreeNode>();
        }
        this.children.add(child);
    }
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
    public void setLeaf(boolean val) {
        this.leaf = val;   
    }
    
    public boolean isLeaf() {
        return this.leaf;
    }
    public boolean hasParent() {
        return parent == null ? false : true;   
    }
    
    @Override
    public int hashCode() {
        return this.value;
    }
    @Override
    public boolean equals(Object obj) {
        if (this.getValue() == ((TreeNode)obj).getValue())
            return true;
        return false;
    }
}

class Teads {
    private int n;
    private Map<Integer, TreeNode> map;
    private Set<TreeNode> mixedLeafs;
    private Set<TreeNode> leafs;
    
    public Teads () {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); // the number of adjacency relations
        map = new HashMap<Integer,TreeNode>();
        leafs = new HashSet<TreeNode>();
        
        for (int i = 0; i < n; i++) {
            int xi = in.nextInt(); // the ID of a person which is adjacent to yi
            int yi = in.nextInt(); // the ID of a person which is adjacent to xi
            
            TreeNode tmpNx;            
            TreeNode tmpNy;
           
            if (map.containsKey(xi)) {
                tmpNx = map.get(xi);
                tmpNx.setLeaf(false);
            }
            else {
                tmpNx = new TreeNode(xi);
                map.put(xi, tmpNx);
            }
               
            if (map.containsKey(yi)) {
                tmpNy = map.get(yi);
                tmpNy.setLeaf(false);
            }
            else {
                tmpNy = new TreeNode(yi);
                tmpNy.setLeaf(true);
                map.put(yi, tmpNy);
            }
            tmpNx.addChild(tmpNy);
            tmpNy.setParent(tmpNx);
            
            if (tmpNy.isLeaf())
                leafs.add(tmpNy);
        }                
    }
    
    public void execute() {
        int answer = 0, diameter = 0, countFromRootToMiddle = 0, halfDiameter = 0, tempAnswer = 0;
        Stack<TreeNode> maxLen = new Stack<>();
        
        TreeNode highestNode = new TreeNode();
        TreeNode middleNode = new TreeNode();
        TreeNode smallestNode = new TreeNode();
        
        TreeNode rootNode = new TreeNode();
        TreeNode tempNode = new TreeNode();
        
        for (TreeNode each : leafs) {
            if (each.isLeaf()) {
                int count = 1;
                countFromRootToMiddle = 1;                
                rootNode = each;
                
                while (rootNode.hasParent()) {
                    rootNode = rootNode.getParent();
                    count++;
                }
                tempNode = rootNode;
               
                while (true) {
                    List<TreeNode> tL = rootNode.getChildren();
                
                    if (tL != null) {
                        if (tL.size() == 1) {
                            countFromRootToMiddle++;
                            rootNode = tL.get(0);
                        }
                        else {
                            break;
                        }
                    } 
                    else {
                        break;
                    }        
                }
                            
                if (count > diameter) {                    
                    highestNode = tempNode;
                    smallestNode = each;
                    middleNode = rootNode;
                    diameter = count;
                    halfDiameter = diameter/2;                   
                    tempAnswer = diameter - countFromRootToMiddle;
                }
            }
        }
        int lengthOfBranch = 0;
        boolean finished = false;      
        TreeNode helpNode = new TreeNode();
        
        for (TreeNode each : leafs) {
            if (!each.equals(smallestNode) && each.isLeaf()) {
                helpNode = each;
                lengthOfBranch = 0;
                while (helpNode.hasParent()) {
                    helpNode = helpNode.getParent();
                    lengthOfBranch++;
                    if (helpNode.equals(middleNode)) {
                        finished = true;
                        break;
                    }
                }
                if (finished)
                    break;
            }
        }
        if ((tempAnswer - countFromRootToMiddle + lengthOfBranch) > diameter)
            answer = tempAnswer;
        else
            answer = halfDiameter;
            
        System.out.println(answer);
    }
}

