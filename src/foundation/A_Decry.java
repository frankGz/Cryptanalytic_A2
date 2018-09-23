package foundation;

import java.math.BigInteger;

import util.CryptoTools;

public class A_Decry {
	
		public static void main(String[] args) throws Exception {
			byte[] ct = CryptoTools.fileToBytes("data/MSG3.ct");
			byte[] pt = new byte[ct.length];
			int a = 'F' - 'A';
			int b = 'O' - 'A';
			BigInteger inverse = BigInteger.valueOf(a).modInverse(BigInteger.valueOf(26));
			
			for(int i = 0; i < ct.length; i++) {
				pt[i] = (byte) ((inverse.intValue()*(ct[i] - 'A' - b + 26))%26 + 'A');
			}
			
			String string = new String(pt);
			System.out.println(string);
		}
}
