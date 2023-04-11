public class Dice {
    //サイコロをふるメソッド
    public int throwDice() {
        int dice = new java.util.Random().nextInt(6);
        dice ++;
        return dice;
    }
}
