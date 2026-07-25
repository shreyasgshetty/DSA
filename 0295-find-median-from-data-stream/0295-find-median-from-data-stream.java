class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int idx = Collections.binarySearch(list, num);

        if (idx < 0)
            idx = -(idx + 1);
        list.add(idx, num);
    }
    
    public double findMedian() {
        if(list.size()%2==1) return list.get((list.size()/2));
        return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */