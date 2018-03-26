package ineed.to.practice;

import java.util.*;
import java.util.stream.Collectors;

public class Traveller {

    final static String INPUT = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
            "john.png, London, 2015-06-20 15:13:22\n" +
            "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
            "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
            "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
            "BOB.jpg, London, 2015-08-05 00:02:03\n" +
            "notredame.png, Paris, 2015-09-01 12:00:00\n" +
            "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
            "a.png, Warsaw, 2016-02-13 13:33:50\n" +
            "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
            "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
            "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
            "e.png, Warsaw, 2016-01-02 09:49:09\n" +
            "f.png, Warsaw, 2016-01-02 10:55:32\n" +
            "g.jpg, Warsaw, 2016-02-29 22:13:11\n";

    final static String OUTPUT = "Warsaw02.jpg\n" +
            "London1.png\n" +
            "Warsaw01.png\n" +
            "Paris2.jpg\n" +
            "Paris1.jpg\n" +
            "London2.jpg\n" +
            "Paris3.png\n" +
            "Warsaw03.jpg\n" +
            "Warsaw09.png\n" +
            "Warsaw07.jpg\n" +
            "Warsaw06.jpg\n" +
            "Warsaw08.jpg\n" +
            "Warsaw04.png\n" +
            "Warsaw05.png\n" +
            "Warsaw10.jpg\n";

    public static void main(String[] args) {
        System.out.println(checkCorrect(INPUT, OUTPUT));
    }

    private static String checkCorrect(String input, String output) {
        String solution = solution8(input);
        if (!solution.equals(output)) {
            System.err.println("WRONG");
            System.err.println("EXPECTED");
            System.err.println(output);

        }
        return solution;
    }

    private static String solution(String str) {
        if (str == null || str.length()==0) return "";
        String[] lines = str.split("\\r?\\n");
        List<String[]> lineRecords = new ArrayList<String[]>(lines.length);
        Map<String, List<String[]>> records = new HashMap<String, List<String[]>>();
        for (String line: lines) {
            if (line != null && line.length()>0) {
                String[] entries = line.split(", ");
                String[] fileEntries = entries[0].split("\\.");
                String[] record = {fileEntries[0], fileEntries[1], entries[1], entries[2]};
                lineRecords.add(record);
                List<String[]> recordsArr = records.get(entries[1]);
                if (recordsArr == null) {
                    recordsArr = new ArrayList<String[]>();
                    records.put(entries[1], recordsArr);
                }
                recordsArr.add(record);
            }
        }
        for (List<String[]> recordsList: records.values()) {
            Collections.sort(recordsList, new Comparator<String[]>() {
                @Override
                public int compare(String[] s1, String[] s2) {
                    return s1[3].compareTo(s2[3]);
                }
            });
        }
        StringBuilder result = new StringBuilder();
        for (String[] lineRec: lineRecords) {
            result.append(lineRec[2]).append(getCount(lineRec, records)).append(".").append(lineRec[1]).append("\n");
        }
        return result.toString();
    }

    private static String solution8(String str) {
        if (str == null || str.length()==0) return "";
        List<String[]> lineRecords = new ArrayList<String[]>();
        Map<String, List<String[]>> records = Arrays.stream(str.split("\\r?\\n"))
            .map(line -> line.split(", "))
                .map(lineArr -> {
                    String[] fileEntries = lineArr[0].split("\\.");
                    String[] record = new String[]{fileEntries[0], fileEntries[1], lineArr[1], lineArr[2]};
                    lineRecords.add(record);
                    return record;
                }).collect(Collectors.groupingBy(lineArr -> lineArr[2]));
        for (List<String[]> recordsList: records.values()) {
            Collections.sort(recordsList, new Comparator<String[]>() {
                @Override
                public int compare(String[] s1, String[] s2) {
                    return s1[3].compareTo(s2[3]);
                }
            });
        }
        StringBuilder result = new StringBuilder();
        for (String[] lineRec: lineRecords) {
            result.append(lineRec[2]).append(getCount(lineRec, records)).append(".").append(lineRec[1]).append("\n");
        }
        return result.toString();
    }

    private static String getCount(String[] lineRec, Map<String, List<String[]>> records) {
        List<String[]> lineRecords = records.get(lineRec[2]);
        int count = lineRecords.size();
        int index = 0;
        for (int i = 0; i < lineRecords.size(); i++) {
            if (Arrays.equals(lineRec, lineRecords.get(i))) {
                index = i+1;
                break;
            }
        }
        StringBuilder result = new StringBuilder();
        int fills = (count / 10) - (index / 10);
        for (int i = 0; i < fills; i++ ) {
            result.append(0);
        }
        result.append(index);
        return result.toString();
    }

}
