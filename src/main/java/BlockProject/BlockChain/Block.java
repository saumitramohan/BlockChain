package BlockProject.BlockChain;

import java.util.Date;

public class Block {
	// Hash of the current block
	public String hash;
	// Hash of the previous block, helps in validation
	public String previousHash;
	// Simple Message
	private String data; 
	private long timeStamp; 

	//Block Constructor.
	public Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
	}
}
