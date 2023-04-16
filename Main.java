
class Main {
    public static void main(String[] args) {

        Game game = new Game();
        game.setBoard("board.csv", 15);
        game.addPlayer("Taro");
        game.addPlayer("Jiro");
        // game.setDice();
        game.start();


        // System.out.println(game.masuList.size());
        // System.out.println(game.players.get(0).name);
        // System.out.println(game.players.get(0).position);
        // System.out.println(game.players.get(1).name);
        // System.out.println(game.players.get(1).position);
    }
}