# [프로그래머스] 완주하지 못한 선수

## 1. 문제를 보고 처음에 떠올린 아이디어

마라톤에 참가한 선수는 1로만들고 마라톤에서 완주한 선수는 0으로 만든다.

문제에서 중복된 선수는 한명만 출력하라고 되어있기 때문에 내부적으로 중복을 허용하지 않는 HashMap를 사용하기로 했다.

## 2. 그 아이디어를 바탕으로 정한 풀이 방식

getOrDefalut() 함수는 키(코드에서는 p)에 해당하는 값을 반환하되, 없으면 기본값(코드에서는 0)을 반환함.

그래서 map에 저장한 participant와 completion을 각각 for문을 돌려 참가선수 배열에는 1을 더하고 완주선수 배열엔 1을 뺀다. 

마지막으론 participant에서 반복문을 돌려 map에 값이 0이 아닌 선수를 찾아서 완주하지못한선수를 골라낸다.

여기서 키포인트는 중복선수인데, 이름으로 골라내지 않고 참가한 인원수로 로직을 풀어낸게 그 이유다.

HashMap의 value에 인원수를 담아서 참가 시 +1 완주 시 -1로 ㅂ교했다.

## 3. 실제 코드 구조

```
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        
        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        for(String p : completion){
            map.put(p, map.getOrDefault(p, 0) - 1);
        }
        
        for(String p : participant){
            if(map.get(p) != 0) {
                return p;
            }
        }
        
        return "";
       
    
    }
}
```
## 4. 풀면서 막혔던 부분과 새롭게 알게 된 점

HashMap과 HashSet의 차이를 알게되었다. Set은 같은 값을 넣으면 무시하고 하나만 저장하기 때문에 동명이인이 몇명인지 정보를 알 수 없다.
Map은 key는 중복을 막고 value에 인원을 담아낼 수 있어서 박성준=1 일때 1을더하면 박성준=2가 되기때문에 동명이인이 몇명인지 정보를 알 수 있다. 
이때 `map.put(name, map.getOrDefault(name, 0) + 1)`처럼 기존 값을 꺼내 +1 해서 다시 넣는다.
참가자는 +1, 완주자는 -1 하면 값이 0이 아닌 이름이 완주하지 못한 선수이다.
