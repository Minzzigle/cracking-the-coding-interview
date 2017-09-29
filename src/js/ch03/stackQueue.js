// 3.1 한 개로 세 걔: 배열 한 개로 스택 세 개를 구현
(function () {
    function Stack () {
        this.arr = [];
        this.sIdx = [
            {
                s: 0,
                c: 0,
                e: 9
            },
            {
                s: 10,
                c: 10,
                e: 19
            },
            {
                s: 20,
                c: 20,
                e: 29
            }
        ];
    }

    Stack.prototype.push = function (sN, v) {
        var sIdx = this.sIdx[sN - 1];
        if (sIdx.c === sIdx.e) {
            console.log('Full stack');
            return;
        }
        this.arr[sIdx.c] = v;
        sIdx.c++;
    };

    Stack.prototype.pop = function (sN) {
        var sIdx = this.sIdx[sN - 1];
        if (sIdx.c === sIdx.s) {
            console.log('Empty stack');
            return;
        }
        return this.arr[--sIdx.c];
    };

    var s = new Stack();
    s.push(1, 3);
    s.push(2, 5);
    s.push(3, 1);
    s.pop(1);
})();

// 3.2 기본적인 push, pop 기능이 구현된 스택에서 최솟값을 반환하는 min함수 추가 O(1)이어야 함
(function () {
    function Stack () {
        this.stack = [];
        this.min = [];
    }

    Array.prototype.peek = function () {
        if (this.length === 0) {
            return null;
        }
        return this[this.length - 1];
    };

    Stack.prototype.push = function (v) {
        this.stack.push(v);

        if (this.min.length === 0 || this.min.peek() > v) {
            this.min.push(v);
        }
    };

    Stack.prototype.pop = function () {
        var v = this.stack.pop();
        if (v === this.min.peek()) {
            this.min.pop();
        }
        return v;
    };

    Stack.prototype.minv = function () {
        return this.min.peek();
    };

    var s = new Stack();
    s.push(4);
    s.push(5);
    s.push(3);
    s.minv();
    s.pop();
    s.minv();
})();
