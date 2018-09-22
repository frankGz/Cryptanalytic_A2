package foundation;

import java.io.ByteArrayOutputStream;

import util.CryptoTools;

public class Vig
{

	public static void main(String[] args) throws Exception
	{
		byte[] ct = CryptoTools.fileToBytes("data/CT");
		for (int keyLen = 8; keyLen < 9; keyLen++)
		{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			for (int pos = 0; pos < ct.length; pos += keyLen)
			{
				baos.write(ct[pos]);
			}
			byte[] subset = baos.toByteArray();
			double ic = CryptoTools.getIC(subset);
			System.out.println(keyLen + " --> " + ic);
			int[] f = CryptoTools.getFrequencies(subset);
			for (int i = 0; i < f.length; i++)
			{
				System.out.println((char) (i+'A') + " -->" + f[i]/(double) subset.length);
			}
		}

	}

}