// Your First Program

class Main {
    public static void main(String[] args) {

        Game game = new Game();
        // game.setBoard(20, "abc.csv");
        game.addPlayer("Taro");
        game.addPlayer("Jiro");
        // game.setDice();
        game.start(15);

        // game = Game.new
        // game.setBoard(Board.new("board.csv"))
        // game.addPlayer(Player.new("Taro"))
        // game.addPlayer(Player.new("Jiro"))
        // game.setDice(Dice.new)
        // game.start
    }
}