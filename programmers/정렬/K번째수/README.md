# [프로그래머스] K번째 수

## 1. 문제를 보고 처음에 떠올린 아이디어

문제를 처음 봤을 때 아이디어가 떠오르지 않아서 막막했다.

처음에는 문제를 이해하는데 많은 시간이 걸렸다.

문제를 이해하고 나서는 자바의 슬라이스 함수와 정렬 함수에 대해 검색했다.

그리고 `for`문을 어떻게 활용할지 고민했다. `for`문으로 배열을 순회하며 해당 배열의 2차원배열값을 꺼내서 슬라이싱하면 될 것 같다는 생각을 했다.

## 2. 그 아이디어를 바탕으로 정한 풀이 방식

`for`문을 돌려서 `commands`를 순회한다.
각 명령에서 `i,j,k` 값을 꺼내서 index를 slice 하려고했다.
하지만 자바의 Arrays클래스는 `slice()`함수를 지원하지 않는다. 그래서 비슷한 기능인 `copyOfRange()`함수를 발견하고 사용하는법을 익혔다.
slice한 값을 `sort()` 함수로 정렬한 뒤 `answer`에 담아서 리턴한다.
구조는 크게 세 부분으로 나눌 수 있다. 먼저 `answer` 배열을 `commands.length` 크기로 미리 만들어서, 명령 개수만큼 결과를 담을 자리를 확보했다. 그다음 `for` 문으로 commands를 순회하면서 각 명령에서 `i, j, k` 값을 꺼내고, `copyOfRange`로 자른 뒤 `sort`로 정렬하고, 정렬된 배열의 `k - 1`번째 값을 `answer[idx]`에 저장했다. 마지막으로 모든 명령을 처리한 뒤 `answer`를 반환하면 된다.

## 3. 실제 코드 구조

최종 코드

```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int index = 0; idx < commands.length; index++) {
            int i = commands[index][0];
            int j = commands[index][1];
            int k = commands[index][2];

            int[] sliced = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(sliced);
            answer[index] = sliced[k - 1];
        }

        return answer;
    }
}
```

## 4. 풀면서 막혔던 부분과 새롭게 알게 된 점

가장 헷갈렸던 부분은 `for`문을 구성하는 방법이었다.
`i,j,k`값을 추출한다라는 부분을 그려가는 것이 어려웠다.
알고리즘 문제풀이가 처음이다보니 감을 잡는데 시간이 많이 걸렸다.
각종 함수를 사용해서 구현하는 것도 방법이다.
