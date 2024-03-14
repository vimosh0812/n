import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class playBattle {
    double Archspeed;
    double Magespeed;
    double Knightspeed;
    double Healerspeed;
    double Mythicalspeed;
    
    int Archattack;
    int Mageattack;
    int Knightattack;
    int Healerattack;
    int Mythicalattack;

    double Archhealth;
    double Magehealth;
    double Knighthealth;
    double Healerhealth;
    double Mythicalhealth;

    double Archhealthuser;
    double Magehealthuser;
    double Knighthealthuser;
    double Healerhealthuser;
    double Mythicalhealthuser;

    double Archhealth2;
    double Magehealth2;
    double Knighthealth2;
    double Healerhealth2;
    double Mythicalhealth2;

    double Archhealthuser2;
    double Magehealthuser2;
    double Knighthealthuser2;
    double Healerhealthuser2;
    double Mythicalhealthuser2;
    String minVariable = "";
    String maxVariable = "";
    public String minVariable1 = "";
    String playground="";
    String minVariable2="";
    String minVariable3="";

    String Userchar="";
    String Oppchar="";

    Double Attackuser;
    Double Defenceopp;
    int count=1;
    int playercount=0;
    int opponentcount=0;
    String homeland;
    playBattle(User user, User opponent){
        int turn = 1;
         Archhealth = opponent.getArcher().getHealth();
         Magehealth = opponent.getMage().getHealth();
         Knighthealth = opponent.getKnight().getHealth();
         Healerhealth = opponent.getHealer().getHealth();
         Mythicalhealth = opponent.getMythicalCreature().getHealth();

         Archhealthuser = user.getArcher().getHealth();
         Magehealthuser = user.getMage().getHealth();
         Knighthealthuser = user.getKnight().getHealth();
         Healerhealthuser = user.getHealer().getHealth();
         Mythicalhealthuser = user.getMythicalCreature().getHealth();

            String RESET = "\033[0m";  // Text Reset
            String GREEN = "\033[0;32m";  // GREEN
            String YELLOW = "\033[0;33m";  // YELLOW
            String CYAN = "\033[0;36m";  // CYAN
            String RED = "\033[0;31m";  // RED
            String ORANGE = "\033[0;35m";  // PINK
            String BLUE = "\033[0;34m";  // BLUE

        String homeland=opponent.getPlayground().getName(); 
        while(turn<=20){
            System.out.println(CYAN+"\n"+user.getPlayerName()+"'s turn - " + (turn/2+1)+RESET);
            System.out.println("----------------------\n");

            Attack(user, opponent,homeland);
            turn++;
            
            System.out.println(ORANGE+"\n"+opponent.getPlayerName()+"'s turn - " + turn/2+RESET);
            System.out.println("----------------------\n");
            Attack(opponent, user,homeland);
            turn++;

            if(opponentcount == 5){

                System.out.println(GREEN +user.getPlayerName() +" has won the match");
                System.out.println("\r\n" + //
                                        " __     _____ ____ _____ ___  ______   __\r\n" + //
                                        " \\ \\   / /_ _/ ___|_   _/ _ \\|  _ \\ \\ / /\r\n" + //
                                        "  \\ \\ / / | | |     | || | | | |_) \\ V / \r\n" + //
                                        "   \\ V /  | | |___  | || |_| |  _ < | |  \r\n" + //
                                        "    \\_/  |___\\____| |_| \\___/|_| \\_\\|_|  \r\n" + //
                                        "                                         \r\n" + //
                                        "" + RESET);
                user.increaseXP(1);

                user.addGoldCoins(opponent.getGoldCoins()*0.1);
                opponent.addGoldCoins(-(opponent.getGoldCoins()*0.1));
                System.out.println(user.getPlayerName()+"'s remaing coins "+YELLOW +user.getGoldCoins()+RESET);
                System.out.println(opponent.getPlayerName()+"'s remaing coins "+YELLOW +opponent.getGoldCoins()+RESET);
                break;
            }
            else if(playercount==5){
                System.out.println(RED +opponent.getPlayerName() +" has won the match");
                System.out.println("\r\n" + //
                                        "  ____  _____ _____ _____    _  _____ \r\n" + //
                                        " |  _ \\| ____|  ___| ____|  / \\|_   _|\r\n" + //
                                        " | | | |  _| | |_  |  _|   / _ \\ | |  \r\n" + //
                                        " | |_| | |___|  _| | |___ / ___ \\| |  \r\n" + //
                                        " |____/|_____|_|   |_____/_/   \\_\\_|  \r\n" + //
                                        "                                      \r\n" + //
                                        ""+ RESET);
                opponent.increaseXP(1);
                opponent.addGoldCoins(user.getGoldCoins()*0.1);
                user.addGoldCoins(-(user.getGoldCoins()*0.1));
                System.out.println(user.getPlayerName()+"'s remaing coins "+YELLOW +user.getGoldCoins()+RESET);
                System.out.println(opponent.getPlayerName()+"'s remaing coins "+YELLOW +opponent.getGoldCoins()+RESET);
                break;
            }
            else if (turn==21){
                System.out.println(BLUE +"Battle is draw");
                System.out.println("\r\n" + //
                                        "  ____  ____      ___        __\r\n" + //
                                        " |  _ \\|  _ \\    / \\ \\      / /\r\n" + //
                                        " | | | | |_) |  / _ \\ \\ /\\ / / \r\n" + //
                                        " | |_| |  _ <  / ___ \\ V  V /  \r\n" + //
                                        " |____/|_| \\_\\/_/   \\_\\_/\\_/   \r\n" + //
                                        "                               \r\n" + //
                                        "" + RESET);
                System.out.println(user.getPlayerName()+"'s remaing coins "+ YELLOW +user.getGoldCoins()+RESET);
                System.out.println(opponent.getPlayerName()+"'s remaing coins "+YELLOW +opponent.getGoldCoins()+RESET);
            }
        }
         
        opponent.getArcher().setHealth(Archhealth);
        opponent.getMage().setHealth(Magehealth);
        opponent.getKnight().setHealth(Knighthealth);
        opponent.getHealer().setHealth(Healerhealth);
        opponent.getMythicalCreature().setHealth(Mythicalhealth);

        
        user.getArcher().setHealth(Archhealthuser);
        user.getMage().setHealth(Magehealthuser);
        user.getKnight().setHealth(Knighthealthuser);
        user.getHealer().setHealth(Healerhealthuser);
        user.getMythicalCreature().setHealth(Mythicalhealthuser);
    }


    private void Attack(User user, User opponent,String homeland){
        String CYAN = "\033[0;36m";  // CYAN
        String RESET = "\033[0m";  // Text Reset
        int playcount=0;
        
        if(count==1){
            // display where the batlle is taking place
            System.out.println("The battle is taking place in "+CYAN +homeland+RESET);
            System.out.println();
            playgroundBattle.buffcharacter(homeland, user.getArcher(), true);
            playgroundBattle.buffcharacter(homeland, user.getKnight(), true);
            playgroundBattle.buffcharacter(homeland, user.getMage(), true);
            playgroundBattle.buffcharacter(homeland, user.getHealer(), true);
            playgroundBattle.buffcharacter(homeland, user.getMythicalCreature(), true);

            playgroundBattle.buffcharacter(homeland, opponent.getArcher(), true);
            playgroundBattle.buffcharacter(homeland, opponent.getKnight(), true);
            playgroundBattle.buffcharacter(homeland, opponent.getMage(), true);
            playgroundBattle.buffcharacter(homeland, opponent.getHealer(), true);
            playgroundBattle.buffcharacter(homeland, opponent.getMythicalCreature(), true);
            System.out.println();
            
        }

        count+=1;
        Map<String, Double> speeduser = new LinkedHashMap<>();
        if (!user.getHealer().isDead()){
            speeduser.put("H", user.getHealer().getSpeed());
        }
        if (!user.getMage().isDead()){
            speeduser.put("M", user.getMage().getSpeed());
        }
        if (!user.getMythicalCreature().isDead()){
            speeduser.put("My", user.getMythicalCreature().getSpeed());
        }
        if (!user.getKnight().isDead()){
            speeduser.put("K", user.getKnight().getSpeed());
        }
        if (!user.getArcher().isDead()){
            speeduser.put("A", user.getArcher().getSpeed());
        }
        
        Double max= Double.MIN_VALUE;

        for (Map.Entry<String, Double> entry : speeduser.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxVariable = entry.getKey();
            }
        }
        
        Map<String, Double> defenceopponent = new LinkedHashMap<>();
        if (!opponent.getMage().isDead()){
            defenceopponent.put("M", opponent.getMage().getDefence());
        }
        if (!opponent.getKnight().isDead()){
            defenceopponent.put("K", opponent.getKnight().getDefence());
        }
        if (!opponent.getArcher().isDead()){
            defenceopponent.put("A", opponent.getArcher().getDefence());
        }
        if (!opponent.getMythicalCreature().isDead()){
            defenceopponent.put("My", opponent.getMythicalCreature().getDefence());
        }
        if (!opponent.getHealer().isDead()) {
            defenceopponent.put("H", opponent.getHealer().getDefence());
        }

        
        Double min= Double.MAX_VALUE;

        for (Map.Entry<String, Double> entry : defenceopponent.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                minVariable = entry.getKey();
            }
        }

        
        if (maxVariable == "A") {
             Attackuser=user.getArcher().getAttack();
             Userchar=user.getArcher().getName();
        }
        else if (maxVariable == "K"){
             Attackuser=user.getKnight().getAttack();
             Userchar=user.getKnight().getName();
        }
        else if (maxVariable == "M"){
             Attackuser=user.getMage().getAttack();
             Userchar=user.getMage().getName();
        }
        else if (maxVariable == "H"){
             Attackuser=user.getHealer().getAttack();
             Userchar=user.getHealer().getName();
        }
        else{
             Attackuser=user.getMythicalCreature().getAttack();
             Userchar=user.getMythicalCreature().getName();
        }
        
        
        if (minVariable == "A") {
             Defenceopp=opponent.getArcher().getDefence();
             Oppchar=opponent.getArcher().getName();
             
        }
        else if (minVariable == "K"){
             Defenceopp=opponent.getKnight().getDefence();
             Oppchar=opponent.getKnight().getName();
        }
        else if (minVariable == "M"){
             Defenceopp=opponent.getMage().getDefence();
             Oppchar=opponent.getMage().getName();
        }
        else if (minVariable == "H"){
             Defenceopp=opponent.getHealer().getDefence();
             Oppchar=opponent.getHealer().getName();
        }
        else{
             Defenceopp=opponent.getMythicalCreature().getDefence();
             Oppchar=opponent.getMythicalCreature().getName();
        }

        System.out.println(user.getPlayerName()+"'s "+ CYAN +Userchar+ RESET+" is fighting with "+opponent.getPlayerName()+"'s "+CYAN +Oppchar + RESET);
        double damage;


        if (maxVariable!="H"){
            damage = (0.5*(Attackuser)) - (0.1*(Defenceopp));
            damage = round(damage);
            String RED = "\033[0;31m";  // RED
            System.out.println(RED +"damage: "+RESET + damage); 

            if (minVariable == "A"){
                opponent.getArcher().getdamage(damage);
            }
            else if (minVariable == "K"){
                opponent.getKnight().getdamage(damage);
            }
            else if (minVariable == "M"){
                opponent.getMage().getdamage(damage);
            }
            else if (minVariable == "H"){
                opponent.getHealer().getdamage(damage);
            }
            else{
                opponent.getMythicalCreature().getdamage(damage);
            }
        }

        else{
            Map<String, Double> healthuser = new LinkedHashMap<>();
            if (!user.getMage().isDead()){
                healthuser.put("M", user.getMage().getHealth());
            }
            if (!user.getKnight().isDead()){
                healthuser.put("K", user.getKnight().getHealth());
            }
            if (!user.getArcher().isDead()){
                healthuser.put("A", user.getArcher().getHealth());
            }
            if (!user.getMythicalCreature().isDead()){
                healthuser.put("My", user.getMythicalCreature().getHealth());
            }
            if (!user.getHealer().isDead()){
                healthuser.put("H", user.getHealer().getHealth());
            }
            

            Double min1= Double.MAX_VALUE;

            for (Map.Entry<String, Double> entry : healthuser.entrySet()) {
                if (entry.getValue() < min1) {
                    min1 = entry.getValue();
                    minVariable1 = entry.getKey();
                }
            }

            double healAmount = 0.1*(user.getHealer().getAttack());

            healAmount=round(healAmount);
            if (minVariable1 == "A" && !user.getArcher().isDead()) {
                
                user.getArcher().increasehealth(healAmount);
                

                
            }
            else if (minVariable1 == "K" && !user.getKnight().isDead()){
                
                user.getKnight().increasehealth(healAmount);

            }
            else if (minVariable1 == "M" && !user.getMage().isDead()){
                
                user.getMage().increasehealth(healAmount);

            }
            
            else if(!user.getMythicalCreature().isDead()){
                
                user.getMythicalCreature().increasehealth(healAmount);
            }
            


        }

        if (minVariable=="A" && opponent.getArcher().isDead()){
            playcount+=1;
        }
        if (minVariable=="K"  && opponent.getKnight().isDead()){
            playcount+=1;
        }
        if (minVariable=="M"  && opponent.getMage().isDead()){
            playcount+=1;
        }
        if (minVariable=="H"  && opponent.getHealer().isDead()){
            playcount+=1;
        }
        if (minVariable=="My"  && opponent.getMythicalCreature().isDead()){ //&& !opponent.getArcher().isDead()
            playcount+=1;
        }

        if (minVariable=="A" && !opponent.getArcher().isDead()){
            System.out.println(opponent.getPlayerName()+"'s "+opponent.getArcher().getName()+" health is "+round(opponent.getArcher().getHealth()));
        }
        if (minVariable=="K"  && !opponent.getKnight().isDead()){
            System.out.println(opponent.getPlayerName()+"'s "+opponent.getKnight().getName()+" health is "+round(opponent.getKnight().getHealth()));
        }
        if (minVariable=="M"  && !opponent.getMage().isDead()){
            System.out.println(opponent.getPlayerName()+"'s "+opponent.getMage().getName()+" health is "+round(opponent.getMage().getHealth()));
        }
        if (minVariable=="H"  && !opponent.getHealer().isDead()){
            System.out.println(opponent.getPlayerName()+"'s "+opponent.getHealer().getName()+" health is "+round(opponent.getHealer().getHealth()));
        }
        if (minVariable=="My"  && !opponent.getMythicalCreature().isDead()){ //&& !opponent.getArcher().isDead()
            System.out.println(opponent.getPlayerName()+"'s "+opponent.getMythicalCreature().getName()+" health is "+round(opponent.getMythicalCreature().getHealth()));
        }
        // if (minVariable=="A" && opponent.getArcher().isDead()){
        //     playcount+=1;
        // }
        // if (minVariable=="K"  && opponent.getKnight().isDead()){
        //     playcount+=1;
        // }
        // if (minVariable=="M"  && opponent.getMage().isDead()){
        //     playcount+=1;
        // }
        // if (minVariable=="H"  && opponent.getHealer().isDead()){
        //     playcount+=1;
        // }
        // if (minVariable=="My"  && opponent.getMythicalCreature().isDead()){ //&& !opponent.getArcher().isDead()
        //     playcount+=1;
        // }


        Map<String, Double> newdefenceopponent = new LinkedHashMap<>();
        if (!opponent.getMage().isDead()){
            newdefenceopponent.put("M", opponent.getMage().getDefence());
        }
        if (!opponent.getKnight().isDead()){
            newdefenceopponent.put("K", opponent.getKnight().getDefence());
        }
        if (!opponent.getArcher().isDead()){
            newdefenceopponent.put("A", opponent.getArcher().getDefence());
        }
        if (!opponent.getMythicalCreature().isDead()){
            newdefenceopponent.put("My", opponent.getMythicalCreature().getDefence());
        }
        if (!opponent.getHealer().isDead()) {
            newdefenceopponent.put("H", opponent.getHealer().getDefence());
        }

        for (Map.Entry<String, Double> entry : newdefenceopponent.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                minVariable2 = entry.getKey();
            }
        }
        if(maxVariable=="A"){
            if (minVariable2 == "A") {
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getArcher(), false);
                double damage3 = attack2-0.1*(opponent.getArcher().getDefence());
                damage3=round(damage3);       
                if(attack2!=0){
                    opponent.getArcher().getdamage(damage3);
                }
                
            }
            else if (minVariable2 == "K"){
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getArcher(), false);
                double damage3 = attack2-0.1*(opponent.getKnight().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getArcher().getdamage(damage3);
                }
            }
            else if (minVariable2 == "M"){
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getArcher(), false);
                double damage3 = attack2-0.1*(opponent.getMage().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getArcher().getdamage(damage3);
                }
            }
            else if (minVariable2 == "H"){
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getArcher(), false);
                double damage3 = attack2-0.1*(opponent.getHealer().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getArcher().getdamage(damage3);
                }
            }
            else{
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getArcher(), false);
                double damage3 = attack2-0.1*(opponent.getMythicalCreature().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getArcher().getdamage(damage3);
                }
            }
        }
        if(maxVariable=="K"){
            if (minVariable2 == "A") {
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getKnight(), false);
                double damage3 = attack2-0.1*(opponent.getArcher().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getKnight().getdamage(damage3);
                }
            }
            else if (minVariable2 == "K"){
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getKnight(), false);
                double damage3 = attack2-0.1*(opponent.getKnight().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getKnight().getdamage(damage3);
                }
            }
            else if (minVariable2 == "M"){
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getKnight(), false);
                double damage3 = attack2-0.1*(opponent.getMage().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getKnight().getdamage(damage3);
                }
            }
            else if (minVariable2 == "H"){
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getKnight(), false);
                double damage3 = attack2-0.1*(opponent.getHealer().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getKnight().getdamage(damage3);
                }
            }
            else{
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getKnight(), false);
                double damage3 = attack2-0.1*(opponent.getMythicalCreature().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getKnight().getdamage(damage3);
                }
            }
        }
        if(maxVariable=="M"){
            if (minVariable2 == "A") {
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getMage(), false);
                double damage3 = attack2-0.1*(opponent.getArcher().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getMage().getdamage(damage3);
                }
                
            }
            else if (minVariable2 == "K"){
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getMage(), false);
                double damage3 = attack2-0.1*(opponent.getKnight().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getMage().getdamage(damage3);
                }
            }
            else if (minVariable2 == "M"){
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getMage(), false);
                double damage3 = attack2-0.1*(opponent.getMage().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getMage().getdamage(damage3);
                }
            }
            else if (minVariable2 == "H"){
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getMage(), false);
                double damage3 = attack2-0.1*(opponent.getHealer().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getMage().getdamage(damage3);
                }
            }
            else{
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getMage(), false);
                double damage3 = attack2-0.1*(opponent.getMythicalCreature().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getMage().getdamage(damage3);
                }
            }
        }

        if(maxVariable=="My"){
            if (minVariable2 == "A") {
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getMythicalCreature(), false);
                double damage3 = attack2-0.1*(opponent.getArcher().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getMythicalCreature().getdamage(damage3);
                }
                
            }
            else if (minVariable2 == "K"){
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getMythicalCreature(), false);
                double damage3 = attack2-0.1*(opponent.getKnight().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getMythicalCreature().getdamage(damage3);
                }
            }
            else if (minVariable2 == "M"){
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getMythicalCreature(), false);
                double damage3 = attack2-0.1*(opponent.getMage().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getMythicalCreature().getdamage(damage3);
                }
            }
            else if (minVariable2 == "H"){
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getMythicalCreature(), false);
                double damage3 = attack2-0.1*(opponent.getHealer().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getMythicalCreature().getdamage(damage3);
                }
            }
            else{
                double attack2 = playgroundBattle.buffcharacter(homeland, user.getMythicalCreature(), false);
                double damage3 = attack2-0.1*(opponent.getMythicalCreature().getDefence());
                damage3=round(damage3);
                if(attack2!=0){
                    opponent.getMythicalCreature().getdamage(damage3);
                }
            }
        }
        if(maxVariable=="H"){
            Map<String, Double> healthuser1 = new LinkedHashMap<>();
            if (!user.getMage().isDead()){
                healthuser1.put("M", user.getMage().getHealth());
            }
            if (!user.getKnight().isDead()){
                healthuser1.put("K", user.getKnight().getHealth());
            }
            if (!user.getArcher().isDead()){
                healthuser1.put("A", user.getArcher().getHealth());
            }
            if (!user.getMythicalCreature().isDead()){
                healthuser1.put("My", user.getMythicalCreature().getHealth());
            }

            Double min1= Double.MAX_VALUE;

            for (Map.Entry<String, Double> entry : healthuser1.entrySet()) {
                if (entry.getValue() < min1) {
                    min1 = entry.getValue();
                    minVariable3 = entry.getKey();
                }
            }
            if (minVariable1 == "A") {
                double heal=playgroundBattle.buffcharacter(homeland, user.getHealer(), false);
                heal=round(heal);

                if (heal!=0){
                    user.getArcher().increasehealth(heal);
                }

                
                
            }
            else if (minVariable1 == "K"){
                double heal=playgroundBattle.buffcharacter(homeland, user.getHealer(), false);
                heal=round(heal);
                
                if (heal!=0){
                    user.getKnight().increasehealth(heal);
                }
            }
            else if (minVariable1 == "M"){
                double heal=playgroundBattle.buffcharacter(homeland, user.getHealer(), false);
                heal=round(heal);
                if (heal!=0){
                    user.getMage().increasehealth(heal);
                }
            }
            // else if (minVariable1 == "H"){
            //     double heal=playgroundBattle.buffcharacter(homeland, user.getHealer(), false);
            //     heal=round(heal);
            //     if (heal!=0){
            //         user.getHealer().increasehealth(heal);
            //     }
            // }
            else{
                double heal=playgroundBattle.buffcharacter(homeland, user.getHealer(), false);
                heal=round(heal);
                if (heal!=0){
                    user.getMythicalCreature().increasehealth(heal);
                }
            }
        }




        if(minVariable == minVariable2){
            if (minVariable=="A" && opponent.getArcher().isDead()){
                playcount+=1;
            }
            if (minVariable=="K"  && opponent.getKnight().isDead()){
                playcount+=1;
            }
            if (minVariable=="M"  && opponent.getMage().isDead()){
                playcount+=1;
            }
            if (minVariable=="H"  && opponent.getHealer().isDead()){
                playcount+=1;
            }
            if (minVariable=="My"  && opponent.getMythicalCreature().isDead()){ //&& !opponent.getArcher().isDead()
                playcount+=1;
            }
            
            if (minVariable=="A" && !opponent.getArcher().isDead()){
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getArcher().getName()+" health is "+round(opponent.getArcher().getHealth()));
            }
            if (minVariable=="K"  && !opponent.getKnight().isDead()){
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getKnight().getName()+" health is "+round(opponent.getKnight().getHealth()));
            }
            if (minVariable=="M"  && !opponent.getMage().isDead()){
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getMage().getName()+" health is "+round(opponent.getMage().getHealth()));
            }
            if (minVariable=="H"  && !opponent.getHealer().isDead()){
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getHealer().getName()+" health is "+round(opponent.getHealer().getHealth()));
            }
            if (minVariable=="My"  && !opponent.getMythicalCreature().isDead()){ //&& !opponent.getArcher().isDead()
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getMythicalCreature().getName()+" health is "+round(opponent.getMythicalCreature().getHealth()));
            }
        }else{
            if (minVariable2=="A" && opponent.getArcher().isDead()){
                playcount+=1;
            }
            if (minVariable2=="K"  && opponent.getKnight().isDead()){
                playcount+=1;
            }
            if (minVariable2=="M"  && opponent.getMage().isDead()){
                playcount+=1;
            }
            if (minVariable2=="H"  && opponent.getHealer().isDead()){
                playcount+=1;
            }
            if (minVariable2=="My"  && opponent.getMythicalCreature().isDead()){ //&& !opponent.getArcher().isDead()
                playcount+=1;
            }
            //System.out.println(opponent.getPlayerName()+"Characters and their health:");
            if (minVariable2=="A" && !opponent.getArcher().isDead()){
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getArcher().getName()+" health is "+round(opponent.getArcher().getHealth()));
            }
            if (minVariable2=="K"  && !opponent.getKnight().isDead()){
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getKnight().getName()+" health is "+round(opponent.getKnight().getHealth()));
            }
            if (minVariable2=="M"  && !opponent.getMage().isDead()){
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getMage().getName()+" health is "+round(opponent.getMage().getHealth()));
            }
            if (minVariable2=="H"  && !opponent.getHealer().isDead()){
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getHealer().getName()+" health is "+round(opponent.getHealer().getHealth()));
            }
            if (minVariable2=="My"  && !opponent.getMythicalCreature().isDead()){ //&& !opponent.getArcher().isDead()
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getMythicalCreature().getName()+" health is "+round(opponent.getMythicalCreature().getHealth()));
            }
        }
        

        if (maxVariable=="A"){
            System.out.println(user.getPlayerName()+"'s "+Userchar+"'s health is "+round(user.getArcher().getHealth()));
            
        }
        else if (maxVariable=="K"){
            System.out.println(user.getPlayerName()+"'s "+Userchar+"'s health is "+round(user.getKnight().getHealth()));
            
        }
        else if(maxVariable=="M"){
            System.out.println(user.getPlayerName()+"'s "+Userchar+"'s health is "+round(user.getMage().getHealth()));
            
        }
        else if (maxVariable=="H"){
            System.out.println(user.getPlayerName()+"'s "+Userchar+"'s health is "+round(user.getHealer().getHealth()));
            
        }
        else{
            System.out.println(user.getPlayerName()+"'s "+Userchar+"'s health is "+round(user.getMythicalCreature().getHealth()));
            
        }
        if (count%2!=0){
            playercount+=playcount;
            
        }else{
            opponentcount+=playcount;
        }
        
    }

    public static double round(double dbl) {
        return Math.round(dbl * 10.0) / 10.0;
    }

}
