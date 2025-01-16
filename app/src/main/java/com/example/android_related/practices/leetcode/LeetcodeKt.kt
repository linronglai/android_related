package com.example.android_related.practices.leetcode

object LeetcodeKt {
    val directions = arrayOf(arrayOf(1,0), arrayOf(-1,0), arrayOf(0, 1), arrayOf(0, -1))
    fun solve(board: Array<CharArray>): Unit {
        val rows = board.size
        val cols = board[0].size
        for(i in 0..rows - 1) {
            for(j in 0..cols-1) {
                if (isEdge(i, j , rows, cols) && board[i][j] == 'O') {
                    backTrack(i, j, rows, cols, board)
                }
            }
        }
        for(i in 0..<rows) {
            for (j in 0..<cols) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'
                }
            }
        }
        for(i in 0..<rows) {
            for (j in 0..<cols) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O'
                }
            }
        }
    }

    private fun backTrack(i: Int, j: Int, rows: Int, cols: Int, board: Array<CharArray>) {
        if (!isArea(i, j, rows, cols) && board[i][j] != 'O') {
            return
        }
        board[i][j] = '#'
        for(direction in directions) {
            val newX = i + direction[0]
            val newY = j + direction[1]
            if (isArea(newX, newY, rows, cols) && board[newX][newY] == 'O') {
                backTrack(newX, newY, rows, cols, board)
            }
        }
    }

    private fun isEdge(row: Int, col: Int, rows: Int, cols: Int): Boolean {
        return row == 0 || row == rows - 1 || col == 0 || col == cols - 1
    }

    private fun isArea(i: Int, j: Int, rows: Int, cols: Int): Boolean {
        return i in 0..<rows && j in 0..<cols
    }
}