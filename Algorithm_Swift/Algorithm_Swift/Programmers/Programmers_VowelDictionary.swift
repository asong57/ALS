//
//  Programmers_VowelDictionary.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/24.
//

import Foundation

let arr = [0,1,2,3,4]
let vowel = ["A","E","I","O","U"]
var words: [String] = []
func solution_VowelDictionary(_ word:String) -> Int {
    var temp = [0,0,0,0,0]
    for i in 1...5{
        temp = Array(repeating: 0, count : i)
        makePermutation(i,temp, 0)
    }
    words.sort()
    for i in 0..<words.count{
        if words[i] == word{
            return i+1
            break
        }
    }
    return 0
}

func makePermutation(_ r: Int, _ tem: [Int], _ current: Int){
    var temp = tem
    if current == r{
        var str = ""
        for i in 0..<temp.count{
            str += vowel[temp[i]]
        }
        words.append(str)
    }else{
        for i in 0..<5{
            temp[current] = arr[i]
            makePermutation(r,temp, current+1)
        }
    }
}
