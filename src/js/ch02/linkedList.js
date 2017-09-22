function SingleLinkedNode(v, next) {
    this.value = v || null;
    this.next = next || null;
}

SingleLinkedNode.prototype.setNext = function (next) {
    this.next = next;
};

SingleLinkedNode.prototype.print = function () {
    var cur = this;
    var count = 0;
    while (count < 100 && cur) {
        count++;
        console.log(cur.value);
        cur = cur.next;
    }
};

// 2.3 중간노드 삭제
(function () {
    function make() {
        var a = [];
        a.push(new SingleLinkedNode('a'));
        a.push(new SingleLinkedNode('b'));
        a.push(new SingleLinkedNode('c'));
        a.push(new SingleLinkedNode('d'));
        a.push(new SingleLinkedNode('e'));

        for (var i = 0; i < a.length - 1; i++) {
            a[i].setNext(a[i + 1]);
        }
        return a;
    }
    // 정답! : 나는 그냥 덮어쓰기를 하려고 했는데 얕은복사, 깊은복사의 문제인듯
    function del(delNode) {
        if (!delNode.next) {
            delNode.next = new SingleLinkedNode();
        }
        delNode.value = delNode.next.value;
        delNode.next = delNode.next.next;
    }

    var arr1 = make();
    del(arr1[2]);
    console.log('del method test: ');
    arr1[0].print();

    // 풀이 | Error : 문제 이해를 잘 못함
    function delateNode(firstNode, delNode) {
        var cur = firstNode;
        if (cur.value === delNode.value) {
            return cur.next;
        }
        while (cur.next) {
            if (cur.next.value === delNode.value) {
                cur.next = cur.next.next;
                break;
            } else {
                cur = cur.next;
            }
        }
        return firstNode;
    }
    var arr2 = make();
    console.log('delateNode method test: ');
    var r = delateNode(arr2[0], arr2[2]);
    r.print();
})();

// 2.4 x값 기준으로 작은 것과 같거나 큰 값 으로 나누기(정렬)
(function () {
    function make() {
        var b = [];
        b.push(new SingleLinkedNode(3));
        b.push(new SingleLinkedNode(5));
        b.push(new SingleLinkedNode(8));
        b.push(new SingleLinkedNode(5));
        b.push(new SingleLinkedNode(10));
        b.push(new SingleLinkedNode(2));
        b.push(new SingleLinkedNode(1));

        for (var i = 0; i < b.length - 1; i++) {
            b[i].setNext(b[i + 1]);
        }
        return b;
    }

    // 풀이 | 간단한 풀이
    function separateCertainX(firstNode, x) {
        var cur = firstNode;
        var head = cur;
        var notSmallHead = new SingleLinkedNode();
        var notSmallCur = notSmallHead;

        while (cur.value >= x) {
            notSmallCur.next = cur;
            notSmallCur = notSmallCur.next;
            cur = cur.next;
            head = cur;
        }

        while (cur.next) {
            if (cur.next.value >= x) {
                notSmallCur.next = cur.next;
                notSmallCur = notSmallCur.next;
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        notSmallCur.next = null;
        cur.next = notSmallHead.next;
        return head;
    }
    var arr1 = make();
    var r = separateCertainX(arr1[0], 5);
    console.log('simple method test: ');
    r.print();

    // 정답 | 리스트를 활용
    function partition(node, x) {
        var head = node;
        var tail = node;
        var next;

        while (node !== null) {
            next = node.next;
            if (node.value < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        return head;
    }

    var arr2 = make();
    var r2 = partition(arr2[0], 5);
    console.log('partition method test: ');
    r2.print();
})();
