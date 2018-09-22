package foundation;


import util.CryptoTools;

public class C_Encrypt {
	
	public static void main(String[] args) throws Exception
	{
		int key = 19;
		byte[] bytes = CryptoTools.fileToBytes("data/MSG1.pt");
		byte[] pt = CryptoTools.clean(bytes);
		CryptoTools.bytesToFile(pt, "data/MSG1.clean");
		byte[] ct = new byte[pt.length];
		for(int i = 0; i < pt.length; i ++) {
			//byte ptb = pt[i];
			//byte ctb = (byte)((ptb + k)% 26);
			ct[i] = (byte) (((pt[i] - 'A')+key + 26) % 26 + 'A');
		}
		
		System.out.println(CryptoTools.getMD5(ct));
		System.out.println(CryptoTools.getIC(pt));
		
		
	}

}
