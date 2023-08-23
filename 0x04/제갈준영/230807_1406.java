import javax.print.CancelablePrintJob;
import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


//System.out.printlin 대신 BufferdWriter를 쓰는 이유: https://devaily.tistory.com/11
//BufferedReader와 Scanner의 차이: https://studywithus.tistory.com/61
//iterator와 ListIterator의 차이: http://www.tcpschool.com/java/java_collectionFramework_iterator
public class Main{

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = br.readLine();
    int count = Integer.parseInt(br.readLine());

    LinkedList<Character> list = new LinkedList<>();

    for(int i = 0; i < s.length(); i++){
      list.add(s.charAt(i));
    }

    ListIterator<Character> iter = list.listIterator();
    while(iter.hasNext()){
      iter.next();
    }

    for(int i = 0; i < count; i++){
      String input = br.readLine();



      if(input.equals("L")){
        if(iter.hasPrevious()) {
          iter.previous();
        }
      }else if(input.equals("D")){
        if(iter.hasNext()) {
          iter.next();
        }
      }else if(input.equals("B")){
          if(iter.hasPrevious()){
            iter.previous();
            iter.remove();
          }
      }else{ // P $
        char newInput = input.charAt(2);
        iter.add(newInput);
      }
    }
    iter = list.listIterator();
    while(iter.hasNext()) {
      bw.write(iter.next());
    }

    bw.flush();
    bw.close();

    return;
  }
}