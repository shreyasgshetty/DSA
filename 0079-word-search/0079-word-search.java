class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (getWord(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean getWord(int i, int j, char[][] board, String word, int index){
        if(index == word.length()){
            return true;
        }

        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length) {
            return false;
        }

        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found =
                getWord(i + 1, j, board, word, index + 1) ||
                getWord(i - 1, j, board, word, index + 1) ||
                getWord(i, j + 1, board, word, index + 1) ||
                getWord(i, j - 1, board, word, index + 1);

        board[i][j] = temp;

        return found;

    }
}