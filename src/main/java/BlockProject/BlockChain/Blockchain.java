package BlockProject.BlockChain;
import BlockProject.Transaction.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Blockchain {
	public static ArrayList<Block> blockchain ;
	public static int difficulty = 5;
	public static HashMap<String,TransactionOutput> UTXOs ;

	
	public Blockchain() {
		blockchain = new ArrayList<Block>();
		UTXOs = new HashMap<String,TransactionOutput>(); //list of all unspent transactions.
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
		blockchain.add(newBlock);
	}
}
