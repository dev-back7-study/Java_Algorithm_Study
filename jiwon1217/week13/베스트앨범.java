package jiwon1217.week13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 베스트앨범 {
    /**
     * 문제 풀이
     * 1. 순회하며 장르별 총 재생횟수 계산하고, 장르별 노래 리스트 추가
     * 2. 장르 정렬, 각 장르별 노래 정렬
     * 3. 최대 2곡씩 선택
     * 시간 복잡도
     * N: 장르의 길이
     * O(NlogN)
     */
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotalPlays = new HashMap<>();
        Map<String, List<int[]>> genreToSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreTotalPlays.put(genres[i], genreTotalPlays.getOrDefault(genres[i], 0) + plays[i]);

            genreToSongs.computeIfAbsent(genres[i], k -> new ArrayList<>())
                .add(new int[]{i, plays[i]});
        }
        List<String> sortedGenres = new ArrayList<>(genreTotalPlays.keySet());
        sortedGenres.sort((a, b) -> genreTotalPlays.get(b) - genreTotalPlays.get(a));

        List<Integer> answer = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<int[]> songs = genreToSongs.get(genre);

            songs.sort((s1, s2) -> {
                if (s2[1] != s1[1]) {
                    return s2[1] - s1[1];
                }
                return s1[0] - s2[0];
            });

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                answer.add(songs.get(i)[0]);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
