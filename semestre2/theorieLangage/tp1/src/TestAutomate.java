public class TestAutomate {


    static Automate automate =
            new Automate(
                            0,
			    new Integer[] {0,2},
		            new int[][] {{0,1},
					 {3,2},
					 {0,2},
					 {3,3}}
			 ); 


    public static void main(String args[]) {
        if (args.length < 1) {
            System.err.println("Usage : TestAutomate mots ...");
            System.exit(1);
        }
        for (int i = 0; i < args.length; i++) {
           String arg = args[i];
	   boolean r = automate.reconnait(arg);
	   System.out.println("\"" + arg + "\"" + (r ? " est" : " n'est pas") + " reconnu\n"); 
        }
    }
}

