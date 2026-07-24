class Solution {
    public int leastInterval(char[] tasks, int n) {
        int arr[] = new int[26];
        int maxfreq = 0;

        for(int i = 0; i < tasks.length; i++){
            arr[tasks[i]-'A']++;
            maxfreq = Math.max(maxfreq, arr[tasks[i] - 'A']);
        }

        int countmax = 0;

        for(int i = 0; i < arr.length;i++){
            if(maxfreq == arr[i]) countmax++;
        }

        return Math.max(tasks.length,(maxfreq-1)*(n+1)+countmax);

    }
}