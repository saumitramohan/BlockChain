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
	
	private int nonce;

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
				Integer.toString(nonce) +
				this.data 
				);
		return calculatedhash;
	}
	
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}
	
}
