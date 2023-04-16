import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

class Game {
    Board b = new Board();
    //ENTERキー
    Scanner scan = new Scanner(System.in);
    //
    ArrayList<Integer> masuList = b.intLi;
    //プレイヤーの配列を定義
    ArrayList<Player> players = new ArrayList<Player>();
    //サイコロインスタンスの生成
    Dice dc = new Dice();

    public static void main(String[] args) {
    }

    public void setBoard(String filename, int size) {
        //引数sizeの大きさで、引数filenameのcsvファイルを作成する処理
        try {
            FileWriter fw = new FileWriter(filename, false);
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

            for(int i = 0; i < size; i++){
                int masuEvent = new java.util.Random().nextInt(6)-2;
                pw.print(masuEvent);
                if(i<size-1){
                    pw.print(",");
                }
            }
            pw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void addPlayer(String name) {
        //生成したプレイヤーをプレイヤーの配列に格納する処理
        Player p = new Player(name);
        this.players.add(p);
    }
    public static void setDice() {
    }

    //ゲーム実行
    public void start(){
        //作成したcsvファイルを整数型配列に格納する処理
        this.b.csvToIntList();
        int goal = masuList.size();

        while(this.players.get(0).position<goal && this.players.get(1).position<goal){
            //プレイヤーの入れ替え
            for(int p=0; p<this.players.size(); p++){
                System.out.println(this.players.get(p).name + "さんの現在の位置は" + this.players.get(p).position);
                System.out.println(this.players.get(p).name + "さん、サイコロを振ってください");
                //サイコロを投げる
                scan.nextLine();
                dc.throwDice();
                System.out.println(dc.diceNum + "がでました！" + dc.diceNum + "マス進みます");
                this.players.get(p).position += dc.diceNum;
                //
                if(this.players.get(p).position > goal) {
                    //サイコロで進んでゴールした場合
                    System.out.println(this.players.get(p).name + "さんの勝利！");
                    break;
                } else {
                    //サイコロで進んでマスに止まった場合
                    System.out.println(this.players.get(p).name + "さんの現在の位置は" + this.players.get(p).position);
                }
                //止まったマス
                int stopMasu = this.masuList.get(this.players.get(p).position-1);
                this.players.get(p).position += stopMasu;
                
                if(stopMasu < this.players.get(p).position*-1) {
                    //大幅なマイナスマスに止まった場合
                    this.players.get(p).position = 0;
                    System.out.println(stopMasu + "のマスにとまったので、" + stopMasu*-1 + "マス戻ります");
                    System.out.println(this.players.get(p).name + "さんの現在の位置は" + this.players.get(p).position);
                    System.out.println("プレイヤーを交代してください。");
                    scan.nextLine();
                    System.out.println("--------------------------------------------------------");
                } else if(stopMasu > goal - this.players.get(p).position) {
                    //大幅なプラスマスに止まった場合
                    this.players.get(p).position = goal;
                    System.out.println(stopMasu + "のマスにとまったので、" + stopMasu + "マス進みます");
                    System.out.println(players.get(p).name + "さんの勝利！");
                    break;
                } else {
                    if(stopMasu < 0) {
                        //マイナスマスに止まった場合
                        System.out.println(stopMasu + "のマスにとまったので、" + stopMasu*-1 + "マス戻ります");
                    } else {
                        //プラスマスに止まった場合
                        System.out.println(stopMasu + "のマスにとまったので、" + stopMasu + "マス進みます");
                    }
                    
                    if(players.get(p).position > goal){
                        //プラスマスによって進んでゴールした場合
                        System.out.println(this.players.get(p).name + "さんの勝利！");
                        break;
                    } else{
                        //プラスマスによって進んでゴールしなかった場合
                        System.out.println(this.players.get(p).name + "さんの現在の位置は" + this.players.get(p).position);
                        System.out.println("プレイヤーを交代してください。");
                        scan.nextLine();
                        System.out.println("--------------------------------------------------------");
                    }
                }
            }
        } 
        
        
    }
}