public class Game {
    private int[] totalThrows = new int[21];
    private int currentThrow = 0;


    public void roll(int queues){
        totalThrows[currentThrow] = queues;
        if(currentThrow <20){
            currentThrow++;
        }
    }
    public int score_V1(){
        int score = 0;
        return score;
    }
    public int score_V2(){
        int score = 0;

        for(int i = 0; i< totalThrows.length; i++){
            if(isSpare(i)){
                score+=10 + totalThrows[i+2];
                i=+1;
            }else{
                score+= totalThrows[i];
            }
        }

        return score;
    }
   public int score(){
        int score = 0;

        for(int i = 0; i< totalThrows.length; i++){
            if(isSpare(i)){
                score+=10 + totalThrows[i+2];
                i=+1;
            }else if(isStrike(i)){
                score+=10+ totalThrows[i+1]+ totalThrows[i+2];
            }else {
                score+= totalThrows[i];
            }
        }

        return score;
    }

    private boolean isSpare(int CurrentThrowIndex){
        if(CurrentThrowIndex == 20){
            return false;
        }
        return totalThrows[CurrentThrowIndex] + totalThrows[CurrentThrowIndex + 1] == 10;
    }

    private boolean isStrike(int CurrentThrowIndex){
        return totalThrows[CurrentThrowIndex]==10;
    }
}
