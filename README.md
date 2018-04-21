# BlockChain
First attempt to blockchain technology in java

Step 1 : Create a Block class which makes up block chain
         Block has its own hash and hash of the prev block

Step 2 : Create DigitalSignatureUtil
         It uses already exisiting hashing Java implementation.
         
Step 3: Use the above implemtation to generate hash for each block

Each block now has its own digital signature based on its information and the signature of the previous block.

Step 4: To generate chains of block, I have implemented an ArrayList

Step 5: Implement a method in BlockChain class to validateHash

Step 6: Use mining algorithm to mine the block
