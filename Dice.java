public class Dice {
    int diceNum;
    //サイコロをふるメソッド
    public void throwDice() {
        this.diceNum = new java.util.Random().nextInt(6);
        diceNum++;
    }
}
