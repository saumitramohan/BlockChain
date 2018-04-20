package BlockProject.Transaction;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

import BlockProject.Cryptography.DigitalSignatureUtil;

public class Transactions {
	
	public String transactionId; // this is also the hash of the transaction.
	public PublicKey sender; // senders address/public key.
	public PublicKey reciepient; // Recipients address/public key.
	public float value;
	public byte[] signature; // this is to prevent anybody else from spending funds in our wallet.
	
	public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
	public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();
	
	private static int sequence = 0; // a rough count of how many transactions have been generated. 
	
	// Constructor: 
	public Transactions(PublicKey from, PublicKey to, float value,  ArrayList<TransactionInput> inputs) {
		this.sender = from;
		this.reciepient = to;
		this.value = value;
		this.inputs = inputs;
	}
	
	// This Calculates the transaction hash (which will be used as its Id)
	private String calulateHash() {
		sequence++; //increase the sequence to avoid 2 identical transactions having the same hash
		return DigitalSignatureUtil.applyHash(
				DigitalSignatureUtil.getStringFromKey(sender) +
				DigitalSignatureUtil.getStringFromKey(reciepient) +
				Float.toString(value) + sequence
				);
	}
	
	public void generateSignature(PrivateKey privateKey) {
		String data = DigitalSignatureUtil.getStringFromKey(sender) + DigitalSignatureUtil.getStringFromKey(reciepient) + Float.toString(value)	;
		signature = DigitalSignatureUtil.applyECDSASig(privateKey,data);		
	}
	
	public boolean verifySignature() {
		String data = DigitalSignatureUtil.getStringFromKey(sender) + DigitalSignatureUtil.getStringFromKey(reciepient) + Float.toString(value)	;
		return DigitalSignatureUtil.verifyECDSASig(sender, data, signature);
	}
}