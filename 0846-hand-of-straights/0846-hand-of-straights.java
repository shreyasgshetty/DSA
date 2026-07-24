class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;

        HashMap<Integer,Integer> hm = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int card: hand){
            hm.put(card,hm.getOrDefault(card,0)+1);
            pq.add(card);
        }

        while(!pq.isEmpty()){
            while (!pq.isEmpty() && hm.get(pq.peek()) == 0) {
                pq.poll();
            }

            if (pq.isEmpty())
                break;

            int start = pq.peek();

            for (int i = start; i < start + groupSize; i++) {

                if (!hm.containsKey(i) || hm.get(i) == 0)
                    return false;

                hm.put(i, hm.get(i) - 1);
            }
        }

        return true;
    }
}