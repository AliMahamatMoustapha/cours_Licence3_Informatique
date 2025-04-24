package schedules.basicconstraints;
//import schedulestests.basicconstraints.MeetConstraintTests;
//import schedulestests.basicconstraints.PrecedenceConstraintTests;
import schedulestests.basicconstraints.PrecedenceConstraintWithGapTests;
public class Demo {
    public static void main(String[] args) {
        boolean ok = true;
       /*  PrecedenceConstraintTests precedenceTester = new PrecedenceConstraintTests();
        ok = ok && precedenceTester.testGetFirst();
        ok = ok && precedenceTester.testGetSecond();
        ok = ok && precedenceTester.testIsSatisfiedBy();*/       
        PrecedenceConstraintWithGapTests precedenceConstraintWithGapTester = new PrecedenceConstraintWithGapTests();
        ok = ok && precedenceConstraintWithGapTester.testExtends();
        ok = ok && precedenceConstraintWithGapTester.testGetFirst();
        ok = ok && precedenceConstraintWithGapTester.testGetSecond();
        ok = ok && precedenceConstraintWithGapTester.testIsSatisfiedBy();
        System.out.println(ok ? "All tests passed PrecedenceConstraintTests" : "At least one test failed");

        /* ok =false;
        MeetConstraintTests meetTester = new MeetConstraintTests();
        ok = ok && meetTester.testGetFirst();
        ok = ok && meetTester.testGetSecond();
        ok = ok && meetTester.testIsSatisfiedBy();
        System.out.println(ok ? "All tests passed MeetConstraintTests" : "At least one test failed");
        */
    }
}
