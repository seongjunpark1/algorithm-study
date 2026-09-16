import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int index = 0; index < commands.length; index++){
            int i = commands[index][0];
            int j = commands[index][1];
            int k = commands[index][2];
            
            int[] slice = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(slice);
            answer[index] = slice[k - 1];
        }
        return answer;
    }
    
}

// 문제 풀이
// Line 6 : commands 배열을 for문으로 돌리면서 각 명령어를 처리함.
// Line 7,8,9 : 각 명령어에서 i, j, k 값을 추출하고
// Line 11 : array 배열에서 i번째부터 j번째까지의 부분 배열을 추출함. slice()함수와 비슷한 기능을 하는 copyOfRange() 함수를 사용함.
// Line 12 : sort() 함수를 사용하여 추출한 부분 배열을 정렬함.
// Line 13 : 정렬된 배열에서 k번째 원소를 선택하여 answer 배열에 저장함.
// Line 15 : 모든 명령어를 처리한 후 answer 배열을 반환함.


