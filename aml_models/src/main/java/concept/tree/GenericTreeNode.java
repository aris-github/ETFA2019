/**
 * 
 */
package concept.tree;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author Yingbing Hua, yingbing.hua@kit.edu
 * A generic tree node class
 */
public class GenericTreeNode<T>{

    public T data;
    private GenericTreeNode<T> parent;
    private Set<GenericTreeNode<T>> children = new HashSet<GenericTreeNode<T>>();
    private static AtomicInteger nextId = new AtomicInteger(0);
    protected int id;
    
    public GenericTreeNode() {
    		this.id = nextId.getAndIncrement();
    }
    
    public T copy (T item) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    		Class<?> classT = item.getClass();
		Constructor<?> copyConstructor = classT.getConstructor(classT);
		
		T copy = (T) copyConstructor.newInstance(item);
		
		return copy;
    }
    
    /**
     * simple copy constructor.
     * It only copies the data from the give node, but not its descending tree structure
     * @param other
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    @SuppressWarnings("unchecked")
	public GenericTreeNode(GenericTreeNode<T> other) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    		this();    		
    		this.data = copy(other.data);    		
    }
    
    public GenericTreeNode(GenericTreeNode<T> other, boolean deeply) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    		this(other);
    		copyChildrenRec(other);
    }
    
	/**
	 * copy the children of the source tree node to the current node
	 * @param node current node
	 * @param source source node
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public void copyChildrenRec(GenericTreeNode<T> source) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// for each child of the source node, make a copy, and add the copy as a child to the current node
		// do it recursively for the children of the child of the source node
		for(GenericTreeNode<T> sourceChild : source.getChildren()) {
			GenericTreeNode<T> childNodeCopy = new GenericTreeNode<T>(sourceChild);
			childNodeCopy.copyChildrenRec(sourceChild);
			this.addChild(childNodeCopy);
		}		
	}

    public GenericTreeNode(T data) {
    		this();
        this.data = data;
//        this.parent = null;
    }

    public void addChild(T child) {
        GenericTreeNode<T> childNode = new GenericTreeNode<T>(child);
        childNode.parent = this;
        this.children.add(childNode);
    }
    
    public void addChild(GenericTreeNode<T> child) {
    		this.children.add(child);
    		child.parent = this;
    }
 
    
    public List<GenericTreeNode<T>> getDescendant(){
    		List<GenericTreeNode<T>> descendants = new ArrayList<GenericTreeNode<T>>();
    		
    		for(GenericTreeNode<T> child : children) {
    			// direct child
    			descendants.add(child);
    			// recursive descendant
    			descendants.addAll(child.getDescendant());
    		}    		
    		return descendants;
    } 
    
    public List<GenericTreeNode<T>> getDescendantOrSelf(){
    		List<GenericTreeNode<T>> descendants = this.getDescendant();
    		descendants.add(this);
    		return descendants;
    }    
 
    public GenericTreeNode<T> getParent(){
    		return this.parent;
    }
    
    // although it is a list, it is already sorted by depth, since it does recursive calls on parent->parent->...
    public List<GenericTreeNode<T>> getAncestor(){
    		List<GenericTreeNode<T>> ancestors = new ArrayList<GenericTreeNode<T>>();
    		if(this.parent != null) {
    			ancestors.add(this.parent);
    			if(this.parent.getAncestor() != null)
    				ancestors.addAll(this.parent.getAncestor());
    		}
    		return ancestors;
    }
    
    public Set<GenericTreeNode<T>> getChildren(){
    		return this.children;
    }
    
    public List<GenericTreeNode<T>> getSibling(GenericTreeNode<T> node) {
		List<GenericTreeNode<T>> siblings = new ArrayList<GenericTreeNode<T>>();
		for(GenericTreeNode<T> sibling : this.parent.children) {
			siblings.add(sibling);
		}		
		return siblings;
	}
    
    /**
     * get the lowest (i.e. deepest) common parent of current node and the other node
     * @param other
     * @return
     */
    public GenericTreeNode<T> getLeastCommonParent(GenericTreeNode<T> other) {
    		GenericTreeNode<T> parent = null;
    		int d = -1;
    		List<GenericTreeNode<T>> ancestor_this = this.getAncestor();
    		ancestor_this.add(this);
    		List<GenericTreeNode<T>> ancestor_other = other.getAncestor();
    		ancestor_other.add(other);
    		for (int i = 0; i < ancestor_this.size(); i++) {    			
    			for (int j = 0; j < ancestor_other.size(); j++) {
    				if(ancestor_this.get(i) == ancestor_other.get(j)){
    					int depth = ancestor_this.get(i).getDepth();
    					if(depth > d) {
    						parent = ancestor_this.get(i);
        					d = depth;	
    					}    					
    				}
    			}
    		}
    		return parent;
    }
    
    public int getDepth() {
    		if(this.parent == null)
    			return 0;
    		else
    			return this.getParent().getDepth()+1;
    }
    
    /**
     * get descendant nodes at a given depth (not to the depth!)
     * @param depth
     * @return
     */
    public List<GenericTreeNode<T>> getDescendantsAtDepth (int depth){
    		if(depth < this.getDepth())
    			return null;
    		
    		List<GenericTreeNode<T>> ret = new ArrayList<GenericTreeNode<T>>();
    		List<GenericTreeNode<T>> descendants = getDescendant();
    		for(GenericTreeNode<T> descendant : descendants) {
    			if(descendant.getDepth() == depth)
    				ret.add(descendant);
    		}
    		
    		return ret;    		
    }
    
    /**
     * get the parent node of the current node until we reach the depth of the given node
     * i.e. all parent nodes above the given node
     * @param node
     * @return
     */
    public List<GenericTreeNode<T>> getParentToNode (GenericTreeNode<T> node) {    	
    		List<GenericTreeNode<T>> ret = new ArrayList<GenericTreeNode<T>>();
    		List<GenericTreeNode<T>> ancestors = this.getAncestor();
    		for(GenericTreeNode<T> ancestor : ancestors) {
    			if(ancestor.getDepth() <= node.getDepth())
    				ret.add(ancestor);
    		}
    		
    		return ret;
    }
    
    public GenericTreeNode<T> getRoot (){
    		if(this.parent == null)
    			return this;
    		else
			return this.parent.getRoot();
    }    
    
    public int getID() {
    		return id;
    }
    
    public void removeChild(GenericTreeNode<T> child) {
		if(children.contains(child))
			children.remove(child);
    }
    
    public boolean isLeaf() {
    		return this.children.isEmpty();    				
    }
    
    @Override
    public int hashCode() {
    		return this.id;
    }

	@Override
	public boolean equals(Object obj) {
	    if (obj == null) return false;
	    if (!(obj instanceof GenericTreeNode<?>))
	        return false;
	    if (obj == this)
	        return true;
	    
	    return 
//	    		this.data.equals( ((SimpleTreeNode<?>) obj).data ) &&
	    		this.id == ((GenericTreeNode<?>) obj).id; 
	}
	
	/**
	 * print the tree structure
	 */
	public String toString() {
		
		String s = "";
		
		s += this.data.toString();	

		for (GenericTreeNode<T> child : this.children) {
			s += "\n";
			for(int i = 0; i < child.getDepth(); i++)
				s += "    ";
			
			s += child.toString();
		}
		
		return s;
	}
	
	
    /**
     * print the tree where each line has a fixed indent 
     * @param indent the indent as a sequence of white spaces
     * @return
     */
	public String toStringWithIndent (int indent) {
		
		String s = "";
		String indents = "";
		for(int i = 0; i < indent; i++)
			indents += " ";
		
		s += indents + this.data.toString();	

		for (GenericTreeNode<T> child : this.children) {	
			String childIndents = indents;
			for(int i = 0; i < child.getDepth(); i++)
				childIndents = "   " + childIndents;
			
			String sc = childIndents + child.toStringWithIndent(indent);
			s += "\n" + sc;
		}
		
		return s;
	}

}