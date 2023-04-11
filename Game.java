import java.util.ArrayList;
import java.util.Scanner;
// import java.util.List;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

class Game {
    //ENTERキー
    Scanner scan = new Scanner(System.in);
    //プレイヤーの配列を定義。
    ArrayList<String> players = new ArrayList<String>();
    //プレイヤーの位置の配列を定義
    int[] position = {0,0};
    //サイコロを振るメソッドの定義
    Dice dc = new Dice();
    


    public static void main(String[] args) {

    }
    //
    public void setBoard(int size, String filename) {
        //引数sizeの大きさで、引数filenameのcsvファイルをつくる処理
        try {
            FileWriter fw = new FileWriter(filename, false);
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

            //ヘッダーの設定
            pw.print("ターン数");
            pw.print(",");
            pw.print("プレイヤー名");
            pw.print(",");
            pw.print("サイコロの目");
            pw.print(",");
            pw.print("今いるマス");
            pw.print('\n');

            for(int i = 0; i < size; i++){
                pw.print(i);
                pw.print(" | ");
            }
            pw.print('\n');
            pw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void addPlayer(String name) {
        //Playerクラスで取得した名前をリストに格納、board.csvに書き込み
        // this.players.add(name);
        this.players.add(name);
        

    }
    public static void setDice() {
        //出た目の記録をboard.csvに書き込み
        // int dice = new java.util.Random().nextInt(6);
        // dice++;
    }
    //ゲーム実行
    public void start(int goal){
        // System.out.println(players.get(0));
        // System.out.println("今の位置は" + position[0] + "です");
        System.out.println("ゴールは" + goal + "です。");
        while (this.position[0] < goal || this.position[1] < goal) {
            for(int i=0; i<2; i++) {
                System.out.println('\n');
                System.out.println(players.get(i) + "さん、サイコロを振ってください");
                scan.nextLine();
            //エンターキーを押して次に進む処理
            //サイコロの出た目を出力する処理
            int dice = this.dc.throwDice();
            System.out.println(dice + "がでました。");
            //出た目の数だけプレイヤーのポジションを進める処理
            //プレイヤーの位置を出力
            this.position[i] = this.position[i] + dice;
            System.out.println(players.get(i) + "の位置は" + position[i] + "です");
            // if(this.position % 5 = 0) {

            // }
            //先にゴールに到達したプレイヤーの勝利を出力する処理
            //addPlayerで作成したリストの順番を進める処理
            if(this.position[i] >= goal) {
                System.out.println('\n' + players.get(i) + "さんの勝利");
                break;
            }
        }
        
            }
            
        //     System.out.println(players.get(0) + "さん、サイコロを振ってください");
        //     //エンターキーを押して次に進む処理
        //     //サイコロの出た目を出力する処理
        //     int dice = this.dc.throwDice();
        //     System.out.println(dice + "がでました。");
        //     //出た目の数だけプレイヤーのポジションを進める処理

        //     //プレイヤーの位置を出力
        //     this.position[0] = this.position[0] + dice;
        //     System.out.println("今の位置は" + position[0] + "です");
        //     //先にゴールに到達したプレイヤーの勝利を出力する処理
        //     //addPlayerで作成したリストの順番を進める処理
        //     if(this.position[0]>20) {
        //         break;
        //     }
        // }
        // System.out.println(players.get(0) + "さんの勝利");

        
        // for(int i=0; i<10; i++) {
        //     //
        //     System.out.println("サイコロを振ってください");
        //     //エンターキーを押して次に進む処理
        //     //サイコロの出た目を出力する処理
        //     int dice = this.dc.throwDice();
        //     System.out.println(dice + "がでました。");
        //     //出た目の数だけプレイヤーのポジションを進める処理

        //     //プレイヤーの位置を出力
        //     this.position = this.position + dice;
        //     System.out.println("今の位置は" + position + "です");
        //     //先にゴールに到達したプレイヤーの勝利を出力する処理
        //     //addPlayerで作成したリストの順番を進める処理
        // }
        

        //繰り返し
            // プレイヤーがダイスを投げる処理
            //出た目の数だけプレイヤーのポジションを進める処理
            //addPlayerで作成したリストの順番を進める処理
        //ループの終了
        //先にゴールに到達したプレイヤーの勝利を出力する処理


       }
}