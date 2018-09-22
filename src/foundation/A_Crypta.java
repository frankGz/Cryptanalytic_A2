package foundation;

import util.CryptoTools;

public class A_Crypta {
	public static void main(String[] args) throws Exception {
		byte[] ct = CryptoTools.fileToBytes("data/MSG3.ct");
		int[] frequences = CryptoTools.getFrequencies(ct);
		for(int i = 0; i < frequences.length; i ++) {
			System.out.println((char)(i+'A') + " --> " + (double)frequences[i] / (double)frequences.length);
		}
	}
}
