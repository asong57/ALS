//
//  Baekjoon12933.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/14.
//

import Foundation

func BJ12933(){
    let str = readLine()!
    var arr: [[String]] = []
    var check = true

    l: for c in str {
        switch c {
        case "q":
            for i in 0..<arr.count{
                    if arr[i].last == "k" {
                        arr[i].removeAll()
                        arr[i].append("q")
                        continue l
                    }
                }
            arr.append(["q"])
        case "u":
       for i in 0..<arr.count{
                if arr[i].last == "q" {
                    arr[i].append("u")
                    continue l
                }
            }
            print(-1)
            check = false
            break l
        case "a":
        for i in 0..<arr.count{
                if arr[i].last == "u" {
                    arr[i].append("a")
                    continue l
                }
            }
            print(-1)
            check = false
            break l
        case "c":
        for i in 0..<arr.count{
                if arr[i].last == "a" {
                    arr[i].append("c")
                    continue l
                }
            }
            print(-1)
            check = false
            break l
        case "k":
        for i in 0..<arr.count{
                if arr[i].last == "c" {
                    arr[i].append("k")
                    continue l
                }
            }
            print(-1)
            check = false
            break l
        default: break
        }
    }
    if check {
        for i in 0..<arr.count{
            if arr[i].count != 5 {
                print(-1)
                check = false
                break
            }
        }
    }

    if check {
        print(arr.count)
    }
}
