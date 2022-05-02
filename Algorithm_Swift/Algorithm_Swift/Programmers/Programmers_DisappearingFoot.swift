//
//  Programmers_DisappearingFoot.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/02.
//

import Foundation

func Programmers_DisappearingFoot(){
    let dx = [0,1,0,-1]
    let dy = [1,0,-1,0]

    func solution(_ board:[[Int]], _ aloc:[Int], _ bloc:[Int]) -> Int {
        var game = dfs(board,aloc,bloc,true,0)
        return game.count
    }
    func dfs(_ board: [[Int]], _ aloc: [Int], _ bloc: [Int], _ isATurn: Bool, _ count: Int) -> Game{
        let ax = aloc[0]
        let ay = aloc[1]
        let bx = bloc[0]
        let by = bloc[1]
        var board = board
        if (board[ax][ay] == 0 && isATurn) || (board[bx][by] == 0 && !isATurn){
            return Game(false, count)
        }
        var win = Int.max
        var lose = 0
        var y = 0
        var x = 0
        if isATurn{
            x = ax
            y = ay
        }else{
            x = bx
            y = by
        }
        board[x][y] = 0
        var canGo = false
        var res: Game? = nil
        for i in 0..<4{
            let xx = x + dx[i]
            let yy = y + dy[i]
            if xx < 0 || yy < 0 || xx >= board.count || yy >= board[0].count || board[xx][yy] == 0{
                continue
            }
            canGo = true
            var arr: [Int] = [xx,yy]
            if isATurn{
                res = dfs(board, arr, bloc, !isATurn, count + 1)
            }else{
                res = dfs(board, aloc, arr, !isATurn, count+1)
            }
            
            if res!.isWin{
                lose = Swift.max(lose, res!.count)
            }else{
                win = Swift.min(win, res!.count)
            }
        }
        board[x][y] = 1
        if !canGo{
            return Game(false, count)
        }else if win != Int.max{
            return Game(true, win)
        }else{
            return Game(false, lose)
        }
    }
    class Game{
        let isWin: Bool
        let count: Int
        init( _ win: Bool, _ count: Int){
            self.isWin = win
            self.count = count
        }
    }
}
