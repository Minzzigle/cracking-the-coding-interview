// 4.7 순서 정하기: 프로젝트의 리스트와 프로젝트들 간의 종속 관계(즉, proj 쌍이 리스트로 주어지면 두 번째 proj이 첫번째에 종속)가 주어졌을 때, 프로젝트 수해 순서를 찾아라. 
//유효한 순서가 존재하지 않으면 에러를 발생한다.
/*
 * 전체 proj에서 종속관계에서 두번째 위치한 proj들을 소거한다. 모두 소거되면 error. 소거되지 않은 노드부터 큐에 넣는다. 
 * 큐에서 빼면서 방문하며 자식노드 (종속 proj)들을 큐에 넣는다. inorder.
 */

function Graph (v, next) {
    this.v = v;
    this.next = Array.isArray(next) ? next: [];
};

Graph.prototype.addNext = function (nextGraph) {
    this.next.push(nextGraph);
}

(function () {
    function findOrder (list, connectionList) {
        // 그래프를 만든다
        var graphs = {};
        var q = []; // push, shift 메소드 사용
        var result = [];
        for (var i = 0; i < list.length; i++) {
            graphs[list[i]] = new Graph(list[i]);
        }

        // 종속된 프로젝트를 소거 & 종속을 그래프로 저장
        for (var j = 0; j < connectionList.length; j++) {
            var delIdx = list.indexOf(connectionList[j][1]);
            graphs[connectionList[j][0]].addNext(graphs[connectionList[j][1]]);
            if (delIdx != -1) {
                list.splice(delIdx, 1);
            }
        }

        if (list.length === 0) {
            console.error('유효한 순서가 존재하지 않습니다');
            return;
        }
        // list를 큐에 넣고 순회 (방문후 next를 집어넣음)
        for (var k = 0; k < list.length; k++) {
            q.push(graphs[list[k]]);
        }

        while (q.length !== 0) {
            var cur = q.shift();
            if (graphs[cur.v]) {
                result.push(cur.v);
                for (var i = 0; i < cur.next.length; i++) {
                    q.push(cur.next[i]);
                }
                graphs[cur.v] = null
            }
        }

        return result;


    };
    var r = findOrder(['a', 'b', 'c', 'd', 'e', 'f'], [['a', 'd'], ['f', 'b'], ['b', 'd'], ['f', 'a'], ['d', 'c']]);
    console.log(r);
})();

// 4.8 첫번째 공통조상: 이진 트리에서 노두 두개가 주어졌을 때, 첫번째 공통조상을  찾아라. 자료구조내에 추가로 노드를 저장해 두면 안된다. 반드시 이진탐색트리일 필요는 없다.
/*
 * 각 부모를 따라 올라가며 높이를 카운팅. 높이가 긴 쪽을 움직여서 (부모쪽으로) 높이레벨을 맞춘다.
 * 높이가 맞으면 각 1칸씩 이동하며 만나는 노드를 찾아서 반환한다.
 *
 * 둘 중 하나를 잡고, 한칸 올라간 후 반대쪽 sub tree에 나머지 노드가 있는지 확인하는 방법도 있겠지만 더 복잡할듯 함
 */

function Tree (v, r, l) {
    this.v = v || null;
    this.r = r || null;
    this.l = l || null;
};

(function () {
    function findAncestor (node, target1, target2, getResult) {
        var sum = 0;
        var isTarget = false;

        if (node === target1 || node === target2) {
            isTarget = true;
        }
        if (node.r === null && node.l === null) {
            if (isTarget) {
                return 1;
            } else {
                return 0;
            }
        }

        sum = findAncestor(node.r, target1, target2, getResult) + findAncestor(node.l, target1, target2, getResult);
        if (isTarget) {
            sum++;
        }

        if (!getResult && sum === 2) {
            getResult = true;
            console.log(node.v);
        }
        return sum;
    }
    var node5 = new Tree(5);
    var node4 = new Tree(4);
    var node3 = new Tree(3);
    var node2 = new Tree(2, node5, node4);
    var head = new Tree(1, node3, node2);

    findAncestor(head, node4, node5, false); //v 2가 나와야 함
})();
