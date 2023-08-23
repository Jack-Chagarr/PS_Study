import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            LinkedList<Character> keyLogged = new LinkedList<>();



            ListIterator<Character> iter = keyLogged.listIterator();
            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                if(c == '<'){
                    if(iter.hasPrevious()) iter.previous();
                }else if(c == '>'){
                    if(iter.hasNext()) iter.next();
                }else if(c == '-'){
                    if(iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                }else iter.add(c);
            }

            Iterator<Character> newIter = keyLogged.iterator();
            while(newIter.hasNext()){
                bw.write(newIter.next());
                //System.out.println(newIter.next());
            }

            bw.write("\n");
            bw.flush();
        }
        bw.close();
        return;

    }
}
