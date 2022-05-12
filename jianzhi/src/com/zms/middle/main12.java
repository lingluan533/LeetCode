package com.zms.middle;

/**
 * @author: zms
 * @create: 2022/3/9 10:58
 */
public class main12 {
    public static void main(String[] args) {
//        char a[][] = new char[][]{
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}
//        };
//
//        exist(a,"ABCCED");
        char a[][] = new char[][]{{'A','B'}};
        System.out.println(exist(a, "BA"));
    }
    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                try {
                    dfs(i,j,board,board.length,board[0].length,word,new StringBuilder(),new boolean[board.length][board[0].length]);
                }catch (Exception e){
                    return true;
                }

            }
        }

         return  false;
    }

    private static void dfs(int i, int j, char[][] board,int row,int col,  String word, StringBuilder stringBuilder,boolean vis[][]) throws Exception {
        if(i ==row || i<0|| j==col || j < 0 || stringBuilder.length() == word.length() || vis[i][j]){
            return ;
        }
        if(stringBuilder.toString().equals(word)){
          throw new Exception();

        }
                if(stringBuilder.length()>=1){

                    if( board[i][j] == word.charAt(stringBuilder.length())){

                        //上
                        stringBuilder.append(board[i][j]);
                        vis[i][j] = true;
                        if(stringBuilder.toString().equals(word)){
                            throw new Exception();
                        }
                        dfs(i-1,j,board,row,col,word,stringBuilder,vis);
                        stringBuilder.deleteCharAt(stringBuilder.length()-1);
                        vis[i][j] = false;
                        //下
                        stringBuilder.append(board[i][j]);
                        vis[i][j] = true;
                        dfs(i+1,j,board,row,col,word,stringBuilder,vis);
                        stringBuilder.deleteCharAt(stringBuilder.length()-1);
                        vis[i][j] = false;
                        //左
                        stringBuilder.append(board[i][j]);
                        vis[i][j] = true;
                        dfs(i,j-1,board,row,col,word,stringBuilder,vis);
                        stringBuilder.deleteCharAt(stringBuilder.length()-1);
                        vis[i][j] = false;
                        //右
                        stringBuilder.append(board[i][j]);
                        vis[i][j] = true;
                        dfs(i,j+1,board,row,col,word,stringBuilder,vis);
                        stringBuilder.deleteCharAt(stringBuilder.length()-1);
                        vis[i][j] = false;
                    }else return ;
                }else {
                    if( board[i][j] == word.charAt(0)){
                        //上
                        stringBuilder.append(board[i][j]);
                        if(stringBuilder.toString().equals(word)){
                            throw new Exception();
                        }
                        vis[i][j] = true;
                        dfs(i-1,j,board,row,col,word,stringBuilder,vis);
                        stringBuilder.deleteCharAt(stringBuilder.length()-1);
                        vis[i][j] = false;
                        //下
                        stringBuilder.append(board[i][j]);
                        vis[i][j] = true;
                        dfs(i+1,j,board,row,col,word,stringBuilder,vis);
                        stringBuilder.deleteCharAt(stringBuilder.length()-1);
                        vis[i][j] = false;
                        //左
                        stringBuilder.append(board[i][j]);
                        vis[i][j] = true;
                        dfs(i,j-1,board,row,col,word,stringBuilder,vis);
                        stringBuilder.deleteCharAt(stringBuilder.length()-1);
                        vis[i][j] = false;
                        //右
                        stringBuilder.append(board[i][j]);
                        vis[i][j] = true;
                        dfs(i,j+1,board,row,col,word,stringBuilder,vis);
                        stringBuilder.deleteCharAt(stringBuilder.length()-1);
                        vis[i][j] = false;
                    }else return ;
                }


            }

}
