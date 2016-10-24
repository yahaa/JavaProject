import java.util.*;
import java.io.BufferedInputStream;
public class HaffmanTest{
	private Scanner input=new Scanner(new BufferedInputStream(System.in));
	private PriorityQueue<Tree>qu=new PriorityQueue<Tree>();
	private Tree haffmanTree=null;
	private int id;
	private String []in=null;
<<<<<<< HEAD
	private int []ttt;
=======
	private int []inNumbet;
>>>>>>> f24c3b0f593c53a98db296838f13d34c0b239e0b
	private Map<String,String>mp=new HashMap<String,String>();

	private void clearQu(){
		while(!qu.isEmpty())qu.poll();
		id=0;
	}

	public void solve(){
		int t=input.nextInt();
		for(int i=1;i<=t;i++){
			clearQu();
			int n=input.nextInt();
			in=new String[n];
<<<<<<< HEAD
			ttt=new int[n];
=======
			inNumbet=new int[n];
>>>>>>> f24c3b0f593c53a98db296838f13d34c0b239e0b
			for(int k=0;k<n;k++){
				int value=input.nextInt();
				qu.offer(new Tree(value,id));
				in[k]=value+" "+id;
<<<<<<< HEAD
				ttt[k]=value;
=======
				inNumbet[k]=value;
>>>>>>> f24c3b0f593c53a98db296838f13d34c0b239e0b
				id++;
			}
			buildTree();
			System.out.println("Case "+i);
			haffmanTree.preOrder(haffmanTree,"",mp);
			for(int ii=0;ii<n;ii++){
<<<<<<< HEAD
				System.out.println(ttt[ii]+" "+mp.get(in[ii]));
=======
				System.out.println(inNumbet[ii]+" "+mp.get(in[ii]));
>>>>>>> f24c3b0f593c53a98db296838f13d34c0b239e0b
			}
			
		}
	}

	private void buildTree(){
		while(qu.size()>1){
			Tree t1=qu.poll();
			Tree t2=qu.poll();
			int v=t1.getValue()+t2.getValue();
			Tree node=new Tree(v,id++);
			node.setLeftChild(t2);
			node.setRightChild(t1);
			qu.offer(node);
		}
		haffmanTree=qu.poll();
	}


	public static void main(String[]args){
		HaffmanTest a=new HaffmanTest();
		a.solve();
	}
}

class Tree implements Comparable<Tree>{
	private Integer value=0;
	private Tree leftChild=null;
	private Tree rightChild=null;
	private int nodes=1;
	private int id;
	private String code=null;

	public Tree(){}

	public Tree(int value,int id){
		this.value=value;
		this.id=id;
	}

	public void setLeftChild(Tree leftChild){
		this.leftChild=leftChild;
		nodes+=leftChild.nodes;
	}

<<<<<<< HEAD
	

=======
>>>>>>> f24c3b0f593c53a98db296838f13d34c0b239e0b
	public void setRightChild(Tree rightChild){
		this.rightChild=rightChild;
		this.nodes+=rightChild.nodes;
	}

	public int getValue(){
		return value;
	}

	public void setValue(int value){
		this.value=value;
	}
	public Tree getLeft(){
		return leftChild;
	}

	public boolean leftEmpty(){
		return leftChild==null;
	}

	public boolean rightEmpty(){
		return rightChild==null;
	}

	public Tree getRight(){
		return rightChild;
	}

	public void preOrder(Tree node,String s,Map<String,String> mp){
		if(node.leftEmpty()&&node.rightEmpty()){
			node.code=s;
			mp.put(node.value+" "+node.id,node.code);
			return ;
		}
<<<<<<< HEAD

		preOrder(node.getLeft(),s+"0",mp);
		preOrder(node.getRight(),s+"1",mp);


	}

=======
		preOrder(node.getLeft(),s+"0",mp);
		preOrder(node.getRight(),s+"1",mp);
	}

	
>>>>>>> f24c3b0f593c53a98db296838f13d34c0b239e0b
	public int compareTo(Tree tree){
		if(value<tree.value)return -1;
		else if(value>tree.value)return 1;
		else{
			if(id<tree.id)return 1;
			else if(id>tree.id)return -1;
			else return 0;
		}
	}
<<<<<<< HEAD

=======
	
	@Override
>>>>>>> f24c3b0f593c53a98db296838f13d34c0b239e0b
	public String toString(){
		return value.toString()+" "+code;
	}

}
<<<<<<< HEAD

class Two implements Comparable<Two>{
		int value,id;
		String code;
		public Two(){}
		public Two(int id,int value,String code){
			this.id=id;
			this.code=code;
			this.value=value;
		}

		public String toString(){
			return value+" "+code;
		}

		public int compareTo(Two b){
			if(value<b.value)return 1;
			else if(value>b.value)return -1;
			else {
				if(id<b.id)return 1;
				else if(id>b.id)return -1;
				else return 0;
			}
		}
}
=======
>>>>>>> f24c3b0f593c53a98db296838f13d34c0b239e0b
