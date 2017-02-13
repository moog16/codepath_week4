package com.questions;

import java.util.ArrayList;

/**
 * Created by matthewgoo on 2/12/17.
 */
public class nQueens {
    public static void main(String[] args) {
       nQueens q = new nQueens();
       ArrayList<Integer> x = new ArrayList<>();
       x.add(2);
       x.add(0);
       boolean y = q.isValid(x, 3);
       System.out.println(q.solveNQueens(4));
    }

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<Integer>> validTables = new ArrayList<>();
        iter(new ArrayList<Integer>(), a, validTables);
        return printTables(validTables, a);
    }

    public void iter(ArrayList<Integer> currentRows, int n, ArrayList<ArrayList<Integer>> validTables) {
        if(currentRows.size() == n) {
            validTables.add(currentRows);
            return;
        }
        for(int j=0; j<n; j++) {
            if(isValid(currentRows, j)) {
                ArrayList<Integer> copy = new ArrayList<>(currentRows);
                copy.add(j);
                iter(copy, n, validTables);
            }
        }
    }


    public boolean isValid(ArrayList<Integer> rows, int possibleCol) {
        int rowNum = rows.size();

        for(int i=0;i<rows.size(); i++) {
            int colPos = rows.get(i);
            boolean isInSameColumn = colPos == possibleCol;
            boolean isDiagonalRight = colPos+(rowNum-i) == possibleCol;
            boolean isDiagonalLeft = colPos-(rowNum-i) == possibleCol;

            if(isInSameColumn || isDiagonalLeft || isDiagonalRight) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<ArrayList<String>> printTables(ArrayList<ArrayList<Integer>> tables, int a) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for(ArrayList<Integer> table : tables) {
            ArrayList<String> _table = new ArrayList<>();
            for(Integer row : table) {
                _table.add(printRow(row, a));
            }
            res.add(_table);
        }
        return res;
    }

    public String printRow(int num, int a) {
        String res = "";
        for(int i=0; i<a; i++) {
            if(i == num) {
                res += "Q";
            } else {
                res += ".";
            }
        }
        return res;
    }

}
