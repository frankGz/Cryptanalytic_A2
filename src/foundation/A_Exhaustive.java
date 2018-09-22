package foundation;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import util.CryptoTools;

public class A_Exhaustive {
	
	public static void main(String[] args) throws Exception {
		byte[] ct = CryptoTools.fileToBytes("data/MSG3.ct");
		Map<int[], Integer> pairs= new HashMap<>();
		for(int a = 1; a < 26; a++) {
			try {
				BigInteger inverse = BigInteger.valueOf(a).modInverse(BigInteger.valueOf(26));
				for(int b = 0; b < 26; b++) {
					//for every (a,b)
					byte[] test = new byte[ct.length];
					for(int i = 0; i < ct.length; i++) {
						test[i] = (byte) ((inverse.intValue()*(ct[i] - 'A' - b + 26))%26 + 'A');
					}
					
					int[] frequences;
					frequences = CryptoTools.getFrequencies(test);
					
					int sum = 0;
					for(int k = 0; k < 26; k++) {
						sum += CryptoTools.ENGLISH[k] * frequences[k];
					}
					int[] pair = new int[2];
					pair[0] = a;
					pair[1] = b;
					pairs.put(pair, sum);
					System.out.println((char) (a+'A') + "," + (char) (b+'A') + " -->" + sum);
				}
			} catch (ArithmeticException e) {
				System.out.println("'" + (char) (a + 'A') + "' is not invertble!");
			}
		}
		int[] resultPair = maxPair(pairs);
		System.out.println("Max dot product pair: " + (char) (resultPair[0] + 'A') + "," + (char) (resultPair[1] + 'A'));
	}
	
	
	public static int[] maxPair(Map<int[], Integer> dotProductMap) {
		Map.Entry<int[], Integer> maxEntry = null;
		int[] pair;

		for (Map.Entry<int[], Integer> entry : dotProductMap.entrySet())
		{
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
		    {
		        maxEntry = entry;
		    }
		}
		
		pair = maxEntry.getKey();
		return pair;
	}
}
