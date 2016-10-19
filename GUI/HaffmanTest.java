import java.util.*;
public class HaffmanTest{
	public static void main(String[]args){
		Tree t1=new Tree(300);
		Tree t2=new Tree(200);
		System.out.println(t1.compareTo(t2));
		PriorityQueue<Tree>qu=new PriorityQueue<Tree>();
		qu.offer(new Tree(100));
		qu.offer(new Tree(20));
		while(!qu.isEmpty()){
			System.out.println(qu.poll());
		}
	}
}

class Tree implements Comparable<Tree>{
	private Integer value=0;
	private Tree leftChild=null;
	private Tree rightChild=null;
	private int nodes=1;

	public Tree(){}

	public Tree(int value){
		this.value=value;
	}

	public void setLeftChild(Tree leftChild){
		this.leftChild=leftChild;
		nodes+=leftChild.nodes;
	}

	public void setRightChild(Tree right){
		this.rightChild=rightChild;
		nodes+=rightChild.nodes;
	}

	public int getValue(){
		return value;
	}

	public void setValue(int value){
		this.value=value;
	}

	public int compareTo(Tree tree){
		return this.value.compareTo(tree.value);
	}

	public String toString(){
		return value.toString();
	}

}