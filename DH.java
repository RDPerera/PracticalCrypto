public class DH {
    public static void main(String args[]) {
        int p = 13, g = 6, arglen = args.length;
        long privKey, pubKey, sessionKey;
        if (arglen == 1) {// checking number of arguments
            privKey = Integer.parseInt(args[0]);
            pubKey = ((long) Math.pow(g, privKey)) % p;
            System.out.println("Public Key : " + pubKey);
        } else if (arglen == 2) {
            privKey = Integer.parseInt(args[0]);
            pubKey = Integer.parseInt(args[1]);
            sessionKey = ((long) Math.pow(pubKey, privKey)) % p;
            System.out.println("Session Key : " + sessionKey);
        } else {
            System.out.println("Invaild Arguments! Input PrivKey or PrivKey PubKey As Arguments");
        }
    }
}
