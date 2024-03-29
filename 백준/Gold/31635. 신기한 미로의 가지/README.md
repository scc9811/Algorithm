# [Gold IV] 신기한 미로의 가지 - 31635 

[문제 링크](https://www.acmicpc.net/problem/31635) 

### 성능 요약

메모리: 17448 KB, 시간: 260 ms

### 분류

애드 혹, 해 구성하기, 깊이 우선 탐색, 그래프 이론, 그래프 탐색, 트리

### 제출 일자

2024년 3월 16일 21:10:39

### 문제 설명

<p>이 문제는 <strong>적응적 인터랙티브</strong> 문제입니다.</p>

<p>마법사 가지는 신기한 미로의 $1$번 정점에 입장합니다. 미로에는 $1$번부터 $N$번까지 번호가 붙은 정점이 있고, 총 $N-1$개의 양방향 간선이 있습니다. 이 미로에서 서로 다른 두 정점을 잇는 경로는 항상 존재하며 유일합니다.</p>

<p>현재 정점에서 연결된 다른 정점으로 이동하려면 다음 둘 중 하나의 주문을 외워 이동할 수 있으며, 이동한 후에 도착한 정점의 번호를 미로가 알려줍니다.</p>

<ul>
	<li><span style="color:#e74c3c;"><code>maze</code></span>: 미로의 마법으로 현재 정점과 연결된 정점 중 하나로 이동합니다. 해당 정점은 <strong>가지가 아닌 미로가 결정</strong>하며 다음 규칙을 따릅니다.

	<ul>
		<li>현재 정점과 연결되어 있고 방문하지 않은 정점 중 하나로 이동합니다.</li>
		<li>만약 그러한 정점이 없다면 현재 정점과 연결되어 있고 방문한 정점 중 하나로 이동합니다.</li>
	</ul>
	</li>
	<li><span style="color:#e74c3c;"><code>gaji</code> $m$</span>: 가지의 마법으로 $m$번 정점으로 이동합니다. $m$번 정점은 현재 정점과 연결된 정점이어야 합니다.</li>
</ul>

<p>마법사 가지는 신기한 미로의 지도를 만들고자 합니다. 그러나 미로는 $4N$번 초과하여 정점을 이동하는 것을 허락하지 않습니다. 지도 제작에 어려움을 겪고 있는 가지는 여러분에게 도움을 요청했습니다. 주어진 마법을 적절히 활용해 이동하고 도착한 정점을 입력받아 미로의 모든 간선을 찾아봅시다.</p>

### 입력 

 <p>첫 번째 줄에 정수 $N$이 주어집니다. $(2 \le N \le 100)$</p>

### 출력 

 <p>다음을 표준 출력 스트림(stdout)으로 한 줄에 출력하여 $4N$번까지 이동할 수 있습니다.</p>

<ul>
	<li><span style="color:#e74c3c;"><code>maze</code></span>: 미로의 마법으로 현재 정점과 연결된 정점 중 하나로 이동합니다. 해당 정점은 <strong>가지가 아닌 미로가 결정</strong>하며 다음 규칙을 따릅니다.

	<ul>
		<li>현재 정점과 연결되어 있고 방문하지 않은 정점 중 하나로 이동합니다.</li>
		<li>만약 그러한 정점이 없다면 현재 정점과 연결되어 있고 방문한 정점 중 하나로 이동합니다.</li>
	</ul>
	</li>
	<li><span style="color:#e74c3c;"><code>gaji</code> $m$</span>: 가지의 마법으로 $m$번 정점으로 이동합니다. $m$번 정점은 현재 정점과 연결된 정점이어야 합니다.</li>
</ul>

<p>이동 방법을 출력한 뒤, 여러분은 인터랙터에게서 양의 정수 하나를 입력받아 이동한 결과를 알 수 있습니다.</p>

<ul>
	<li><span style="color:#e74c3c;">$k$</span>: 도착한 정점은 $k$번 정점입니다.</li>
</ul>

<p>만약 미로의 모든 간선을 찾았다면 다음과 같이 정답을 출력합니다.</p>

<ul>
	<li><span style="color:#e74c3c;"><code>answer</code></span>를 한 줄에 출력한 뒤 다음 $N - 1$개 줄 각각에 미로의 간선을 출력합니다.</li>
	<li>각 줄에 양의 정수 $i$, $j$를 공백으로 구분하여 출력합니다. 이는 $i$번 정점과 $j$번 정점을 연결하는 간선이 존재한다는 뜻입니다. $(1 \le i, j \le N;$ $i \neq j)$</li>
	<li>정답 출력을 마친 직후 프로그램을 종료합니다.</li>
</ul>

<p>다음과 같은 경우에는 <span class="result-wa-text"><!-- 틀렸습니다 --></span>를 받습니다.</p>

<ul>
	<li>현재 정점에서 연결되어 있지 않은 정점으로 이동하려는 경우</li>
	<li>$4N$번 초과하여 정점을 이동하는 경우</li>
	<li>올바르지 않은 정답을 출력하는 경우</li>
</ul>

<p>다음과 같은 경우에는 예상하지 못한 채점 결과를 받을 수 있습니다.</p>

<ul>
	<li>어떤 출력 직후 출력 버퍼를 비우지 않은 경우</li>
	<li>출력 형식을 어기는 경우</li>
	<li>정답 출력을 마친 직후 프로그램을 종료하지 않은 경우</li>
</ul>

