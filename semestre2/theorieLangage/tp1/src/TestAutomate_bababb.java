public class TestAutomate_bababb {
    static Automate automate =
            new Automate(
                            0,
			    new Integer[] {6},
		        new int[][] {
                     {0,1},
					 {2,1},
					 {0,3},
					 {4,1},
                     {0,5},
                     {4,6},
                     {2,1}
                    
                    }
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
