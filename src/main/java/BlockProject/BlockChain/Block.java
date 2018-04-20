package BlockProject.BlockChain;

import java.util.Date;

import BlockProject.Cryptography.DigitalSignatureUtil;

public class Block {
	// Digital signature of the current block
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
		//Making sure we do this after we set the other values.
		this.hash = calculateHash();
	}
	
	public String calculateHash() {
		// We want to calculate hash of all data involved
		String calculatedhash = DigitalSignatureUtil.applyHash( 
				this.previousHash +
				Long.toString(timeStamp) +
				this.data 
				);
		return calculatedhash;
	}
}
