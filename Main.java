import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main{
    public static void main(String[] args){
        Map<String,Integer> mymap=new TreeMap<>();
        String path="txtfile.txt";
        try(BufferedReader read=new BufferedReader(new FileReader(path))){
            String line;
            while ((line = read.readLine()) != null){
                //System.out.println(line);
                String tem="";
                for(int i=0;i<line.length();i++){
                    if((line.charAt(i)>='a'&&line.charAt(i)<='z')||(line.charAt(i)>='A'&&line.charAt(i)<='Z')){
                        char ch=Character.toLowerCase(line.charAt(i));
                        tem+=ch;
                    }else{
                        mymap.put(tem, mymap.getOrDefault(tem, 0)+1);
                        tem="";
                    }
                }
                if(tem.length()>0){
                    mymap.put(tem, mymap.getOrDefault(tem, 0)+1);
                }

            } 

        }catch(IOException e){
            e.printStackTrace();
        }
    for(Map.Entry<String,Integer> it:mymap.entrySet()){
            System.out.println(it.getKey()+" "+it.getValue());
        }
    }

}