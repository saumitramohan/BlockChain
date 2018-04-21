package BlockProject.BlockChain;

import java.util.ArrayList;
import java.util.Date;

import BlockProject.Cryptography.DigitalSignatureUtil;
import BlockProject.Transaction.Transactions;

public class Block {
	// Digital signature of the current block
	public String hash;
	// Hash of the previous block, helps in validation
	public String previousHash;
	// Simple Message
	private String data; 
	private long timeStamp; 
	
	private int nonce;
	
	public String merkleRoot;
	public ArrayList<Transactions> transactions = new ArrayList<Transactions>(); //our data will be a simple message.

	//Block Constructor.
	public Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		//Making sure we do this after we set the other values.
		this.hash = calculateHash();
	}
	
	public Block(String previousHash ) {
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		
		this.hash = calculateHash(); //Making sure we do this after we set the other values.
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
	
	//Add transactions to this block
			public boolean addTransaction(Transactions transaction) {
				//process transaction and check if valid, unless block is genesis block then ignore.
				if(transaction == null) return false;		
				if((previousHash != "0")) {
					if((transaction.processTransaction() != true)) {
						System.out.println("Transaction failed to process. Discarded.");
						return false;
					}
				}
				transactions.add(transaction);
				System.out.println("Transaction Successfully added to Block");
				return true;
			}
	
}
