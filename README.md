# README #

This repository contains a generic implementation of Simple Recursive Neural Network in java. It uses dl4j and nd4j libraries (version >= 3.6).

### What is this repository for? ###

* Contains implementation of Simple Recursive Neural Network in java
* Version 3.7 dl4j

### How do I set up? ###

* Clone the project.
* Run the unit test `SimpleRecursiveTreeNetworkUnitTest.java`.

Custom project
* Create a list of trees and set up their leaf-vectors and 
  initialize their gradients. See unit test to see gain insights.
* Iterate over training trees and backprop the errors over any loss      
  function of your choice. You can use loss functions in dl4j.
* Make prediction on test trees using feedForward function.
* You can use the Abstract class to define your own composition function for 
  every node. You can thus create an RNTN or each node can be a neural network 
  itself!

### Contribution guidelines ###

Add your name to the contributors list if you do the following:

* If you fix errors or bug that affect accuracy or performance.
* Add another example such as create RNTN etc.
* Integrate with dl4j by adding adaptive learning rates, momentum etc. 

Please send an email to the repo. owner in that case.

### Who do I talk to? ###

* **Repo owner:** Dipendra Misra, PhD student at Cornell Univ. (dkm@cs.cornell.edu)
* **Dl4j, Nd4j contact:** Adam  Gibson, Founder Skymind
  for dl4j, nd4j queries use this.
  https://gitter.im/deeplearning4j/deeplearning4j