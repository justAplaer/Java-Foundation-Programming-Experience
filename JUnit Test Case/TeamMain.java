public static void main (String[] args)
{
   // Notice that here the cities will be equal. Based on our own compareTo logic, the whole comparison will be
   // run through the nicknames comparsion. -1 and 1 are just the most frequent letters we use when 
   // compareTo method is overrun, but we not necessarily stick with them
   Team team1 = new Team("Almaty_Cadrid");
   Team team2 = new Team("Almaty", "Madrid");
   
   // 'C' - 'M' = -10, which means C is preceding and M's number on java is beager
   System.out.println(team1.compareTo(team2));
    
   Team team3 = new Team("Almaty_Badrid");
   Team team4 = new Team("Almaty", "Madrid");
   
   // 'B' - 'M' = -10. Notice that B number is smaller than C on 1. Because it is right next in
   // the alphabet, hence, since 'C' - 'M' = -10 and 'C' - 'B' = 1, then 'B' - 'M' = -11
   // 'C' = 1 + 'B', hence, 'B' + 1 - 'M' = -10, therefore, 'B' - 'M' = -11 
   System.out.println(team3.compareTo(team4)); 
}