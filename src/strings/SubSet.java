package strings;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> ans = subset(arr);
        for(List<Integer> list: ans){
            System.out.println(list);
        }
    }

    static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for(int num : arr){
            int n = outer.size();
            for (int i = 0; i < n;i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));//ye andar wala list hai aur hum us list me num add dal rahe hai.outer.(i)->[1]
                internal.add(num);// agr i=1 hai to say outer.get(i) ek list return karega kyunki outer ek list ka list hai. aur list me add kar do num [1,num]
                outer.add(internal); //aur fir internal ko outer me dal do. khel khatam
            }
        }
        return outer;
    }

}
