package foundation;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import util.CryptoTools;

public class C_Exhaustive {
	
	public static void main(String[] args) throws Exception {
		byte[] ct = CryptoTools.fileToBytes("data/MSG2.ct");
		byte[] test = new byte[ct.length];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int[] frequences;
		int i,j,k;
		for(i = 0; i < 26; i++) {
			
			//decrypt the ciphertext into a test byte array
			for(j=0;j<ct.length;j++) {
				test[j] = (byte) (((ct[j] - 'A')- i + 26) % 26 + 'A');
			}
			
			//Compute the frequencies of all letters in the produced test array.
			frequences = CryptoTools.getFrequencies(test);
			
			int sum = 0;
			for(k = 0; k < 26; k++) {
				sum += CryptoTools.ENGLISH[k] * frequences[k];
			}
			
			System.out.println((char) (i+'A') + " -->" + sum);
			map.put(i, sum);
			//largest is the shift
		}
		
		Entry<Integer, Integer> maxEntry = map.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println("Max is: " + (char)(maxEntry.getKey() + 'A') + " --> " + maxEntry.getValue());
	}
}
