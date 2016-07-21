import java.util.*;

public class PrintSortedPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "ABCD";
		List<String> list =  permuteArray(string.toCharArray());
		for (String str : list) {
			System.out.println(str);
		}
	}

	private static List<String> permuteArray(char[] input) {
		// TODO Auto-generated method stub
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (Character ch: input){
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch) + 1);
			}else{
				map.put(ch, 1);
			}
		}
		char[] chars = new char[map.size()];
		int[] count = new int[map.size()];
		
		Set<Character> keys = map.keySet();
		int i = 0;
		for(Character key: keys){
			chars[i] = key;
			count[i] = map.get(key);
			i++;
		}
		
		List<String> permutations = new ArrayList<String>();
		char[] result = new char[input.length];
		permutationUtil(chars, count, result, permutations, 1, input.length);
		System.out.println("Length : "+ permutations.size());
		return permutations;
	}

	private static void permutationUtil(char[] chars, int[] count, char[] result, List<String> permutations, int level, int max) {
		// TODO Auto-generated method stub
		if(level == max + 1){
			//System.out.println(result.toString());
			permutations.add(new String(result));
			return;
		}
		for(int i = 0 ; i < count.length; i++){
			if(count[i] > 0){
				result[level - 1] = chars[i];
				count[i] -= 1;
				permutationUtil(chars, count, result, permutations, level + 1, max);
				count[i] += 1;
			}
		}
	}

}
