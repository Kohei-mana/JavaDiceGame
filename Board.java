import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Board {
    Path path = Paths.get("board.csv");
    ArrayList<Integer> intLi = new ArrayList<>();
    //csvファイルをIntリストに格納する
    public void csvToIntList() {
        try {
            String content = Files.readString(path);
            String[] str = content.split(",");
            
            for(int i=0; i<str.length; i++){
                intLi.add(Integer.parseInt(str[i]));
            }
        }catch(IOException e) {
            System.out.println("ファイル読み込みに失敗");
            
        }
    }
}