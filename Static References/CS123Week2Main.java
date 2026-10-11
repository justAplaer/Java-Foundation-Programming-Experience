// Tair Moldakhmetov CS 123 - Java Data Structures Fall 2026 03/10/2026
// Notice that this program does not have public class {} rapper
// public static void main is here immediately - and the program still runs

public static void main(String[] args)
{
   String[] mainData = {"Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta"};
   System.out.println(StringArrayTools.stringArrayToString(mainData));
   System.out.println();
   
   StringArrayTools.upperCaseAll(mainData);
   System.out.println(StringArrayTools.stringArrayToString(mainData));
   System.out.println();

   StringArrayTools.reverseArray(mainData);
   System.out.println(StringArrayTools.stringArrayToString(mainData));
   System.out.println();

   String[] mainData2;
   mainData2 = StringArrayTools.copyAndReverse(mainData);
   System.out.println(StringArrayTools.stringArrayToString(mainData2));
   System.out.println();

   StringArrayTools.clearArray(mainData);
   System.out.println(StringArrayTools.stringArrayToString(mainData));
   System.out.println(StringArrayTools.stringArrayToString(mainData2));
   System.out.println();
   
   String[] mainData3 = {"test"};
   System.out.println(StringArrayTools.stringArrayToString(mainData3));
   mainData3 = null;
   System.out.println(StringArrayTools.stringArrayToString(mainData3));
}