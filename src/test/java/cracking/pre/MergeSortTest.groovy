package cracking.pre

import spock.lang.Specification

class MergeSortTest extends Specification {

    MergeSort mergeSort

    void setup() {
        mergeSort = new MergeSort()
    }

    def "Sort_빈배열이들어오는경우"() {
        given:
        int [] arr = {}

        when:
        def result = mergeSort.sort(arr, 0, 0)

        then:
        result.size() == 0
    }
}
