
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LC1087_Brace_Expansion {

    Set<String> visited = new HashSet<>();

    public String[] expand(String S) {
        int start = 0;
        List<List<String>> strList = new ArrayList<>();

        while (start < S.length()) {
            char cur = S.charAt(start);
            if (cur != '{') {
                List<String> curList = new ArrayList<>();
                curList.add(String.valueOf(cur));
                strList.add(curList);
                start++;
                continue;
            } else if (cur == '{') {
                int end = start + 1;
                List<String> curList = new ArrayList<>();
                while (end < S.length() && S.charAt(end) != '}') {
                    if (S.charAt(end) == ',') {
                        end++;
                    } else {
                        curList.add(String.valueOf(S.charAt(end)));
                        end++;
                    }
                }
                Collections.sort(curList);
                strList.add(curList);
                start = end + 1;
                continue;
            }
        }

        List<String> res = new ArrayList<>();
        dfs(res, strList, 0, "");
        return res.toArray(new String[0]);
    }

    public void dfs(List<String> res, List<List<String>> strList, int cur, String tmp) {
        if (cur == strList.size() && visited.add(tmp)) {
            res.add(tmp);
            return;
        }

        List<String> curList = strList.get(cur);
        for (String s : curList) {
            dfs(res, strList, cur + 1, tmp + s);
        }
        return;
    }
}
