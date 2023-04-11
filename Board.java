import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Board {
    //GameクラスのsetBoardメソッドで呼び出されたら、csv形式のすごろくファイルを出力する
    public static void main(String args[]) {
        String[] masu = {"_","_","_","_"};
        
        // for(int i = 0; i < 20; i++){
            
        // }

        // exportCsvクラスに渡す
        exportCsv(masu);
        // exportCsv(turn, player, number, position);
    }
    // public static void exportCsv(int[] turn, String[] player, int[] number, int[] position){
    public static void exportCsv(String[] masu){
        try {
            // 出力ファイルの作成
            FileWriter fw = new FileWriter("board.csv", false);
            // PrintWriterクラスのオブジェクトを生成
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
 
            // ヘッダーの指定
            pw.print("");
            // pw.print("ターン数");
            // pw.print(",");
            // pw.print("プレイヤー名");
            // pw.print(",");
            // pw.print("サイコロの目");
            // pw.print(",");
            // pw.print("今いるマス");

 
            // データを書き込む
            for(int i = 0; i < masu.length; i++){
                pw.print(masu[i]);
                pw.print(" | ");
                // pw.print(turn[i]);
                // pw.print(",");
                // pw.print(player[i]);
                // pw.print(",");
                // pw.print(number[i]);
                // pw.print(",");
                // pw.print(position[i]);
                // pw.println();
            }
 
            // ファイルを閉じる
            pw.close();
 
            // 出力確認用のメッセージ
            System.out.println("csvファイルを出力しました");
 
        // 出力に失敗したときの処理
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    // public static void newBoard("ファイル名") {

    // }
}