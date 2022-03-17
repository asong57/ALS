//
//  Baekjoon1991.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/17.
//

import Foundation

func BJ1991(){
    let n = Int(readLine()!)!
    var tree: [String: [String]] = [:]
    var answer = ""
    for _ in 0..<n{
        let input = readLine()!.split(separator: " ").map{ String($0)}
        tree[input[0]] = [input[1], input[2]]
    }
    preorder("A")
    answer += "\n"
    inorder("A")
    answer += "\n"
    postorder("A")
    print(answer)

    func preorder(_ start: String){
        let arr = tree[start]!
        answer += start
        if arr[0] != "."{
            preorder(arr[0])
        }
        if arr[1] != "." {
            preorder(arr[1])
        }
    }

    func inorder(_ start: String){
        let arr = tree[start]!
        if arr[0] != "."{
            inorder(arr[0])
        }
        answer += start
        if arr[1] != "." {
            inorder(arr[1])
        }
    }

    func postorder(_ start: String){
        let arr = tree[start]!
        if arr[0] != "."{
            postorder(arr[0])
        }
        if arr[1] != "." {
            postorder(arr[1])
        }
        answer += start
    }
}
