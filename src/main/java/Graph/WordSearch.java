package Graph;

public class WordSearch {
    public static void main(String[] args) {
//        char[][] board ={
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}
//        };
//        String word ="ABCCED";

//        char[][] board ={
  //              {'Z'}
    //    };
//        String word ="Z";

//        char[][] board ={
//                {'A'}
//        };
//        String word ="AB";

       char[][] board ={
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word ="ABCESEEEFS";


        System.out.println(exist(board, word));
    }

    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public static boolean exist(char[][] board, String word) {
        boolean possible = false;
        if (board == null || word == null) return possible;
        if (word.length() == 1 && word.charAt(0) == board[0][0]) return true;

        boolean[][] checked = new boolean[board.length][board[0].length];

        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    possible = dfs(board, checked, word, 1, i, j, false);
                    if (possible) return possible;
                }
            }
        }

        return possible;
    }

    public static boolean dfs(char[][] board, boolean[][] checked, String word, int target, int dx, int dy, boolean state){
        checked[dx][dy] = true;

        if (dx-1 >= 0 && board[dx-1][dy] == word.charAt(target) && checked[dx-1][dy] == false){
            if (target == word.length()-1) return true;
            state = dfs(board, checked, word, ++target, dx-1, dy, state);
        }
        if (dy+1 < board[0].length && board[dx][dy+1] == word.charAt(target) && checked[dx][dy+1] == false){
            if (target == word.length()-1) return true;
            state = dfs(board, checked, word, ++target, dx, dy+1, state);
        }
        if (dx+1 < board.length && board[dx+1][dy] == word.charAt(target) && checked[dx+1][dy] == false){
            if (target == word.length()-1) return true;
            state = dfs(board, checked, word, ++target, dx+1, dy, state);
        }
        if (dy-1 >= 0 && board[dx][dy-1] == word.charAt(target) && checked[dx][dy-1] == false){
            if (target == word.length()-1) return true;
            state = dfs(board, checked, word, ++target, dx, dy-1, state);
        }

        return state;
    }
}
