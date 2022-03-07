//
//  Baekjoon2422.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/07.
//

import Foundation

func BJ2422(){
    
    let input = readLine()!.split(separator: " ").map{ Int(String($0))! }
    
    var dict: [Int: Array<Int>] = [:]
    for _ in 0..<input[1]{
        var arr = readLine()!.split(separator: " ").map{ Int(String($0))! }
        arr.sort()
        if dict[arr[0]] == nil {
            var array: [Int] = []
            array.append(arr[1])
            dict[arr[0]] = array
        }else{
            var array = dict[arr[0]]
            array?.append(arr[1])
            dict[arr[0]] = array
        }
    }
    
    var arr: [Int] = []
    for i in 1...input[0] {
        arr.append(i)
    }
    var answer = 0
    var ex: [Int] = Array<Int>(repeating: 0, count: input[0])
    makeCombination(0, 0, temps: ex, k: 3)
    print(answer)
    
    
    func makeCombination(_ count: Int, _ start: Int, temps: [Int], k: Int){
        var temp = temps
        if count == k {
            var array = dict[temp[0]]
            if array != nil && (array!.contains(temp[1]) || array!.contains(temp[2])){
                return
            }
            array = dict[temp[1]]
            if array != nil && array!.contains(temp[2]){
                return
            }
            answer += 1
            
        }else{
            var i = start
            while i < arr.count {
                temp[count] = arr[i]
                makeCombination(count+1, i+1, temps: temp, k: k)
                i += 1
            }
        }
    }
}
