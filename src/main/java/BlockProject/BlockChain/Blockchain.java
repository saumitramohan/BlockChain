package BlockProject.BlockChain;
import BlockProject.Transaction.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Blockchain {
	public static float minimumTransaction = 0.1f;

	public static ArrayList<Block> blockchain = blockchain = new ArrayList<Block>();
	public static int difficulty = 5;
	public static HashMap<String,TransactionOutput> UTXOs = UTXOs = new HashMap<String,TransactionOutput>();
	
	
	

	
	public Blockchain() {
		//blockchain = new ArrayList<Block>();
		 //list of all unspent transactions.
	}
	
	public static Boolean isChainValid() {
		Block currentBlock; 
		Block previousBlock;
		
		//loop through blockchain to check hashes:
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			//compare registered hash and calculated hash:
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			//compare previous hash and registered previous hash
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
		}
		return true;
	}
	
	
	public static void addBlock(Block newBlock) {
		newBlock.mineBlock(difficulty);
		blockchain.add(newBlock);
	}
}
