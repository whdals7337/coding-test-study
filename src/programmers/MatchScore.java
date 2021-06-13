package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Page {
    private final int basicScore;
    private final int linkCount;

    public Page(int basicScore, int linkCount) {
        this.basicScore = basicScore;
        this.linkCount = linkCount;
    }

    public int getBasicScore() {
        return basicScore;
    }

    public int getLinkCount() {
        return linkCount;
    }

    public double calcSubPLinkScore() {
        if (linkCount != 0) {
            return  (double) basicScore / linkCount;
        }
        return 0;
    }
}

// 프로그래머스 매칭 점수 문제
class MatchScore {
    static Map<String, Page> pageMap = new HashMap<>();
    static Map<String, List<String>> graph = new HashMap<>();
    static List<String> pNames = new ArrayList<>();
    public int solution(String word, String[] pages) {
        word = word.toLowerCase();
        for(int i = 0; i < pages.length; i++) {
            pages[i] = pages[i].toLowerCase();
        }

        for(int i = 0; i < pages.length; i++) {
            String pName = getPageName(pages[i]);
            int basicScore = calcBasicScore(pages[i], word);
            int linkCount = calcLinkCountAndSetGraph(pages[i], pName);

            pNames.add(pName);
            pageMap.put(pName, new Page(basicScore ,linkCount));
        }

        return getTopMatchScoreSiteIndex();
    }

    static String getPageName(String page){
        String pName = "";
        Pattern pageName = Pattern.compile("<meta property=\"og:url\" content=\\S+/>");
        Matcher pageNameMatcher = pageName.matcher(page.split("</head>")[0]);

        if (pageNameMatcher.find()) {
            pName = pageNameMatcher.group(); // <meta property="og:url" content="https://a.com"/>
        }
        pName = pName.substring("<meta property=\"og:url\" content=\"https://".length()); // a.com"/>
        pName = pName.substring(0, pName.length()-"\"/>".length()); // a.com
        return pName;
    }

    static int calcBasicScore(String page, String word) {
        int basicScore = 0;
        page = page.split("<body>")[1].replaceAll("[0-9]", " ");
        Pattern pattern = Pattern.compile("\\b"+word+"\\b");
        Matcher matcher = pattern.matcher(page);
        while(matcher.find()) {
            basicScore++;
        }
        return basicScore;
    }

    static int calcLinkCountAndSetGraph(String page, String pageName) {
        int linkCount = 0;
        page = page.split("<body>")[1];
        Pattern linkPattern = Pattern.compile("<a href=\\S+>");
        Matcher linkMatcher = linkPattern.matcher(page);
        while(linkMatcher.find()) {
            linkCount++;
            String tempGroup = linkMatcher.group();
            tempGroup = tempGroup.substring("<a href=\"https://".length());
            tempGroup = tempGroup.substring(0, tempGroup.length() - 2);
            if(tempGroup.charAt(tempGroup.length()-1) == '/') {
                tempGroup = tempGroup.substring(0, tempGroup.length()-4);
            }
            graph.put(tempGroup, graph.getOrDefault(tempGroup, new ArrayList<>()));
            graph.get(tempGroup).add(pageName);
        }
        return linkCount;
    }

    static int getTopMatchScoreSiteIndex() {
        int idx = 0;
        double maxvalue = 0;
        for (int i = 0; i < pNames.size(); i++) {
            String pName = pNames.get(i);
            Page page = pageMap.get(pName);
            int basicScore = page.getBasicScore();
            double linkScore = calcLinkScore(pName);

            if (maxvalue < basicScore + linkScore) {
                idx = i;
                maxvalue = basicScore + linkScore;
            }
        }
        return idx;
    }

    static double calcLinkScore(String pageName) {
        if (!graph.containsKey(pageName)) {
            return 0;
        }

        double linkScore = 0;
        for (String subPage : graph.get(pageName)) {
            if (pageMap.containsKey(subPage)) {
                Page page = pageMap.get(subPage);
                linkScore += page.calcSubPLinkScore();
            }
        }
        return linkScore;
    }
}