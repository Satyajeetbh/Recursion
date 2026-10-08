package strings;


import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        subseq("abc","");
        System.out.println(subseqRet("abc",""));
    }

    static void subseq(String up, String p){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        subseq(up.substring(1),p+ch);
        subseq(up.substring(1),p);

    }

    static ArrayList<String> subseqRet(String up, String p){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String> add = subseqRet(up.substring(1),p+ch);
        ArrayList<String> skip = subseqRet(up.substring(1),p);
        add.addAll(skip);
        return add;
    }
}
