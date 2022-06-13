//
//  Baekjoon11729.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/13.
//

import Foundation

func BJ11729(){
    let N = Int(readLine()!)!
    var k = 0
    var str = ""
    moveHanoiTop(N, 1, 2, 3)
    print(k)
    print(str)
    func moveHanoiTop(_ num: Int, _ from: Int, _ by: Int, _ to: Int){
        if num == 1{
            k += 1
            str += "\(from) \(to)\n"
        }else{
            moveHanoiTop(num-1, from, to, by)
            str += "\(from) \(to)\n"
            k += 1
            moveHanoiTop(num-1, by, from, to)
        }
    }
    // 하노이탑 -> 재귀문제
    // 먼저 1번에서 2번으로 보내고, 2번에서 3번으로 보내기
}
