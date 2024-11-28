package io.github.KunalSuman.Angry_Bird;

public class End_level_helper_class {
    public static int CCL(int currentLevel){
        if(currentLevel == 1 || currentLevel == 2 || currentLevel == 3 || currentLevel == 4 || currentLevel == 5){
            return 1;
        }
        else{
            return 0;
        }
    }
    public  static int CWL (int currentLevel){
        if(currentLevel == 1 || currentLevel == 2 || currentLevel == 3 || currentLevel == 4 || currentLevel == 5){
            return 1;
        }
        else {
            return 0;
        }
    }
    public static int returnNumberChecker(int return_number){
        if (return_number == 1){
            return 1;
        }else if (return_number ==2){
            return 2;
        }else if (return_number == 3){
            return 3;
        }else if (return_number == 4){
            return 4;
        }else if (return_number ==5){
            return 5;
        }else{
            return 0;
        }
    }
    public static int setPiggyDamage(int k){
        if (k<50) {
            return k;
        }else{
            return 30;
        }
    }

}
