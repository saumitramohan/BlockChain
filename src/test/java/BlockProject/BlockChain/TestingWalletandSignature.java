package BlockProject.BlockChain;

import java.security.Security;
import java.util.ArrayList;

import BlockProject.Cryptography.DigitalSignatureUtil;
import BlockProject.Transaction.Transactions;
import BlockProject.Wallet.Wallet;

public class TestingWalletandSignature {

		
		public static ArrayList<Block> blockchain = new ArrayList<Block>();
		public static int difficulty = 5;
		public static Wallet walletA;
		public static Wallet walletB;

		public static void main(String[] args) {	
			//Setup Bouncey castle as a Security Provider
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider()); 
			//Create the new wallets
			walletA = new Wallet();
			walletB = new Wallet();
			//Test public and private keys
			System.out.println("Private and public keys:");
			System.out.println(DigitalSignatureUtil.getStringFromKey(walletA.privateKey));
			System.out.println(DigitalSignatureUtil.getStringFromKey(walletA.publicKey));
			//Create a test transaction from WalletA to walletB 
			Transactions transaction = new Transactions(walletA.publicKey, walletB.publicKey, 5, null);
			transaction.generateSignature(walletA.privateKey);
			//Verify the signature works and verify it from the public key
			System.out.println("Is signature verified");
			System.out.println(transaction.verifySignature());
			
		}
}
