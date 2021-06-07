package haqnawaz.org.expandablelistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListData {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> programming = new ArrayList<String>();
        programming.add("C");
        programming.add("C++");
        programming.add("Java");
        programming.add("Swift");
        programming.add("Kotlin");

        List<String> web = new ArrayList<String>();
        web.add("PHP");
        web.add("Dotnet");
        web.add("Angular");
        web.add("ROR");
        web.add("React");

        List<String> web1 = new ArrayList<String>();
        web1.add("PHP");
        web1.add("Dotnet");
        web1.add("Angular");
        web1.add("ROR");
        web1.add("React");


        expandableListDetail.put("Programming Languages", programming);
        expandableListDetail.put("Web Development Web", web);
        expandableListDetail.put("Web Development Web1", web1);
        return expandableListDetail;
    }
}