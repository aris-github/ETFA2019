/**
 * 
 */
package concept.tree;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * @author aris
 * @param <T>
 *
 */
public class GenericTree<T> {

	protected GenericTreeNode<T> root;
	
	public GenericTree (){		
	}
	
	public GenericTree (GenericTreeNode<T> root) {
		this.root = root;
	}

	
	public GenericTree(GenericTree<T> other) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.root = new GenericTreeNode<T>(other.root, true);				
	}
	
	public GenericTreeNode<T> getRoot (){
		return this.root;
	}
	
	   // TODO: might not be good to be here - better a generic tree class
    public List<GenericTreeNode<T>> getLeafNodes(){
    		List<GenericTreeNode<T>> leaves = new ArrayList<GenericTreeNode<T>>();
    		List<GenericTreeNode<T>> descendants = this.root.getDescendantOrSelf();
    		for(GenericTreeNode<T> descendant : descendants) {
    			if(descendant.getChildren().isEmpty())
    				leaves.add(descendant);
    		}
    		return leaves;
    }
    
    // 	TODO: might not be good to be here - better a generic tree class
    public List<GenericTreeNode<T>> getNodesAtDepth(int depth) {
    		    		
    		List<GenericTreeNode<T>> nodes = new ArrayList<GenericTreeNode<T>>();
    		if(depth < 0)
    			return nodes;
    		
    		else if(depth == 0)
    			nodes.add(root);
    		
    		else {
    			List<GenericTreeNode<T>> descendants = root.getDescendantOrSelf();
    			for(GenericTreeNode<T> descendant : descendants) {
    				if(descendant.getDepth() == depth)
    					nodes.add(descendant);
    			}	
    		}
		
		return nodes;
    }
    
	/**
	 * get all leaf nodes of the given node at given distance from the node
	 * notice this is a recursive function, and the given distance is not necessarily the "depth" of a node in the tree
	 * in each iteration, the distance is reduced
	 * @param node
	 * @param depth
	 * @return
	 */
	public List<Set<GenericTreeNode<T>>> getLeafNodeSetsAtDistance(GenericTreeNode<T> node, int dist){
		List<Set<GenericTreeNode<T>>> sets = new ArrayList<Set<GenericTreeNode<T>>>();
		
		if(dist <= 0)
			return null;
		
//		if(dist == 0){
//			List<SimpleTreeNode<OWLClassExpression>> set = new ArrayList<SimpleTreeNode<OWLClassExpression>>();
//			set.add(node);
//			sets.add(set);
//			return sets;
//		}
		
		if(dist == 1) {
			Set<GenericTreeNode<T>> childSet = new HashSet<GenericTreeNode<T>>();
			for(GenericTreeNode<T> child : node.getChildren()) {
				if(child.isLeaf()) {
					childSet.add(child);
				}
			}
			sets.add(childSet);
			return sets;
		}
		
		else {
			for(GenericTreeNode<T> child : node.getChildren()) {
				sets.addAll(getLeafNodeSetsAtDistance(child, dist-1));
			}
		}
		
		return sets;
	}
    
    public String toString() {
    		return root.toString();
    }
    
    /**
     * print the tree where each line has a fixed indent 
     * @param indent the number of white spaces preceding the string
     * @return
     */
    public String toStringWithIndent (int indents) {
    		return root.toStringWithIndent(indents);
    }
    
}
