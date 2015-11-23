package recursivenetwork.abstractnetwork;

import java.util.Iterator;
import java.util.List;

import org.nd4j.linalg.api.ndarray.INDArray;

/** A tree structure useful with recursive network
 * @author Dipendra Misra (dkm@cs.cornell.edu) */
public class Tree {

	/** for leaves this contains reference to a global leaf vector */
	private INDArray vector;
	/** INDArray before non-linearity is applied */
	private INDArray preOutput; 
	/** gradient is non-null only for leaf nodes. Contains reference. Contains
	 * reference to the unique gradient vector corresponding to the leaf */
	private INDArray gradient;  
	private final String label;
	private final List<Tree> children;
	private final int numChild;
	
	public Tree(String label, List<Tree> children) {
		this.label = label;
		this.children = children;
		this.numChild = children.size();
	}
	
	public int numChildren() {
		return this.numChild;
	}
	
	public Tree getChild(int i) { 
		/* use iterator for trees with large degree */
		return this.children.get(i);
	}
	
	public Iterator<Tree> getChildren() {
		return this.children.iterator();
	}
	
	public INDArray getVector() {
		return this.vector;
	}
	
	public void setVector(INDArray vector) {
		this.vector = vector;
	}
	
	public INDArray getGradient() {
		return this.gradient;
	}
	
	public void setGradient(INDArray gradient) {
		this.gradient = gradient;
	}
	
	/** accumulate gradient so that after a set of backprop through several trees
	 * you can update all the leaf vectors by the sum of gradients. Don't forget to 
	 * clear the gradients after updating. */
	public void addGradient(INDArray gradient) {
		this.gradient.addi(gradient);
		double v = this.gradient.max(1).getDouble(0);
		if(v > 0)
			System.out.println("Gradient Size "+v);
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public INDArray getPreOutput() {
		return this.preOutput;
	}
	
	public void setPreOutput(INDArray preOutput) {
		this.preOutput = preOutput;
	}
 }
