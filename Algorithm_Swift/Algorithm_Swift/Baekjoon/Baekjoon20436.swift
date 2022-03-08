//
//  Baekjoon20436.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/08.
//

import Foundation
func BJ20436(){
    let left = [["q","w","e","r","t"],["a","s","d","f","g"],["z","x","c","v","0"]]
    let right = [["ㅇ","y","u","i","o","p"],["ㅇ","h","j","k","l","3"],["b","n","m","3","3","3"]]
    var ax = 0
    var ay = 0
    var bx = 0
    var by = 0

    let input = readLine()!.split(separator: " ").map{ String($0) }
    for i in 0..<left.count {
        for j in 0..<left[0].count{
            if input[0] == left[i][j] {
                ax = i
                ay = j
                break
            }
        }
    }
    for i in 0..<right.count {
        for j in 0..<right[0].count{
            if input[1] == right[i][j] {
                bx = i
                by = j
                break
            }
        }
    }
    var answer = 0
    let str = readLine()!
    l: for c in str{
        let ch = String(c)
        for i in 0..<left.count {
            for j in 0..<left[0].count{
                if ch == left[i][j] {
                    answer += abs(ax-i) + abs(ay-j) + 1
                    ax = i
                    ay = j
                    continue l
                }
            }
            
            
            for i in 0..<right.count {
                for j in 0..<right[0].count{
                    if ch == right[i][j] {
                        answer += abs(bx-i) + abs(by-j) + 1
                        bx = i
                        by = j
                        continue l
                    }
                }
                
            }
        }
    }
    print(answer)
}


// typealias 활용하여 객체처럼 만들고 딕셔너리 활용
func BJ20436plus(){
    typealias Coordinate = (x: Int, y:Int)

    let leftKeyboard : [String : Coordinate] = [
        "q" : (0,0), "w" : (0,1), "e" : (0,2), "r" : (0,3), "t" : (0,4),
        "a" : (1,0), "s" : (1,1), "d" : (1,2), "f" : (1,3), "g" : (1,4),
        "z" : (2,0), "x" : (2,1), "c" : (2,2), "v" : (2,3)
    ]

    let rightKeyboard : [String : Coordinate] = [
        "y" : (0,5), "u" : (0,6), "i" : (0,7), "o" : (0,8), "p": (0,9),
        "h" : (1,5), "j" : (1,6), "k" : (1,7), "l" : (1,8),
        "b" : (2,4), "n" : (2,5), "m" : (2,6)
    ]

    let distance : (Coordinate, Coordinate) -> Int = { from, to in
        return abs(from.x - to.x) + abs(from.y - to.y)
    }

    let startPlace = readLine()!.split(separator: " ").map{String($0)}

    var left = leftKeyboard[startPlace.first!]!
    var right = rightKeyboard[startPlace.last!]!

    let input = readLine()!.map{String($0)}

    var answer = input.count
    for char in input {
        if let next = leftKeyboard[char] {
            answer += distance(left, next)
            left = next
        } else if let next = rightKeyboard[char] {
            answer += distance(right, next)
            right = next
        }
    }
    print(answer)
}
