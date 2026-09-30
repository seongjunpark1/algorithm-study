# [프로그래머스] 같은 숫자는 싫어

## 1. 문제를 보고 처음에 떠올린 아이디어

이 문제는 배열의 인덱스 위치의 값을 서로 비교 한 뒤 앞 뒤가 다르면 뒤에 값을 배열에 추가하는 식으로 구현하면 된다고 생각했다.

하지만 배열은 크기가 고정이라 결과 크기를 미리 알 수 없는 상황에서 직접 추가할 수 없으니 크기가 늘어나는 리스트(ArrayList)에 담는 방향으로 잡았다.

## 2. 그 아이디어를 바탕으로 정한 풀이 방식

ArrayList를 만들어서 첫 번째 원소를 미리 넣어둔다. 첫 원소는 비교할 앞 값이 없기 때문이다.

그다음 i = 1부터 끝까지 돌면서 arr[i] != arr[i - 1]일 때만 리스트에 추가한다.

마지막에 List<Integer>는 int[]로 자동 변환되지 않으므로 for문(또는 stream)으로 옮겨 담아 반환했다.

## 3. 실제 코드 구조

```java
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List <Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i - 1] ){
                list.add(arr[i]);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
```

## 4. 풀면서 막혔던 부분과 새롭게 알게 된 점

- 인덱스끼리 비교(`i == i + 1`)하면 항상 false다. 비교해야 하는 건 인덱스 위치의 값(`arr[i]`, `arr[i - 1]`)이다.
- 반복문을 i = 0부터 시작하면 `arr[-1]`을 읽어 ArrayIndexOutOfBoundsException이 난다. 첫 원소를 미리 넣고 i = 1부터 돌아야 한다.
- 배열은 크기가 고정이라 add가 안 되고, ArrayList는 내부 배열이 꽉 차면 더 큰 배열로 복사해 크기를 늘려준다. ArrayList는 배열 기반이지만 배열 자체는 아니다.
- List<Integer>는 int[]로 바로 변환되지 않는다(Integer와 int가 다름).
