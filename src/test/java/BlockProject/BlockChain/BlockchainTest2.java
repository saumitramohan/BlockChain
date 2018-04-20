package BlockProject.BlockChain;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class BlockchainTest2 {
	
	public static ArrayList<Block> blockchain = new ArrayList<Block>(); 

	public static void main(String[] args) {	
		//add our blocks to the blockchain ArrayList:
		blockchain.add(new Block("Genesis Block", "0"));		
		blockchain.add(new Block("Second Block",blockchain.get(blockchain.size()-1).hash)); 
		blockchain.add(new Block("Third Block",blockchain.get(blockchain.size()-1).hash));
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);		
		System.out.println(blockchainJson);
	}

}
