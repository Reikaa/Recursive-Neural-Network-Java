package recursivenetwork.abstractnetwork;

import org.nd4j.linalg.api.ndarray.INDArray;

/** This class contains sum of gradients along with the number of 
 * entries in the summation. This is useful during gradient descent since 
 * most updates use average gradient */
public class SumOfGradient {
	
	private final INDArray sumOfGradient;
	private int count;
	
	public SumOfGradient(INDArray gradient) {
		this.sumOfGradient = gradient;
		this.count = 0;
	}
	
	public void addGradient(INDArray gradient) {
		this.sumOfGradient.addi(gradient);
		this.count++;
	}
	
	public INDArray getAverageGradient() {
		if(this.count == 0) {
			return this.sumOfGradient; //returns initial value
		} else {
			return this.sumOfGradient.div(this.count);
		}
	}

}
