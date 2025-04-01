# 자연수 뒤집어 배열로 만들기

## 상수조건
- 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

## 풀이
- 자연수 n을 문자열로 변환한다.
- StringBuilder를 사용하여 각 자리 숫자를 역순으로 저장한다.
- 역순으로 나온 문자열을 char[] 형태로 변환한다.
- char[]를 int[]로 변환한다.
- int[]를 리턴한다.

## 풀이실수

- 1st
    - StringBuilder reverse 함수를 몰라서 하드하게 구현함
    - 나중에 풀이집을 보고 StringBuilder 로 바꿈

## 출처
https://school.programmers.co.kr/learn/courses/30/lessons/12932


## 소요시간
1st 20분

## 복잡도
- 시간 복잡도: O(N)
- 공간 복잡도: O(N)
