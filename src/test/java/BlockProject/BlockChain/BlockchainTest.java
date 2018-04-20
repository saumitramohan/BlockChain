package BlockProject.BlockChain;

public class BlockchainTest {
	
public static void main(String[] args) {
		
		Block genesisBlock = new Block("Genesis Block", "0");
		System.out.println("Hash for block 1 : " + genesisBlock.hash);
		
		Block secondBlock = new Block("Second block in the chain",genesisBlock.hash);
		System.out.println("Hash for block 2 : " + secondBlock.hash);
		
		Block thirdBlock = new Block("Third block in the chain",secondBlock.hash);
		System.out.println("Hash for block 3 : " + thirdBlock.hash);
		
	}
}

