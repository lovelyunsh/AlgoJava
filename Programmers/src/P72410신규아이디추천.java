public class P72410신규아이디추천 {


	public String solution(String new_id) {
		new_id = new_id.toLowerCase();
		new_id = new_id.replaceAll("[^a-z0-9\\.\\-\\_]", "");
		new_id = new_id.replaceAll("[\\.]\\.*", ".");
		StringBuilder sb = new StringBuilder(new_id);
		if (sb.charAt(0) == '.')
			sb.deleteCharAt(0);
		if (sb.length() >0 && sb.charAt(sb.length() - 1) == '.')
			sb.deleteCharAt(sb.length() - 1);
		if (sb.length() == 0)
			sb.append("a");
		if (sb.length() > 15)
			sb = sb.delete(15, sb.length());
		if (sb.charAt(sb.length() - 1) == '.')
			sb.deleteCharAt(sb.length() - 1);
		while(sb.length() <3)
			sb.append(sb.charAt(sb.length()-1));
		
		String answer = sb.toString();
		return answer;
	}

}
