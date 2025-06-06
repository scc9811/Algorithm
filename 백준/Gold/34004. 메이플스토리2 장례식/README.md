# [Gold III] 메이플스토리2 장례식 - 34004 

[문제 링크](https://www.acmicpc.net/problem/34004) 

### 성능 요약

메모리: 14184 KB, 시간: 100 ms

### 분류

그리디 알고리즘, 애드 혹, 기하학, 3차원 기하학

### 제출 일자

2025년 5월 25일 19:39:41

### 문제 설명

<p style="text-align: center;"><img alt="묘비와 비석 앞에서 춤을 추는 pichulia 의 메이플스토리2 캐릭터" src="" style="max-width:80%;display:block; margin-left: auto; margin-right: auto;"></p>

<blockquote>
<p>"안녕하세요. 무슨 축제인가요?"</p>

<p>"아니요. 메이플스토리2 장례식입니다."</p>
</blockquote>

<p>메이플스토리 게임의 흥행에 맞춰서 2015년 7월 7일에 야심 차게 오픈했던 메이플스토리2는 2025년 5월 29일 자로 서비스를 종료한다.</p>

<p>2차원에서 움직이던 메이플스토리와는 다르게, 메이플스토리2는 3차원에서 3D 캐릭터가 움직이며, 지형지물도 모두 3차원으로 이루어져 있다.</p>

<p>메이플스토리2의 열렬한 플레이어였던 pichulia는 나흘 뒤에 열릴 장례식을 준비하며 메이플스토리2의 특성에 맞게 3차원으로 묘비를 만들고자 한다. 우선 단위길이의 정육면체 블록을 $N$ 개 준비한 뒤, 각 블록의 면을 이어 붙여서 3D 묘비를 만들 것이다.</p>

<p>물론 묘비를 그냥 만들면 재미가 없기 때문에, 겉넓이가 최소가 되는 묘비를 만들어서 메이플스토리2의 넋을 기리고자 한다.</p>

<p>블록의 개수 $N$ 이 주어졌을 때, 이 $N$ 개의 블록으로 만들 수 있는 묘비의 겉넓이 최솟값을 구해보자.</p>

### 입력 

 <p>첫 번째 줄에는 테스트 케이스의 개수 $T$ 가 입력으로 주어진다. ($1 \le T \le 10$)</p>

<p>이후 $T$ 줄에 걸쳐 블록의 개수 $N$ 이 주어진다. ($1 \le N \le 1\,000\,000$)</p>

<p>입력으로 주어지는 모든 $N$들의 합은 $1\,000\,000$보다 작거나 같다.</p>

### 출력 

 <p>테스트 케이스마다 겉넓이의 최솟값을 $T$ 줄에 걸쳐 한 줄에 하나씩 출력한다.</p>

