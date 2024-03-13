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

    // Boolean archdead = false;
    // Boolean magedead = false;
    // Boolean knightdead = false;
    // Boolean healerdead = false;
    // Boolean mythicaldead = false;

    String Userchar="";
    String Oppchar="";

    Double Attackuser;
    Double Defenceopp;
    int count=1;
    int playercount=0;
    int opponentcount=0;
    String homeland;
    playBattle(User user, User opponent){
        int turn=20;
        // System.out.println("Starting battle in...");
        // //countdown();
        // System.out.println(user.getPlayerName() + " vs " + opponent.getPlayerName());
        // System.out.println();
        //  System.out.println(user.getArcher().getSpeed());
        //  System.out.println(user.getMage().getSpeed());
        //  System.out.println(user.getKnight().getSpeed());
        //  System.out.println(user.getHealer().getSpeed());
        //  System.out.println(user.getMythicalCreature().getSpeed());
        
        //  System.out.println(user.getArcher().getAttack());
        //  System.out.println(user.getMage().getAttack());
        //  System.out.println(user.getKnight().getAttack());
        //  System.out.println(user.getHealer().getAttack());
        //  System.out.println(user.getMythicalCreature().getAttack());

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

        String homeland=opponent.getPlayground().getName(); 
        while(turn>0){
            System.out.println(user.getPlayerName()+"'s turn");
            Attack(user, opponent,homeland);
            turn--;
            System.out.println("----------------------");
            System.out.println(opponent.getPlayerName()+"'s turn");
            Attack(opponent, user,homeland);
            turn--;
            System.out.println("----------------------");

            if(opponentcount==5){
                System.out.println(user.getPlayerName() +" has won the match");
                user.increaseXP(1);
                user.addGoldCoins(opponent.getGoldCoins()*0.1);
                opponent.addGoldCoins(-(opponent.getGoldCoins()*0.1));
                System.out.println(user.getPlayerName()+"'s remaing coins "+user.getGoldCoins());
                System.out.println(opponent.getPlayerName()+"'s remaing coins "+opponent.getGoldCoins());
                break;
            }
            else if(playercount==5){
                System.out.println(opponent.getPlayerName() +" has won the match");
                opponent.increaseXP(1);
                opponent.addGoldCoins(user.getGoldCoins()*0.1);
                user.addGoldCoins(-(user.getGoldCoins()*0.1));
                System.out.println(user.getPlayerName()+"'s remaing coins "+user.getGoldCoins());
                System.out.println(opponent.getPlayerName()+"'s remaing coins "+opponent.getGoldCoins());
                break;
            }
            else if(turn==0){
                System.out.println("battle is draw");
                System.out.println(user.getPlayerName()+"'s remaing coins "+user.getGoldCoins());
                System.out.println(opponent.getPlayerName()+"'s remaing coins "+opponent.getGoldCoins());
            }
        }
        // System.out.println(opponent.getArcher().getHealth());
        // System.out.println(opponent.getMage().getHealth());
        // System.out.println(opponent.getKnight().getHealth());
        // System.out.println(opponent.getHealer().getHealth());
        // System.out.println(opponent.getMythicalCreature().getHealth());

        // System.out.println(user.getArcher().getHealth());
        // System.out.println(user.getMage().getHealth());
        // System.out.println(user.getKnight().getHealth());
        // System.out.println(user.getHealer().getHealth());
        // System.out.println(user.getMythicalCreature().getHealth());

        // Archhealthuser2 = user.getArcher().getHealth();
        // Magehealthuser2 = user.getMage().getHealth();
        // Knighthealthuser2 = user.getKnight().getHealth();
        // Healerhealthuser2 = user.getHealer().getHealth();
        // Mythicalhealthuser2 = user.getMythicalCreature().getHealth();
         
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

        // System.out.println("----------------------");
        // System.out.println(opponent.getArcher().getHealth());
        // System.out.println(opponent.getMage().getHealth());
        // System.out.println(opponent.getKnight().getHealth());
        // System.out.println(opponent.getHealer().getHealth());
        // System.out.println(opponent.getMythicalCreature().getHealth());

        // System.out.println(user.getArcher().getHealth());
        // System.out.println(user.getMage().getHealth());
        // System.out.println(user.getKnight().getHealth());
        // System.out.println(user.getHealer().getHealth());
        // System.out.println(user.getMythicalCreature().getHealth());
        

        
    }


    private void Attack(User user, User opponent,String homeland){
        int playcount=0;
        // if (count/2==0){
        //     User temp = user;
        //     user = opponent;
        //     opponent = temp;
        //     playcount=playercount;
        // }else{
        //     playcount=opponentcount;
        // }
        if(count==1){
            System.out.println(user.getPlayerName()+" speed : "+user.getArcher().getSpeed());
            System.out.println(user.getPlayerName()+" speed: "+user.getMage().getSpeed());
            System.out.println(user.getPlayerName()+" speed: "+user.getKnight().getSpeed());
            System.out.println(user.getPlayerName()+" speed: "+user.getHealer().getSpeed());
            System.out.println(user.getPlayerName()+" speed: "+user.getMythicalCreature().getSpeed());
            System.out.println("-----------");
            System.out.println(user.getPlayerName()+" attack: "+user.getArcher().getAttack());
            System.out.println(user.getPlayerName()+" attack: "+user.getMage().getAttack());
            System.out.println(user.getPlayerName()+"attack : "+user.getKnight().getAttack());
            System.out.println(user.getPlayerName()+"attack : "+user.getHealer().getAttack());
            System.out.println(user.getPlayerName()+"attack : "+user.getMythicalCreature().getAttack());
            System.out.println("-----------");
            System.out.println(user.getPlayerName()+" defence: "+user.getArcher().getDefence());
            System.out.println(user.getPlayerName()+" defence: "+user.getMage().getDefence());
            System.out.println(user.getPlayerName()+"defence : "+user.getKnight().getDefence());
            System.out.println(user.getPlayerName()+"defence : "+user.getHealer().getDefence());
            System.out.println(user.getPlayerName()+"defence : "+user.getMythicalCreature().getDefence());
            System.out.println("-----------");
            
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

            System.out.println(user.getPlayerName()+" speed : "+user.getArcher().getSpeed());
            System.out.println(user.getPlayerName()+" speed: "+user.getMage().getSpeed());
            System.out.println(user.getPlayerName()+" speed: "+user.getKnight().getSpeed());
            System.out.println(user.getPlayerName()+" speed: "+user.getHealer().getSpeed());
            System.out.println(user.getPlayerName()+" speed: "+user.getMythicalCreature().getSpeed());
            System.out.println("-----------");
            System.out.println(user.getPlayerName()+" attack: "+user.getArcher().getAttack());
            System.out.println(user.getPlayerName()+" attack: "+user.getMage().getAttack());
            System.out.println(user.getPlayerName()+"attack : "+user.getKnight().getAttack());
            System.out.println(user.getPlayerName()+"attack : "+user.getHealer().getAttack());
            System.out.println(user.getPlayerName()+"attack : "+user.getMythicalCreature().getAttack());
            System.out.println("-----------");
            System.out.println(user.getPlayerName()+" defence: "+user.getArcher().getDefence());
            System.out.println(user.getPlayerName()+" defence: "+user.getMage().getDefence());
            System.out.println(user.getPlayerName()+"defence : "+user.getKnight().getDefence());
            System.out.println(user.getPlayerName()+"defence : "+user.getHealer().getDefence());
            System.out.println(user.getPlayerName()+"defence : "+user.getMythicalCreature().getDefence());
            System.out.println("-----------");
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
        // System.out.println(user.getPlayerName()+"Characters and their speed:");
        // for (Entry<String, Double> entry : speeduser.entrySet()) {
        //     System.out.println(entry.getKey() + ": " + entry.getValue());
        // }
        
        
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

        // System.out.println("Characters and their defence:");
        // for (Entry<String, Double> entry : defenceopponent.entrySet()) {
        //     System.out.println(entry.getKey() + ": " + entry.getValue());
        // }
        
        

        // Find the variable name with the minimum value

        
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

        System.out.println(user.getPlayerName()+"'s "+Userchar+" is fighting with "+opponent.getPlayerName()+"'s "+Oppchar);
        double damage;

        // if (maxVariable == "A"){
        //     System.out.println(Archspeed);
            
        // }
        // else if (maxVariable == "K"){
        //     System.out.println(Knightspeed);
        // }
        // else if (maxVariable == "M"){
        //     System.out.println(Magespeed);
        // }
        // else if (maxVariable == "H"){
        //     System.out.println(Healerspeed);
        // }
        // else if (maxVariable=="My"){
        //     System.out.println(Mythicalspeed);
        // }

        if (maxVariable!="H"){
            damage = (0.5*(Attackuser)) - (0.1*(Defenceopp));
            String formattedString = String.format("%.1f", damage);

            // Parse the formatted string back to double
            damage= Double.parseDouble(formattedString);

            if (minVariable == "A"){
                // System.out.println(opponent.getArcher().getHealth() + " damage " + damage);
                opponent.getArcher().getdamage(damage);
                // System.out.println(opponent.getArcher().getHealth());
                // if (opponent.getArcher().getHealth()<=0){
                //     System.out.println("archer is dead");
                // }
                // else
                //     {
                //         System.out.println("archer helath is"+ opponent.getArcher().getHealth());
                //     }
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

            double Healthuser = 0.1*(user.getHealer().getAttack());
            String formattedString = String.format("%.1f", Healthuser);

            // Parse the formatted string back to double
            Healthuser= Double.parseDouble(formattedString);

            if (minVariable1 == "A" && !user.getArcher().isDead()) {
                // Healthuser=user.getArcher().getHealth();
                user.getArcher().increasehealth(Healthuser);
                

                
            }
            else if (minVariable1 == "K" && !user.getKnight().isDead()){
                // Healthuser=user.getKnight().getHealth();
                user.getKnight().increasehealth(Healthuser);

            }
            else if (minVariable1 == "M" && !user.getMage().isDead()){
                // Healthuser=user.getMage().getHealth();
                user.getMage().increasehealth(Healthuser);

            }
            // else if (minVariable1 == "H"){
            //     // Healthuser=user.getHealer().getHealth();
            //     Healerhealth+=Healthuser;
            // }
            else if(!user.getMythicalCreature().isDead()){
                // Healthuser=user.getMythicalCreature().getHealth();
                user.getMythicalCreature().increasehealth(Healthuser);
            }
            


        }
        
        // playgroundBattle.buffcharacter(opponent.getPlayground().getName(), user.getArcher(), opponent.getArcher(), false);
        // playgroundBattle.buffcharacter(opponent.getPlayground().getName(), user.getKnight(), opponent.getKnight(), false);
        // playgroundBattle.buffcharacter(opponent.getPlayground().getName(), user.getMage(), opponent.getMage(), false);
        // playgroundBattle.buffcharacter(opponent.getPlayground().getName(), user.getHealer(), opponent.getHealer(), false);
        // playgroundBattle.buffcharacter(opponent.getPlayground().getName(), user.getMythicalCreature(), opponent.getMythicalCreature(), false);
        
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
                minVariable = entry.getKey();
            }
        }
        if(maxVariable=="A"){
            if (minVariable2 == "A") {
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getArcher(), false);
                double damage3 = damage2-0.1*(opponent.getArcher().getDefence());
                if(damage2!=0){
                    opponent.getArcher().getdamage(damage3);
                }
                
            }
            else if (minVariable2 == "K"){
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getArcher(), false);
                double damage3 = damage2-0.1*(opponent.getKnight().getDefence());
                if(damage2!=0){
                    opponent.getArcher().getdamage(damage3);
                }
            }
            else if (minVariable2 == "M"){
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getArcher(), false);
                double damage3 = damage2-0.1*(opponent.getMage().getDefence());
                if(damage2!=0){
                    opponent.getArcher().getdamage(damage3);
                }
            }
            else if (minVariable2 == "H"){
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getArcher(), false);
                double damage3 = damage2-0.1*(opponent.getHealer().getDefence());
                if(damage2!=0){
                    opponent.getArcher().getdamage(damage3);
                }
            }
            else{
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getArcher(), false);
                double damage3 = damage2-0.1*(opponent.getMythicalCreature().getDefence());
                if(damage2!=0){
                    opponent.getArcher().getdamage(damage3);
                }
            }
        }
        if(maxVariable=="K"){
            if (minVariable2 == "A") {
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getKnight(), false);
                double damage3 = damage2-0.1*(opponent.getArcher().getDefence());
                if(damage2!=0){
                    opponent.getKnight().getdamage(damage3);
                }
            }
            else if (minVariable2 == "K"){
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getKnight(), false);
                double damage3 = damage2-0.1*(opponent.getKnight().getDefence());
                if(damage2!=0){
                    opponent.getKnight().getdamage(damage3);
                }
            }
            else if (minVariable2 == "M"){
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getKnight(), false);
                double damage3 = damage2-0.1*(opponent.getMage().getDefence());
                if(damage2!=0){
                    opponent.getKnight().getdamage(damage3);
                }
            }
            else if (minVariable2 == "H"){
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getKnight(), false);
                double damage3 = damage2-0.1*(opponent.getHealer().getDefence());
                if(damage2!=0){
                    opponent.getKnight().getdamage(damage3);
                }
            }
            else{
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getKnight(), false);
                double damage3 = damage2-0.1*(opponent.getMythicalCreature().getDefence());
                if(damage2!=0){
                    opponent.getKnight().getdamage(damage3);
                }
            }
        }
        if(maxVariable=="M"){
            if (minVariable2 == "A") {
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getMage(), false);
                double damage3 = damage2-0.1*(opponent.getArcher().getDefence());
                if(damage2!=0){
                    opponent.getMage().getdamage(damage3);
                }
                
            }
            else if (minVariable2 == "K"){
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getMage(), false);
                double damage3 = damage2-0.1*(opponent.getKnight().getDefence());
                if(damage2!=0){
                    opponent.getMage().getdamage(damage3);
                }
            }
            else if (minVariable2 == "M"){
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getMage(), false);
                double damage3 = damage2-0.1*(opponent.getMage().getDefence());
                if(damage2!=0){
                    opponent.getMage().getdamage(damage3);
                }
            }
            else if (minVariable2 == "H"){
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getMage(), false);
                double damage3 = damage2-0.1*(opponent.getHealer().getDefence());
                if(damage2!=0){
                    opponent.getMage().getdamage(damage3);
                }
            }
            else{
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getMage(), false);
                double damage3 = damage2-0.1*(opponent.getMythicalCreature().getDefence());
                if(damage2!=0){
                    opponent.getMage().getdamage(damage3);
                }
            }
        }

        if(maxVariable=="My"){
            if (minVariable2 == "A") {
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getMythicalCreature(), false);
                double damage3 = damage2-0.1*(opponent.getArcher().getDefence());
                if(damage2!=0){
                    opponent.getMythicalCreature().getdamage(damage3);
                }
                
            }
            else if (minVariable2 == "K"){
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getMythicalCreature(), false);
                double damage3 = damage2-0.1*(opponent.getKnight().getDefence());
                if(damage2!=0){
                    opponent.getMythicalCreature().getdamage(damage3);
                }
            }
            else if (minVariable2 == "M"){
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getMythicalCreature(), false);
                double damage3 = damage2-0.1*(opponent.getMage().getDefence());
                if(damage2!=0){
                    opponent.getMythicalCreature().getdamage(damage3);
                }
            }
            else if (minVariable2 == "H"){
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getMythicalCreature(), false);
                double damage3 = damage2-0.1*(opponent.getHealer().getDefence());
                if(damage2!=0){
                    opponent.getMythicalCreature().getdamage(damage3);
                }
            }
            else{
                double damage2 = playgroundBattle.buffcharacter(homeland, user.getMythicalCreature(), false);
                double damage3 = damage2-0.1*(opponent.getMythicalCreature().getDefence());
                if(damage2!=0){
                    opponent.getMythicalCreature().getdamage(damage3);
                }
            }
        }
        if(maxVariable=="H"){
            if (minVariable1 == "A") {
                double heal=playgroundBattle.buffcharacter(homeland, user.getHealer(), false);
                user.getArcher().increasehealth(heal);
                
            }
            else if (minVariable1 == "K"){
                double heal=playgroundBattle.buffcharacter(homeland, user.getHealer(), false);
                user.getKnight().increasehealth(heal);
            }
            else if (minVariable1 == "M"){
                double heal=playgroundBattle.buffcharacter(homeland, user.getHealer(), false);
                user.getMage().increasehealth(heal);
            }
            else if (minVariable1 == "H"){
                double heal=playgroundBattle.buffcharacter(homeland, user.getHealer(), false);
                user.getHealer().increasehealth(heal);
            }
            else{
                double heal=playgroundBattle.buffcharacter(homeland, user.getHealer(), false);
                user.getMythicalCreature().increasehealth(heal);
            }
        }




        if(minVariable1 == minVariable2){
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
            //System.out.println(opponent.getPlayerName()+"Characters and their health:");
            if (minVariable=="A" && !opponent.getArcher().isDead()){
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getArcher().getName()+" health is "+opponent.getArcher().getHealth());
            }
            if (minVariable=="K"  && !opponent.getKnight().isDead()){
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getKnight().getName()+" health is "+opponent.getKnight().getHealth());
            }
            if (minVariable=="M"  && !opponent.getMage().isDead()){
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getMage().getName()+" health is "+opponent.getMage().getHealth());
            }
            if (minVariable=="H"  && !opponent.getHealer().isDead()){
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getHealer().getName()+" health is "+opponent.getHealer().getHealth());
            }
            if (minVariable=="My"  && !opponent.getMythicalCreature().isDead()){ //&& !opponent.getArcher().isDead()
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getMythicalCreature().getName()+" health is "+opponent.getMythicalCreature().getHealth());
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
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getArcher().getName()+" health is "+opponent.getArcher().getHealth());
            }
            if (minVariable2=="K"  && !opponent.getKnight().isDead()){
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getKnight().getName()+" health is "+opponent.getKnight().getHealth());
            }
            if (minVariable2=="M"  && !opponent.getMage().isDead()){
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getMage().getName()+" health is "+opponent.getMage().getHealth());
            }
            if (minVariable2=="H"  && !opponent.getHealer().isDead()){
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getHealer().getName()+" health is "+opponent.getHealer().getHealth());
            }
            if (minVariable2=="My"  && !opponent.getMythicalCreature().isDead()){ //&& !opponent.getArcher().isDead()
                System.out.println(opponent.getPlayerName()+"'s "+opponent.getMythicalCreature().getName()+" health is "+opponent.getMythicalCreature().getHealth());
            }
        }
        // System.out.println("archer helath is "+opponent.getArcher().getHealth());
        // System.out.println("mage helath is "+opponent.getMage().getHealth());
        // System.out.println("knight helath is "+opponent.getKnight().getHealth());
        // System.out.println("healer helath is "+opponent.getHealer().getHealth());
        // System.out.println("mythical creature helath is "+opponent.getMythicalCreature().getHealth());

        // if (opponent.getArcher().isDead()){
        //     System.out.println(opponent.getPlayerName()+"'s Archer died");
            
        // // }else{
        // //     System.out.println("------------------------------------------------");
        // //     System.out.println(opponent.getPlayerName()+"'s "+opponent.getArcher().getPlayerName() +"'s health is "+Archhealth);
        // //     System.out.println(user.getPlayerName()+"'s ");
        // }
        // if (opponent.getMage().isDead()){
        //     System.out.println(opponent.getPlayerName()+"'s Mage died");
            

        // }//else{
        //     //System.out.println(opponent.getPlayerName()+"'s "+opponent.getArcher().getName() +"'s health is "+Archhealth);

        // if (opponent.getKnight().isDead()){
        //     System.out.println(opponent.getPlayerName()+"'s Knight died");
            
        // }
        // if (opponent.getHealer().isDead()){
        //     System.out.println(opponent.getPlayerName()+"'s Healer died");
            
        // }
        // if (opponent.getMythicalCreature().isDead()){
        //     System.out.println(opponent.getPlayerName()+"'s Mythical Creature died");
            
        // }

        if (maxVariable=="A"){
            System.out.println(user.getPlayerName()+"'s "+Userchar+"'s health is "+user.getArcher().getHealth());
            // if (minVariable=="A" && (opponent.getArcher().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getArcher().getHealth());
            // }
            // else if (minVariable=="K" && (!opponent.getKnight().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getKnight().getHealth());
            // }
            // else if (minVariable=="M" && (!opponent.getMage().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getMage().getHealth());
            // }
            // else if (minVariable=="H" && (!opponent.getHealer().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getHealer().getHealth());
            // }
            // else if (!opponent.getMythicalCreature().isDead()){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getMythicalCreature().getHealth());
            // }
        }
        else if (maxVariable=="K"){
            System.out.println(user.getPlayerName()+"'s "+Userchar+"'s health is "+user.getKnight().getHealth());
            // if (minVariable=="A" && (!opponent.getArcher().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getArcher().getHealth());
            // }
            // else if (minVariable=="K" && (!opponent.getKnight().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getKnight().getHealth());
            // }
            // else if (minVariable=="M" && (!opponent.getMage().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getMage().getHealth());
            // }
            // else if (minVariable=="H" && (!opponent.getHealer().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getHealer().getHealth());
            // }
            // else if (!opponent.getMythicalCreature().isDead()){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getMythicalCreature().getHealth());
            // }
        }
        else if(maxVariable=="M"){
            System.out.println(user.getPlayerName()+"'s "+Userchar+"'s health is "+user.getMage().getHealth());
            // if (minVariable=="A" && (!opponent.getArcher().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getArcher().getHealth());
            // }
            // else if (minVariable=="K" && (!opponent.getKnight().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getKnight().getHealth());
            // }
            // else if (minVariable=="M" && (!opponent.getMage().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getMage().getHealth());
            // }
            // else if (minVariable=="H" && (!opponent.getHealer().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getHealer().getHealth());
            // }
            // else if (!opponent.getMythicalCreature().isDead()){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getMythicalCreature().getHealth());
            // }
        }
        else if (maxVariable=="H"){
            System.out.println(user.getPlayerName()+"'s "+Userchar+"'s health is "+user.getHealer().getHealth());
            // if (minVariable=="A" && (!opponent.getArcher().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getArcher().getHealth());
            // }
            // else if (minVariable=="K" && (!opponent.getKnight().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getKnight().getHealth());
            // }
            // else if (minVariable=="M" && (!opponent.getMage().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getMage().getHealth());
            // }
            // else if (minVariable=="H" && (!opponent.getHealer().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getHealer().getHealth());
            // }
            // else if (!opponent.getMythicalCreature().isDead()){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getMythicalCreature().getHealth());
            // }
        }
        else{
            System.out.println(user.getPlayerName()+"'s "+Userchar+"'s health is "+user.getMythicalCreature().getHealth());
            // if (minVariable=="A" && (!opponent.getArcher().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getArcher().getHealth());
            // }
            // else if (minVariable=="K" && (!opponent.getKnight().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getKnight().getHealth());
            // }
            // else if (minVariable=="M" && (!opponent.getMage().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getMage().getHealth());
            // }
            // else if (minVariable=="H" && (!opponent.getHealer().isDead())){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getHealer().getHealth());
            // }
            // else if (!opponent.getMythicalCreature().isDead()){
            //     System.out.println(opponent.getPlayerName()+"'s "+Oppchar +"'s health is "+ opponent.getMythicalCreature().getHealth());
            // }
        }

        // if(turn=20)
        //     if(!user.getMythicalCreature().isDead()){
        //         opponentcount+=1;
        //     }
        //     if(!user.getArcher().isDead()){
        //         opponentcount+=1;
        //     }
        //     if(!user.getKnight().isDead()){
        //         opponentcount+=1;
        //     }
        //     if(!user.getMage().isDead()){
        //         opponentcount+=1;
        //     }
        //     if(!user.getHealer().isDead()){
        //         opponentcount+=1;
        //     }

        //     if(!opponent.getArcher().isDead()){
        //         playercount+=1;
        //     }
        //     if(!opponent.getKnight().isDead()){
        //         playercount+=1;
        //     }
        //     if(!opponent.getMage().isDead()){
        //         playercount+=1;
        //     }
        //     if(!opponent.getHealer().isDead()){
        //         playercount+=1;
        //     }
        //     if(!opponent.getMythicalCreature().isDead()){
        //         playercount+=1;
        //     }
        //System.out.println("count ; "+ playcount);
        if (count%2!=0){
            playercount+=playcount;
            //System.out.println("player count ; "+ playercount);
        }else{
            opponentcount+=playcount;
            //System.out.println("opponent count; "+ opponentcount);
        }

        // System.out.println("player count ; "+ playercount);
        // System.out.println("opponent count; "+ opponentcount);
    
        
    }



}//this last file dosent give any return , i think the parameters in the playgroundbattle method