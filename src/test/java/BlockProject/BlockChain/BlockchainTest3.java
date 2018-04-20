package BlockProject.BlockChain;

import com.google.gson.GsonBuilder;

public class BlockchainTest3 {
	
	public static int difficulty = 5;

	public static void main(String[] args) {	
		//add our blocks to the blockchain ArrayList:
		
		Blockchain blockchain = new Blockchain();
		
		blockchain.addBlock(new Block("Genesis Block", "0"));
		System.out.println("Trying to Mine block 1... ");
		blockchain.blockchain.get(0).mineBlock(difficulty);
		
		blockchain.addBlock(new Block("Second Block",blockchain.blockchain.get(blockchain.blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 2... ");
		blockchain.blockchain.get(1).mineBlock(difficulty);
		
		blockchain.addBlock(new Block("Third Block",blockchain.blockchain.get(blockchain.blockchain.size()-1).hash));	
		System.out.println("Trying to Mine block 3... ");
		blockchain.blockchain.get(2).mineBlock(difficulty);
		
		System.out.println("\nBlockchain is Valid: " + blockchain.isChainValid());
		
		//System.out.println("\nThe block chain");
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain.blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);
	}

}
